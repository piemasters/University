<?php

	/*
	* Reference: 
	* New Boston Videos, http://thenewboston.org/list.php?cat=11
	* PHPeaststep, http://www.phpeasystep.com/phptu/6.html
	*/

	ob_start();
	session_start();
	//$current_file = $_SERVER['SCRIPT_NAME'];
	//$http_referer = $_SERVER['HTTP_REFERER'];

	// Function which states if user is logged in or not
	function loggedin() {	
		if (isset($_SESSION['myusername'])&&!empty($_SESSION['myusername'])) {
			return true;
		} else {
			return false;
		}
	}
?>