
let webSocket;
function connect(){
    webSocket = new WebSocket("ws://localhost/socket");
    webSocket.onmessage = onReceive;
}
function sendViaSocket(text, name){
    let message = {
        "text" : text,
        "userName": name
    };
    webSocket.send(JSON.stringify(message));
}
function onReceive(data){
    let value = JSON.parse(data['data']);
    $('#discussions').first().after("<li> " + value['text'] + "</li>");
}
window.onload = function() {
    connect();
}