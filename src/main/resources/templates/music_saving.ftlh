
<#include  "resources/config.ftl">
<@config name="auth"/>
<#import "spring.ftl" as spring />
<#include "resources/starter.ftl">
<@starter/>
<div id= "posts" class="must-paste" >
    <form method="POST" enctype="multipart/form-data" action="http://localhost/save_music">
        <table>
            <tr><td>File to upload:</td><td><input type="file" name="file" /></td></tr>
            <tr><td></td><td><input type="submit" value="Upload"/></td></tr>
        </table>
        <input type="text" name="author" placeholder="author">
        <input type="text" name="name" placeholder="name">
        <input type="text" name="album" placeholder="album">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    </form>
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