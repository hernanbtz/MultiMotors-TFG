package com.multimotors.controllers;

import com.multimotors.models.Message;
import com.multimotors.utils.ApiRequests;
import com.multimotors.utils.ReadProperties;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * @author Fabian
 * @author Sergio
 */
public class ChatController {
    
    private final ApiRequests apiRequests;
    private final String SERVER_PATH, SERVER_PATH_GPT;
    private final ReadProperties properties; 
    private final SimpleDateFormat formatES;
    
    public ChatController(){
        
        apiRequests = new ApiRequests();
        properties = new ReadProperties("src/main/resources/config/application.properties");
        formatES = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
	SERVER_PATH_GPT = properties.getProperty("application.chat");
        SERVER_PATH = properties.getProperty("application.aws");
    }
    
    public String sendMessage(String text) throws IOException {
        
        return apiRequests.getRequest(SERVER_PATH_GPT+"?text="+text);     
    }
    
    public boolean sendMessageGlobal(int id_user, String message) {
        try {
            JSONObject objUserJ = new JSONObject();
            
            objUserJ.put("id_user", id_user);
            objUserJ.put("message", message);
            objUserJ.put("date_time", formatES.format(new Date()));
                 
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
    
    public HashMap<Integer, Message> readMessages(int id_user, String date_time) {
        
        String url = SERVER_PATH+"?date_time="+date_time+"&id_user="+id_user;
        HashMap<Integer, Message> messages = new HashMap<>();
                
	try {
            String reply = apiRequests.getRequest(url);
            JSONObject response = (JSONObject) JSONValue.parse(reply);
            
            if (response == null) {	
		System.out.println("El json recibido no es correcto o no existe el email");
		return null;
				
            } else {
		String status = (String) response.get("status");
				
		if (status.equals("ok")) {		
                    JSONArray array = (JSONArray) response.get("data");

                    if (!array.isEmpty()) {
                        
			Message message;
                                                
			for (int i = 0; i < array.size(); i++) {
							
                            JSONObject row = (JSONObject) array.get(i);     
                            
                            message = new Message(
                                    Integer.parseInt(row.get("id").toString()),
                                    Integer.parseInt(row.get("id_user").toString()),
                                    row.get("user_name").toString(),
                                    row.get("message").toString(),
                                    formatES.parse(row.get("date_time").toString())
                            );
                            
                            messages.put(message.getId(), message);      
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
	} catch (ParseException pe){
        }
	return messages;
    }
}