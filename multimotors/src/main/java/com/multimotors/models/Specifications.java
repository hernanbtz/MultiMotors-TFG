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
public class Specifications {
    
    private int id;
    private String traction;
    private String fuel_type;
    private String transmission_type;
    private int consumption;
    private int kilometres;
    private int model_year;
    private int fuel_tank;
    private int engine_cc;
    private int weight;
}