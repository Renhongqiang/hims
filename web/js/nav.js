$(function(){
    // nav收缩展开
    $('.nav-item>a').on('click',function(){
        if (!$('.nav').hasClass('nav-mini')) {
            if ($(this).next().css('display') == "none") {
                //展开未展开
                $('.nav-item').children('ul').slideUp(300);
                $(this).next('ul').slideDown(300);
                $(this).parent('li').addClass('nav-show').siblings('li').removeClass('nav-show');
            }else{
                //收缩已展开
                $(this).next('ul').slideUp(300);
                $('.nav-item.nav-show').removeClass('nav-show');
            }
        }
    });
    //nav-mini切换
    $('#mini').on('click',function(){
        if (!$('.nav').hasClass('nav-mini')) {
            $('.nav-item.nav-show').removeClass('nav-show');
            $('.nav-item').children('ul').removeAttr('style');
            $('.nav').addClass('nav-mini');
        }else{
            $('.nav').removeClass('nav-mini');
        }

        if($('#top-span').hasClass("top-span")) {
            $('#top-span').removeClass("top-span");
            $('#top-span').addClass("top-span-no");
        }else {
            $('#top-span').removeClass("top-span-no");
            $('#top-span').addClass("top-span");
        }

        if($('#test').hasClass("maindiv")) {
            $('#test').removeClass("maindiv");
            $('#test').addClass("maindiv2");
        }else {
            $('#test').removeClass("maindiv2");
            $('#test').addClass("maindiv");
        }

    });
});