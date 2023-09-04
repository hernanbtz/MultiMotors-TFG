package com.multimotors.invoice.model;

import java.util.Optional;
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
public class Product {

    private Optional<String> pname;
    private int quantity;
    private float priceperpeice;

    public Product(String pname, int quantity, float priceperpeice) {
        this.pname = Optional.ofNullable(pname);
        this.quantity = quantity;
        this.priceperpeice = priceperpeice;
    }
}