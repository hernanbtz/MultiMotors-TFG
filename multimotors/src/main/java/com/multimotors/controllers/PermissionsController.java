package com.multimotors.controllers;

import com.multimotors.utils.ApiRequests;
import com.multimotors.utils.ReadProperties;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * @author Fabian
 * @author Sergio
 */
public class PermissionsController {
    
    private final ApiRequests apiRequests;
    private final String SERVER_PATH;
    private final ReadProperties properties;
    
    public PermissionsController() {

        apiRequests = new ApiRequests();
        properties = new ReadProperties("src/main/resources/config/application.properties");

	SERVER_PATH = properties.getProperty("application.aws");
    }

    public boolean create(int id_user, int id_role) {
        try {
            JSONObject objUserJ = new JSONObject();
            
            objUserJ.put("id_user", id_user);
            objUserJ.put("id_role", id_role);
     
            String json = objUserJ.toJSONString();
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

    public boolean delete(int id_user, int id_role) {
        try {            
            String reply = apiRequests.deleteRequest(SERVER_PATH+"?id_user="+id_user+"&id_role="+id_role);
            
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
}