<?php

	/*
	* Reference: 
	* New Boston Videos, http://thenewboston.org/list.php?cat=11
	* PHPeaststep, http://www.phpeasystep.com/phptu/6.html
	*/
	
	// Obtain User details
	require 'app_config.php';
	
	// Connect to MySQL
	mysql_connect(DATABASE_HOST, DATABASE_USERNAME, DATABASE_PASSWORD)
	or die("<p>Error connecting to database: " . mysql_error() . "</p>");
	//echo "<p>Connected to MySQL!</p>";
	
	// Connect to BFS database
	mysql_select_db(DATABASE_NAME)
	or die("<p>Error selecting the database " . DATABASE_NAME . mysql_error() . "</p>");
	//echo "<p>Connected to MySQL, using database " . DATABASE_NAME . ".</p>";
?>