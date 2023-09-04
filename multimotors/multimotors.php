<?php

$method = $_SERVER["REQUEST_METHOD"];

switch ($method) {

	case "DELETE":
		require "delete.php";
		break;
	case "POST":
		require "create.php";
		break;
	case "PUT":
		require "update.php";
		break;
	default:
		require "read.php";
		break;
}
?>