<#include  "resources/config.ftl">
<@config name="success"/>
<#include "resources/background.ftl">
<#include "resources/nav.ftl">
<div style="margin-top: 56px;height: 100%;">
    <#include  "resources/header.ftl">
    <@header text ="Все плохо"/>
    <div class="figure2 top_margin d-flex justify-content-end">
        <p id = "help" class="text">Потрачено</p>
    </div>
</div>
<#include "resources/footer.ftl">
<@footer margin=30/>
<@bootstrapjs></@bootstrapjs>
</body>
</html>