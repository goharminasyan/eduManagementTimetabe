function PopUpShowMonday() {
    $("#popup-container").show();
    document.getElementById("demo").innerHTML = document.getElementById("monday").getElementsByTagName("a").item(0).text;;
    $("#main-wrapper").css("-webkit-filter", "blur(10px)");
    $("#header").css("-webkit-filter", "blur(10px)");
    $("#main-wrapper").css("pointer-events", "none");
    $("#header").css("pointer-events", "none");
    $("#show-btn").css("pointer-events", "none");
    $("#show-btn").css("-webkit-filter", "blur(1px)");
}

function PopUpShowTuesday() {
    $("#popup-container").show();
    document.getElementById("demo").innerHTML = document.getElementById("tuesday").
    getElementsByTagName("a").item(0).text;;
    $("#main-wrapper").css("-webkit-filter", "blur(10px)");
    $("#header").css("-webkit-filter", "blur(10px)");
    $("#main-wrapper").css("pointer-events", "none");
    $("#header").css("pointer-events", "none");
    $("#show-btn").css("pointer-events", "none");
    $("#show-btn").css("-webkit-filter", "blur(1px)");
}

function PopUpHide() {
    window.location.href = $("#tab").text();
    $("#main-wrapper").css("-webkit-filter", "blur(0px)");
    $("#header").css("-webkit-filter", "blur(0px)");
    $("#main-wrapper").css("pointer-events", "auto");
    $("#header").css("pointer-events", "auto");
    $("#show-btn").css("pointer-events", "auto");
    $("#show-btn").css("-webkit-filter", "blur(0px)");
}

function add() {

}