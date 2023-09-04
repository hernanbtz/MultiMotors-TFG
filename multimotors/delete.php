<?php

require 'bbdd.php'; 

$arrMessage = array();

$query = "DELETE FROM ";

$conn->autocommit(false);

if(isset($_GET["id_user"]) && isset($_GET["id_role"])) {

	$id_user = $_GET["id_user"];
	$id_role = $_GET["id_role"];

	$query .= "permissions WHERE id_user = $id_user AND id_role = $id_role";

} else if(isset($_GET["id_user"]) && isset($_GET["id_vehicle"])) {

	$id_user = $_GET["id_user"];
	$id_vehicle = $_GET["id_vehicle"];

	$query .= "favorites WHERE id_user = $id_user AND id_vehicle = $id_vehicle";

} else if(isset($_GET["id_user"])) {

	$id = $_GET["id_user"];

	if($conn->query ("DELETE FROM permissions WHERE id_user = $id") &&
		$conn->query ("DELETE FROM sales WHERE id_user = $id") &&
		$conn->query ("DELETE FROM users WHERE id = $id")){	

		$query .= "address WHERE id = $id";

	} else {
		$conn->rollback();
	}

} else if(isset($_GET["id_vehicle"])) {

	$id = $_GET["id_vehicle"];

	if($conn->query ("DELETE FROM sales WHERE id_vehicle = $id") &&
		$conn->query ("DELETE FROM vehicles WHERE id = $id")){

		$query .= "specifications WHERE id= $id";

	} else {
		$conn->rollback();
	}
}

$result = $conn->query ( $query );

if (isset ( $result ) && $result) {
	$conn->commit();	
	$arrMessage["status"] = "ok";
	$arrMessage["message"] = "Eliminado correctamente";
} else {
	$conn->rollback();
	$arrMessage["status"] = "error";
	$arrMessage["message"] = "SE HA PRODUCIDO UN ERROR AL ACCEDER A LA BASE DE DATOS";
	$arrMessage["error"] = $conn->error;
	$arrMessage["query"] = $query;
}
$messageJSON = json_encode($arrMessage,JSON_PRETTY_PRINT);

if(isset($_GET["test"]) && $_GET["test"]==1 ){
    echo "<pre>";   
    echo $messageJSON;
    echo "</pre>"; 
} else {
    echo $messageJSON;
}
$conn->close ();

?>