(function () {
'use strict';

$(function () {
  $('.banner').unslider({
    speed: 500, //  The speed to animate each slide (in milliseconds)
    delay: 2000, //  The delay between slide animations (in milliseconds)
    keys: true, //  Enable keyboard (left, right) arrow shortcuts
    dots: true, //  Display dot navigation
    fluid: true //  Support responsive design. May break non-responsive designs
  });

  $('#banner>ul>li').click(function () {
    console.log($(this).attr('data-id'));
  });

  $('.pointer').hover(function () {
    $(this).find('.link-msg').css({ top: '-100%' });
    $(this).find('.link-msg').stop(false, true).animate({ top: '0' });
  }, function () {
    $(this).find('.link-msg').stop(false, true).animate({ top: '100%' });
  });
});
  //搜索的点击事件
 $("#searchBtn").click(function () {
    var search=$('#searchInput').val();
     window.location.href='http://www.duxiu.com/gosearch.jsp?sw='+search;

 });

}());
