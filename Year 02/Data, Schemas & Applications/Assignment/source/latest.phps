<!doctype html>
<html lang="en">
<head>
  <meta charset='utf-8'> 
  <title>BFS Music</title>
  <meta name="description" content="A dedicated fan site for the best Rock and Metal bands">
  <meta name="author" content="David Norton, Hiten Kotecha, Chris Rollin, Greg Huntley">
  <link rel="stylesheet" href="css/styles.css?v=1.0">
</head>
<body>  
    <div id="wrapper">  
        
		
		<!-- Header -->
		<header role="banner" , id="header">
			
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
					<li class="current"><a href="latest.php">Latest</a></li>
					<li><a href="bands.php">Bands</a></li>
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
			<img src="images\banner.jpg" alt="Logo">	
			<h2><span>Welcome to BFS Music!</span></h2>
			<h3><span>A dedicated fan site for all the best
			& upcoming Rock / Metal bands</span></h3>
		</div>				
    </section>
	<!-- /Introduction --> 
	
	<section id="content">
	
		<?php require 'scripts/writearticles.php';?>

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