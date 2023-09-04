package com.multimotors.utils;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

/**
 * @author Sergio
 * @author Fabian
 */
public class SendEmail {
    public String emailFFrom = "multimotorscompany@gmail.com";
    public String passwordFrom = "hcymhugwzjtcwion";
    public String emailTo;
    public String subject;
    public String content;
    
    public Properties mproperties = new Properties();
    public Session msession;
    public MimeMessage mmessage;   
    
    public void createEmail(String codigo, String email, String tipo){
        try {          
            emailTo = email;
            subject = "CODIGO DE VERIFICACION DE SEGURIDAD";
            content = "<!DOCTYPE HTML><html lang=\"es\"><head> <meta http-equiv=\"Content-Type\" content=\"text/html\" charset=\"UTF-8\"> <title></title></head><body class=\"clean-body u_body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #ffffff;color: #000000\"> <table id=\"u_body\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #ffffff;width:100%\" cellpadding=\"0\" cellspacing=\"0\"> <tbody> <tr style=\"vertical-align: top\"> <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\"> <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\"> <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #038cfe;\"> <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\"> <div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 550px;display: table-cell;vertical-align: top;\"> <div style=\"height: 100%;width: 100% !important;\"> <div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"> <table id=\"u_content_image_1\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\"> <tbody> <tr> <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:30px 10px;font-family:arial,helvetica,sans-serif;\" align=\"left\"> <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"> <tr> <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"> <a href=\"https://unlayer.com\" target=\"_blank\"> <img align=\"center\" border=\"0\" src=\"https://www.multimotors.com.ar/img/logos/logo.png\" alt=\"Logo\" title=\"Logo\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 40%;max-width: 212px;\" width=\"212\" class=\"v-src-width v-src-max-width\" /> </a> </td> </tr> </table> </td> </tr> </tbody> </table> </div> </div> </div> </div> </div> </div> <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\"> <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\"> <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-image: url('images/image-7.png');background-repeat: no-repeat;background-position: center top;background-color: transparent;\"> <div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 550px;display: table-cell;vertical-align: top;\"> <div style=\"height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"> <div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"> <table id=\"u_content_image_4\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\"> <tbody> <tr> <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:50px 10px 25px;font-family:arial,helvetica,sans-serif;\" align=\"left\"> <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"> <tr> <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"> <img align=\"center\" border=\"0\" src=\"https://www.icm.es/wp-content/webp-express/webp-images/uploads/2020/12/ilustracion-vector-autenticacion-dos-pasos_100456-2148.jpg.webp\" alt=\"Hero Image\" title=\"Hero Image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 54%;max-width: 286.2px;\" width=\"286.2\" class=\"v-src-width v-src-max-width\" /> </td> </tr> </table> </td> </tr> </tbody> </table> <table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\"> <tbody> <tr> <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 20px 5px;font-family:arial,helvetica,sans-serif;\" align=\"left\"> <h2 style=\"margin: 0px; color: #141414; line-height: 140%; text-align: center; word-wrap: break-word; font-family: 'Open Sans',sans-serif; font-size: 28px; font-weight: 400;\"> Aquí tienes tu código de verificación</h2> </td> </tr> </tbody> </table> <table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\"> <tbody> <tr> <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:0px 10px 10px;font-family:arial,helvetica,sans-serif;\" align=\"left\"> <div style=\"color: #a7a5a5; line-height: 140%; text-align: center; word-wrap: break-word;\"> <p style=\"font-size: 14px; line-height: 140%;\">Introduce el siguiente código para poder verificar la cuenta correctamente.</p> </div> </td> </tr> </tbody> </table> <table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\"> <tbody> <tr> <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:15px 10px 12px;font-family:arial,helvetica,sans-serif;\" align=\"left\"> <h1 style=\"margin: 0px; color: #3b4d63; line-height: 140%; text-align: center; word-wrap: break-word; font-family: arial,helvetica,sans-serif; font-size: 41px; font-weight: 400;\"> <strong><span style=\"text-decoration: underline;\">"+codigo+"</span></strong></h1> </td> </tr> </tbody> </table> <table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\"> <tbody> <tr> <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:0px 10px 117px;font-family:arial,helvetica,sans-serif;\" align=\"left\"> <div style=\"color: #0081ff; line-height: 140%; text-align: center; word-wrap: break-word;\"> <p style=\"font-size: 14px; line-height: 140%;\"><span style=\"font-size: 18px; line-height: 25.2px;\"><strong><span style=\"font-family: Lato, sans-serif; line-height: 25.2px; font-size: 18px;\">Válido una única vez!</span></strong></span></p> </div> </td> </tr> </tbody> </table> </div> </div> </div> </div> </div> </div> <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\"> <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #000000;\"> <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\"> <div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 550px;display: table-cell;vertical-align: top;\"> <div style=\"height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"> <div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"> <table id=\"u_content_menu_1\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\"> <tbody> <tr> <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:40px 10px 10px;font-family:arial,helvetica,sans-serif;\" align=\"left\"> <div class=\"menu\" style=\"text-align:center\"> <a href=\"#\" target=\"_self\" style=\"padding:5px 16px;display:inline-block;color:#a3b2c3;font-family:'Open Sans',sans-serif;font-size:15px;text-decoration:none\" class=\"v-padding v-layout-display\"> FAQs </a> <span style=\"padding:5px 16px;display:inline-block;color:#5f6d7e;font-family:'Open Sans',sans-serif;font-size:15px;\" class=\"v-padding hide-mobile\"> | </span> <a href=\"#\" target=\"_self\" style=\"padding:5px 16px;display:inline-block;color:#a3b2c3;font-family:'Open Sans',sans-serif;font-size:15px;text-decoration:none\" class=\"v-padding v-layout-display\"> Terms & Condition </a> <span style=\"padding:5px 16px;display:inline-block;color:#5f6d7e;font-family:'Open Sans',sans-serif;font-size:15px;\" class=\"v-padding hide-mobile\"> | </span> <a href=\"#\" target=\"_self\" style=\"padding:5px 16px;display:inline-block;color:#a3b2c3;font-family:'Open Sans',sans-serif;font-size:15px;text-decoration:none\" class=\"v-padding v-layout-display\"> Contact Us </a> </div> </td> </tr> </tbody> </table> <table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\"> <tbody> <tr> <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 10px 20px;font-family:arial,helvetica,sans-serif;\" align=\"left\"> <div style=\"color: #a3b2c3; line-height: 140%; text-align: center; word-wrap: break-word;\"> <p style=\"font-size: 14px; line-height: 140%;\"><span style=\"font-family: Lato, sans-serif; font-size: 14px; line-height: 19.6px;\">Si tienes alguna duda contactanos a multimotors@gmail.com</span></p> </div> </td> </tr> </tbody> </table> </div> </div> </div> </div> </div> </div> </td> </tr> </tbody> </table></body></html>";
            mproperties.put("mail.smtp.host", "smtp.gmail.com");
            mproperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            mproperties.setProperty("mail.smtp.starttls.enable", "true");
            mproperties.setProperty("mail.smtp.port", "587");
            mproperties.setProperty("mail.smtp.user", emailFFrom);
            mproperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
            mproperties.setProperty("mail.smtp.auth", "true");
            msession = Session.getDefaultInstance(mproperties);
            mmessage = new MimeMessage(msession);
            mmessage.setFrom(new InternetAddress(emailFFrom));
            mmessage.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            
            switch (tipo) {
                case "verify":
                    mmessage.setText(content, "ISO-8859-1", "html");
                    break;
                case "contract":
                    {
                        subject = "CONTRATO RENTING MULTIMOTORS";
                        BodyPart textoParte = new MimeBodyPart();
                        textoParte.setContent(content, "text/html");
                        
                        BodyPart adjuntoParte = new MimeBodyPart();
                        DataSource source = new ByteArrayDataSource(new AWSFiles().downloadPDF("contrato-renting.pdf"), "application/pdf");
                        adjuntoParte.setDataHandler(new DataHandler(source));
                        adjuntoParte.setFileName("document.pdf");
                        
                        Multipart multipart = new MimeMultipart();
                        multipart.addBodyPart(textoParte);
                        multipart.addBodyPart(adjuntoParte);
                        mmessage.setContent(multipart);
                        break;
                    }
                default:
                    {
                        subject = "FACTURA COMPRA MULTIMOTORS";
                        BodyPart textoParte = new MimeBodyPart();
                        textoParte.setText("AQUI TIENES LA FACTURA DE TU COMPRA");
                        
                        BodyPart adjuntoParte = new MimeBodyPart();                 
                        DataSource fuenteDatos = new FileDataSource("factura.pdf");
                        adjuntoParte.setDataHandler(new DataHandler(fuenteDatos));
                        adjuntoParte.setFileName(fuenteDatos.getName());
                        
                        Multipart multipart = new MimeMultipart();
                        multipart.addBodyPart(adjuntoParte);
                        mmessage.setContent(multipart);
                        break;
                    }
            }           
            mmessage.setSubject(subject);
            
            sendEmail();
            
        } catch (MessagingException ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void sendEmail(){
        try {         
            try (Transport transport = msession.getTransport("smtp")) {
                transport.connect(emailFFrom, passwordFrom);
                transport.sendMessage(mmessage, mmessage.getRecipients(Message.RecipientType.TO));
            }
        } catch (MessagingException ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}