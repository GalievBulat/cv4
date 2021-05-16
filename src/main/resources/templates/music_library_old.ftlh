<#include  "resources/config.ftl">
<@config name="routes"/>
<#include "resources/background.ftl">
<#include "resources/nav.ftl">
<div style="margin-top: 56px;" xmlns="http://www.w3.org/1999/html">
    <#include  "resources/header.ftl">
    <@header text ="Маршруты"/>
    <div style="display: flex;">
        <div class="figure2 leftAl">
            <form action="http://localhost/music" id="form" method="get">
                <input id = "query" name="name" type="text" placeholder="music name">
                <input id = "query2" name="album" type="text" placeholder="music album">
                <input id = "query3" name="author" type="text" placeholder="music author">
                <input id = "page" name="page" type="hidden">
                <#--<div class="btn btn-dark main_button btn-sm default" onclick="send('${_csrf.parameterName}','${_csrf.token}');">
                    <p class="highlight  default" style="font-size: 150%">Поиск</p></div>-->
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <input type="submit" class="highlight default" style="font-size: 150%" value="Поиск" class="btn btn-dark main_button btn-sm default" />
            </form>
            <#include "resources/field.ftl">
        </div>
        <div class="figure2 rightAl "  style="text-align: center;">
            <div style="background: black;height: 45px;border-radius: 0.5rem 0.5rem 0 0;"></div>
            <div class="spread" id="list" style="overflow: auto; height: 555px;">
                <#list music_list as item>
                    <div class="card text-white bg-dark mb-3" >
                        <div class="card-header">
                            ${item.getName()}
                        </div>
                        <audio controls>
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
            <a href="?page=1">1</a>
            <a href="?page=2">2</a>
            <a href="?page=3">3</a>
            <a href="?page=4">4</a>
        </div>
    </div>
</div>
<#include "resources/footer.ftl">
<@footer margin=30/>
</body>
<@bootstrapjs></@bootstrapjs>
<script src="/resources/music_library.js" charset="UTF-8"></script>

</html>