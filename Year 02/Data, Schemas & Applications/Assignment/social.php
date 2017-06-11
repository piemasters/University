<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>BFS Music - Widgets</title>
  <meta name="description" content="Rock and metal band widgets">
  <meta name="author" content="David Norton, Hiten Kotecha, Chris Rollin, Greg Huntley">
  <link rel="stylesheet" href="css/styles.css?v=1.0">
  <link rel="stylesheet" href="css/slider.css?v=1.0">
</head>
<body>  
    <div id="wrapper">  
        
		
		<!-- Header -->
		<header role="banner", id="header">
			
			<!-- Logo -->
			<div id="logo">
				<a href="latest.php">
					<img src="images\logo2.png" alt="Logo">
				</a>
			</div>
			<!-- /Logo -->
			
			<!-- Nav -->
			<nav id="nav" role="navigation">
				<ul>
					<li><a href="latest.php">Latest</a></li>
					<li><a href="bands.php">Bands</a></li>
					<li class="current"><a href="social.php">Social</a></li>
					<li><a href="events.php">Events</a></li>
					<li><a href="gallery.php">Gallery</a></li>
					<li><?php require 'scripts/userbutton.php';?></li>
				</ul>
			</nav>
			<!-- /Nav -->
			
			<br class="clear">
	
	</header>
	<!-- /Header -->
     
    <!-- Introduction --> 	 
    <section id="intro">  
		<h1>Social</h1>		
    </section>
	<!-- /Introduction --> 
	
	<section id="content">
		
		<!-- Bio -->
		<article>
		
			<h1>Latest News & Social Feeds</h1>

			<center><script type="text/javascript" src="http://jh.revolvermaps.com/2/1.js?i=7a1zjq80b40&amp;s=220&amp;m=2&amp;v=true&amp;r=true&amp;b=f0f0ed&amp;n=false&amp;c=ff0000" async="async"></script></center>
			
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
			<script src="js/slides.min.jquery.js"></script>

			<script>
				$(function(){
					$('#slides').slides({
						generateNextPrev: false,
						preload: false,
						play: 7500
					});
				});
			</script>

			<div id="slides">
				<div class="slides_container">
					<div>
						<h1>Apocalyptica</h1>
						<?php 
							$bio = "http://ws.audioscrobbler.com/2.0/?method=artist.getinfo&artist=Apocalyptica&api_key=7d1cf605a874d212abc7c62b127ab61f";
							require 'scripts/bio.php';
						?>
						<center><?php @readfile('http://output21.rssinclude.com/output?type=php&id=645431&hash=29ab52890fe1e28bb258f555c2f5c756')?></center>
					</div>
					<div>
						<h1>Flyleaf</h1>
						<?php 
							$bio = "http://ws.audioscrobbler.com/2.0/?method=artist.getinfo&artist=Flyleaf&api_key=7d1cf605a874d212abc7c62b127ab61f";
							require 'scripts/bio.php';
						?>
						<center><?php @readfile('http://output74.rssinclude.com/output?type=php&id=645462&hash=e9d5a70d8d23047a851aa981710a940e')?></center>
					</div>
					<div>
						<h1>Shinedown</h1>
						<?php 
							$bio = "http://ws.audioscrobbler.com/2.0/?method=artist.getinfo&artist=Shinedown&api_key=7d1cf605a874d212abc7c62b127ab61f";
							require 'scripts/bio.php';
							
						?>
						<center><?php @readfile('http://output26.rssinclude.com/output?type=php&id=645419&hash=243cce853784845caaf0ce2e74a76be5')?></center>
					</div>
					<div>
						<h1>Slash</h1>
						<?php 
							$bio = "http://ws.audioscrobbler.com/2.0/?method=artist.getinfo&artist=Slash&api_key=7d1cf605a874d212abc7c62b127ab61f";
							require 'scripts/bio.php';
						?>
						<center><?php @readfile('http://output54.rssinclude.com/output?type=php&id=641595&hash=960ab14c7f7fdac09acec6a571595bd6')?></center>
					</div>
					<div>
						<h1>Stone Sour</h1>
						<?php 
							$bio = "http://ws.audioscrobbler.com/2.0/?method=artist.getinfo&artist=Stone+Sour&api_key=7d1cf605a874d212abc7c62b127ab61f";
							require 'scripts/bio.php';
						?>
						<center><?php @readfile('http://output48.rssinclude.com/output?type=php&id=645428&hash=67aab47fc4461f156fb65fed0858f342')?></center>
					</div>
				</div>
			</div>
		</article>
		
		<!-- /Bio --> 

		 <!-- Twitter  
		
		<article>
			<center>
				<a class="twitter-timeline" href="https://twitter.com/Shinedown" data-widget-id="306383485172588544">Tweets by @Shinedown</a>
				<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];
					if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src="//platform.twitter.com/widgets.js";
					fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");
				</script>
			</center>
		</article>
		 /Twitter --> 	

	</section>
	
<!-- Footer --> 
	<br class="clear">	
	<br class="clear">	
    <footer id = "footer">
		<?php require 'scripts/loginmessage.php';?>	
		<a href="#top"><img src="images\top.png" alt="Back To Top"></a>
    </footer>
	
    </div>  
</body>
</html>