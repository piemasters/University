<?PHP
	require_once "database_connection.php";
	
	$songquery = mysql_query("SELECT `Song_ID` FROM `songfavorited` LIMIT 7");
	$artistquery = mysql_query("SELECT `Artist_ID` FROM `artistfavorited` LIMIT 3");

	$songids = Array();
	while($songresult = mysql_fetch_array($songquery)){
		$songids[] = $songresult["Song_ID"];
	}
	$artids = Array();
	while($artistresult = mysql_fetch_array($artistquery)){
		$artids[] = $artistresult["Artist_ID"];
		
 	}
	
	$intro = '<?xml version="1.0" encoding="UTF-8"?>
<rss version="2.0">
<channel>
	<title>Recently Favourited Items</title>
	<link>http://www.cems.uwe.ac.uk/~d3-norton</link>
	<description>BFS Music - A place to spread the sounds</description>
	<language>en-gb</language>
			';			
			
	$ending = '
</channel>
</rss>
</xml>';
	
	echo $intro;
	$i = 0;
	while($i <= 6){
		$resong = mysql_fetch_array(mysql_query("SELECT * FROM `song` WHERE Song_ID = $songids[$i]"));
		echo "
	<item>
		<title>".$resong['Song_Name']."</title>
		<link>"."http://www.cems.uwe.ac.uk/~d3-norton/".$resong['Song_Location']."</link>
		<description>"."Duration ".$resong['Duration']."</description>
	</item>";
		$i++;
	}
	
	
		$r = 0;
	while($r <= 2){
		$reart = mysql_fetch_array(mysql_query("SELECT * FROM `artist` WHERE Artist_ID = $artids[$r]"));
		echo "
	<item>
		<title>".$reart['Artist_Name']."</title>
		<link>"."www.cems.uwe.ac.uk/~d3-norton/".$reart['Image_Location']."</link>
		<description></description>
	</item>";
		$r++;
	}
	
	echo $ending;
?>	