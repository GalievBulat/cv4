<#include  "resources/config.ftl">

<@config name="reg"/>
<#include "resources/background.ftl">
<#include "resources/nav.ftl">

<#import "spring.ftl" as spring />

<div style="margin-top: 56px;">
    <#include  "resources/header.ftl">
    <@header text ='Registration' />
    <div class="figure2" style="width: 80%;">
        <#include "resources/errors.ftl">
        <@spring.bind "userData"/>
        <form method="post"  class="form">

            <label class="highlight"><@spring.message 'reg.highlight'/></label>
            <@spring.formInput "userData.name" "class=\"form_element\" name=\"name\" placeholder=\"имя\"" "text" />
            <@spring.showErrors " "/>
            <@spring.formInput "userData.surname" "class=\"form_element\" name=\"surname\" placeholder=\"фамилия\"" "text"/>
            <@spring.showErrors " "/>
            <@spring.formInput "userData.phone_num" "class=\"form_element\" name=\"phone_num\" placeholder=\"тел номер (+7**********)\"" "tel"/>
            <@spring.showErrors " "/>
            <@spring.formInput "userData.email" "class=\"form_element\" name=\"email\" placeholder=\"эл почта\"" "email"/>
            <@spring.showErrors " "/>
            <@spring.formInput "userData.password" "class=\"form_element\" name=\"password\" placeholder=\"пароль\" id = \"password_input\"" "password"/>
            <@spring.showErrors " "/>
            <div id="invalid password"></div>
            <#--<input class="form_element" type="date" name="birth_day" placeholder="день рождения"/>-->
            <input class="figure3 unskewed btn btn-dark" type="submit" value="REGISTER"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        </form>

    </div>

    <a href="?lang=en">EN</a>
    <a href="?lang=ru">RU</a>

</div>
<#include "resources/footer.ftl">
<@footer margin=30/>
<script src="templates/resources/reg.js" charset="UTF-8"></script>
<@bootstrapjs></@bootstrapjs>
</body>
</html>