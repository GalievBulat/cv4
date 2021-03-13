<#include  "resources/config.ftl">
<@config name="profile"/>
<#include "resources/background.ftl">
<#include "resources/nav.ftl">
<div style="margin-top: 56px;">
    <#include  "resources/header.ftl">
    <@header text ="Профиль"/>
    <#include "resources/errors.ftl">
    <#include "resources/alert.ftl">
    <form method="POST" enctype="multipart/form-data" action="http://localhost/profile">
        <table>
            <tr><td>File to upload:</td><td><input type="file" name="file" /></td></tr>
            <tr><td></td><td><input type="submit" value="Upload" /></td></tr>
        </table>
    </form>
    <form  method="post" action="http://localhost/profile" enctype="multipart/form-data" id="avatarPicking">
        <div class="input-group mb-3" style="padding: 3% 30% 1% 30%;">
            <div class="input-group-prepend">
                <span class="input-group-text" id="bt_sbm" onclick="send()" data-toggle="modal" data-target="#exampleModal">Upload</span>
            </div>
            <div class="custom-file">
                <input type="file" name="avatar" class="custom-file-input" id="inputGroupFile01" aria-describedby="inputGroupFileAddon01">
                <label class="custom-file-label" for="inputGroupFile01">Choose file</label>
            </div>
        </div>
    </form>

    <#--<img class="rounded mx-auto d-block " src="${avatar}" id = "picture" style="border: 5px solid #dee2e6;width: 10%; margin: 3%;">-->


    <div id="parallelogram1" class="figure top_margin d-flex justify-content-end" style="margin-top: 1%;">
        <p id = "name" class="text skewed">${user.name}</p>
    </div>
    <div id="parallelogram2" class="figure top_margin d-flex justify-content-end">
        <p id = "surname"  class="text skewed">${user.surname}</p>
    </div>
    <div id="parallelogram3" class="figure top_margin d-flex justify-content-end">
        <p id = "tc" class="text skewed ">Номер карты: ${user.tc}</p>
    </div>
    <button id ="change" type="button" class="btn btn-dark main_button top_margin d-flex justify-content-center" onclick="changeProfile()" style="
    margin: auto; margin-bottom: 3%; margin-top: 3%;font-size: 200%;">Изменить профиль</button>
    <a href="http://localhost:8088/cv/tc">
        <button type="button" class="btn btn-dark main_button top_margin d-flex justify-content-center"  style="
        margin: auto; margin-bottom: 3%; margin-top: 3%; font-size: 200%;">Управление тк</button>
    </a>
    <form action="sign_out" method="post">
        <input type="submit" value="Выход" class="btn btn-dark main_button top_margin d-flex justify-content-center"  style="
        margin: auto; margin-bottom: 3%; margin-top: 3%; font-size: 200%;">
    </form>
</div>
<#include "resources/footer.ftl">
<@footer margin=30/>
<script src="templates/resources/profile.js" charset="UTF-8"></script>
<@bootstrapjs></@bootstrapjs>
</body>
<script>

    window.onload = function() {
        $("#avatarPicking").toggle();
    }
    function send(){
        //$("#bt_sbm").prop("onclick", "");
        let form = $("#avatarPicking")[0];
        let formObj = new FormData(form);
        if (formObj != null) {
            $.ajax({
                enctype: 'multipart/form-data',
                type: 'POST',
                url: form.action,
                data: formObj,
                processData: false,
                contentType: false,
                data_type: "text/plain",
                success: function (_data) {
                    $("#picture").prop("src", _data + "?" + new Date().getTime());
                },
                error: function (data) {
                    document.write(data.responseText);
                }
            });
        }
    }
    let html =
        '<input />';
    let nameLocal;
    let surnameLocal;
    let state = 0;
    function changeProfile(){

        if (state === 0) {
            surnameLocal =  $("#surname").text();
            nameLocal =  $("#name").text();
            $("#avatarPicking").toggle();
            $("#name").html(html);
            $("#surname").html(html);
            state++
            $("#change").text(decodeURI("%D1%81%D0%BE%D1%85%D1%80%D0%B0%D0%BD%D0%B8%D1%82%D1%8C"));
        }else if (state === 1) {
            $("#avatarPicking").toggle();
            let root = {};
            let name = $("#name").children().val();
            let surname = $("#surname").children().val();
            if(name!=='' && surname!=='') {
                root["name"] = '' + name;
                root["surname"] = '' + surname;
                $.ajax({
                    type: 'POST',
                    url: 'http://localhost:8088/cv/profile',
                    data: JSON.stringify(root),
                    processData: false,
                    contentType: false,
                    data_type: "json",
                    success: function () {
                        $("#name").text(name);
                        $("#surname").text(surname);
                    },
                    error: function (data) {
                        document.write(data.responseText);
                    }
                });
                state = 0;
            } else {
                $("#name").text(nameLocal);
                $("#surname").text(surnameLocal);
                state = 0;
            }
            $("#change").text(
                decodeURI("%D0%98%D0%B7%D0%BC%D0%B5%D0%BD%D0%B8%D1%82%D1%8C%20%D0%BF%D1%80%D0%BE%D1%84%D0%B8%D0%BB%D1%8C"));
        }
    }
</script>
</html>