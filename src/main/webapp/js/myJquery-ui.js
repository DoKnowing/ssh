
$(function () {

    $("body").css("padding-left","50px");
    $("body").css("padding-right","50px");
    $("body").css("background-image","url(/imgs/others/clientbground0.jpg)");
    $("body").css("background-size","cover");
    // $("body").css("font-style","italic");

    var boarddiv = "<div id='topImg' style='height:100px;top:0;margin-top:0px;text-align:center;vertical-align: middle;font-size: 50px;color: white;'>大学生活动交友平台</div>";
    var boarddiv1 = "<div id='bottomImg' style='position:absolute; bottom:0; right:25px'><img src='/imgs/others/right0.png' width='250' height='500'></div>";

    $(document.body).prepend(boarddiv);
    $("#topImg").css("background-image","url(/imgs/others/top0.jpg)");
    $(document.body).prepend(boarddiv1);
    $( "input[type=submit],input[type=reset], a, button" )
        .button();
    $("select").selectmenu();
    $( "input[type='checkbox']" ).checkboxradio();
    $( "input[type='radio']" ).checkboxradio();



});
