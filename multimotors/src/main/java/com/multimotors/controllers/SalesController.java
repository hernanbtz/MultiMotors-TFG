package com.multimotors.controllers;

import com.multimotors.models.Sales;
import com.multimotors.utils.ApiRequests;
import com.multimotors.utils.ReadProperties;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * @author Fabian
 * @author Sergio
 */
public class SalesController {
    
    private final ApiRequests apiRequests;
    private final String SERVER_PATH;
    private final ReadProperties properties;
    private final SimpleDateFormat formatES;
  
    public SalesController() {

        apiRequests = new ApiRequests();
        properties = new ReadProperties("src/main/resources/config/application.properties");
        formatES = new SimpleDateFormat("yyyy-MM-dd");

	SERVER_PATH = properties.getProperty("application.aws");
    }
    
     public boolean create(Sales sales) {
        try {
            JSONObject objUserJ = new JSONObject();
            
            objUserJ.put("id_user", sales.getId_user());
            objUserJ.put("sale_date", formatES.format(sales.getSale_date()));
            objUserJ.put("sale_type", sales.getSale_type());
            objUserJ.put("id_vehicle", sales.getId_vehicle());
            objUserJ.put("payment_type", sales.getPayment_type());
            objUserJ.put("payment_method", sales.getPayment_method());
            objUserJ.put("amount_payments", sales.getAmount_payments());
                     
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
     
    public HashMap<Integer, Sales> readAll() {
        return readAux(SERVER_PATH+"?table=sales");
    }
    
     
    private HashMap<Integer, Sales> readAux(String url) {
		
	HashMap<Integer, Sales> salesAux = new HashMap<>();
	try {
            String reply = apiRequests.getRequest(url);
            JSONObject response = (JSONObject) JSONValue.parse(reply);
            
            if (response == null) {			
		System.out.println("El json recibido no es correcto o no existen ventas.");
		return null;
				
            } else {
		String status = (String) response.get("status");
				
		if (status.equals("ok")) {		
                    JSONArray array = (JSONArray) response.get("data");

                    if (!array.isEmpty()) {
                        
			Sales sales;

			for (int i = 0; i < array.size(); i++) {
							
                            JSONObject row = (JSONObject) array.get(i);
                            
                            sales = new Sales(
                                    Integer.parseInt(row.get("id").toString()),
                                    formatES.parse(row.get("sale_date").toString()),
                                    row.get("sale_type").toString(),
                                    row.get("payment_type").toString(),
                                    row.get("payment_method").toString(),
                                    Integer.parseInt(row.get("amount_payments").toString()),
                                    Integer.parseInt(row.get("id_vehicle").toString()),
                                    Integer.parseInt(row.get("id_user").toString())
                            );
                            salesAux.put(sales.getId(), sales);
			}
                    }
		} else { 
                    System.out.println("Ha ocurrido un error en la busqueda de datos");
                    System.out.println("Error: " + (String) response.get("error"));
                    System.out.println("Consulta: " + (String) response.get("query"));
		}
            }
	} catch (IOException | NumberFormatException | ParseException  e ) {
            System.out.println("Ha ocurrido un error en la busqueda de datos.");
	}
	return salesAux;
    }
}