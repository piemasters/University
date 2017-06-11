<?php

  include("flickr_functions.php");
  
/* 
    References: 
	- New Boston, PHP Guides, http://thenewboston.org/list.php?cat=11
	- NetTuts, How to Create a Photo Gallery using the Flickr API,
		http://net.tutsplus.com/tutorials/php/how-to-create-a-photo-gallery-using-the-flickr-api/
	- Mikel, phpFlickrGallery, http://www.mdp3.net
	- Flickr, API documentation, http://www.flickr.com/services/api/	
	- DSA Lecture Week 6
*/
 
 // =================================| Displays Gallery |=========================================
 
 function showGallery($username, $amount_per_page, $apiKey = "ad8e9f1882194c1b86bf0d36ea21cb5e") {

  // Get page number 
  if (isset($_GET['flickr_page'])) $page = $_GET['flickr_page'];
  else $page = 1;
  
  $extras = "description";
  $flickr = new flickr_functions($apiKey);
  
  // Cache username & ID in session if not changed to cut down on flickr api calls
  //session_start();
  //if ($username == $_SESSION["flickr_username"])
  //  $userid = $_SESSION["flickr_userid"];
  //else
  {
    $userid = $flickr->findByUsername($username);
    $_SESSION["flickr_username"] = $username;
    $_SESSION["flickr_userid"] = $userid;
  }
  
  // Get photos & num of pages
  $photos = $flickr->getPublicPhotosForUserNoAuth($userid, $amount_per_page, $page, $extras);
  $totalpages = $photos['pages'];
  $thispage = $_SERVER["PHP_SELF"];
  
  // Begin printing out HTML tags
  echo "<div class='flickr_gallery'>\n";
  echo "<div class='flickr_gallerynav'>";
  
  // Show prev and next buttons
  if ($page > 1)  
    echo "<a href='$thispage?flickr_page=" . (intval($page)-1) . "' id='flickr_prev'>PREV</a>\n";
  if ($page < $totalpages)
    echo " <a href='$thispage?flickr_page=" . (intval($page)+1) . "' id='flickr_next'>NEXT</a>\n";
  echo "</div><br>\n";
  
  // Loop through images
  for ($i = 0; $i < count($photos['photo']); $i++) {
    
	echo "<div class='flickr_imagebox'>";
	
	// Get img URL and photo ID
    $imgurl = $flickr->makePhotoImageURLfromArray($photos['photo'][$i], "m");
    $photo_id = $photos['photo'][$i]['id'];
    
    // Pass the photo array thats already loaded, faster than querying flickr for each photo page
    $imagepage = $flickr->makePhotoPageUrl($photo_id, $userid);
    $title = $photos['photo'][$i]['title'];
    $fulldescription = $photos['photo'][$i]['description']['_content'];
    $fulldescription = strip_tags($fulldescription);
	
    if (strlen($fulldescription) > 75)  //show only first 75 chars
      $description = substr($fulldescription, 0, 75) . "..."; // display ... afterwards
    else $description = $fulldescription;
    
	// Print img, title and description along with link to photo page
	echo "<a href=\"$imagepage\">";
    echo "<img src=\"$imgurl\">";
    echo "</a>";
    echo "<h3>$title</h3>";
    echo "<p>$description</p>";
    echo "</div>\n";
  }
  
  // Close final HTML tag and clear floats
  echo "</div>\n";
  echo "<div class=\"flickr_clear\"></div>";
}
 // ==============================================================================================
?>
