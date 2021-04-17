<#include  "resources/config.ftl">
<@config name="booking"/>
<#include "resources/background.ftl">
<#include "resources/nav.ftl">

<div style="margin-top: 56px;">
    <#include  "resources/header.ftl">
    <@header text ="Бронирование"/>
    <div class="figure2" style="width: 80%; text-align: center;">
        <#include "resources/errors.ftl">
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

</div>
<#include "resources/footer.ftl">
<@footer margin=30/>

<@bootstrapjs></@bootstrapjs>
</body>
</html>