package com.multimotors.controllers;

import com.multimotors.models.Address;
import com.multimotors.utils.ApiRequests;
import com.multimotors.utils.ReadProperties;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * @author Fabian
 * @author Sergio
 */
public class AddressController{
    
    private final ApiRequests apiRequests;
    private final String SERVER_PATH;
    private final ReadProperties properties; 
    
    public AddressController() {

        apiRequests = new ApiRequests();
        properties = new ReadProperties("src/main/resources/config/application.properties");

	SERVER_PATH = properties.getProperty("application.aws");
    }
    
     public boolean create(Address address) {
        try {
            JSONObject objUserJ = new JSONObject();
            
            if (address.getId() != 0) {
                objUserJ.put("id", address.getId());
            }        
            objUserJ.put("city", address.getCity());
            objUserJ.put("door", address.getDoor());
            objUserJ.put("floor", address.getFloor());
            objUserJ.put("portal", address.getPortal());
            objUserJ.put("country", address.getCountry());
            objUserJ.put("poblation", address.getPoblation());
            objUserJ.put("street_num", address.getStreet_num());
            objUserJ.put("street_name", address.getStreet_name());
            objUserJ.put("postal_code", address.getPostal_code());
                     
            String json = objUserJ.toJSONString();
            String reply = apiRequests.postRequest(SERVER_PATH, json);
            
            JSONObject response = (JSONObject) JSONValue.parse(reply);
            
            System.out.println(response);
                                    
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

    public boolean update(Address address) {
             
        try {
            JSONObject objUserJ = new JSONObject();
            
            objUserJ.put("id", address.getId());
            objUserJ.put("city", address.getCity());
            objUserJ.put("door", address.getDoor());
            objUserJ.put("floor", address.getFloor());
            objUserJ.put("portal", address.getPortal());
            objUserJ.put("country", address.getCountry());
            objUserJ.put("poblation", address.getPoblation());
            objUserJ.put("street_num", address.getStreet_num());
            objUserJ.put("street_name", address.getStreet_name());
            objUserJ.put("postal_code", address.getPostal_code());
                 
            String json = objUserJ.toJSONString();

            String reply = apiRequests.putRequest(SERVER_PATH, json);
            
            JSONObject response = (JSONObject) JSONValue.parse(reply);
            
            System.out.println(response);
                        
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
}