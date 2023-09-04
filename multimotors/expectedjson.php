<?php

function JSONCorrectVerifyCode($received){
    
	if(isset($received["verify_code"]) && isset($received["email"])){	
		return true;
	}
    return false;  
}

function JSONCorrectPass($received){
    
	if(isset($received["pass"]) && isset($received["email"])){	
		return true;
	}
    return false;  
}

function JSONCorrectFavorite($received){
    
	if(isset($received["id_user"]) && isset($received["id_vehicle"])){	
		return true;
	}
    return false;  
}

function JSONCorrectPermission($received){
    
	if(isset($received["id_user"]) && isset($received["id_role"])){	
		return true;
	}
    return false;  
}

function JSONCorrectMessage($received){
    
	if(isset($received["id_user"]) && isset($received["message"]) && isset($received["date_time"])){	
		return true;
	}
    return false;  
}

function JSONCorrectUser($received){
    
	if(isset($received["dni"]) && isset($received["name"]) && isset($received["surname"]) 
		&& isset($received["phone"]) && isset($received["email"]) && isset($received["pass"])
		&& isset($received["gender"]) && isset($received["nationality"]) && isset($received["birthdate"])){	
		return true;
	}
    return false;  
}

function JSONCorrectVehicle($received){
    
	if(isset($received["type"]) && isset($received["brand"]) && isset($received["model"]) && isset($received["status"]) && isset($received["photos"]) 
		&& isset($received["engine_cc"]) && isset($received["traction"]) && isset($received["weight"]) && isset($received["fuel_tank"])
		&& isset($received["category"]) && isset($received["license_plate"]) && isset($received["price"]) && isset($received["fuel_type"])
		&& isset($received["transmission_type"]) && isset($received["kilometres"]) && isset($received["consumption"]) && isset($received["model_year"])){	
		return true;
	}
    return false;  
}

function JSONCorrectAddress($received){
    
	if(isset($received["country"]) && isset($received["city"]) && isset($received["poblation"]) 
		&& isset($received["postal_code"]) && isset($received["street_name"]) && isset($received["street_num"]) 
		&& isset($received["portal"]) && isset($received["floor"]) && isset($received["door"])){	
		return true;
	}
    return false;  
}

function JSONCorrectSales($received){
    
	if(isset($received["id_user"]) && isset($received["id_vehicle"]) && isset($received["sale_date"])  && isset($received["sale_type"]) 
		&& isset($received["payment_type"]) && isset($received["payment_method"]) && isset($received["amount_payments"])){	
		return true;
	}
    return false;  
}

?>