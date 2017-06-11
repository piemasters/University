<?php
  
/* 
    References: 
	- New Boston, PHP Guides, http://thenewboston.org/list.php?cat=11
	- NetTuts, How to Create a Photo Gallery using the Flickr API,
		http://net.tutsplus.com/tutorials/php/how-to-create-a-photo-gallery-using-the-flickr-api/
	- Mikel, phpFlickrGallery, http://www.mdp3.net
	- Flickr, API documentation, http://www.flickr.com/services/api/	
	- DSA Lecture Week 6
*/

// Class to query Flickr API and make gallery for output
class flickr_functions
{
  var $apiKey;
  var $secret;
  
  // ==============| Create new object with API keys |================
  
  function flickr_functions($apiKey, $secret = "")
  {
    $this->apiKey = $apiKey;
    $this->secret = $secret;
  }
  //==================================================================
    
  // =====| Query Flickr API with URL built from params array |=======
  //-----| http://www.flickr.com/services/api/response.php.html |-----
 
 private function query($params)
  {
    $encoded_params = array(); // array for query url

    foreach ($params as $k => $v)
      $encoded_params[] = urlencode($k).'='.urlencode($v);

	// call the API and decode the response
    $url = "http://api.flickr.com/services/rest/?".implode('&', $encoded_params);
    $rsp = file_get_contents($url);
    $rsp_obj = unserialize($rsp);
    return $rsp_obj; // return array of strings from php unserialized api response
  }
  //==================================================================
  
   
  // ======| Searches Flickr by username to get nsid number |========= 
  //-----| http://www.flickr.com/services/api/response.php.html |-----
  
  public function findByUsername($username) {
	
	// Use username to search
    $params = array(
      'api_key'   => $this->apiKey,
      'method'    => 'flickr.people.findByUsername',
      'username'  => $username,
      'format'    => 'php_serial',
      );
    
	// Output nsid number for user
    $rsp_obj = $this->query($params);
    
    if ($rsp_obj['stat'] == 'ok')
      return $rsp_obj['user']['nsid'];
    else
      return false;
  }
  //==================================================================
  
   
  // ========| Queries the info required to get photo info |==========
  //-----| http://www.flickr.com/services/api/response.php.html |-----
  
  function loadPhotoInfo($photo_id) {
	
	// Use photo ID to search
    $params = array(
    'api_key'	=> $this->apiKey,
    'method'	=> 'flickr.photos.getInfo',
    'photo_id'	=> $photo_id,
    'format'	=> 'php_serial',
    );
    
	// Output photo info number for user
    $rsp_obj = $this->query($params);

    if ($rsp_obj['stat'] == 'ok')
      return $rsp_obj;
    else
      return false;
  }
  //==================================================================
  
   
  // ===============| Load photo info for photo ID |================== 
  
  function getPhotoUrl($photo_id, $photoInfo = false) {
    
	//if photoInfo is false/empty, load info for photo id
	if ($photoInfo) 
      $photo = $photoInfo;
    // else look in the array for photo page url
	else
      $photo = $this->loadPhotoInfo($photo_id);
    $url = $photo['photo']['urls']['url'][0]['_content'];
    return $url;
  }
  //==================================================================

   
   // ==================| Create photo page URL |===================== 
   
  function makePhotoPageUrl($photo_id, $user_id) {
  
    //Combine user ID & photID to create photo page URL
    $url = "http://www.flickr.com/photos/$user_id/$photo_id";
    return $url;
  }
  //==================================================================
  
   
  // ==============| Get public photos for user ID |================== 
  //--| flickr.com/services/api/flickr.people.getPublicPhotos.html |--
	
  function getPublicPhotosForUserNoAuth($user_id, $per_page = 100,
										$page = 1, $extras = "") {
										
	// Create array of all photo info
	$params = array(
        'api_key'   => $this->apiKey,
        'method'    => 'flickr.people.getPublicPhotos',
        'user_id'   => $user_id,
        'per_page'  => $per_page,
        'page'      => $page,
        'extras'    => $extras,
        'format'    => 'php_serial',
        );
    
	// Output array of photo info
    $rsp_obj = $this->query($params);
    return $rsp_obj['photos'];
	}
	//================================================================
  

   // =====================| Get URL to img |=========================
  
  function makePhotoImageURLfromArray($photoAr, $suffix = "") {
    
	$farmid = $photoAr['farm'];
    $serverid = $photoAr['server'];
    $photoid = $photoAr['id'];
    $secret = $photoAr['secret'];
    
	// Returns URL to img, from the array of photo info from getPublicPhotos
    return $this->makePhotoImageURL($farmid, $serverid, $photoid, $secret, $suffix);
  }
  //==================================================================

  
  // =================| Builds a Flickr image URL |====================
  
  function makePhotoImageURL($farmid, $serverid, $photoid, $secret, 
								$suffix = "", $fileType = "jpg") {
    
	if ($suffix != "")
      $suffix = "_" . $suffix;
    $url = "http://farm" . $farmid . ".static.flickr.com/" . $serverid . 
            "/" . $photoid . "_" . $secret . $suffix . "." . $fileType;
    return $url;
  }
  //==================================================================
}