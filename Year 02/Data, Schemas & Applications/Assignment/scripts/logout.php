<?php
require 'login_success.php';

// Logout user and return to home
session_destroy();
$redirect_page = '../latest.php';
header('Location: ' . $redirect_page);
?>