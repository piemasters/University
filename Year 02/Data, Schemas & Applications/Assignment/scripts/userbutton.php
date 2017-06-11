<?php
	require 'scripts/login_success.php';	
	if (loggedin()) {
		echo '<a href="user.php">' . $_SESSION['myusername'] . '\'s Profile</a>';
	} else { 
		echo '<a href="login.php">Login</a>';
	}
?>