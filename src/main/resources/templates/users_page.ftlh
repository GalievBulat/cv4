
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
                </div>
            </div>
        </div>
    </div>
    <a href="http://localhost/subscribe/${user.id}" class="btn btn-dark main_button top_margin d-flex justify-content-center" style="margin: auto; margin-bottom: 3%; margin-top: 3%; font-size: 200%;">
        Подписаться
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