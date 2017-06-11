<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>BFS Music - Widgets</title>
  <meta name="description" content="Rock and metal band widgets">
  <meta name="author" content="David Norton, Hiten Kotecha, Chris Rollin, Greg Huntley">
  <link rel="stylesheet" href="css/styles.css?v=1.0">
  <link rel="stylesheet" href="css/flickrgallery.css?v=1.0">
  <?php include("/scripts/phpFlickrGallery/phpFlickrGallery.php");
  $username = 'Scenes of Madness Photography'; $amount_per_page = 12; ?>
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
					<li><a href="social.php">Social</a></li>
					<li><a href="events.php">Events</a></li>
					<li class="current"><a href="gallery.php">Gallery</a></li>
					<li><?php require 'scripts/userbutton.php';?></li>
				</ul>
			</nav>
			<!-- /Nav -->
			
			<br class="clear">
	
	</header>
	<!-- /Header -->
     
    <!-- Introduction --> 	 
    <section id="intro">  
		<h1>Gallery</h1>		
    </section>
	<!-- /Introduction --> 
	
	<section id="content">
	
		<article>
		<h1>Latest Photos!</h1>
			<?php showGallery($username, $amount_per_page); ?>
		</article>

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