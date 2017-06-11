	/*
	* Reference: 
	* tympanus, http://tympanus.net/Tutorials/LoginRegistrationForm/#tologin
	*/

$(window).load(function(){

	// Set and get some variables
	var thumbnail = {
		imgIncrease : 100, /* the image increase in pixels (for zoom) */
		effectDuration : 400, /* the duration of the effect (zoom and caption) */
		/*
		Get the width and height of the images. Going to use those
		for 2 things:
			make the list items same size
			get the images back to normal after the zoom
		*/
		imgWidth : $('.thumbnailWrapper ul li').find('img').width(),
		imgHeight : $('.thumbnailWrapper ul li').find('img').height()

	};

	// Make the list items same size as the images
	$('.thumbnailWrapper ul li').css({

		'width' : thumbnail.imgWidth,
		'height' : thumbnail.imgHeight

	});

	// When mouse over the list item...
	$('.thumbnailWrapper ul li').hover(function(){

		$(this).find('img').stop().animate({

			/* Increase the image width for the zoom effect*/
			width: parseInt(thumbnail.imgWidth) + thumbnail.imgIncrease,
			/* We need to change the left and top position in order to
			have the zoom effect, so we are moving them to a negative
			position of the half of the imgIncrease */
			left: thumbnail.imgIncrease/2*(-1),
			top: thumbnail.imgIncrease/2*(-1)

		},{

			"duration": thumbnail.effectDuration,
			"queue": false

		});

		// Show the caption using slideDown event
		$(this).find('.caption:not(:animated)').slideDown(thumbnail.effectDuration);

	// When mouse leave...
	}, function(){

		// Find the image and animate it...
		$(this).find('img').animate({

			/* Get it back to original size (zoom out) */
			width: thumbnail.imgWidth,
			/* Get left and top positions back to normal */
			left: 0,
			top: 0

		}, thumbnail.effectDuration);

		// Hide the caption using slideUp event
		$(this).find('.caption').slideUp(thumbnail.effectDuration);

	});

});
