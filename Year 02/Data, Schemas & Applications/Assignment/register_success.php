<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>BFS Music - Login</title>
  <meta name="description" content="User login">
  <meta name="author" content="David Norton, Hiten Kotecha, Chris Rollin, Greg Huntley">
  <link rel="stylesheet" href="css/styles.css?v=1.0">
  <link rel="stylesheet" href="css/loginform.css?v=1.0">
  <link rel="stylesheet" href="css/animate.css?v=1.0">
</head>
<body>     		
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
     	
	<section id="content">
	
		<a class="hiddenanchor" id="toregister"></a>
		<a class="hiddenanchor" id="tologin"></a>
		
			<div id="wrapper">

				<div id="login" class="animate form">
					<form id="loginforms" action="scripts/attempt_login.php" autocomplete="on" method="POST">
						<h1>Log In</h1>
						<fieldset id="inputs">
							<input name="myusername" id="username" type="text" placeholder="Username" autofocus required>   
							<input name="mypassword" id="password" type="password" placeholder="Password" required>
						</fieldset>
						<fieldset id="actions">
							<input type="submit" id="submit" value="Log in">						
							<p class="change_link">Not a member yet ?<a href="#toregister" class="to_register">Join us</a></p>
						</fieldset>
						
					</form>
				</div>
			
				<div id="register" class="animate form">
					<form id="loginforms" action="scripts/attempt_register.php" autocomplete="on" method="POST">
						<h1>Register</h1>
						<fieldset id="inputs">
							<input name="myname" id="name" type="text" placeholder="Name" autofocus required>   
							<input name="myemail" id="email" type="text" placeholder="Email" required>
							<input name="myusername" id="username" type="text" placeholder="Username" autofocus required>   
							<input name="mypassword" id="password" type="password" placeholder="Password" required>
							<input name="confirmpassword"id="confirmpassword" type="password" placeholder="Confirm Password" required>
						</fieldset>
						<fieldset id="actions">
							<input type="submit" id="submit" value="Register">
							<p class="change_link">Already a member ?<a href="#tologin" class="to_register"> Go and log in </a></p>
						</fieldset>
					</form>
				</div>
				
			</div>		

		<article>
			<br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
			<h1>You have successfully created an account! Please log in above!</h1>
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