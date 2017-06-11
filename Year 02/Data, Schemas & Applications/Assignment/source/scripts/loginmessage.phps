<?php
			if (loggedin()) {
				echo '<h4>You\'re Logged in as \'' . $_SESSION['myusername'];
				echo '\'<a href="scripts/logout.php"> Log Out?</a></h4>';
			}
?>