<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>BFS Music - Events</title>
  <meta name="description" content="Rock and metal band events">
  <meta name="author" content="David Norton, Hiten Kotecha, Chris Rollin, Greg Huntley">
  <link rel="stylesheet" href="css/styles.css?v=1.0">
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
					<li class="current"><a href="events.php">Events</a></li>
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
		<h1>Events</h1>
		</section>
		<!-- /Introduction --> 
	
	<section id="content">
	
		<article> 
			<h2>Venue Location Maps</h2>
				
				<h3><a href="javascript: changeDiv('birmingham');">Birmingham |</a>
				<a href="javascript: changeDiv('london');"> London |</a>
				<a href="javascript: changeDiv('bristol');"> Bristol |</a>
				<a href="javascript: changeDiv('manchester');"> Manchester</a></h3>
			
			
			<div id="birmingham" style="display: block;">
				<aside>
					<iframe style="float:right" width="425" height="350" frameborder="0" scrolling="no" 
						marginheight="0" marginwidth="0" src="https://maps.google.co.uk/maps/ms?msa=0&amp;
						msid=218260678772310647403.0004d656f8928f804d73c&amp;ie=UTF8&amp;ll=52.476612,-1.9
						07222&amp;spn=0.006483,0.014806&amp;t=m&amp;z=12&amp;output=embed"></iframe>
				</aside>	
					
				<h4>National Indoor Arena</h4>
				<p>
					The National Indoor Arena (The NIA) is one of the busiest large scale indoor sporting 
					and entertainment venues in Europe. Since opening in 1991, it has welcomed visitors 
					to over 30 different sports (including indoor rowing!) and an extensive variety of 
					entertainment and music.
				</p>
				<a href="http://www.thenia.co.uk/">Go to The NIA website</a>
				<h4>O2 Academy Birmingham</h4>
				<p>
					AMG invested £5.5m in its latest 45,000sq ft development, three state of the art venues 
					that can operate independently as well as simultaneously. With an exceptionally busy 
					diary, O2 Academy Birmingham actively supports new and developing talent in O2 Academy2 
					and O2 Academy 3, through to gigs by top international artists for over 3,000 fans in 
					its main auditorium.
				</p>
				<a href="http://www.o2academybirmingham.co.uk/">Go to The Birmingham O<sub>2</sub> website</a> 
			</div>
			
			<div id="london" style="display: none;">
				<aside>	
					<iframe style="float:right" width="425" height="350" frameborder="0" scrolling="no" 
						marginheight="0" marginwidth="0" src="https://maps.google.co.uk/maps/ms?msa=0&amp;
						msid=218260678772310647403.0004d65ad9bc809fef866&amp;ie=UTF8&amp;ll=51.504972,-0.16
						7284&amp;spn=0.079523,0.128918&amp;t=m&amp;z=10&amp;output=embed"></iframe>
				</aside>	
				
				<h4>Bush Hall</h4>
				<p>
					The lavish decor and ornate plasterwork has been enhanced and defined by Bush Hall's six 
					two-tiered chandeliers. Bush Hall thrives on its versatility, allowing for music and 
					special events alike.
				</p>
				<a href="http://www.bushhallmusic.co.uk/live-music/">Go to the Bush Hall website</a>
				<h4>Union Chapel</h4>
				<p>
					 Union Chapel has become an award winning music venue, regarded as one of the best places 
					 in London to experience live music. The aim of the project is to place the arts and 
					 creativity at the heart of Union Chapel and to increase access and inclusive involvement 
					 in the performing arts.
				</p>
				<a href="http://www.unionchapel.org.uk/">Go to the Union Chapel website</a>
				<h4>O2 Academy Brixton</h4>
				<p>
					O2 Academy Brixton has long been hailed London's flagship venue, a must-play for artists 
					and must-visit for music lovers. It has scooped the NME 'Best Venue' award on an 
					incredible twelve occasions between 1994 and 2007, proving its popularity with fans and 
					the media alike and in 2009, received the Music Week 'Venue Of The Year' Award. With a 
					capacity of almost 5,000, it is truly one of a kind on the circuit and combines the 
					feeling of an electrifying arena sized atmosphere, with great views because of its 
					sloping floor and incredible capabilities for production.
				</p>
				<a href="http://www.o2academybrixton.co.uk">Go to the Brixton O<sub>2</sub> website</a>
			</div>
				
			<div id="bristol" style="display: none;">
				<aside>	
					<iframe style="float:right" width="425" height="350" frameborder="0" scrolling="no" 
						marginheight="0" marginwidth="0" src="https://maps.google.co.uk/maps/ms?msa=0&amp;
						msid=218260678772310647403.0004d66a20afb78789cea&amp;ie=UTF8&amp;t=m&amp;ll=51.4547
						02,-2.59419&amp;spn=0.00936,0.018239&amp;z=12&amp;output=embed"></iframe>
				</aside>	
					
				<h4>The Fleece</h4>
				<p>
					The Fleece is Bristol's largest and best independent venue, hosting a massive variety 
					of live music and club nights.
				</p>
				<a href="http://www.thefleece.co.uk/">Go to The Fleece website</a>
				<h4>O2 Academy Bristol</h4>
				<p>
					Packed full of atmosphere from floor to ceiling, O2 Academy Bristol caters for the wide 
					and varied musical demands of its demographic; from clubbers wanting hip hop, deep house 
					and drum 'n' bass, to students wanting cutting edge indie, rock and alternative. Since 
					October 2001, gig lovers young and old have flocked through its doors for fantastic live 
					performance and is the perfect focal point for the South West's exceptionally creative 
					cultural scene.
				</p>
				<a href="http://www.o2academybristol.co.uk/">Go to the Bristol O<sub>2</sub> website</a>
				<h4>The Bierkeller</h4>
				<p>
					This 'timeless' venue really hasn't changed in the slightest for at least the last 15 years. 
					Possibly the least plush place in Bristol, the main dancefloor is all stone and pillars with 
					rows of benches down the sides. It specialises in rock and metal nights.
				</p>
				<a href="http://www.bristolbierkeller.co.uk">Go to The Bierkeller website</a>
			</div>
				
			<div id="manchester" style="display:none;">
				<aside>	
					<iframe style="float:right" width="425" height="350" frameborder="0" scrolling="no" 
						marginheight="0" marginwidth="0" src="https://maps.google.co.uk/maps/ms?msa=0&amp;
						msid=218260678772310647403.0004d66b308338612c07f&amp;gl=uk&amp;hl=en&amp;ie=UTF8&amp;
						t=m&amp;ll=53.476041,-2.237992&amp;spn=0.024724,0.013132&amp;z=12&amp;output=embed"></iframe>
				</aside>	
					
				<h4>Manchester Arena</h4>
				<p>
					Attracting over one million visitors each year, the 21,000 capacity Arena was named 
					'International Venue of the Year' in 2002 by industry publication Pollstar and has been 
					nominated an unrivalled ten consecutive times.
				</p>
				<a href="http://www.men-arena.com/">Go to The Manchester Arena website</a>
				<h4>The Deaf Institute</h4>
				<p>
					Everything you could want and more... A massive mirror ball, velvet curtains, domed ceiling, 
					smoking terrace, tiered seating and parrots on the wall. Singing, dancing, cavorting, jigging.
					Capacity 260 people.
				</p>
				<a href="http://www.thedeafinstitute.co.uk/">Go to The Deaf Institute website</a>
				<h4>Manchester Academy</h4>
				<p>
					A fantastic venue used for all sorts of music events.
				</p>
					<a href="http://www.manchesteracademy.net">Go to the Manchester Academy website</a>
			</div>
				
			<!-- Code adapted from: User F'Nox of forum.devshed.com -->
			<script type="text/javascript">
				var currentDiv = null;
				var count = 0;
				function changeDiv(nameOfDiv){
					if(currentDiv != null){
						document.getElementById(currentDiv).style.display = "none";
						count = 1;
					}
					if(count == 0){
						document.getElementById('birmingham').style.display = "none";
						count = 1;
					}
					currentDiv = nameOfDiv;
					document.getElementById(currentDiv).style.display = "block";
				}
				</script>
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