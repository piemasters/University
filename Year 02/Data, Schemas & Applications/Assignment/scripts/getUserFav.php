<?php

error_reporting(0);
ini_set("display_errors", 0);

require 'database_connection.php';
// require 'login_success.php';

session_start();

$sql = "SELECT * FROM user WHERE Username = '" . addslashes($_SESSION['myusername']) . "'";
$usernameQuery = mysql_query($sql);
$row = mysql_fetch_array($usernameQuery);

// $ID = $row['User_ID'];

// $echo = mysql_query("SELECT * FROM artistfavorited WHERE User_ID = '$ID'");
// echo "<h3>  | ";
// for ($count=0; $count <= mysql_numrows($echo); $count++) {
// 	$name = mysql_result($echo, $count, "Artist_ID");
// 	$getUsername = mysql_fetch_array(mysql_query("SELECT * FROM artist WHERE Artist_ID = $name"));
// 	if ($getUsername['Artist_Name'] != "") {
// 		echo $getUsername['Artist_Name'];
// 		echo " | ";
// 	}					
//    }


// $ID = $row['User_ID'];

// $echo = mysql_query("SELECT * FROM songfavorited WHERE User_ID = '$ID'");
// echo "<h3>  | ";
// for ($count=0; $count <= mysql_numrows($echo); $count++) {
// 	$name = mysql_result($echo, $count, "Song_ID");
// 	$getUsername = mysql_fetch_array(mysql_query("SELECT * FROM song WHERE Song_ID = $name"));
// 	if ($getUsername['Song_Name'] != "") {
// 		echo $getUsername['Song_Name'];
// 		echo " | ";
// 	}					
//    } 


?>