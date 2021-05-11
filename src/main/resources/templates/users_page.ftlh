<#include  "resources/config.ftl">
<#import "spring.ftl" as spring/>
<@config name="profile"/>
<#include "resources/background.ftl">
<#include "resources/nav.ftl">
<div style="margin-top: 56px;">
    <#include  "resources/header.ftl">
    <@header text ="Profile"/>
    <#include "resources/errors.ftl">
    <#include "resources/alert.ftl">
    <div class="card mb-3" style="max-width: 540px;">
        <div class="row g-0">
            <div class="col-md-4">
                <img src="..." alt="...">
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
<#include "resources/footer.ftl">
<@footer margin=30/>
<script src="/resources/profile.js" charset="UTF-8"></script>
<@bootstrapjs></@bootstrapjs>
</body>
</html>