<!doctype html>
<html lang="en">
<link rel="stylesheet" type="text/css" href="/resources/styles_new.css"/>
<#include  "resources/config.ftl">
<@config name="Music"/>
<script>
    function zoom()
    {
        document.body.style.zoom = "120%";
    }
</script>
<body onload="zoom()" >
<div class="back_final1"></div>

<div class="back_final2"> </div>

<div class="Rectangle6" ></div>

<div class="Rectangle4"></div>

<div class="Rectangle5" >


</div>

<div style="
 position: absolute; left: 163px;
    top: 231px;  overflow: auto;
    width: 954px; height: 390px" >
    <#list music_list as item>
        <div style="margin: 15px; color: #eaeaea" class="card text-white bg-dark mb-3" >
            <div class="card-header">
                ${item.getName()}
            </div>
            <audio controls style="width: 100%">
                <source src="${item.getFileName()}" type="audio/mpeg">
                Your browser does not support the audio element.
            </audio>
            <div class="card-body">
                <h2 class="card-title">
                    Album: ${item.getAlbum()}
                </h2>
                <p class="card-text">
                    Author: ${item.getAuthor()}
                    <br>
                    provided by:  ${item.getProvider().getName()} ||
                    email: ${item.getProvider().getEmail()}
                </p>
            </div>
        </div>
    </#list>
</div>

<header class="Text">Text</header>

<header class="Text2">Text</header>

<footer class="Rectangle8" >
    <div class="card" style="background: #001A29">
        <div class="card-body">
            <h5 class="card-title" style="color: #eaeaea">Disclaimer Disclaimer Disclaimer Disclaimer</h5>
            <p class="card-text" style="color: #eaeaea">Здесь вы можете найти дополнительные ссылки на ресурсы для освоения портала.</p>
            <a href="http://localhost/help"><p class="card-text">Помощь в эксплуатации ресурса</p></a>
            <p class="card-text"><p style="background: white; width: max-content ">
                OOO "Музыка Чкачатб Онлайн"</p> <small class="text-muted">.Все права защищены
                    <br> design by kakadurf@gmail.com</small></p>
        </div>
    </div>
</footer>


<hr class="Line4" style="margin: 0;">
<div class="image1"></div>

<div class="image2"></div>

</body>

<@bootstrapjs></@bootstrapjs>
</html>