package com.multimotors.invoice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sergio
 * @author Fabian
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductHeader {

    private String description = "";
    private String quantity = "";
    private String price = "";

    public ProductHeader build() {
        return this;
    }
}