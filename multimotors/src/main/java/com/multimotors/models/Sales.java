package com.multimotors.models;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fabian
 * @author Sergio
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sales {
    
    private int id;
    private Date sale_date;
    private String sale_type;
    private String payment_type;
    private String payment_method;
    private int amount_payments;  
    private int id_vehicle;
    private int id_user;
}