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
public class InfoDetails {

    private String billingInfoText = "Información de la compra";
    private String shippingInfoText = "Información de envío";
    private String billingCompanyText = "Método de pago";
    private String billingCompany = "";
    private String billingNameText = "Correo electrónico";
    private String billingName = "";

    private String shippingNameText = "Nombre completo";
    private String shippingName = "";
    private String shippingAddressText = "Dirección de envío";
    private String shippingAddress = "";

    public InfoDetails build() {
        return this;
    }
}