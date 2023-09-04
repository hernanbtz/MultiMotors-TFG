package com.multimotors.models;

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
public class Address {
    
    private int id;
    private String city;
    private String door;
    private String country;
    private String poblation;
    private String street_name;
    private int postal_code;
    private int street_num;
    private int portal;   
    private int floor;   
}