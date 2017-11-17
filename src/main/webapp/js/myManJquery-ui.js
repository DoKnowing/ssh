
$(function () {

    $("body").css("padding-left","50px");
    $("body").css("padding-right","50px");
    $("body").css("background-image","url(/imgs/others/background.jpg)");
    $("body").css("background-size","cover");
    var boarddiv = "<div id='topImg' style='height:100px;top:0;margin-top:0px;text-align:center;vertical-align: middle;font-size: 50px;color: white;'>大学生活动管理平台</div>";
    $(document.body).prepend(boarddiv);
    $("#topImg").css("background-image","url(/imgs/others/top.jpg)");

    $( "input[type=submit],input[type=reset], a, button" )
        .button();
    $("select").selectmenu();
    $( "input[type='checkbox']" ).checkboxradio();
    $( "input[type='radio']" ).checkboxradio();



});
