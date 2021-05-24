function like( postId, token){
    $.ajax({
        type: 'POST',
        url: '/api/like/' + postId,
        headers: { 'Authorization': token },
        success: function () {
            alert('ok');
        },
        error: function (data) {
        }
    });
}
function expand(postId, token){
    $.ajax({
        type: 'POST',
        url: '/api/comments/' + postId,
        headers: { 'Authorization': token },
        success: function (data) {
            let values = JSON.parse(data);
            values.forEach(function (value) {
                $( "div[id= "+ postId +"]" ).first().after('<div id = "' + value['id'] + '" style="margin: 15px; color: #eaeaea" class="card text-white bg-dark mb-3" >\n' +
                    '            <div class="card-header">\n' +
                    value['owner']['name'] +
                    '            </div>\n' +
                    '            <div class="card-body">\n' +
                    '                <h2 class="card-title">\n' +
                    value['text'] +
                '                </h2>\n' +
                '                    <svg onclick="like(' + value['id'] + ', \'' +
                token + '\')" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart" viewBox="0 0 16 16">\n' +
                '                        <path d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"/>\n' +
                '                    </svg>\n' +
                value["liked"] +
                '\n' +
                '            </div>\n' +
                '        </div>'
                );
            });
            $( "div[id= "+ postId +"]" ).find("svg")[1].innerHTML = "";
        },
        error: function (data) {
            document.write(data.responseText);
        }
    });
}
function addPost(token){
    var q1 = $("input#query").val();
    var q2 = $("input#query2").val();
    var q3 = $("input#query3").val();
    var data2 = {
        "text": q1,
        "parentId": q2,
        "musicId": q3
    };
    $.ajax({
        type: 'POST',
        url: '/api/add_post',
        data: JSON.stringify(data2),
        contentType: "application/json",
        headers: { 'Authorization': token },
        success: function () {
            alert('ok');
        },
        error: function (data) {
        }
    });
}
function getFormData($form){
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};

    $.map(unindexed_array, function(n, i){
        indexed_array[n['name']] = n['value'];
    });

    return indexed_array;
}
