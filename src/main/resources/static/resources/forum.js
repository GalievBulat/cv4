
let webSocket;
function connect(){
    webSocket = new WebSocket("ws://localhost/socket");
    webSocket.onmessage = onReceive;
}
function sendViaSocket(text){
    let message = {
        "text" : text
    };
    webSocket.send(JSON.stringify(message));
}
function onReceive(data){
    let value = JSON.parse(data['data']);
    $('#discussions').first().after("<li> another@user.com" + value['text'] + "</li>");
}
window.onload = function() {
    connect();
}