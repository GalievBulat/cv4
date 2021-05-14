<#include  "resources/config.ftl">
<@config name="booking"/>
<#include "resources/background.ftl">
<#include "resources/nav.ftl">

<div style="margin-top: 56px;">
    <#include  "resources/header.ftl">
    <@header text ="Бронирование"/>
    <div class="figure2" style="width: 80%; text-align: center;">
        <#include "resources/errors.ftl">
        <form  method="post" id = "form" action="/registration_confirmation">
            <label class="highlight">Введите код подтверждения</label>
            <input class="form_element" type="number" name="code" placeholder="код подтверждения"/>
            <input style="height: 80px;font-size: 200%;width: 60%;margin-bottom: 3%;"
                   type="submit" class="btn btn-dark main_button btn-sm default" value="Отправить">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        </form>
    </div>

</div>
<#include "resources/footer.ftl">
<@footer margin=30/>

<@bootstrapjs></@bootstrapjs>
</body>
</html>