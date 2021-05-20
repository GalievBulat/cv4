function like( postId, token){
    $.ajax({
        type: 'POST',
        url: '/api/like/' + postId,
        headers: { 'Authorization': token },
        success: function () {
            alert('ok');
        },
        error: function (data) {
            document.write(data.responseText);
        }
    });
}