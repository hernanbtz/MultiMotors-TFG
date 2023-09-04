package com.multimotors.forms;

import com.multimotors.models.User;
import com.multimotors.models.Vehicle;
import com.multimotors.controllers.FavoritesController;
import com.multimotors.controllers.VehiclesController;
import com.multimotors.utils.AWSFiles;
import com.multimotors.utils.Utils;
import java.awt.Frame;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

/**
 * @author Sergio
 * @author Fabian 
 */
public class ScreenVehicle extends javax.swing.JDialog {

    public ScreenVehicle(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    public ScreenVehicle(java.awt.Frame parent, boolean modal, int id) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        init(id);
    }

    public ScreenVehicle(java.awt.Frame parent, boolean modal, int id, User u) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        init(id, u);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        btn_buyrent = new javax.swing.JButton();
        btn_comparator = new javax.swing.JButton();
        leftarrow = new javax.swing.JLabel();
        rightarrow = new javax.swing.JLabel();
        txt_photos = new javax.swing.JLabel();
        txt_renting = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        txt_price = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        txt_license = new javax.swing.JLabel();
        txt_category = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        txt_model = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txt_brand = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txt_year = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txt_cc = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txt_traction = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txt_km = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_transmission = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_weight = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_fueltype = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_consumption = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_fueltank = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        bt_fav = new javax.swing.JLabel();
        bt_nofav = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_buyrent.setBackground(new java.awt.Color(255, 153, 255));
        btn_buyrent.setText("COMPRAR O RENTAR");
        btn_buyrent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btn_buyrent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buyrentActionPerformed(evt);
            }
        });
        jPanel7.add(btn_buyrent, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 600, 280, 40));

        btn_comparator.setBackground(new java.awt.Color(255, 153, 255));
        btn_comparator.setText("COMPARAR CON OTRO VEHICULO");
        btn_comparator.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btn_comparator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_comparatorActionPerformed(evt);
            }
        });
        jPanel7.add(btn_comparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 600, 280, 40));

        leftarrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/svgexport-1.jpg"))); // NOI18N
        leftarrow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                leftarrowMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                leftarrowMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                leftarrowMouseExited(evt);
            }
        });
        jPanel7.add(leftarrow, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 40, 150));

        rightarrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/svgexport-4.jpg"))); // NOI18N
        rightarrow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rightarrowMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rightarrowMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rightarrowMouseExited(evt);
            }
        });
        jPanel7.add(rightarrow, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 40, 150));

        txt_photos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_photosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_photosMouseExited(evt);
            }
        });
        jPanel7.add(txt_photos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 450, 390));

        txt_renting.setForeground(new java.awt.Color(102, 102, 102));
        txt_renting.setText("22000");
        jPanel7.add(txt_renting, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 90, 140, -1));

        jLabel50.setText("Precio de Renting");
        jPanel7.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 70, 140, -1));

        txt_price.setForeground(new java.awt.Color(102, 102, 102));
        txt_price.setText("22000");
        jPanel7.add(txt_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 160, -1, -1));

        jLabel52.setText("Precio de compra");
        jPanel7.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 140, 140, -1));

        jLabel45.setText("Matrícula");
        jPanel7.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 140, 140, -1));

        txt_license.setForeground(new java.awt.Color(102, 102, 102));
        txt_license.setText("1234 ABC");
        jPanel7.add(txt_license, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 160, -1, -1));

        txt_category.setForeground(new java.awt.Color(102, 102, 102));
        txt_category.setText("Sedan");
        jPanel7.add(txt_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, -1, -1));

        jLabel48.setText("Categoría");
        jPanel7.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 70, 140, -1));

        txt_model.setForeground(new java.awt.Color(102, 102, 102));
        txt_model.setText("Rio");
        jPanel7.add(txt_model, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, -1, -1));

        jLabel44.setText("Modelo");
        jPanel7.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 140, -1));

        jLabel41.setText("Marca");
        jPanel7.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 140, -1));

        txt_brand.setForeground(new java.awt.Color(102, 102, 102));
        txt_brand.setText("Kia");
        jPanel7.add(txt_brand, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, -1, -1));

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/svgexport-21.jpg"))); // NOI18N
        jPanel7.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, -1, -1));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 102, 102));
        jLabel40.setText("Protegido por garantía");
        jPanel7.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 250, 20));

        jLabel39.setText("<html><body>Este vendedor ofrece una garantía de un año para este vehículo.<br>Recuerda que, a la entrega del vehículo este deberá de estar tal y como<br>figura en el contrato de compraventa</body></html>");
        jPanel7.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, 420, 60));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/svgexport-11.jpg"))); // NOI18N
        jPanel7.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 270, -1, -1));

        jLabel30.setText("Año del modelo");
        jPanel7.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 270, 140, -1));

        txt_year.setForeground(new java.awt.Color(102, 102, 102));
        txt_year.setText("2010");
        jPanel7.add(txt_year, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 290, -1, -1));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/svgexport-15.jpg"))); // NOI18N
        jPanel7.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 320, -1, -1));

        jLabel33.setText("Potencia");
        jPanel7.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 320, 140, -1));

        txt_cc.setForeground(new java.awt.Color(102, 102, 102));
        txt_cc.setText("120 cv");
        jPanel7.add(txt_cc, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 340, -1, -1));

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/svgexport-25.jpg"))); // NOI18N
        jPanel7.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 370, -1, -1));

        jLabel36.setText("Tracción");
        jPanel7.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 370, 140, -1));

        txt_traction.setForeground(new java.awt.Color(102, 102, 102));
        txt_traction.setText("Trasera");
        jPanel7.add(txt_traction, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 390, -1, -1));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/svgexport-12.jpg"))); // NOI18N
        jPanel7.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 270, -1, -1));

        txt_km.setForeground(new java.awt.Color(102, 102, 102));
        txt_km.setText("100.000 km");
        jPanel7.add(txt_km, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 290, -1, -1));

        jLabel28.setText("Kilómetros");
        jPanel7.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 270, 140, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/svgexport-14.jpg"))); // NOI18N
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 320, -1, -1));

        txt_transmission.setForeground(new java.awt.Color(102, 102, 102));
        txt_transmission.setText("Manual");
        jPanel7.add(txt_transmission, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 340, -1, -1));

        jLabel18.setText("Tipo de transmisión");
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 320, 140, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/svgexport-27.jpg"))); // NOI18N
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 370, -1, -1));

        txt_weight.setForeground(new java.awt.Color(102, 102, 102));
        txt_weight.setText("120 kg");
        jPanel7.add(txt_weight, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 390, -1, -1));

        jLabel15.setText("Peso");
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 370, 140, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/svgexport-13.jpg"))); // NOI18N
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, -1, -1));

        jLabel11.setText("Tipo gasolina");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, 140, -1));

        txt_fueltype.setForeground(new java.awt.Color(102, 102, 102));
        txt_fueltype.setText("Gasolina");
        jPanel7.add(txt_fueltype, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 340, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/svgexport-30.jpg"))); // NOI18N
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, -1, -1));

        jLabel8.setText("Consumo medio");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, 140, -1));

        txt_consumption.setForeground(new java.awt.Color(102, 102, 102));
        txt_consumption.setText("5 L / 100km");
        jPanel7.add(txt_consumption, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/svgexport-13.jpg"))); // NOI18N
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, -1, -1));

        jLabel5.setText("Capacidad del depósito");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 140, -1));

        txt_fueltank.setForeground(new java.awt.Color(102, 102, 102));
        txt_fueltank.setText("65L");
        jPanel7.add(txt_fueltank, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Datos técnicos");
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, 110, -1));
        jPanel7.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 610, 10));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Datos básicos");
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 110, -1));
        jPanel7.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 610, 10));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Card_Content.png"))); // NOI18N
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 450, 200));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Card_Content.png"))); // NOI18N
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 450, 130));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Card_Content.png"))); // NOI18N
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 450, 190));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Card_Content.png"))); // NOI18N
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel7.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 450, 190));

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Card_Content.png"))); // NOI18N
        jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel7.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 450, 190));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Card_Content.png"))); // NOI18N
        jLabel24.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 450, 190));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Card_Content.png"))); // NOI18N
        jLabel25.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel7.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 220, 450, 190));

        bt_fav.setBackground(new java.awt.Color(255, 255, 255));
        bt_fav.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/white-heart_1f90d.png"))); // NOI18N
        bt_fav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_favMouseClicked(evt);
            }
        });
        jPanel7.add(bt_fav, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 590, 50, 50));

        bt_nofav.setBackground(new java.awt.Color(255, 255, 255));
        bt_nofav.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/image.png"))); // NOI18N
        bt_nofav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_nofavMouseClicked(evt);
            }
        });
        jPanel7.add(bt_nofav, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 590, 50, 50));

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 1190, 660));

        jPanel1.setBackground(new java.awt.Color(244, 243, 243));
        jPanel1.setForeground(new java.awt.Color(60, 63, 65));
        jPanel1.setMaximumSize(new java.awt.Dimension(1280, 720));
        jPanel1.setMinimumSize(new java.awt.Dimension(1280, 720));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/myacc_wp.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(1280, 720));
        jLabel1.setMinimumSize(new java.awt.Dimension(1280, 720));
        jLabel1.setPreferredSize(new java.awt.Dimension(1280, 720));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_photosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_photosMouseEntered
        setArrowsVisibility(true);
    }//GEN-LAST:event_txt_photosMouseEntered

    private void txt_photosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_photosMouseExited
        setArrowsVisibility(false);
    }//GEN-LAST:event_txt_photosMouseExited

    private void rightarrowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rightarrowMouseClicked
        rightarrowclicked();
    }//GEN-LAST:event_rightarrowMouseClicked

    private void leftarrowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leftarrowMouseClicked
        leftarrowclicked();
    }//GEN-LAST:event_leftarrowMouseClicked

    private void rightarrowMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rightarrowMouseEntered
        rightarrow.setVisible(true);
    }//GEN-LAST:event_rightarrowMouseEntered

    private void leftarrowMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leftarrowMouseEntered
        leftarrow.setVisible(true);
    }//GEN-LAST:event_leftarrowMouseEntered

    private void btn_comparatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_comparatorActionPerformed
        compare(vehicle);
    }//GEN-LAST:event_btn_comparatorActionPerformed

    private void btn_buyrentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buyrentActionPerformed
        buyrent();
    }//GEN-LAST:event_btn_buyrentActionPerformed

    private void rightarrowMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rightarrowMouseExited
        rightarrow.setVisible(false);
    }//GEN-LAST:event_rightarrowMouseExited

    private void leftarrowMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leftarrowMouseExited
        leftarrow.setVisible(false);
    }//GEN-LAST:event_leftarrowMouseExited

    private void bt_nofavMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_nofavMouseClicked
        quitarFavorito();
    }//GEN-LAST:event_bt_nofavMouseClicked

    private void bt_favMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_favMouseClicked
        agregarFavorito();
    }//GEN-LAST:event_bt_favMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScreenVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ScreenVehicle dialog = new ScreenVehicle(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bt_fav;
    private javax.swing.JLabel bt_nofav;
    private javax.swing.JButton btn_buyrent;
    private javax.swing.JButton btn_comparator;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel leftarrow;
    private javax.swing.JLabel rightarrow;
    private javax.swing.JLabel txt_brand;
    private javax.swing.JLabel txt_category;
    private javax.swing.JLabel txt_cc;
    private javax.swing.JLabel txt_consumption;
    private javax.swing.JLabel txt_fueltank;
    private javax.swing.JLabel txt_fueltype;
    private javax.swing.JLabel txt_km;
    private javax.swing.JLabel txt_license;
    private javax.swing.JLabel txt_model;
    private javax.swing.JLabel txt_photos;
    private javax.swing.JLabel txt_price;
    private javax.swing.JLabel txt_renting;
    private javax.swing.JLabel txt_traction;
    private javax.swing.JLabel txt_transmission;
    private javax.swing.JLabel txt_weight;
    private javax.swing.JLabel txt_year;
    // End of variables declaration//GEN-END:variables

    private int idVehicle;
    private int imageIndex;
    private User user;
    private Utils utils;
    private Vehicle vehicle;
    private AWSFiles awsImages;
    private VehiclesController vehicleDAO;
    private FavoritesController favoriteDAO;
    private ArrayList<String> imagesVehicle;
    private List<BufferedImage> images;

    private void init(){
        this.imageIndex = 0;
        this.utils = new Utils(this);
        this.awsImages = new AWSFiles();
        this.imagesVehicle = new ArrayList<>();
        this.vehicleDAO = new VehiclesController();
        this.favoriteDAO = new FavoritesController();
        this.vehicle = vehicleDAO.read(idVehicle);
        this.leftarrow.setVisible(false);
        this.rightarrow.setVisible(false);
        initVehicleData(vehicle);
    }
    
    private void init(int id) {
        this.user = null;
        this.idVehicle = id;
        init();
    }

    private void init(int id, User user) {
        this.user = user;
        this.idVehicle = id;
        init();
        comprobarFavorito();
    }
    
    private void comprobarFavorito(){
        if(favoriteDAO.existFavorite(user.getId(), idVehicle)){
            bt_fav.setVisible(false);
        } else {
            bt_nofav.setVisible(false);
        }
    }
    
    private void quitarFavorito(){
        favoriteDAO.delete(user.getId(), idVehicle);
        bt_fav.setVisible(true);
        bt_nofav.setVisible(false);
    }
    
    private void agregarFavorito(){
         if (user != null) {
            favoriteDAO.create(user.getId(), idVehicle);
            bt_fav.setVisible(false);
            bt_nofav.setVisible(true); 
        } else {
            utils.showMessage("Es necesario iniciar sesión");
        }   
    }

    private void compare(Vehicle v) {
        String type = v.getType();
        JComboBox combo = new JComboBox();
        ArrayList<Vehicle> comboSort = new ArrayList<>();
        HashMap<Integer, Vehicle> hash;
        hash = vehicleDAO.readAll();
        for (int clave : hash.keySet()) {
            Vehicle ve = hash.get(clave);
            if (ve.getType().equals(type)) {
                comboSort.add(ve);
            }
        }
        for (int i = 0; i < comboSort.size(); i++) {
            combo.addItem(comboSort.get(i).getBrand() + " " + comboSort.get(i).getModel());
        }
        if (utils.showConfirmCombo("¿Con qué otro vehículo lo quieres comparar?", combo) == 0) {
            CompareScreen cs = new CompareScreen(null, false, vehicle, comboSort.get(combo.getSelectedIndex()));
            cs.setVisible(true);
        }
    }

    private void initVehicleData(Vehicle v) {
        txt_brand.setText(v.getBrand());
        txt_model.setText(v.getModel());
        txt_category.setText(v.getCategory());
        txt_license.setText(v.getLicense_plate());
        txt_renting.setText(getDecimalFormat(v.getPrice()) + " €");        
        txt_price.setText(String.valueOf(v.getPrice()) + " €");
        txt_fueltank.setText(String.valueOf(v.getSpecs().getFuel_tank()) + " L");
        txt_fueltype.setText(v.getSpecs().getFuel_type());
        txt_consumption.setText(String.valueOf(v.getSpecs().getConsumption()) + " L / 100km");
        txt_km.setText(String.valueOf(v.getSpecs().getKilometres()) + " km");
        txt_transmission.setText(v.getSpecs().getTransmission_type());
        txt_weight.setText(String.valueOf(v.getSpecs().getWeight()));
        txt_year.setText(String.valueOf(v.getSpecs().getModel_year()));
        txt_cc.setText(String.valueOf(v.getSpecs().getEngine_cc()) + " cv");
        txt_traction.setText(v.getSpecs().getTraction());
        
        initImages(v);
        putImage();
    }
    
    private String getDecimalFormat(double price){
        return String.valueOf(new DecimalFormat("#0.00").format(price / 36 * 0.5));
    }

    private void initImages(Vehicle v) {
        String dato = v.getPhotos();
        if(dato.equals("") || dato.equals("null")){
            dato = "noimageavailable.jpg";
        }
        String[] imagenes = dato.split("-");
        imagesVehicle.addAll(Arrays.asList(imagenes));     
        images = awsImages.downloadImages(imagesVehicle);
    }

    private void putImage() {
        Image imgEscalada = images.get(imageIndex).getScaledInstance(txt_photos.getWidth(),txt_photos.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        txt_photos.setIcon(iconoEscalado);
    }

    private void buyrent() {
        if (user != null) {
            ScreenBuyRent scr = new ScreenBuyRent((Frame) getParent(), false, user, vehicle);
            scr.setVisible(true);
            this.setVisible(false);
        } else {
            utils.showMessage("Es necesario iniciar sesión");
        }
    }

    private void rightarrowclicked() {
        imageIndex++;
        if (imageIndex >= imagesVehicle.size()) {
            imageIndex = 0;
        }
        putImage();
    }

    private void leftarrowclicked() {
        imageIndex--;
        if (imageIndex < 0) {
            imageIndex = imagesVehicle.size() - 1;
        }
        putImage();
    }

    private void setArrowsVisibility(boolean visible) {
        leftarrow.setVisible(visible);
        rightarrow.setVisible(visible);    
    }
}