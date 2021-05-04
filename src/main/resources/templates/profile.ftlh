<#include  "resources/config.ftl">
<#import "spring.ftl" as spring/>
<@config name="profile"/>
<#include "resources/background.ftl">
<#include "resources/nav.ftl">
<div style="margin-top: 56px;">
    <#include  "resources/header.ftl">
    <@header text ="Profile"/>
    <#include "resources/errors.ftl">
    <#include "resources/alert.ftl">
    <#--<form  method="post" action="http://localhost/profile" enctype="multipart/form-data" id="avatarPicking">
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
-->
    <#--<img class="rounded mx-auto d-block " src="${avatar}" id = "picture" style="border: 5px solid #dee2e6;width: 10%; margin: 3%;">-->

    <div class="card mb-3" style="max-width: 540px;">
        <div class="row g-0">
            <div class="col-md-4">
                <img src="..." alt="...">
            </div>
            <div class="col-md-8">
                <div class="card-body">
                    <h5 class="card-title" id="name">${user.name}</h5>
                    <p class="card-text" id="surname">${user.surname}</p>
                    <#--<p class="card-text"><small class="text-muted">${user.tc}</small></p>-->
                </div>
            </div>
        </div>
    </div>
    <button id ="change" type="button" class="btn btn-dark main_button top_margin d-flex justify-content-center"
            onclick="changeProfile('${_csrf.parameterName}','${_csrf.token}')" style="
    margin: auto; margin-bottom: 3%; margin-top: 3%;font-size: 200%;">
        <@spring.message 'profile.change_password'/>
    </button>
    <a href="/logout" class="btn btn-dark main_button top_margin d-flex justify-content-center"
       style="margin: auto; margin-bottom: 3%; margin-top: 3%; font-size: 200%;">
        Выход
    </a>
</div>
<#include "resources/footer.ftl">
<@footer margin=30/>
<script src="/resources/profile.js" charset="UTF-8"></script>
<@bootstrapjs></@bootstrapjs>
</body>
</html>