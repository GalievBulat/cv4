
let webSocket;
let userName = "";
function connect(){
    webSocket = new SockJS("http://localhost/socket");
    webSocket.onmessage = onReceive;
}
function sendViaSocket(text, name, token){
    userName = name;
    let message = {
        "text" : text,
        "userName": name,
        "token": token
    };
    webSocket.send(JSON.stringify(message));
}
function onReceive(data){
    let value = JSON.parse(data['data']);
    $('#discussions').first().after(' <div style="margin: 15px; color: #eaeaea" class="card text-white bg-dark mb-3"> <div class="card-header">' +
               userName +
            '</div> <div class="card-body"> <h2 class="card-title">Album:' +
         value['text'] +
                '</h2> <p class="card-text">Date:'
        + new Date() + '</p> </div> </div> ');
}
window.onload = function() {
    connect();
}