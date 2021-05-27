
<#include  "resources/config.ftl">
<@config name="auth"/>
<#import "spring.ftl" as spring />
<#include "resources/starter.ftl">
<@starter/>
<div id= "posts" class="must-paste" >
    <div class="card mb-3" style="max-width: 540px;">
        <div class="row g-0">
            <div class="col-md-4">
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
    margin: 3% auto;font-size: 200%;">
        <@spring.message 'profile.change_password'/>
    </button>
    <a href="/logout" class="btn btn-dark main_button top_margin d-flex justify-content-center"
       style="margin: 3% auto;font-size: 200%;">
        Выход
    </a>
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