function send(csrfName, csrfTocken) {
    let root = {
    };

    root[csrfName] = csrfTocken;
    root["value"] = $("#query").val() ;
        $.ajax({
            type: 'POST',
            url: form.action,
            data: root,
            data_type: "json",
            success: function (_data) {
                let inf = JSON.parse(_data);
                let rootEl = document.getElementById("list");
                rootEl.innerText = "";
                for (i in inf) {
                    console.log(inf[i]["id"]);
                    let el = document.createElement("div");
                    el.innerHTML = "<div class=\"card text-white bg-dark mb-3\" > " +
                        "<div class=\"card-header\">"
                        + inf[i]["name"]
                        + "</div> <audio controls>" +
                        "<source src=\"" +inf[i]["filePath"]  + "\" type=\"audio/mpeg\">" +
                        "Your browser does not support the audio element.\n" +
                        "</audio> <div class=\"card-body\"> <h2 class=\"card-title\">"
                        + inf[i]["album"] + "</h2> <p class=\"card-text\">"
                        + "email"
                        + ': ' + escapeRegExp(inf[i]["author"]) +
                        "</p> </div> </div>";
                    rootEl.appendChild(el);
                }

            },
            error: function (_data) {
                document.write(_data.responseText);
            }
        });
    function escapeRegExp(string){
        return string.replace(/[.*+?^${}()|[\]\\]/g, "\\$&");
    }
}