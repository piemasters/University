<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>BFS Music - Bands</title>
  <meta name="description" content="Rock and metal bands">
  <meta name="author" content="David Norton, Hiten Kotecha, Chris Rollin, Greg Huntley">
  <link rel="stylesheet" href="css/styles.css?v=1.0">
  <link rel="stylesheet" href="css/band_thumbnails.css?v=1.0">
  <script src="js/jquery.js"></script>
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
					<li class="current"><a href="bands.php">Bands</a></li>
					<li><a href="social.php">Social</a></li>
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
		<div class="headlines">
			<a href="shinedown.php">		
				<img src="images\Bands\shinedown_banner.png" alt="Shinedown">	
				<h2><span>Highlight Band: Shinedown</span></h2>
				<h3><span>Shinedown, the chart-topping rock band, continues to churn out hit after hit. </span></h3>
			</a>
		</div>
    </section>
	<!-- /Introduction --> 
	
	<section id="content">

		<article>
			<h1>Bands</h1>
		</article>
	
		<!-- Band Icons --> 
		<article>					
			<div class='thumbnailWrapper'>
				<ul>
					<li>
						<a href="stone_sour.php"><img src="images/Bands/Stone_Sour.jpg" /></a>
						<div class="caption">
							<p class="captionInside">Stone Sour</p>
						</div>
					</li>
					<li>
						<a href="apocalyptica.php"><img src="images/Bands/Apocalyptica.jpg" /></a>
						<div class="caption">
							<p class="captionInside">Apocalyptica</p>
						</div>
					</li>
					</ul>
					<ul>
					<li>
						<a href="flyleaf.php"><img src="images/Bands/Flyleaf.jpg" /></a>
						<div class="caption">
							<p class="captionInside">Flyleaf</p>
						</div>
					</li>
					<li>
						<a href="slash.php"><img src="images/Bands/Slash.jpg" /></a>
						<div class="caption">
							<p class="captionInside">Slash</p>
						</div>
					</li>
				</ul>
			</div>
		</article>
		<!-- /Band Icons -->

	</section>
	
<!-- Footer --> 
	<br class="clear">	
	<br class="clear">	
	<footer id = "footer">
		<?php require 'scripts/loginmessage.php';?>	
		<a href="#top"><img src="images\top.png" alt="Back To Top"></a>
    </footer>
	
    </div>

  <script src="js/core.js"></script>
</body>
</html>