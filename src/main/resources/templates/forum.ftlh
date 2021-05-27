
<#include  "resources/config.ftl">
<@config name="auth"/>
<#import "spring.ftl" as spring />
<#include "resources/starter.ftl">
<@starter/>
<div id= "posts" class="must-paste" >
    <form id="comment" style="margin-left: 20px;">
        <div class="form-group">
            <label id ="parent" for="exampleFormControlTextarea1">Комментарий</label>
            <input id = "message" class="form-control form-control-lg" rows="2" placeholder="Текст сообщения"/>
        </div>

        <button type="button" class="btn btn-dark"
                onclick="sendViaSocket($('#message').val(), '${username}', '${token}')">Отправить комментарий</button>
    </form>
    <p class="highlight">Обсуждения</p>
    <#include "resources/post.ftl">
    <div id = "discussions">
        <#list messages as item>
            <div style="margin: 15px; color: #eaeaea" class="card text-white bg-dark mb-3" >
                <div class="card-header">
                    ${item.getName()}
                </div>
                <div class="card-body">
                    <h2 class="card-title">
                        Album: ${item.getText()}
                    </h2>
                    <p class="card-text">
                        Date: ${item.getDate()}
                    </p>
                </div>
            </div>
        </#list>
    </div>
</div>

<header class="Text">Поддержка</header>

<div class="Text2">Обсуждения</div>

<hr class="Line4" style="margin: 0;">

<#include  "resources/footer_dark.ftl">
<footer class="Rectangle8" >
    <@footerDark/>
</footer>


<script
        src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
<script src="/resources/forum.js" charset="UTF-8"></script>

<@bootstrapjs></@bootstrapjs>
</body>
</html>