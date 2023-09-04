package com.multimotors.invoice.model;


import com.itextpdf.kernel.color.Color;
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
public class HeaderDetails {

    private String invoiceTitle = "Factura";
    private String invoiceNoText = "Nº Factura";
    private String invoiceDateText = "Fecha Factura";
    private String invoiceNo = "";
    private String invoiceDate = "";
    private Color borderColor = Color.GRAY;

    public HeaderDetails build() {
        return this;
    }
}