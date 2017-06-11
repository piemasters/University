<?php

	/*
	* Reference: 
	* New Boston Videos, http://thenewboston.org/list.php?cat=11
	* PHPeaststep, http://www.phpeasystep.com/phptu/6.html
	*/
	
    require 'login_success.php';

	// Checks if logged in correctly	
	if (loggedin()) {
		// If so go to home
		$redirect_page = '../latest.php';
		$redirect = true;
	} else {
		// Otherwise return to login
		include '../login.php';
	}

	if ($redirect = true) {
		header('Location: ' . $redirect_page);
	}	
?>

