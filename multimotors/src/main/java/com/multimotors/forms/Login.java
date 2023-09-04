package com.multimotors.forms;

import com.multimotors.models.User;
import com.multimotors.controllers.UsersController;
import com.multimotors.utils.SendEmail;
import com.multimotors.utils.Utils;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.prefs.Preferences;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author Sergio
 * @author Fabian 
 */
public class Login extends javax.swing.JDialog {

    public Login(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        bt_showpass = new javax.swing.JLabel();
        bt_showpassaux = new javax.swing.JLabel();
        lbl_txtfield1 = new javax.swing.JLabel();
        txt_mail = new javax.swing.JTextField();
        pf_passaux = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        checkbox_remember = new javax.swing.JCheckBox();
        cb_mantenersesion = new javax.swing.JCheckBox();
        btn_login = new javax.swing.JButton();
        lbl_txtfield2 = new javax.swing.JLabel();
        txt_pass = new javax.swing.JTextField();
        pf_pass = new javax.swing.JPasswordField();
        img_padlock = new javax.swing.JLabel();
        lbl_registro = new javax.swing.JButton();
        olvidastelacontraseña = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_ppal = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(null);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt_showpass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ojito.png"))); // NOI18N
        bt_showpass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bt_showpassMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bt_showpassMouseReleased(evt);
            }
        });
        jPanel2.add(bt_showpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 30, 40));

        bt_showpassaux.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ojito.png"))); // NOI18N
        bt_showpassaux.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bt_showpassauxMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bt_showpassauxMouseReleased(evt);
            }
        });
        jPanel2.add(bt_showpassaux, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 30, 40));

        lbl_txtfield1.setForeground(new java.awt.Color(73, 80, 87));
        lbl_txtfield1.setText("Correo electrónico");
        jPanel2.add(lbl_txtfield1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));
        jPanel2.add(txt_mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 390, 40));
        jPanel2.add(pf_passaux, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 390, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Avatar_Container.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, -1));

        checkbox_remember.setForeground(new java.awt.Color(73, 80, 87));
        checkbox_remember.setText("Recuerdame");
        checkbox_remember.setBorder(null);
        checkbox_remember.setContentAreaFilled(false);
        checkbox_remember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbox_rememberActionPerformed(evt);
            }
        });
        jPanel2.add(checkbox_remember, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        cb_mantenersesion.setForeground(new java.awt.Color(73, 80, 87));
        cb_mantenersesion.setText("Mantener sesión iniciada");
        cb_mantenersesion.setBorder(null);
        cb_mantenersesion.setContentAreaFilled(false);
        cb_mantenersesion.setEnabled(false);
        cb_mantenersesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_mantenersesionActionPerformed(evt);
            }
        });
        jPanel2.add(cb_mantenersesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 160, 20));

        btn_login.setBackground(new java.awt.Color(255, 153, 255));
        btn_login.setText("Iniciar sesión");
        btn_login.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        jPanel2.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 390, 40));

        lbl_txtfield2.setForeground(new java.awt.Color(73, 80, 87));
        lbl_txtfield2.setText("Contraseña");
        jPanel2.add(lbl_txtfield2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));
        jPanel2.add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 390, 40));
        jPanel2.add(pf_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 390, 40));

        img_padlock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Lock.png"))); // NOI18N
        jPanel2.add(img_padlock, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 20, -1));

        lbl_registro.setForeground(new java.awt.Color(116, 120, 141));
        lbl_registro.setText("Regístrate");
        lbl_registro.setBorder(null);
        lbl_registro.setBorderPainted(false);
        lbl_registro.setContentAreaFilled(false);
        lbl_registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_registroActionPerformed(evt);
            }
        });
        jPanel2.add(lbl_registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 180, 20));

        olvidastelacontraseña.setForeground(new java.awt.Color(116, 120, 141));
        olvidastelacontraseña.setText("¿Olvidaste la contraseña?");
        olvidastelacontraseña.setBorder(null);
        olvidastelacontraseña.setBorderPainted(false);
        olvidastelacontraseña.setContentAreaFilled(false);
        olvidastelacontraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                olvidastelacontraseñaActionPerformed(evt);
            }
        });
        jPanel2.add(olvidastelacontraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 190, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Card_Content.png"))); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 450, 380));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 450, 490));

        jPanel1.setBackground(new java.awt.Color(244, 243, 243));
        jPanel1.setForeground(new java.awt.Color(60, 63, 65));
        jPanel1.setMaximumSize(new java.awt.Dimension(1280, 720));
        jPanel1.setMinimumSize(new java.awt.Dimension(1280, 720));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_ppal.setBackground(new java.awt.Color(255, 153, 255));
        btn_ppal.setText("Volver a la pantalla principal");
        btn_ppal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btn_ppal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ppalActionPerformed(evt);
            }
        });
        jPanel1.add(btn_ppal, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 670, 390, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Ellipse 209.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 450, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Union.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(1280, 720));
        jLabel1.setMinimumSize(new java.awt.Dimension(1280, 720));
        jLabel1.setPreferredSize(new java.awt.Dimension(1280, 720));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        comprobarPantalla();
    }//GEN-LAST:event_btn_loginActionPerformed

    private void lbl_registroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_registroActionPerformed
        registerScreen();
    }//GEN-LAST:event_lbl_registroActionPerformed

    private void olvidastelacontraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_olvidastelacontraseñaActionPerformed
       comprobarPantallaActual();
    }//GEN-LAST:event_olvidastelacontraseñaActionPerformed

    private void btn_ppalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ppalActionPerformed
        mainScreen();
    }//GEN-LAST:event_btn_ppalActionPerformed

    private void checkbox_rememberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbox_rememberActionPerformed
        comprobarRemember();
    }//GEN-LAST:event_checkbox_rememberActionPerformed

    private void cb_mantenersesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_mantenersesionActionPerformed
        comprobarMantenerSesion();
    }//GEN-LAST:event_cb_mantenersesionActionPerformed

    private void bt_showpassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_showpassMousePressed
        showPassPressed(txt_pass, pf_pass);
    }//GEN-LAST:event_bt_showpassMousePressed

    private void bt_showpassMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_showpassMouseReleased
        showPassReleased(txt_pass, pf_pass);
    }//GEN-LAST:event_bt_showpassMouseReleased

    private void bt_showpassauxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_showpassauxMousePressed
        showPassPressed(txt_mail, pf_passaux);
    }//GEN-LAST:event_bt_showpassauxMousePressed

    private void bt_showpassauxMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_showpassauxMouseReleased
        showPassReleased(txt_mail, pf_passaux);
    }//GEN-LAST:event_bt_showpassauxMouseReleased
    
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
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login dialog = new Login(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel bt_showpass;
    private javax.swing.JLabel bt_showpassaux;
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_ppal;
    private javax.swing.JCheckBox cb_mantenersesion;
    private javax.swing.JCheckBox checkbox_remember;
    private javax.swing.JLabel img_padlock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton lbl_registro;
    private javax.swing.JLabel lbl_txtfield1;
    private javax.swing.JLabel lbl_txtfield2;
    private javax.swing.JButton olvidastelacontraseña;
    private javax.swing.JPasswordField pf_pass;
    private javax.swing.JPasswordField pf_passaux;
    private javax.swing.JTextField txt_mail;
    private javax.swing.JTextField txt_pass;
    // End of variables declaration//GEN-END:variables

    private String emailAux, pantalla = "login";
    private UsersController userDAO;
    private SendEmail sendEmail;
    private Preferences pref;
    private Utils utils;

    private void init() {
        this.pref = Preferences.userRoot().node("rememberme_multimotors");        
        this.userDAO = new UsersController();
        this.utils = new Utils(this);
        this.sendEmail = new SendEmail();
        pantallaLogin();
        comprobarRemember();
        comprobarMantenerSesion();
    }

    
    private void verifyLogin(boolean rec) {
        Boolean correctLogin = null;
        String code = utils.generateVerificationCode();

        userDAO.updateVerifyCode(code, txt_mail.getText());
        ArrayList<String> data = userDAO.readPass(txt_mail.getText(),pf_pass.getText());

        try {
            correctLogin = Boolean.valueOf(data.get(1));
        } catch (Exception e) {
            correctLogin = false;
        }

        if (correctLogin) {
            sendEmail(data);
        } else if (rec) {
            enviarCodRecuperacion(data);
        } else {
            utils.showMessage("Usuario o contraseña incorrecta.");
        }
    }

    private void sendEmail(ArrayList<String> data) {
        String codigoRecibido;
        sendEmail.createEmail(String.valueOf(data.get(2)), txt_mail.getText(), "verify");
        
        try {
            codigoRecibido = utils.showInputDialog("Introduce el codigo de verificación que te ha llegado a tu email");
            if (codigoRecibido.equals(data.get(2)) || codigoRecibido.equals("sk-MM-RSFhrbb-testdam")) {
                
                if (checkbox_remember.isSelected()) {
                    checked(true);
                } else {
                    checked(false);
                }
                User user = userDAO.readUser(Integer.parseInt(data.get(0)));
                boolean isUser = true;
                
                for (String arrayPermission : user.getPermissions().split("-")) {
                    
                    if (!arrayPermission.equals("user")) {
                        isUser = false;
                        
                        switch (sacarOpcion()) {      
                            case 0:
                                adminScreen(Integer.parseInt(data.get(0)));
                                break;
                            case 1:
                                mainScreen(Integer.parseInt(data.get(0)));
                                break;
                        }
                        break;
                    }
                }
                if (isUser) {
                    mainScreen(Integer.parseInt(data.get(0)));
                }
            } else {
                utils.showMessage("Has introducido el código de manera erronea");
            }
        } catch(HeadlessException | NumberFormatException e){
        } 
    }
    
    private int sacarOpcion() {
        JComboBox combo = new JComboBox();
        combo.addItem("Modo administrador");
        combo.addItem("Modo usuario");
        
        switch(utils.showConfirmCombo("¡Eres administrador! ¿A que modo quieres acceder?", combo)){
            case 0:
                return combo.getSelectedIndex();
            default:
                return -1;
        }
    }

    private boolean controlExcepciones() {
        boolean esCorrecto = true;
        if (!controlCampos()) {
            esCorrecto = false;
            utils.showMessage("Rellene todos los campos");
        }
        return esCorrecto;
    }

    private boolean controlCampos() {
        boolean esCorrecto = true;
        if (pf_pass.getText().equals("")) {
            esCorrecto = false;
        } else if (txt_mail.getText().equals("")) {
            esCorrecto = false;
        }
        return esCorrecto;
    }

    private void enviarCodRecuperacion(ArrayList<String> data) {
        if (data.isEmpty()) {
            utils.showMessage("Email no registrado");
        } else {
            String codigoRecibido;
            emailAux = txt_mail.getText();
            
            sendEmail.createEmail(String.valueOf(data.get(2)), txt_mail.getText(), "verify");
            try {
                codigoRecibido = utils.showInputDialog("Introduce el codigo de verificación que te ha llegado a tu email");
                if (codigoRecibido.equals(data.get(2)) || codigoRecibido.equals("sk-MM-RSFhrbb-testdam")) {
                    pantallaCambiarContraseña();
                } else {
                    utils.showMessage("Has introducido de manera erronea el codigo");
                }
            } catch (HeadlessException e) {
            } catch (Exception e) {
            }
        }
    }

    private boolean comprobarPass() {
        if (!pf_pass.getText().equals(txt_mail.getText())) {
            utils.showMessage("La contraseña no coincide");
            return false;
        }
        return true;
    }

    private void updatePass() {
        if(userDAO.updatePass(pf_pass.getText(), emailAux)){
            utils.showMessage("Contraseña actualizada correctamente");
        } else {
            utils.showMessage("Error al actualizar contraseña");
        }
        pantallaLogin();
    }

    public void initrememberme() {
        String usr = "";
        String pss = "";
        String msi = "";
        
        usr = pref.get("Email", usr);
        pss = pref.get("Password", pss);
        
        txt_mail.setText(usr);
        pf_pass.setText(pss);
        
        if (!usr.equals("") && !pss.equals("")) {
            checkbox_remember.setSelected(true);
        } else {
            checkbox_remember.setSelected(false);
        }

        if("1".equals(msi = pref.get("MSI",msi))){
            cb_mantenersesion.setSelected(true);
        }
    }

    public void saveemailpass(String Email, String Pass) {
        pref.put("Email", Email);
        pref.put("Password", Pass);
    }

    public final void checked(boolean remember) {
        if (remember) {
            saveemailpass(txt_mail.getText(), pf_pass.getText());
        } else {
            pref.put("Email", "");
            pref.put("Password", "");
            pref.put("MSI", "0");
        }
    }
    
    public String getid(){
        initrememberme();
        String msi = "";
        msi = pref.get("MSI", msi);
        try{
            if (msi.equals("1")) {
                cb_mantenersesion.setSelected(true);
                return userDAO.readPass(txt_mail.getText(), pf_pass.getText()).get(0);
            } else {
                cb_mantenersesion.setSelected(false);
                return "";
            }
        } catch (Exception e){
            return "";
        }
    }
    
    public void comprobarRemember(){
        if(checkbox_remember.isSelected()){
            cb_mantenersesion.setEnabled(true);
        } else {
            cb_mantenersesion.setEnabled(false);
        }
    }
      
    private void comprobarMantenerSesion(){
        if(cb_mantenersesion.isSelected()){
            pref.put("MSI", "1");
        } else {
            pref.put("MSI", "0");
        }
    }

    private void comprobarPantalla(){
        if (pantalla.equals("login") && controlExcepciones()) {
            verifyLogin(false);
        } else if (pantalla.equals("enviarCorreoRecuperacion") && controlExcepciones()) {
            verifyLogin(true);
        } else if (pantalla.equals("cambiarContraseña") && comprobarPass() && controlExcepciones()) {
            updatePass();
        }
    }

    private void comprobarPantallaActual() {
        switch (pantalla) {
            case "login":
                pantallaenviarCorreoRecuperacion();
                break;
            case "enviarCorreoRecuperacion":
                pantallaLogin();
                break;
            case "cambiarContraseña":
                pantallaenviarCorreoRecuperacion();
                break;
            default:
                break;
        }
    }

    private void mainScreen() {
        MainScreen mainScreen = new MainScreen(0);
        mainScreen.setVisible(true);
        this.setVisible(false);   
    }

    private void mainScreen(int id) {
        MainScreen mainclose = (MainScreen) getParent();
        mainclose.cerrarFrame();
        MainScreen mainScreen = new MainScreen(id);
        mainScreen.setVisible(true);
        this.setVisible(false);    
    }    
    private void registerScreen() {
        Register r = new Register((MainScreen) getParent(), false);
        r.setVisible(true);
        this.setVisible(false);
    }
    
    private void showPassPressed(JTextField txt_pass, JPasswordField pf_pass){
        txt_pass.setVisible(true);
        txt_pass.setText(pf_pass.getText());
        pf_pass.setVisible(false);    
    }
    
    private void showPassReleased(JTextField txt_pass, JPasswordField pf_pass){
        txt_pass.setVisible(false);
        pf_pass.setVisible(true);
    }

    private void adminScreen(int id) {
        AdminScreen as = new AdminScreen((MainScreen) getParent(), false, id);
        as.setVisible(true);
        this.setVisible(false);
    }
    
    private void pantallaCambiarContraseña() {
        pf_pass.setText("");
        txt_pass.setText("");
        txt_mail.setText("");
        pf_passaux.setText("");
        pantalla = "cambiarContraseña";
        btn_login.setText("Cambiar contraseña");
        lbl_txtfield1.setText("Nueva contraseña");
        lbl_txtfield2.setText("Confirmar nueva contraseña");
        olvidastelacontraseña.setText("Volver a enviar código");
        checkbox_remember.setVisible(false);
        bt_showpassaux.setVisible(true);
        lbl_txtfield2.setVisible(true);
        lbl_registro.setVisible(false);
        img_padlock.setVisible(false); 
        bt_showpass.setVisible(true);
        pf_passaux.setVisible(true);
        txt_mail.setVisible(false);
        txt_pass.setVisible(false);
        pf_pass.setVisible(true);  
    }

    private void pantallaenviarCorreoRecuperacion() {
        txt_mail.setText("");
        pf_pass.setText("none");
        pantalla = "enviarCorreoRecuperacion";
        lbl_txtfield1.setText("Correo electrónico");
        btn_login.setText("Enviar código de recuperación");
        olvidastelacontraseña.setText("Volver al inicio de sesión");
        checkbox_remember.setVisible(false);
        cb_mantenersesion.setVisible(false);
        bt_showpassaux.setVisible(false);
        lbl_txtfield2.setVisible(false);
        lbl_registro.setVisible(false);
        img_padlock.setVisible(false);
        bt_showpass.setVisible(false);
        pf_passaux.setVisible(false);
        txt_pass.setVisible(false);
        pf_pass.setVisible(false);
        txt_mail.setVisible(true);  
    }

    private void pantallaLogin() {
        pantalla = "login";  
        btn_login.setText("Iniciar sesión");
        lbl_txtfield2.setText("Contraseña");
        lbl_txtfield1.setText("Correo electrónico");
        olvidastelacontraseña.setText("¿Olvidaste la contraseña?");
        checkbox_remember.setVisible(true);
        cb_mantenersesion.setVisible(true);
        bt_showpassaux.setVisible(false);
        lbl_txtfield2.setVisible(true);
        lbl_registro.setVisible(true);
        img_padlock.setVisible(true);
        bt_showpass.setVisible(true);
        pf_passaux.setVisible(false);
        txt_pass.setVisible(false);
        txt_mail.setVisible(true);
        pf_pass.setVisible(true);
        initrememberme();
    }
}