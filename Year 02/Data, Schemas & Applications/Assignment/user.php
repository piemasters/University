<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>BFS Music - User Homepage</title>
  <meta name="description" content="Rock and metal band widgets">
  <meta name="author" content="David Norton, Hiten Kotecha, Chris Rollin, Greg Huntley">
  <script src="js/jquery.js"></script>
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
					<li><a href="events.php">Events</a></li>
					<li><a href="gallery.php">Gallery</a></li>
					<li class="current"><?php require 'scripts/userbutton.php';?></li>
				</ul>
			</nav>
			<!-- /Nav -->
			
			<br class="clear">
	
	</header>
	<!-- /Header -->
     
    <!-- Introduction --> 	 
    <section id="intro">  
		<?php						
			echo '<h1>Welcome ' . $_SESSION['myusername'] . '!</h1>';
		?>		
    </section>
	<!-- /Introduction --> 
	   
	<section id="content">
		<article>
		<?php require 'scripts/getUserFav.php';?>
			<h1>User Details</h1>
			<h3>Username: </h3><?=$row['Username'];?>
			</br>
			<h3>Email Address: </h3><?=$row['Email_Address'];?>

			<h1>Favourited Artists</h1>
			<p>	
				<?php 
				$ID = $row['User_ID'];
				$echo = mysql_query("SELECT * FROM artistfavorited WHERE User_ID = '$ID'");
				echo "<h3>  | ";
				for ($count=0; $count <= mysql_numrows($echo); $count++) {
				$name = mysql_result($echo, $count, "Artist_ID");
				$getUsername = mysql_fetch_array(mysql_query("SELECT * FROM artist WHERE Artist_ID = $name"));
				if ($getUsername['Artist_Name'] != "") {
					echo $getUsername['Artist_Name'];
						echo " | ";
							}					
   				} ?>
			</p>

			<h1>Favourited Songs</h1>
			<p>
				<?php
					$ID = $row['User_ID'];

					$echo = mysql_query("SELECT * FROM songfavorited WHERE User_ID = '$ID'");
					echo "<h3>  | ";
					for ($count=0; $count <= mysql_numrows($echo); $count++) {
					$name = mysql_result($echo, $count, "Song_ID");
					$getUsername = mysql_fetch_array(mysql_query("SELECT * FROM song WHERE Song_ID = $name"));
					if ($getUsername['Song_Name'] != "") {
					echo $getUsername['Song_Name'];
					echo " | ";
							}					
  						 } 
				?>
			</p>
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