<?php 

// References:
// http://www.gayadesign.com/diy/reading-xml-with-php/
// http://joseblog.netau.net/web_design/using-php-to-parse-an-rss-feed.php
// http://blog.teamtreehouse.com/how-to-parse-xml-with-php5
// http://www.last.fm/api

$xml = simplexml_load_file($bio);

// get the artist page xml file via the last.fm api
// find tags where it is content and echo it

foreach($xml->artist as $var) {
	$artistBio = $var->bio->content;
		}
echo '<p>' . $artistBio . '</p>';

?>