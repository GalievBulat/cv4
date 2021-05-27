
<#include  "resources/config.ftl">
<@config name="auth"/>
<#import "spring.ftl" as spring />
<#include "resources/starter.ftl">
<@starter/>
<div id= "posts" class="must-paste" >
    <div class="figure2">
        <form method="post"  class="form" action="/auth">
            <label class="highlight"><@spring.message 'auth.highlight'/></label>
            <input class="form_element" type="email" name="tc" placeholder="email"/>
            <input class="form_element" type="password" name="password" placeholder="password"/>
            <div class="custom-control custom-checkbox">
                <input type="checkbox" name="remember_me" class="custom-control-input" id="customCheck1">
                <label class="custom-control-label"  for="customCheck1">
                    <@spring.message 'auth.remember_me'/>
                </label>
            </div>
            <input class="btn btn-dark main_button" type="submit"  value="AUTH"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        </form>
    </div>
    <a href="?lang=en">EN</a>
    <a href="?lang=ru">RU</a>
</div>

<header class="Text">Auth</header>

<div class="Text2">Auth</div>

<hr class="Line4" style="margin: 0;">

<#include  "resources/footer_dark.ftl">
<footer class="Rectangle8" >
    <@footerDark/>
</footer>


<@bootstrapjs></@bootstrapjs>
</body>
</html>