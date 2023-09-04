package com.multimotors.controllers;

import com.multimotors.models.Address;
import com.multimotors.models.User;
import com.multimotors.utils.ApiRequests;
import com.multimotors.utils.ReadProperties;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * @author Fabian
 * @author Sergio
 */
public class UsersController implements GenericController<User>{
    
    private final ApiRequests apiRequests;
    private final String SERVER_PATH;
    private final ReadProperties properties;
    private final SimpleDateFormat formatES;
    
    public UsersController() {

        apiRequests = new ApiRequests();
        properties = new ReadProperties("src/main/resources/config/application.properties");
        formatES = new SimpleDateFormat("yyyy-MM-dd");

	SERVER_PATH = properties.getProperty("application.aws");
    }

    @Override
    public boolean create(User user) {
        try {
            JSONObject objUserJ = new JSONObject();
            
            objUserJ.put("dni", user.getDni());
            objUserJ.put("name", user.getName());
            objUserJ.put("surname", user.getSurname());
            objUserJ.put("phone", user.getPhone());
            objUserJ.put("email", user.getEmail());
            objUserJ.put("pass", user.getPass());
            objUserJ.put("gender", user.getGender());
            objUserJ.put("birthdate", formatES.format(user.getBirthdate()));
            objUserJ.put("nationality", user.getNationality());
     
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

    @Override
    public boolean update(User user) {
             
        try {
            JSONObject objUserJ = new JSONObject();
            
            objUserJ.put("id", user.getId());
            objUserJ.put("dni", user.getDni());
            objUserJ.put("name", user.getName());
            objUserJ.put("surname", user.getSurname());
            objUserJ.put("phone", user.getPhone());
            objUserJ.put("email", user.getEmail());
            objUserJ.put("pass", user.getPass());
            objUserJ.put("gender", user.getGender());
            objUserJ.put("birthdate", formatES.format(user.getBirthdate()));
            objUserJ.put("nationality", user.getNationality());
            objUserJ.put("permissions", user.getPermissions());
                 
            String json = objUserJ.toJSONString();

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
            String reply = apiRequests.deleteRequest(SERVER_PATH+"?id_user="+id);
            
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
    public User read(int id) {
        return readAux(SERVER_PATH+"?table=users&id_user="+id).get(id);
    }

    @Override
    public HashMap<Integer, User> readAll() {
        return readAux(SERVER_PATH+"?table=users");
    }
    
    public User readUser(int id) {
        return readAux(SERVER_PATH+"?table=users&id_user="+id).get(id);
    }
    
    public HashMap<Integer, User> readFilter(String filter) {
        return readAux(SERVER_PATH + "?table=users&filter="+filter);
    }
    
    public ArrayList<String> readPass(String email, String pass) {
        
        String url = SERVER_PATH+"?email="+email+"&pass="+pass;
        ArrayList<String> data = new ArrayList<>();
        
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
                        
                        JSONObject row = (JSONObject) array.get(0);
                            
                        data.add(row.get("id").toString());
                        data.add( row.get("pass").toString());
                        data.add( row.get("verify_code").toString());
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
	return data;
    }
    
    private HashMap<Integer, User> readAux(String url) {
		
	HashMap<Integer, User> usersAux = new HashMap<>(); 
	try {
            String reply = apiRequests.getRequest(url);
            JSONObject response = (JSONObject) JSONValue.parse(reply);
            
            if (response == null) {	
		System.out.println("El json recibido no es correcto o no existen usuarios");
		return null;
				
            } else {
		String status = (String) response.get("status");
				
		if (status.equals("ok")) {		
                    JSONArray array = (JSONArray) response.get("data");

                    if (!array.isEmpty()) {
                        
			User user;

			for (int i = 0; i < array.size(); i++) {
							
                            JSONObject row = (JSONObject) array.get(i);    
                                                        
                            Address address;
                            
                            try{
                                address = new Address(
                                        Integer.parseInt(row.get("id").toString()),
                                        row.get("city").toString(),
                                        row.get("door").toString(),
                                        row.get("country").toString(),
                                        row.get("poblation").toString(),
                                        row.get("street_name").toString(),
                                        Integer.parseInt(row.get("postal_code").toString()),
                                        Integer.parseInt(row.get("street_num").toString()),
                                        Integer.parseInt(row.get("portal").toString()),
                                        Integer.parseInt(row.get("floor").toString())
                                    );
                            } catch (NumberFormatException e){
                                address = null;
                            } catch (Exception e){
                                address = null;
                            }
                         
                            user = new User(
                                    Integer.parseInt(row.get("id").toString()),
                                    row.get("dni").toString(),
                                    row.get("name").toString(),
                                    row.get("surname").toString(),
                                    row.get("phone").toString(),
                                    row.get("email").toString(),
                                    "null",
                                    row.get("gender").toString(),
                                    row.get("nationality").toString(),
                                    row.get("permissions").toString(),
                                    formatES.parse(row.get("birthdate").toString()),
                                    address);
                            
                            usersAux.put(user.getId(), user);
			}
                    }
		} else { 
                    System.out.println("Ha ocurrido un error en la busqueda de datos");
                    System.out.println("Error: " + (String) response.get("error"));
                    System.out.println("Consulta: " + (String) response.get("query"));
		}
            }
	} catch (IOException | NumberFormatException  e ) {
            System.out.println("Ha ocurrido un error en la busqueda de datos.");
	} catch (ParseException ex) {
        }
	return usersAux;
    }
    
    public boolean updateVerifyCode(String code, String email) {
             
        try {
            JSONObject objUserJ = new JSONObject();
            
            objUserJ.put("email", email);
            objUserJ.put("verify_code", code);
                 
            String json = objUserJ.toJSONString();

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
    
    public boolean updatePass(String pass, String email) {
             
        try {
            JSONObject objUserJ = new JSONObject();
            
            objUserJ.put("email", email);
            objUserJ.put("pass", pass);
                 
            String json = objUserJ.toJSONString();

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
}