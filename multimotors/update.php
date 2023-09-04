<?php

require 'bbdd.php'; 
require 'expectedjson.php';

$arrMessage = array();

$parameters = file_get_contents("php://input");

if(isset($parameters)){

	$messageReceived = json_decode($parameters, true);

	if(JSONCorrectUser($messageReceived)){

		$user = $messageReceived;

		$id = $user["id"];
		$dni = $user["dni"];
		$name = $user["name"];
		$pass = $user["pass"];
		$email = $user["email"];
		$phone = $user["phone"];
		$gender = $user["gender"];
		$surname = $user["surname"];
		$birthdate = $user["birthdate"];
		$nationality = $user["nationality"];

		$query  = "UPDATE users SET name='$name', surname='$surname', email='$email', phone='$phone', ";
		$query .= "nationality='$nationality', gender='$gender', birthdate='$birthdate' ";

		if($pass == "null"){
			$query .= "WHERE id=$id";
		} else {
			$pass = password_hash($pass, PASSWORD_DEFAULT, ['cost' => 10]);
			$query .= ", pass='$pass' WHERE id=$id";
		}

		$result = $conn->query ( $query );
		
		if (isset ( $result ) && $result) {
			$arrMessage["status"] = "ok";
			$arrMessage["message"] = "Usuario actualizado correctamente";
		} else {
			$arrMessage["status"] = "error";
			$arrMessage["message"] = "SE HA PRODUCIDO UN ERROR AL ACCEDER A LA BASE DE DATOS";
			$arrMessage["error"] = $conn->error;
			$arrMessage["query"] = $query;	
		}
	} else if(JSONCorrectVehicle($messageReceived)){

		$vehicle = $messageReceived; 
		
		$id = $vehicle["id"];
		$type = $vehicle["type"];
		$brand = $vehicle["brand"];
		$model = $vehicle["model"];
		$price = $vehicle["price"];
		$photos = $vehicle["photos"];
		$weight = $vehicle["weight"];
		$status = $vehicle["status"];
		$traction = $vehicle["traction"];
		$category = $vehicle["category"];
		$engine_cc = $vehicle["engine_cc"];
		$fuel_type = $vehicle["fuel_type"];
		$fuel_tank = $vehicle["fuel_tank"];
		$kilometres = $vehicle["kilometres"];
		$model_year = $vehicle["model_year"];
		$consumption = $vehicle["consumption"];
		$license_plate = $vehicle["license_plate"];
		$transmission_type = $vehicle["transmission_type"];
	
		$query = "UPDATE vehicles SET type='$type', brand='$brand', model='$model', price=$price, 
					status='$status', category='$category', photos='$photos' WHERE id='$id'";

		$conn->autocommit(false);

		if($conn->query ( $query )){
			$query = "UPDATE specifications SET fuel_type='$fuel_type', transmission_type='$transmission_type', kilometres=$kilometres, consumption=$consumption, ";
			$query .= "model_year=$model_year, engine_cc=$engine_cc, traction='$traction', weight=$weight, fuel_tank=$fuel_tank WHERE id ='$id'";
		} else {
			$conn->rollback();
		}
		
		$result = $conn->query ( $query );
		
		if (isset ( $result ) && $result) { 
			$conn->commit();
			$arrMessage["status"] = "ok";
			$arrMessage["message"] = "Vehiculo actualizado correctamente";
		} else {
			$conn->rollback();
			$arrMessage["status"] = "error";
			$arrMessage["message"] = "SE HA PRODUCIDO UN ERROR AL ACCEDER A LA BASE DE DATOS";
			$arrMessage["error"] = $conn->error;
			$arrMessage["query"] = $query;	
		}
	} else if(JSONCorrectAddress($messageReceived)){

		$address = $messageReceived; 
		
		$id = $address["id"];
		$city = $address["city"];
		$door = $address["door"];
		$floor = $address["floor"];
		$portal = $address["portal"];
		$country = $address["country"];
		$poblation = $address["poblation"];
		$street_num = $address["street_num"];
		$postal_code = $address["postal_code"];
		$street_name = $address["street_name"];
	
		$query = "UPDATE address SET country='$country', city='$city', poblation='$poblation', postal_code=$postal_code, ";
		$query .= "street_name='$street_name', street_num=$street_num, portal=$portal, floor=$floor, door='$door' WHERE id='$id'";

		$result = $conn->query ( $query );
		
		if (isset ( $result ) && $result) { 
			$arrMessage["status"] = "ok";
			$arrMessage["message"] = "Direccion actualizada correctamente";
		} else { 
			$arrMessage["status"] = "error";
			$arrMessage["message"] = "SE HA PRODUCIDO UN ERROR AL ACCEDER A LA BASE DE DATOS";
			$arrMessage["error"] = $conn->error;
			$arrMessage["query"] = $query;	
		}
	} else if(JSONCorrectVerifyCode($messageReceived)){

		$user = $messageReceived; 
		
		$email = $user["email"];
		$verify_code = $user["verify_code"];

		$query  = "UPDATE users SET verify_code=$verify_code WHERE email='$email'";
		
		$result = $conn->query ( $query );
		
		if (isset ( $result ) && $result) { 
			$arrMessage["status"] = "ok";
			$arrMessage["message"] = "Codigo actualizado correctamente";
		} else { 
			$arrMessage["status"] = "error";
			$arrMessage["message"] = "SE HA PRODUCIDO UN ERROR AL ACCEDER A LA BASE DE DATOS";
			$arrMessage["error"] = $conn->error;
			$arrMessage["query"] = $query;	
		}
	
	} else if(JSONCorrectPass($messageReceived)){

		$user = $messageReceived; 
		
		$email = $user["email"];
		$pass = $user["pass"];
		$pass = password_hash($pass, PASSWORD_DEFAULT, ['cost' => 10]);

		$query  = "UPDATE users SET pass='$pass' WHERE email='$email'";
		
		$result = $conn->query ( $query );
		
		if (isset ( $result ) && $result) { 
			$arrMessage["status"] = "ok";
			$arrMessage["message"] = "Contraseña actualizada correctamente";
		} else { 
			$arrMessage["status"] = "error";
			$arrMessage["message"] = "SE HA PRODUCIDO UN ERROR AL ACCEDER A LA BASE DE DATOS";
			$arrMessage["error"] = $conn->error;
			$arrMessage["query"] = $query;	
		}
	
	} else {
		$arrMessage["status"] = "error";
		$arrMessage["message"] = "EL JSON NO CONTIENE LOS CAMPOS ESPERADOS";
		$arrMessage["received"] = $messageReceived;
		
	} 
} else {
	$arrMessage["status"] = "error";
	$arrMessage["message"] = "EL JSON NO SE HA ENVIADO CORRECTAMENTE";
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