<?php

require 'bbdd.php';

$arrMessage = array();

$query = "";
$pass = "";
$table = "";

if(isset($_GET["table"])){

	$table = $_GET["table"];

	if($table == "users"){

		$query = "SELECT USU.id, USU.dni, USU.name, USU.surname, USU.phone, USU.email, USU.pass, USU.nationality, USU.gender, USU.birthdate, USU.address,
					DIR.country, DIR.city, DIR.poblation, DIR.postal_code, DIR.street_name, DIR.street_num, DIR.portal, DIR.floor, DIR.door,
					GROUP_CONCAT(ROL.name SEPARATOR '-') AS permissions 
					FROM users USU
					LEFT JOIN address DIR ON DIR.id = USU.address 
					LEFT JOIN permissions PER ON PER.id_user = USU.id 
					LEFT JOIN roles ROL ON ROL.id = PER.id_role ";

		if(!isset($_GET["id_user"]) && !isset($_GET["filter"])){$query .= " GROUP BY 1";}

	} 

	if($table == "vehicles" || $table == "favorites") {

		$query = "SELECT VCL.id, VCL.type, VCL.brand, VCL.model, VCL.status, VCL.category, VCL.license_plate, VCL.photos, VCL.price, VCL.specs,
					SPC.transmission_type, SPC.fuel_type, SPC.kilometres, SPC.model_year, SPC.engine_cc, SPC.consumption, SPC.traction, SPC.weight, SPC.fuel_tank
					FROM vehicles VCL
					LEFT JOIN specifications SPC ON SPC.id = VCL.specs
					LEFT JOIN sales SAL ON SAL.id_vehicle = VCL.id
					LEFT JOIN users USU ON USU.id = SAL.id_user";

		if(!isset($_GET["id_vehicle"]) && !isset($_GET["filter"]) && !isset($_GET["id_user"])){$query .= " WHERE VCL.status = 'Disponible' ";}
	}

	
} if (isset($_GET["date_time"]) && isset($_GET["id_user"])){

	$date_time = $_GET["date_time"];
	$id_user = $_GET["id_user"];

	$query = "SELECT MES.id, MES.id_user, MES.message, MES.date_time, USU.name AS 'user_name'
				FROM messages MES
				LEFT JOIN users USU ON USU.id = MES.id_user 
				WHERE MES.date_time > '$date_time' AND MES.id_user != $id_user";
	
} else if(isset($_GET["id_user"]) && isset($_GET["id_vehicle"])){

	$id_user = $_GET["id_user"];
	$id_vehicle = $_GET["id_vehicle"];

	$query = "SELECT id FROM favorites WHERE id_user = $id_user AND id_vehicle = $id_vehicle";

} else if($table == "favorites" && isset($_GET["id_user"])){

	$id = $_GET["id_user"];

	$query .= " WHERE VCL.id IN (SELECT id_vehicle FROM favorites WHERE id_user = $id)";

} else if(isset($_GET["id_vehicle"])) {

	$id = $_GET["id_vehicle"];

	$query .= " WHERE VCL.id = $id";

} else if(isset($_GET["id_user"])) {

	$id = $_GET["id_user"];

	$query .= " WHERE USU.id = $id";

} else if(isset($_GET["filter"])) {

	$filter = $_GET["filter"];

	$query .= "$filter";

} else if(isset($_GET["email"]) && isset($_GET["pass"])) {

	$email = $_GET["email"];
	$pass = $_GET["pass"];

	$query = "SELECT id, pass, verify_code FROM users WHERE email = '$email'";

} else if($table == "sales"){

	$query = "SELECT * FROM sales";
}

$result = $conn->query ( $query );

if (isset ( $result ) && $result) {
	
	if ($result->num_rows > 0) {
		
		$arrData = array();
		
		while ( $row = $result->fetch_assoc () ) {
			
			$arrData[] = $row;
		}

		if(isset($_GET["pass"])){
			$arrData[0]["pass"] = password_verify($pass, $arrData[0]["pass"]);
		}

		$arrMessage["status"] = "ok";
		$arrMessage["data"] = $arrData;	
	} else {
		$arrMessage["status"] = "ok";
		$arrMessage["data"] = []; 
	}
} else {
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
}else{
    echo $messageJSON;
}
$conn->close ();

?>