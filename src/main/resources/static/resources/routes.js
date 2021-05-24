function send() {
    let root = $("#query").val();
        $.ajax({
            type: 'POST',
            url: form.action,
            data: root,
            processData: false,
            contentType: false,
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
                        + "</div> <div class=\"card-body\"> <h2 class=\"card-title\">"
                        + inf[i]["id"] + "</h2> <p class=\"card-text\">"
                        + "email"
                        + ': ' + inf[i]["email"] +
                        "</p> </div> </div>";
                    rootEl.appendChild(el);
                }

            },
            error: function (_data) {
                document.write(_data.responseText);
            }
        });
}