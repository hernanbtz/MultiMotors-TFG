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
public class Message {
    
    private int id;
    private int id_user;
    private String user_name;
    private String message;
    private Date date_time;
}