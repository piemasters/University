<?php
/* This script gets information about the band from the database, which is then
reference from the main band page in order to get specifc information */


require 'database_connection.php';

$artistQuery = mysql_query("SELECT * FROM artist WHERE Artist_Name ='Shinedown'");
$row = mysql_fetch_array($artistQuery);

$data1 = mysql_fetch_array(mysql_query("SELECT * FROM `song` WHERE Song_ID = 12"));
$data2 = mysql_fetch_array(mysql_query("SELECT * FROM `song` WHERE Song_ID = 16"));
$data3 = mysql_fetch_array(mysql_query("SELECT * FROM `song` WHERE Song_ID = 27"));
$data4 = mysql_fetch_array(mysql_query("SELECT * FROM `song` WHERE Song_ID = 41"));
$data5 = mysql_fetch_array(mysql_query("SELECT * FROM `song` WHERE Song_ID = 43"));
$albumname1 = mysql_fetch_array(mysql_query("SELECT * FROM `album` WHERE Album_ID = $data1[Album_ID]"));
$albumname2 = mysql_fetch_array(mysql_query("SELECT * FROM `album` WHERE Album_ID = $data2[Album_ID]"));
$albumname3 = mysql_fetch_array(mysql_query("SELECT * FROM `album` WHERE Album_ID = $data3[Album_ID]"));
$albumname4 = mysql_fetch_array(mysql_query("SELECT * FROM `album` WHERE Album_ID = $data4[Album_ID]"));
$albumname5 = mysql_fetch_array(mysql_query("SELECT * FROM `album` WHERE Album_ID = $data5[Album_ID]"));
$artistname1 = mysql_fetch_array(mysql_query("SELECT * FROM `artist` WHERE Artist_ID = $albumname1[Artist_ID]"));
$artistname2 = mysql_fetch_array(mysql_query("SELECT * FROM `artist` WHERE Artist_ID = $albumname2[Artist_ID]"));
$artistname3 = mysql_fetch_array(mysql_query("SELECT * FROM `artist` WHERE Artist_ID = $albumname3[Artist_ID]"));
$artistname4 = mysql_fetch_array(mysql_query("SELECT * FROM `artist` WHERE Artist_ID = $albumname4[Artist_ID]"));
$artistname5 = mysql_fetch_array(mysql_query("SELECT * FROM `artist` WHERE Artist_ID = $albumname5[Artist_ID]"));

?>