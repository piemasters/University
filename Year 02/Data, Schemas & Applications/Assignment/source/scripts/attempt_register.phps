<?php

	/*
	* Reference: 
	* New Boston Videos, http://thenewboston.org/list.php?cat=11
	*/

	session_start();
	// Connect to database
	require 'database_connection.php';
	$tbl_name="user"; // Table name
	
	// Get values from html form
	$name = $_POST["myname"];
	$email = $_POST["myemail"];
	$username = $_POST["myusername"];
	$password = $_POST["mypassword"];
	$cpassword = $_POST["confirmpassword"]; 
	$hashpass = md5($password);
	
	// check passwords match
	if($password != $cpassword){
		die(header("location:../register_error1.php#toregister"));
	}
	//get user info
	$check_user = "SELECT * FROM `user` WHERE Username='$username'";
	$result = mysql_query($check_user);
	$rows = mysql_num_rows($result);
    // check is username is available
	if($rows == 1){
		header("location:../register_error2.php#toregister");
	}else{
		$add_user = "INSERT INTO `user`(`Username`, `Password`, `Email_Address`) VALUES ('$username','$hashpass','$email')";
		$result2 = mysql_query($add_user) or die (print "Failed to add user");
		$_SESSION['myusername'] = $myusername;
		$_SESSION['mypassword'] = $hashpass; 
		header("location:../register_success.php");
	}
	
?>