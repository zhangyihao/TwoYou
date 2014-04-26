function TouXiang() {
	/*******我的头像事件 start******/
	var $photo = $('#photo');
	$photo.mouseenter(function () {
		 var y = $photo.position().top+46;//获取当前鼠标滑过的内容的顶部坐标
		 var x = $photo.position().left-134;
		 $('.mytravel').css('top', y);
		 $('.mytravel').css('left', x);
		 $('.mytravel').css('z-index','999');
		 $('.mytravel').show();

	});
	$photo.mouseleave(function () {
		 $('.mytravel').hide();

	});
	/*******我的头像事件 end******/
}

function add() {
	var $add = $('#add');
	$add.mouseenter(function () {
		 var y = $add.position().top+46;//获取当前鼠标滑过的内容的顶部坐标
		 var x = $add.position().left-35;
		 $('#add ul').css('top', y);
		 $('#add ul').css('left', x);
		 $('#add ul').show();

	});
	$add.mouseleave(function () {
		 $('#add ul').hide();

	});
}
$(document).ready(function () {
	TouXiang();
	add();
});