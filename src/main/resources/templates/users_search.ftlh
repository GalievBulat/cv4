<#include  "resources/config.ftl">
<@config name="routes"/>
<#include "resources/background.ftl">
<#include "resources/nav.ftl">
<div style="margin-top: 56px;" xmlns="http://www.w3.org/1999/html">
    <#include  "resources/header.ftl">
    <@header text ="Маршруты"/>
    <div style="display: flex;">
        <div class="figure2 leftAl">
            <form action="http://localhost/search" id="form" method="get">
                <input id = "query" name="name" type="text" placeholder="name">
                <input id = "query3" name="email" type="text" placeholder="email">
                <input id = "page" name="page" type="number">
                <#--<div class="btn btn-dark main_button btn-sm default" onclick="send('${_csrf.parameterName}','${_csrf.token}');">
                    <p class="highlight  default" style="font-size: 150%">Поиск</p></div>-->
                <input type="submit" class="highlight default" style="font-size: 150%" value="Поиск" class="btn btn-dark main_button btn-sm default" />
            </form>
            <#include "resources/field.ftl">
        </div>
        <div class="figure2 rightAl "  style="text-align: center;">
            <div style="background: black;height: 45px;border-radius: 0.5rem 0.5rem 0 0;"></div>
            <div class="spread" id="list" style="overflow: auto; height: 555px;">
                <#list users_list as item>
                    <div class="card text-white bg-dark mb-3" >
                        <div class="card-header">
                            ${item.getName()}
                        </div>
                        <div class="card-body">
                            <h2 class="card-title">
                                Album: ${item.getEmail()}
                            </h2>
                            <a href="/user/${item.getId()}">
                                <p class="card-text">
                                    Profile
                                </p>
                            </a>
                        </div>
                    </div>
                </#list>
            </div>
            <a href="http://localhost/api/auth">АУФ</a>
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