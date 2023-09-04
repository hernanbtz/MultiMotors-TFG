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
public class Vehicle {
    
    private int id;
    private String type;
    private String brand;
    private String model;
    private String status;
    private String photos;
    private String category;
    private String license_plate;
    private Double price;
    private Specifications specs;
}