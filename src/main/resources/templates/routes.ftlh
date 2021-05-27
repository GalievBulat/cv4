
<#include  "resources/config.ftl">
<@config name="auth"/>
<#import "spring.ftl" as spring />
<#include "resources/starter.ftl">
<@starter/>
<div id= "posts" class="must-paste" >
    <div class="figure2 leftAl">
        <form action="http://localhost/search" id="form">
            <input id = "query" type="text" placeholder="query">
            <div class="btn btn-dark main_button btn-sm default" onclick="send()">
                <p class="highlight  default" style="font-size: 150%">Поиск</p></div>

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        </form>
    </div>
    <div class="figure2 rightAl "  style="text-align: center;">
        <div style="background: black;height: 45px;border-radius: 0.5rem 0.5rem 0 0;"></div>
        <div class="spread" id="list" style="overflow: auto; height: 555px;"></div>
    </div>
</div>

<header class="Text">Profile</header>

<div class="Text2">Profile</div>

<hr class="Line4" style="margin: 0;">

<#include  "resources/footer_dark.ftl">
<footer class="Rectangle8" >
    <@footerDark/>
</footer>


<script src="/resources/profile.js" charset="UTF-8"></script>

<@bootstrapjs></@bootstrapjs>
</body>
</html>