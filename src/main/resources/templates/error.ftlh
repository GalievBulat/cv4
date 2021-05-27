
<#include  "resources/config.ftl">
<@config name="auth"/>
<#import "spring.ftl" as spring />
<#include "resources/starter.ftl">
<@starter/>
<div id= "posts" class="must-paste" >
    <div class="figure2 top_margin d-flex justify-content-end">
        <p id = "help" class="text">Потрачено</p>
    </div>
</div>

<header class="Text">Все плохо</header>

<div class="Text2">Потрачено</div>

<hr class="Line4" style="margin: 0;">

<#include  "resources/footer_dark.ftl">
<footer class="Rectangle8" >
    <@footerDark/>
</footer>


<script src="/resources/profile.js" charset="UTF-8"></script>

<@bootstrapjs></@bootstrapjs>
</body>
</html>