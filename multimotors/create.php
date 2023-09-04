<?php

require 'bbdd.php'; 
require 'expectedjson.php';

$arrMessage = array(); 

$parameters = file_get_contents("php://input");

if(isset($parameters)){

	$messageReceived = json_decode($parameters, true);

	if(JSONCorrectUser($messageReceived)){

		$user = $messageReceived; 
		
		$dni = $user["dni"];
		$name = $user["name"];
		$pass = $user["pass"];
		$phone = $user["phone"];
		$email = $user["email"];
		$gender = $user["gender"];
		$surname = $user["surname"];
		$birthdate = $user["birthdate"];
		$nationality = $user["nationality"];

		$pass = password_hash($pass, PASSWORD_DEFAULT, ['cost' => 10]);

		$query  = "INSERT INTO users (dni, name, surname, phone, email, pass, gender, birthdate, nationality)";
		$query .= "VALUES ('$dni', '$name', '$surname', '$phone', '$email', '$pass', '$gender', '$birthdate', '$nationality')";

		$conn->autocommit(false);
		
		if($conn->query ( $query )){
			$query = "INSERT INTO permissions (id_user, id_role) VALUES((SELECT id FROM users WHERE dni = '$dni'), 1)";
		} else {
			$conn->rollback();
		}

		$result = $conn->query ( $query );
		
		if (isset ( $result ) && $result) { 
			$conn->commit();
			$arrMessage["status"] = "ok";
			$arrMessage["message"] = "Usuario insertado correctamente";	
		} else { 
			$conn->rollback();
			$arrMessage["status"] = "error";
			$arrMessage["message"] = "SE HA PRODUCIDO UN ERROR AL ACCEDER A LA BASE DE DATOS";
			$arrMessage["error"] = $conn->error;
			$arrMessage["query"] = $query;	
		}	
	} else if(JSONCorrectVehicle($messageReceived)){

		$vehicle = $messageReceived; 
		
		$type = $vehicle["type"];
		$brand = $vehicle["brand"];
		$model = $vehicle["model"];
		$price = $vehicle["price"];
		$weight = $vehicle["weight"];
		$status = $vehicle["status"];
		$traction = $vehicle["traction"];
		$category = $vehicle["category"];
		$photos = $vehicle["photos"];
		$engine_cc = $vehicle["engine_cc"];
		$fuel_type = $vehicle["fuel_type"];
		$fuel_tank = $vehicle["fuel_tank"];
		$kilometres = $vehicle["kilometres"];
		$model_year = $vehicle["model_year"];
		$consumption = $vehicle["consumption"];
		$license_plate = $vehicle["license_plate"];
		$transmission_type = $vehicle["transmission_type"];
		
		$conn->autocommit(false);

		$query  = "INSERT INTO vehicles (type, brand, model, status, category, license_plate, price, photos)";
		$query .= "VALUES ('$type', '$brand', '$model', '$status', '$category', '$license_plate', $price, '$photos')";
	

		if($conn->query ( $query )){
			$query  = "INSERT INTO specifications (id, transmission_type, fuel_type, kilometres, model_year, engine_cc, consumption, traction, weight, fuel_tank)";
			$query .= "VALUES ((SELECT id from vehicles where license_plate = '$license_plate'),";
			$query .= "'$transmission_type', '$fuel_type', $kilometres, $model_year, $engine_cc, $consumption, '$traction', $weight, $fuel_tank)";
		} else {
			$conn->rollback();
		}

		if($conn->query ( $query )){
			$query = "UPDATE vehicles SET specs = (SELECT MAX(id) from specifications) where license_plate = '$license_plate'";
		} else {
			$conn->rollback();
		}

		$result = $conn->query ( $query );

		if (isset ( $result ) && $result) {
			$conn->commit();
			$arrMessage["status"] = "ok";
			$arrMessage["message"] = "Vehiculo insertado correctamente";	
		} else {
			$conn->rollback();
			$arrMessage["status"] = "error";
			$arrMessage["message"] = "SE HA PRODUCIDO UN ERROR AL ACCEDER A LA BASE DE DATOS";
			$arrMessage["error"] = $conn->error;
			$arrMessage["query"] = $query;	
		}	
	} else if(JSONCorrectAddress($messageReceived)){

		$address = $messageReceived; 
		
		$city = $address["city"];
		$door = $address["door"];
		$floor = $address["floor"];
		$portal = $address["portal"];
		$country = $address["country"];
		$poblation = $address["poblation"];
		$street_num = $address["street_num"];
		$postal_code = $address["postal_code"];
		$street_name = $address["street_name"];

		if(isset($address["id"])){
			$id = $address["id"];
		} else {
			$id = $conn->query("SELECT MAX(id) FROM users")->fetch_assoc()['MAX(id)'];
		}

		$query  = "INSERT INTO address (id, country, city, poblation, postal_code, street_name, street_num, portal, floor, door)";
		$query .= "VALUES ($id, '$country', '$city', '$poblation', $postal_code, '$street_name', $street_num, $portal, $floor, '$door')";

		$conn->autocommit(false);

		if($conn->query ( $query )){
			$query = "UPDATE users SET address = $id where id = $id";
		} else {
			$conn->rollback();
		}

		$result = $conn->query ( $query );
		
		if (isset ( $result ) && $result) {
			$conn->commit();
			$arrMessage["status"] = "ok";
			$arrMessage["message"] = "Direccion insertada correctamente";	
		} else {
			$conn->rollback();
			$arrMessage["status"] = "error";
			$arrMessage["message"] = "SE HA PRODUCIDO UN ERROR AL ACCEDER A LA BASE DE DATOS";
			$arrMessage["error"] = $conn->error;
			$arrMessage["query"] = $query;	
		}	
	} else if(JSONCorrectSales($messageReceived)){

		$sales = $messageReceived; 
		
		$id_user = $sales["id_user"];
		$sale_date = $sales["sale_date"];
		$sale_type = $sales["sale_type"];
		$id_vehicle = $sales["id_vehicle"];
		$payment_type = $sales["payment_type"];
		$payment_method = $sales["payment_method"];
		$amount_payments = $sales["amount_payments"];

		$query  = "INSERT INTO sales (id_user, id_vehicle, sale_date, sale_type, payment_type, payment_method, amount_payments)";
		$query .= "VALUES ($id_user, $id_vehicle, '$sale_date', '$sale_type', '$payment_type', '$payment_method', $amount_payments)";
		
		$conn->autocommit(false);

		if($conn->query ( $query )){
			$query  = "UPDATE vehicles SET status = '$sale_type"."do' where id = $id_vehicle";
		} else {
			$conn->rollback();
		}

		if($conn->query ( $query )){
			$query  = "DELETE FROM favorites WHERE id_vehicle = '$id_vehicle'";
		} else {
			$conn->rollback();
		}

		$result = $conn->query ( $query );
		
		if (isset ( $result ) && $result) {
			$conn->commit();
			$arrMessage["status"] = "ok";
			$arrMessage["message"] = "Venta insertada correctamente";	
		} else {
			$conn->rollback();
			$arrMessage["status"] = "error";
			$arrMessage["message"] = "SE HA PRODUCIDO UN ERROR AL ACCEDER A LA BASE DE DATOS";
			$arrMessage["error"] = $conn->error;
			$arrMessage["query"] = $query;	
		}	
	} else if(JSONCorrectMessage($messageReceived)){

		$messages = $messageReceived; 
		
		$id_user = $messages["id_user"];
		$message = $messages["message"];
		$date_time = $messages["date_time"];

		$query  = "INSERT INTO messages (id_user, message, date_time) VALUES ($id_user, '$message', '$date_time')";

		$result = $conn->query ( $query );
		
		if (isset ( $result ) && $result) {
			$arrMessage["status"] = "ok";
			$arrMessage["message"] = "Mensaje insertado correctamente";	
		} else {
			$arrMessage["status"] = "error";
			$arrMessage["message"] = "SE HA PRODUCIDO UN ERROR AL ACCEDER A LA BASE DE DATOS";
			$arrMessage["error"] = $conn->error;
			$arrMessage["query"] = $query;	
		}	
	} else if(JSONCorrectPermission($messageReceived)){

		$permissions = $messageReceived; 
		
		$id_user = $permissions["id_user"];
		$id_role = $permissions["id_role"];

		$query  = "INSERT INTO permissions (id_user, id_role) VALUES ($id_user, $id_role)";

		$result = $conn->query ( $query );
		
		if (isset ( $result ) && $result) {
			$arrMessage["status"] = "ok";
			$arrMessage["message"] = "Permiso insertado correctamente";	
		} else {
			$arrMessage["status"] = "error";
			$arrMessage["message"] = "SE HA PRODUCIDO UN ERROR AL ACCEDER A LA BASE DE DATOS";
			$arrMessage["error"] = $conn->error;
			$arrMessage["query"] = $query;	
		}	
	} else if(JSONCorrectFavorite($messageReceived)){

		$address = $messageReceived; 
		
		$id_user = $address["id_user"];
		$id_vehicle = $address["id_vehicle"];

		$query  = "INSERT INTO favorites (id_user, id_vehicle) VALUES ($id_user, $id_vehicle)";

		$result = $conn->query ( $query );
		
		if (isset ( $result ) && $result) {
			$conn->commit();
			$arrMessage["status"] = "ok";
			$arrMessage["message"] = "Favorito insertado correctamente";	
		} else {
			$conn->rollback();
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