<?php 

error_reporting(0);
ini_set("display_errors", 0);
 
$doc = new DOMDocument(); 
$doc->load( 'scripts/articles.xml' ); 
   
$articles = $doc->getElementsByTagName( "article" ); 
foreach( $articles as $article ) 
{ 
  $titles = $article->getElementsByTagName( "title" ); 
  $title = $titles->item(0)->nodeValue; 
   
  $headers= $article->getElementsByTagName( "header" ); 
  $header= $headers->item(0)->nodeValue; 
  
  $images = $article->getElementsByTagName( "image" ); 
  $image = $images->item(0)->nodeValue;
  
  $videos = $article->getElementsByTagName( "video" ); 
  $video = $videos->item(0)->nodeValue;
  
  $captions = $article->getElementsByTagName( "caption" ); 
  $caption = $captions->item(0)->nodeValue;
   
  $bodies = $article->getElementsByTagName( "body" ); 
  $body = $bodies->item(0)->nodeValue; 
   
  echo "<article><h1>$title</h1>";
  echo "<h2>$header</h2>";
  if ($image != "") {
	echo "<aside><img src=$image>";
  }
  if ($video != "") {
	echo "<aside><video width='320' height='240' controls source src=$video>";
  }
  echo "<caption>$caption</caption></aside>";
  echo "$body</article>"; 
  } 
?>