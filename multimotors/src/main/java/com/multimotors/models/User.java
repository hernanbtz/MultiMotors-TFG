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
public class User {
    
    private int id;
    private String dni;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String pass;
    private String gender;
    private String nationality;
    private String permissions;
    private Date birthdate;
    private Address address;    
}