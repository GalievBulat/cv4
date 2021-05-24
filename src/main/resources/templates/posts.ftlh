<!doctype html>
<html lang="en">
<link rel="stylesheet" type="text/css" href="/resources/styles_new.css"/>
<#include "resources/config.ftl">
<@config name="Music"/>
<script>
    function zoom()
    {
        document.body.style.zoom = "120%";
    }
</script>
<body onload="zoom()" >
<#include "resources/starter.ftl">
<@starter/>

<div id= "posts" style="
 position: absolute; left: 163px;
    top: 231px;  overflow: auto;
    width: 954px; height: 390px" >
    <#list posts as item>
        <div id = "${item.id}" style="margin: 15px; color: #eaeaea" class="card text-white bg-dark mb-3" >
            <div class="card-header">
                ${item.owner.name}
            </div>
            <#if item.music?has_content>
                <audio controls style="width: 100%">
                    <source src="${item.music.fileName}" type="audio/mpeg">
                    Your browser does not support the audio element.
                </audio>
            </#if>
            <div class="card-body">
                <h2 class="card-title">
                    ${item.text}
                </h2>
                    <svg onclick="like(${item.id},'${token}')" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart" viewBox="0 0 16 16">
                        <path d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"/>
                    </svg>
                ${item.liked}

                <svg onclick="expand(${item.id},'${token}')" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-down" viewBox="0 0 16 16">
                    <path d="M3.204 5h9.592L8 10.481 3.204 5zm-.753.659 4.796 5.48a1 1 0 0 0 1.506 0l4.796-5.48c.566-.647.106-1.659-.753-1.659H3.204a1 1 0 0 0-.753 1.659z"/>
                </svg>
                Comments
            </div>
        </div>
    </#list>
</div>

<header class="Text">Posts</header>

<div class="Text2">
    <button style="width: 250px; background-color: #001A29;border-color: #001A29;" class="btn btn-primary" data-bs-toggle="collapse" href="#add" role="button" aria-expanded="false" aria-controls="collapseExample">
        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chat-left-dots" viewBox="0 0 16 16">
            <path d="M14 1a1 1 0 0 1 1 1v8a1 1 0 0 1-1 1H4.414A2 2 0 0 0 3 11.586l-2 2V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12.793a.5.5 0 0 0 .854.353l2.853-2.853A1 1 0 0 1 4.414 12H14a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
            <path d="M5 6a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm4 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm4 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0z"/>
        </svg>
    </button>
    <div <#--action="http://localhost/api/add_post"-->  class="collapse" id="add" style="margin-top: 20px;">
        <input class="form-control" id = "query" name="text" type="text" placeholder="текст">
        <input class="form-control" id = "query2" name="parentId" type="number" placeholder="теща">
        <input class="form-control" id = "query2" name="musicId" type="number" placeholder="музыка">
        <#--<meta http-equiv="Authorization" content="${token}"/>-->

        <button onclick="addPost('${token}')"  style="font-size: 150%" value="Оставить запись" class="btn btn-dark" />
        <#--Text
        </button>-->
    </div>
   <#-- <input class="form-control" type="text" placeholder="Default input" aria-label="default input example">-->
</div>

<#include  "resources/footer_dark.ftl">
<footer class="Rectangle8" >
   <@footerDark/>
</footer>


<hr class="Line4" style="margin: 0;">
<div class="image1"></div>

<div class="image2"></div>

</body>

<script src="/resources/posts.js" charset="UTF-8"></script>
<@bootstrapjs></@bootstrapjs>
</html>