<?php

$servername = "multimotorsdb.cxy94xndcp6h.eu-north-1.rds.amazonaws.com";
$user = "root";
$password = "multimotors";
$dbname = "multimotorsdb_dev";

/*$servername = "localhost";
$user = "root";
$password = "";
$dbname = "multimotorsdb_dev";*/

$conn  =  new  mysqli($servername,$user,$password,$dbname);

if ($conn->connect_error) {
	die("Error: " . $conn->connect_error);
}

?>