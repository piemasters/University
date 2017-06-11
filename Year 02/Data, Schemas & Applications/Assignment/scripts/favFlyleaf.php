<?php

require 'database_connection.php';
require 'getFlyleafInfo.php';

session_start();

$sql = "SELECT * FROM user WHERE Username = '" . addslashes($_SESSION['myusername']) . "'";
$usernameQuery = mysql_query($sql);
$rowU = mysql_fetch_array($usernameQuery);

$userID = $rowU['User_ID'];
$artistID = $row['Artist_Name']; // from getShinedownInfo file

$sqlA = "SELECT * FROM artist WHERE Artist_Name = '$artistID'";
$artistQuery = mysql_query($sqlA);
$rowA = mysql_fetch_array($artistQuery);

 // echo $userID;
$id = $rowA['Artist_ID'];

$check = mysql_query("SELECT * FROM artistfavorited WHERE Artist_ID = '$id' AND User_ID = '$userID'");

// $hello = mysql_num_rows($check);

// echo $hello;

if (mysql_num_rows($check) == 0) {

$insertDB = mysql_query("INSERT INTO artistfavorited (Artist_ID, User_ID) VALUES ('$id', '$userID')");
 header('Location: ../flyleaf.php');
} else if (mysql_num_rows($check) != 0) {

$delDB = mysql_query("DELETE FROM artistfavorited WHERE `artistfavorited`.`Artist_ID` = $id AND `artistfavorited`.`User_ID` = $userID");
 header('Location: ../flyleaf.php');
}
// echo "You favourited a Artist";

// $sql = "DELETE FROM `bfs_music`.`artistfavorited` WHERE `artistfavorited`.`Artist_ID` = 1 AND `artistfavorited`.`User_ID` = 4;";


?>