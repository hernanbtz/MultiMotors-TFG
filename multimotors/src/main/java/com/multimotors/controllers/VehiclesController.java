package com.multimotors.controllers;

import com.multimotors.models.Specifications;
import com.multimotors.models.Vehicle;
import com.multimotors.utils.ApiRequests;
import com.multimotors.utils.ReadProperties;
import java.io.IOException;
import java.util.HashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * @author Fabian
 * @author Sergio
 */
public class VehiclesController implements GenericController<Vehicle>{
        
    private final ApiRequests apiRequests;
    private final String SERVER_PATH;
    private final ReadProperties properties; 
    
    public VehiclesController(){
        
        apiRequests = new ApiRequests();
        properties = new ReadProperties("src/main/resources/config/application.properties");

	SERVER_PATH = properties.getProperty("application.aws");
    }
    
    @Override   
    public boolean create(Vehicle vehicle){
        try {
            JSONObject objVehicleJ = new JSONObject();
            
            objVehicleJ.put("type", vehicle.getType());
            objVehicleJ.put("brand", vehicle.getBrand());
            objVehicleJ.put("model", vehicle.getModel());
            objVehicleJ.put("price", vehicle.getPrice());
            objVehicleJ.put("status", vehicle.getStatus());
            objVehicleJ.put("photos", vehicle.getPhotos());
            objVehicleJ.put("category", vehicle.getCategory());
            objVehicleJ.put("weight", vehicle.getSpecs().getWeight());
            objVehicleJ.put("license_plate", vehicle.getLicense_plate());   
            objVehicleJ.put("traction", vehicle.getSpecs().getTraction());
            objVehicleJ.put("engine_cc", vehicle.getSpecs().getEngine_cc());
            objVehicleJ.put("fuel_type", vehicle.getSpecs().getFuel_type());
            objVehicleJ.put("fuel_tank", vehicle.getSpecs().getFuel_tank());
            objVehicleJ.put("kilometres", vehicle.getSpecs().getKilometres());
            objVehicleJ.put("model_year", vehicle.getSpecs().getModel_year());
            objVehicleJ.put("consumption", vehicle.getSpecs().getConsumption());
            objVehicleJ.put("transmission_type", vehicle.getSpecs().getTransmission_type());
            
            String json = objVehicleJ.toJSONString();
            String reply = apiRequests.postRequest(SERVER_PATH, json);
            
            JSONObject response = (JSONObject) JSONValue.parse(reply);
            
            if (response == null) {
                System.out.println("El json recibido no es correcto.");
            } else {
                String status = (String) response.get("status");
                
                if (status.equals("ok")) {
                    System.out.println((String) response.get("message"));
                    return true;
                } else {
                    System.out.println("Acceso JSON REMOTO - Error al insertar los datos");
                    System.out.println("Error: " + (String) response.get("error"));
                    System.out.println("Consulta: " + (String) response.get("query"));
                }
            }
        } catch (IOException ex) {
            System.out.println("Excepcion desconocida.");
        }
        return false;
    }

    @Override
    public boolean update(Vehicle vehicle) {
        try {
            JSONObject objVehicleJ = new JSONObject();
                             
            objVehicleJ.put("id", vehicle.getId());
            objVehicleJ.put("type", vehicle.getType());
            objVehicleJ.put("brand", vehicle.getBrand());
            objVehicleJ.put("model", vehicle.getModel());
            objVehicleJ.put("price", vehicle.getPrice());
            objVehicleJ.put("status", vehicle.getStatus());
            objVehicleJ.put("photos", vehicle.getPhotos());
            objVehicleJ.put("category", vehicle.getCategory());
            objVehicleJ.put("weight", vehicle.getSpecs().getWeight());
            objVehicleJ.put("license_plate", vehicle.getLicense_plate());   
            objVehicleJ.put("traction", vehicle.getSpecs().getTraction());
            objVehicleJ.put("engine_cc", vehicle.getSpecs().getEngine_cc());
            objVehicleJ.put("fuel_type", vehicle.getSpecs().getFuel_type());
            objVehicleJ.put("fuel_tank", vehicle.getSpecs().getFuel_tank());
            objVehicleJ.put("kilometres", vehicle.getSpecs().getKilometres());
            objVehicleJ.put("model_year", vehicle.getSpecs().getModel_year());
            objVehicleJ.put("consumption", vehicle.getSpecs().getConsumption());
            objVehicleJ.put("transmission_type", vehicle.getSpecs().getTransmission_type());

            
            String json = objVehicleJ.toJSONString();
            String reply = apiRequests.putRequest(SERVER_PATH, json);
            
            JSONObject response = (JSONObject) JSONValue.parse(reply);
            
            if (response == null) {
                System.out.println("El json recibido no es correcto.");
            } else {
                String status = (String) response.get("status");
                
                if (status.equals("ok")) {
                    System.out.println((String) response.get("message"));
                    return true;
                } else {
                    System.out.println("Acceso JSON REMOTO - Error al actualizar los datos");
                    System.out.println("Error: " + (String) response.get("error"));
                    System.out.println("Consulta: " + (String) response.get("query"));
                }
            }
        } catch (IOException ex) {
            System.out.println("Excepcion desconocida.");
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {            
            String reply = apiRequests.deleteRequest(SERVER_PATH+"?id_vehicle="+id);
            
            JSONObject response = (JSONObject) JSONValue.parse(reply);
            
            if (response == null) {
                System.out.println("El json recibido no es correcto.");
            } else {
                String status = (String) response.get("status");
                
                if (status.equals("ok")) {
                    System.out.println((String) response.get("message"));
                    return true;
                } else {
                    System.out.println("Acceso JSON REMOTO - Error al eliminar los datos");
                    System.out.println("Error: " + (String) response.get("error"));
                    System.out.println("Consulta: " + (String) response.get("query"));
                }
            }
        } catch (IOException ex) {
            System.out.println("Excepcion desconocida.");
        }
        return false;
    }

    @Override
    public Vehicle read(int id) {
        return readAux(SERVER_PATH+"?table=vehicles&id_vehicle="+id).get(id);
    }

    @Override
    public HashMap<Integer, Vehicle> readAll() {
        return readAux(SERVER_PATH+"?table=vehicles");
    }
    
    public HashMap<Integer, Vehicle> readAllForUserId(int id) {
        return readAux(SERVER_PATH+"?table=vehicles&id_user="+id);
    }
    
    public HashMap<Integer, Vehicle> readFilter(String filter) {
        return readAux(SERVER_PATH+"?table=vehicles&filter="+filter);
    }
    
    public HashMap<Integer, Vehicle> readFavorites(int id) {
        return readAux(SERVER_PATH+"?table=favorites&id_user="+id);
    }
    
    private HashMap<Integer, Vehicle> readAux(String url) {
		
	HashMap<Integer, Vehicle> vehiclesAux = new HashMap<>();
	try {
            String reply = apiRequests.getRequest(url);
            JSONObject response = (JSONObject) JSONValue.parse(reply);
            
            if (response == null) {			
		System.out.println("El json recibido no es correcto o no existen vehiculos.");
		return null;
				
            } else {
		String status = (String) response.get("status");
				
		if (status.equals("ok")) {		
                    JSONArray array = (JSONArray) response.get("data");

                    if (!array.isEmpty()) {
                        
			Vehicle vehicle;

			for (int i = 0; i < array.size(); i++) {
							
                            JSONObject row = (JSONObject) array.get(i);
                            
                            vehicle = new Vehicle(
                                    Integer.parseInt(row.get("id").toString()),
                                    row.get("type").toString(),
                                    row.get("brand").toString(),
                                    row.get("model").toString(),
                                    row.get("status").toString(),
                                    row.get("photos").toString(),
                                    row.get("category").toString(),
                                    row.get("license_plate").toString(),
                                    Double.valueOf(row.get("price").toString()),
                                    new Specifications(
                                        Integer.parseInt(row.get("id").toString()),
                                        row.get("traction").toString(),
                                        row.get("fuel_type").toString(),
                                        row.get("transmission_type").toString(),
                                        Integer.parseInt(row.get("consumption").toString()),
                                        Integer.parseInt(row.get("kilometres").toString()),
                                        Integer.parseInt(row.get("model_year").toString()),
                                        Integer.parseInt(row.get("fuel_tank").toString()),
                                        Integer.parseInt(row.get("engine_cc").toString()),
                                        Integer.parseInt(row.get("weight").toString())
                                    ));
                            
                            vehiclesAux.put(vehicle.getId(), vehicle);
			}
                    }
		} else { 
                    System.out.println("Ha ocurrido un error en la busqueda de datos");
                    System.out.println("Error: " + (String) response.get("error"));
                    System.out.println("Consulta: " + (String) response.get("query"));
		}
            }
	} catch (IOException | NumberFormatException  e) {
		System.out.println("Ha ocurrido un error en la busqueda de datos.");
	}
	return vehiclesAux;
    }   
}