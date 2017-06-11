<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>BFS Music - Shinedown</title>
  <meta name="description" content="Shinedown">
  <meta name="author" content="David Norton, Hiten Kotecha, Chris Rollin, Greg Huntley">
  <link rel="stylesheet" href="css/styles.css?v=1.0">
  <script src="js/jquery.js"></script>
</head>
<body>  
    <div id="wrapper">  
        
		
		<!-- Header -->
		<header role="banner", id="header">
		
			<!-- Logo -->
			<div id="logo">
				<a href="latest.php">
					<img src="images/logo2.png" alt="Logo">
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
	
	<?php require 'scripts/getShinedownInfo.php';?>
	
	<section id="content">
	
		<article>
			<h2><?=$row['Intro'];?></h2>
		</article>
		
		<aside> 
			<img src="<?=$row['Image_Location'];?>" alt="Shinedown">
			<div id="fav"><img src="images/star.png" alt="Fav"></div>
			<h2><?=$row['Artist_Name']?></h2>
			
		</aside>
		
		<aside> 
			<h2>Top Fans</h2>
			<p>There are currently no fans yet!</p>
		</aside>
			
		<article>
			<?=$row['Info'];?>
		</article>
		
		<article>
			<h3>Genre</h3>
			<p><?=$row['Genre'];?></p>				
		</article>
		
		<article>
		
		<span id="right"><p>Sort: <a>Recently Added </a> | <a> Most Favourited</a></p></span> 
		<h3>Top Songs</h3>
			
			<table>
				<thead>
					<tr>
						<th></th>
						<th>Name</th>
						<th>Composer</th>
						<th>Album</th>
						<th>Time</th>
						<th>Favorite</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td id="play"><img src="images/play.png" alt="Play" id="song1"></td>
						<td><?=$data1['Song_Name']?></td>
						<td><?=$artistname1['Artist_Name']?></td>
						<td><?=$albumname1['Album_Name']?></td>
						<td><?=$data1['Duration']?></td>
						<td id="star"><img src="images/star.png" alt="Fav"></td>
					</tr>
					<tr>
						<td id="play"><img src="images/play.png" alt="Play" id="song2"></td>
						<td><?=$data2['Song_Name']?></td>
						<td><?=$artistname2['Artist_Name']?></td>
						<td><?=$albumname2['Album_Name']?></td>
						<td><?=$data2['Duration']?></td>
						<td id="star"><img src="images/star.png" alt="Fav"></td>
					</tr>
					<tr>
						<td id="play"><img src="images/play.png" alt="Play" id="song3"></td>
						<td><?=$data3['Song_Name']?></td>
						<td><?=$artistname3['Artist_Name']?></td>
						<td><?=$albumname3['Album_Name']?></td>
						<td><?=$data3['Duration']?></td>
						<td id="star"><img src="images/star.png" alt="Fav"></td>
					</tr>
					<tr>
						<td id="play"><img src="images/play.png" alt="Play" id="song4"></td>
						<td><?=$data4['Song_Name']?></td>
						<td><?=$artistname4['Artist_Name']?></td>
						<td><?=$albumname4['Album_Name']?></td>
						<td><?=$data4['Duration']?></td>
						<td id="star"><img src="images/star.png" alt="Fav"></td>
					</tr>
					<tr>
						<td id="play"><img src="images/play.png" alt="Play" id="song5"></td>
						<td><?=$data5['Song_Name']?></td>
						<td><?=$artistname5['Artist_Name']?></td>
						<td><?=$albumname5['Album_Name']?></td>
						<td><?=$data5['Duration']?></td>
						<td id="star"><img src="images/star.png" alt="Fav"></td>
					</tr>
				</tbody>
			</table>
			
		</article>
		
	</section>
	
<!-- Footer --> 
	<br class="clear">	
	<br class="clear">	
    <footer id = "footer">
		<?php require 'scripts/loginmessage.php';?>
		<?php require 'scripts/songs.php';?>	
		<b id='playSong'></b>
		<a href="#top"><img src="images/top.png" alt="Back To Top"></a>
    </footer>
	
    </div>  
</body>
</html>