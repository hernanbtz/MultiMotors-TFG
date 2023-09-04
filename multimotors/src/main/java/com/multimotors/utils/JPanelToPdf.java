package com.multimotors.utils;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Image;
import java.awt.Desktop;
import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Sergio
 * @author Fabian
 */
public class JPanelToPdf {

    private final ArrayList<Image> jPanels;
    private String pdfPath;

    public JPanelToPdf() {
        jPanels = new ArrayList<>();
    }

    public boolean addToPDF(JPanel jpanel) {
        try {
            BufferedImage image = new BufferedImage(jpanel.getWidth(), jpanel.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = image.createGraphics();
            jpanel.print(graphics);
            graphics.dispose();
            Image pdfImage = new Image(ImageDataFactory.create(image, null));
            pdfImage.setAutoScale(true);
            jPanels.add(pdfImage);
        } catch (IOException ex) {
            return false;
        }
        return true;
    }

    public boolean descargarPDF() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar como PDF");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos PDF (*.pdf)", "pdf"));
            int userSelection = fileChooser.showSaveDialog(null);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                pdfPath = fileChooser.getSelectedFile().getAbsolutePath().concat(".pdf");
                PdfWriter writer = new PdfWriter(new FileOutputStream(pdfPath));
                PdfDocument pdfDocument = new PdfDocument(writer);
                try (Document document = new Document(pdfDocument)) {
                    for (int i = 0; i < jPanels.size(); i++) {
                        document.add(jPanels.get(i));
                        document.add(new AreaBreak());
                    }
                }
            } else {
                return false;
            }
        } catch (HeadlessException | FileNotFoundException e) {
            return false;
        }
        return true;
    }
    
    public void abrirPDF(){
        File file = new File(pdfPath);
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            if (file.exists()) {
                try {
                    desktop.open(file);
                } catch (IOException e) {
                }
            }
        }
    }
}