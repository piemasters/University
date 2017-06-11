<?php
				
error_reporting(0);
ini_set("display_errors", 0);
echo "<h3>  | ";
for ($count=0; $count <= mysql_numrows($echo); $count++) {
	$name = mysql_result($echo, $count, "User_ID");
	$getUsername = mysql_fetch_array(mysql_query("SELECT * FROM user WHERE User_ID = $name"));
	if ($getUsername['Username'] != "") {
		echo $getUsername['Username'];
		echo " | ";
	}					
   } 
echo "</h3>";?>