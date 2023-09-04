package com.multimotors.invoice.service;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.DashedBorder;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.multimotors.invoice.model.*;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergio
 * @author Fabian
 */
public class InvoiceFormatPDF {

    private Document document;
    private PdfDocument pdfDocument;
    private final String pdfName;
    private final float threecol = 190f;
    private final float twocol = 285f;
    private final float twocol150 = twocol + 150f;
    private final float twocolumnWidth[] = {twocol150, twocol};
    private final float threeColumnWidth[] = {threecol, threecol, threecol};
    private final float fullwidth[] = {threecol * 3};

    public InvoiceFormatPDF(String pdfName) {
        this.pdfName = pdfName;
    }

    public void createDocument() throws FileNotFoundException {
        PdfWriter pdfWriter = new PdfWriter(pdfName);
        pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(PageSize.A4);
        this.document = new Document(pdfDocument);
    }

    public void createProduct(List<Product> productList) {
        Table threeColTable2 = new Table(threeColumnWidth);
        float onetwo[] = {threecol + 125f, threecol * 2};  
        float total = productList.get(0).getPriceperpeice();
        
        for (Product product : productList) {
            threeColTable2.addCell(new Cell().add(product.getPname().orElse("")).setBorder(Border.NO_BORDER)).setMarginLeft(10f);
            threeColTable2.addCell(new Cell().add(String.valueOf(product.getQuantity())).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
            threeColTable2.addCell(new Cell().add(String.valueOf(product.getPriceperpeice())).setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER)).setMarginRight(15f);
        }
        document.add(threeColTable2.setMarginBottom(20f));
        
        Table threeColTable4 = new Table(onetwo);
        threeColTable4.addCell(new Cell().add("").setBorder(Border.NO_BORDER));
        threeColTable4.addCell(new Cell().add(fullwidthDashedBorder(fullwidth)).setBorder(Border.NO_BORDER));       
        document.add(threeColTable4);

        Table threeColTable3 = new Table(threeColumnWidth);
        threeColTable3.addCell(new Cell().add("").setBorder(Border.NO_BORDER)).setMarginLeft(10f);
        threeColTable3.addCell(new Cell().add("Total").setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
        threeColTable3.addCell(new Cell().add(String.valueOf(total)).setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER)).setMarginRight(15f);      
        document.add(threeColTable3);
        document.add(fullwidthDashedBorder(fullwidth));
        document.add(new Paragraph("\n"));
        document.add(getDividerTable(fullwidth).setBorder(new SolidBorder(Color.GRAY, 1)).setMarginBottom(15f));
    }

    public ArrayList<Product> getProductList(String vehicle, double price, double quantity) {
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(new Product(vehicle, (int) quantity, getDecimalFormat(price, quantity)));
        return productList;
    }
    
    private float getDecimalFormat(double price, double quantity){
        return Float.parseFloat(String.valueOf(new DecimalFormat("#0.00").format(price / quantity * 0.5)).replace(",", "."));
    }

    public void closeDocument() {
        document.close();
    }

    public void createTableHeader(ProductHeader productTableHeader) {
        Paragraph producPara = new Paragraph("Producto");
        document.add(producPara.setBold());
        
        Table threeColTable1 = new Table(threeColumnWidth);
        threeColTable1.setBackgroundColor(Color.BLACK, 0.7f);
        threeColTable1.addCell(new Cell().add("Vehículo").setBold().setFontColor(Color.WHITE).setBorder(Border.NO_BORDER));
        threeColTable1.addCell(new Cell().add("Número de cuotas").setBold().setFontColor(Color.WHITE).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
        threeColTable1.addCell(new Cell().add("Precio").setBold().setFontColor(Color.WHITE).setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER)).setMarginRight(15f);    
        document.add(threeColTable1);
    }

    public void createAddress(InfoDetails addressDetails) {
        Table twoColTable = new Table(twocolumnWidth);
        twoColTable.addCell(getBillingandShippingCell(addressDetails.getBillingInfoText() + "\n"));
        twoColTable.addCell(getBillingandShippingCell(addressDetails.getShippingInfoText() + "\n"));
        twoColTable.addCell(getCell10fLeft(addressDetails.getBillingCompanyText(), true));
        twoColTable.addCell(getCell10fLeft(addressDetails.getShippingNameText(), true));
        twoColTable.addCell(getCell10fLeft(addressDetails.getBillingCompany(), false));
        twoColTable.addCell(getCell10fLeft(addressDetails.getShippingName(), false));
        twoColTable.addCell(getCell10fLeft(addressDetails.getBillingNameText(), true));
        twoColTable.addCell(getCell10fLeft(addressDetails.getShippingAddressText(), true));
        twoColTable.addCell(getCell10fLeft(addressDetails.getBillingName(), false));
        twoColTable.addCell(getCell10fLeft(addressDetails.getShippingAddress(), false));
        document.add(twoColTable.setMarginBottom(10f));
        document.add(fullwidthDashedBorder(fullwidth));
    }

    public void createHeader(HeaderDetails header) {
        Table table = new Table(twocolumnWidth);
        table.addCell(new Cell().add(header.getInvoiceTitle()).setFontSize(20f).setBorder(Border.NO_BORDER).setBold());
        
        Table nestedtabe = new Table(new float[]{twocol / 2, twocol / 2});
        nestedtabe.addCell(getHeaderTextCell(header.getInvoiceNoText()));
        nestedtabe.addCell(getHeaderTextCellValue(header.getInvoiceNo()));
        nestedtabe.addCell(getHeaderTextCell(header.getInvoiceDateText()));
        nestedtabe.addCell(getHeaderTextCellValue(header.getInvoiceDate()));
        
        table.addCell(new Cell().add(nestedtabe).setBorder(Border.NO_BORDER));
        document.add(table);
        document.add(getNewLineParagraph());
        document.add(getDividerTable(fullwidth).setBorder(new SolidBorder(header.getBorderColor(), 2f)));
        document.add(getNewLineParagraph());
    }

    static Table getDividerTable(float[] fullwidth) {
        return new Table(fullwidth);
    }

    static Table fullwidthDashedBorder(float[] fullwidth) {
        Table tableDivider2 = new Table(fullwidth);
        Border dgb = new DashedBorder(Color.GRAY, 0.5f);
        tableDivider2.setBorder(dgb);
        return tableDivider2;
    }

    static Paragraph getNewLineParagraph() {
        return new Paragraph("\n");
    }

    static Cell getHeaderTextCell(String textValue) {

        return new Cell().add(textValue).setBold().setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT);
    }

    static Cell getHeaderTextCellValue(String textValue) {

        return new Cell().add(textValue).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);
    }

    static Cell getBillingandShippingCell(String textValue) {

        return new Cell().add(textValue).setFontSize(12f).setBold().setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT).setMarginBottom(12f);
    }

    static Cell getCell10fLeft(String textValue, Boolean isBold) {
        Cell myCell = new Cell().add(textValue).setFontSize(10f).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);
        return isBold ? myCell.setBold() : myCell;
    }
}
