<?php

require 'database_connection.php';
require 'getShinedownInfo.php';

session_start();

$sql = "SELECT * FROM user WHERE Username = '" . addslashes($_SESSION['myusername']) . "'";
$usernameQuery = mysql_query($sql);
$rowU = mysql_fetch_array($usernameQuery);

$userID = $rowU['User_ID'];

$songID = $data1['Song_ID']; //needs to change to $data2 / $data3 / $data4 / $data5

// echo $userID;
// echo $songID;

$sqlA = "SELECT * FROM song WHERE Song_ID = '$songID'";
$songQuery = mysql_query($sqlA);
$rowA = mysql_fetch_array($songQuery);

 // echo $userID;
$id = $rowA['Song_ID'];

$check = mysql_query("SELECT * FROM songfavorited WHERE Song_ID = '$id' AND User_ID = '$userID'");

// $hello = mysql_num_rows($check);

// echo $hello;

if (mysql_num_rows($check) == 0) {

$insertDB = mysql_query("INSERT INTO songfavorited (Song_ID, User_ID) VALUES ('$id', '$userID')");
header('Location: ../shinedown.php');
} else if (mysql_num_rows($check) != 0) {

$delDB = mysql_query("DELETE FROM songfavorited WHERE `songfavorited`.`Song_ID` = $id AND `songfavorited`.`User_ID` = $userID");
header('Location: ../shinedown.php');
}




?>