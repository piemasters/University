<?php

	/*
	* Reference: 
	* New Boston Videos, http://thenewboston.org/list.php?cat=11
	* PHPeaststep, http://www.phpeasystep.com/phptu/6.html
	*/

	session_start();
	// Connect to database
	require 'database_connection.php';
	$tbl_name="user"; // Table name
	
	// username and password sent from form 
	$myusername = $_POST["myusername"]; 
	$mypassword=$_POST["mypassword"]; 
	$hashpass = md5($mypassword);

	// To protect MySQL injection
	$myusername = stripslashes($myusername);
	$mypassword = stripslashes($mypassword);
	$myusername = mysql_real_escape_string($myusername);
	$mypassword = mysql_real_escape_string($mypassword);
	
	$sql="SELECT * FROM $tbl_name WHERE username='$myusername' and password='$hashpass'";
	$result=mysql_query($sql);

	// Mysql_num_row is counting table row
	$count=mysql_num_rows($result);

	// If result matched $myusername and $mypassword, table row must be 1 row
	if($count==1){
	// Register $myusername, $mypassword and redirect to file
		$_SESSION['myusername'] = $myusername;
		$_SESSION['mypassword'] = $hashpass; 
		header("location:../latest.php");
	}
	else {
		header("location:../login_error.php");
	}
?>