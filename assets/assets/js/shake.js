(function($) {
	var fish = document.querySelector('.fish');
	var $fish = $('.fish');
	var $shakeCaptcha = $('.shake-captcha');
	var shakeCaptcha = document.querySelector('.shake-captcha');
<<<<<<< HEAD
	// var output = document.querySelector('.output');
=======
	var output = document.querySelector('.output');
>>>>>>> f95b1b80a18ba9384225d75d4c20ae79a18ba82f

	var maxX = shakeCaptcha.clientWidth - fish.clientWidth;
	var maxY = shakeCaptcha.clientHeight - fish.clientHeight;

	function handleOrientation(event) {
		var x = event.beta; // In degree in the range [-180,180]
		var y = event.gamma; // In degree in the range [-90,90]

<<<<<<< HEAD
		// output.innerHTML = "beta : " + x + "\n";
		// output.innerHTML += "gamma: " + y + "\n";
=======
		//output.innerHTML = "beta : " + x + "\n";
		//output.innerHTML += "gamma: " + y + "\n";
>>>>>>> f95b1b80a18ba9384225d75d4c20ae79a18ba82f

		// Because we don't want to have the device upside down
		// We constrain the x value to the range [-90,90]
		if (x > 90) {
			x = 90;
		}
		if (x < -90) {
			x = -90;
		}

		// To make computation easier we shift the range of 
		// x and y to [0,180]
		x += 90;
		y += 90;

		// 10 is half the size of the ball
		// It center the positioning point to the center of the ball
		// ball.style.top = (maxX * x / 180 - 10) + "px";
		// ball.style.left = (maxY * y / 180 - 10) + "px";

		fish.style.left = (maxY * y / 180 - 10) + "px";
		var left = $(fish).offset().left;

<<<<<<< HEAD
		if (left < 70) {
=======
		if (left < 100) {
>>>>>>> f95b1b80a18ba9384225d75d4c20ae79a18ba82f
			$fish.addClass('animg50');
			$fish.on('webkitAnimationEnd', function() {
				$shakeCaptcha.trigger('failure');
			});
			window.removeEventListener("deviceorientation", handleOrientation, true);
		}

<<<<<<< HEAD
		if (left > 215) {
=======
		if (left > 235) {
>>>>>>> f95b1b80a18ba9384225d75d4c20ae79a18ba82f
			$fish.addClass('animg150');
			$fish.on('webkitAnimationEnd', function() {
				$fish.hide();
				$('.cat').hide();
				$('.cat-get-fish').show();
				setTimeout(function() {
					$shakeCaptcha.trigger('success');
				}, 200);
			});
			window.removeEventListener("deviceorientation", handleOrientation, true);
		}
	}

	$.verify({
		target: '.shake-captcha',
		content: '<h4 class="yes toast">验证成功</h4><h4 style="display: none" class="no toast">验证失败</h4>',
		initUI: function() {
			this.target.append('<div class="mask" style="display: none"></div>');
			this.target.find('.mask').append(this.content);
		},
		// 验证成功
		success: function() {
			console.log('success');
			var target = this.target;
			target.find('.mask').show();
			target.find('.yes').show();
			target.find('.no').hide();
			try {
				return control.toastMessage(1);
			} catch (e) {}
		},
		// 验证失败
		failure: function() {
			console.log('failure');
			var target = this.target;
			target.find('.mask').show();
			target.find('.yes').hide();
			target.find('.no').show();
			// 与webview交互
			try {
				return control.toastMessage(0);
			} catch (e) {}
		}
	});

	window.addEventListener("deviceorientation", handleOrientation, true);
})(Zepto)