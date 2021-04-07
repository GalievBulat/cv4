<#include  "resources/config.ftl">
<@config name="routes"/>
<#include "resources/background.ftl">
<#include "resources/nav.ftl">
<div  style="margin-top: 56px;">
    <#include  "resources/header.ftl">
    <@header text ="Маршруты"/>
    <div style="display: flex;">
        <div class="figure2 leftAl">
            <form action="http://localhost/search" id="form">
                <input id = query  type="text" placeholder="query">
                <div class="btn btn-dark main_button btn-sm default" onclick="send()">
                    <p class="highlight  default" style="font-size: 150%">Поиск</p></div>
            </form>
            <#include "resources/field.ftl">
        </div>
        <div class="figure2 rightAl "  style="text-align: center;">
            <div style="background: black;height: 45px;border-radius: 0.5rem 0.5rem 0 0;"></div>
            <div class="spread" id="list" style="overflow: auto; height: 555px;"></div>
        </div>
    </div>
</div>
<#include "resources/footer.ftl">
<@footer margin=30/>
</body>
<@bootstrapjs></@bootstrapjs>
<script src="/resources/routes.js" charset="UTF-8"></script>

</html>