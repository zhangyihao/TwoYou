var totalPic = 1; //记录加载的图片的总数
var flag = true;  //标记下拉时是否继续加载图片

function FavShow() {
	var $btns = $(this).children().eq(0).children('div').eq(0);
	$btns.css('top', 0);
	$btns.css('left', 0);
	$btns.css('z-index','111');
	$btns.height($(this).height());
	$btns.show();
}
function FavHide() {
	$(this).children().eq(0).children('div').eq(0).hide();
}
function boxEvent() {
	var $box = $('#masonry').children();
	$box.each(function () {
		$(this).mouseenter(FavShow);
		$(this).mouseleave(FavHide);
	});
}

function WaterFall(){
	var $container = $('#masonry');
	$container.imagesLoaded( function(){
		$container.masonry({
			itemSelector : '.box', //class选择器，默认.item
			gutterWidth : 10, //列的间隙
			isAnimated: true, //使用Jquery的布局变化，默认为true
		});
	});

	//滚动条滚动到离底部距离50的时候触发
	$(window).scroll(function(){
		// 当滚动到最底部以上100像素时， 加载新内容
		if ($(document).height() - $(this).scrollTop() - $(this).height()<50){
			if (flag){
				//调用getList()方法获取要加载的图片信息
				var $boxes = $(getList());
				$container.append($boxes).masonry('appended',$boxes);
				boxEvent();
			}
		}
		/*item_callback();*/
	});
}

/*
function WaterFallCallBack() {
	item_callback();
	$('.item').fadeIn();
}

function item_callback() {
	item_masonry();
}
*/
function getList() {
	var boxes = [],count = parseInt(Math.random()*40+1);
	for (var i=2; i <=count; i++ ) {
		if(i!=17 && i!=9 && i!=14 && i!=5 && i!=11 && i!=15) {
			totalPic++;
			var str = '<div class="box">'
				+'<div class="img">'
					+'<a href="#"><img src="images/'+i+'.jpg" /></a>'
					+'<div class="btns" style="display:none;">'
						+'<a href="#" class="col">收藏</a>'
						+'<a href="#" class="fav"><span></span></a>'
					+'</div>'
				+'</div>'
				+'<div class="title">'
					+'<div class="desc"><a href="#">这是一只可爱的猫</a></div>'
					+'<div class="favnum">喜欢(122)</div>'
				+'</div>'
				+'<div class="comment">'
					+'<dl>'
						+'<dt><a href="#"><img src="images/tx1.jpg"/></a></dt>'
						+'<dd class="author"><a href="#">张益达</a></dd>'
						+'<dd><a href="#">在北京的日子</a></dd>'
					+'</dl>'
				+'</div>'
			+'</div>';

			boxes.push(str);
			if(totalPic>=210){
				flag=false;
			}
		}
	}
	//把数组转成字符串
	return boxes.join("");
};

function init() {
	var $container = $('#masonry');
	var $div;
	var fav;
	for(var i=3; i<=41; i++) {
		if(i!=17 && i!=9 && i!=14 && i!=15 && i!=5 && i!=11) {
			totalPic++;
			$img = $('<div class="img"><a href="#"><img src="images/'+i+'.jpg"></a><div class="btns" style="display:none;">'
						+'<a href="#" class="col">收藏</a>'
						+'<a href="#" class="fav"><span></span></a>'
					+'</div></div>');
			if(i%4!=0) {
				fav = '<div class="favnum">喜欢(122)</div>';
			} else {
				fav = '';
			}
			$title = $('<div class="title"><div class="desc"><a href="#">这是一只可爱的猫</a></div>'+fav+'</div>');
			$comment = $('<div class="comment"><dl><dt><a href="#"><img src="images/tx1.jpg"/></a></dt><dd class="author"><a href="#">张益达</a></dd>'
					+'<dd><a href="#">在北京的日子</a></dd></dl></div>');
			$div = $('<div class="box"></div>');
			$div.append($img).append($title).append($comment);
			$container.append($div);
		}
	}
}

$(document).ready(function () {
	init();
	WaterFall();
	boxEvent();
});

$(function(){
	//当滚动条的位置处于距顶部100像素以下时，跳转链接出现，否则消失
	$(function () {
		$(window).scroll(function(){
			if ($(window).scrollTop()>100){
				$("#back-to-top").fadeIn(1500);
			} else{
				$("#back-to-top").fadeOut(1500);
			}
		});
		//当点击跳转链接后，回到页面顶部位置
		$("#back-to-top").click(function(){
			$('body,html').animate({scrollTop:0},1000);
			return false;
		});
	});
});