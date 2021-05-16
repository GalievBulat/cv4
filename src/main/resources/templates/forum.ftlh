<#include  "resources/config.ftl">
<@config name="forum"/>
<#include "resources/nav.ftl">
<#include "resources/background.ftl">

<div style="margin-top: 56px" >
    <#include  "resources/header.ftl">
    <@header text ="Форум"/>
    <div class="figure2" style="width: 80%;padding: 2%">
        <#include "resources/errors.ftl">
        <form id="comment">
            <div class="form-group">
                <label id ="parent" for="exampleFormControlTextarea1">Комментарий</label>
                <input id = "message" class="form-control form-control-lg" rows="2" placeholder="Текст сообщения"/>
                <input id = "name" class="form-control form-control-lg" placeholder="Имя"/>
            </div>
            <button type="button" class="btn btn-dark"
                    onclick="sendViaSocket($('#message').val(), $('#name').val())">Отправить комментарий</button>
        </form>
        <div >
        </div>
        <p class="highlight">Обсуждения</p>
        <#include "resources/post.ftl">
        <div id = "discussions">
        </div>
</div>
<@bootstrapjs></@bootstrapjs>
</div>
<#include "resources/footer.ftl">
<@footer margin=30/>
<script src="/resources/forum.js" charset="UTF-8"></script>
</body>
</html>