package com.multimotors.utils;

import com.multimotors.forms.MainScreen;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * @author Fabian
 * @author Sergio
 */
public class Utils {

    private final JDialog parent;
    private HashMap<String, String> paisesNacionalidades;
    
    public Utils(JDialog parent){
        this.parent = parent;
    }

    public void rellenarPaisesNacionalidades() {

        paisesNacionalidades = new HashMap<>();
        paisesNacionalidades.put("Afganistán", "Afgano/a");
        paisesNacionalidades.put("Albania", "Albanés/a");
        paisesNacionalidades.put("Alemania", "Alemán/a");
        paisesNacionalidades.put("Andorra", "Andorrano/a");
        paisesNacionalidades.put("Angola", "Angoleño/a");
        paisesNacionalidades.put("Antigua y Barbuda", "Antiguano/a y Barbudano/a");
        paisesNacionalidades.put("Arabia Saudita", "Saudí");
        paisesNacionalidades.put("Argelia", "Argelino/a");
        paisesNacionalidades.put("Argentina", "Argentino/a");
        paisesNacionalidades.put("Armenia", "Armenio/a");
        paisesNacionalidades.put("Australia", "Australiano/a");
        paisesNacionalidades.put("Austria", "Austriaco/a");
        paisesNacionalidades.put("Azerbaiyán", "Azerbaiyano/a");
        paisesNacionalidades.put("Bahamas", "Bahameño/a");
        paisesNacionalidades.put("Bangladés", "Bangladesí");
        paisesNacionalidades.put("Barbados", "Barbadense");
        paisesNacionalidades.put("Baréin", "Bahreiní");
        paisesNacionalidades.put("Bélgica", "Belga");
        paisesNacionalidades.put("Belice", "Beliceño/a");
        paisesNacionalidades.put("Benín", "Beninés/a");
        paisesNacionalidades.put("Bielorrusia", "Bielorruso/a");
        paisesNacionalidades.put("Birmania", "Birmano/a");
        paisesNacionalidades.put("Bolivia", "Boliviano/a");
        paisesNacionalidades.put("Bosnia y Herzegovina", "Bosnio/a y Herzegovino/a");
        paisesNacionalidades.put("Botsuana", "Botsuano/a");
        paisesNacionalidades.put("Brasil", "Brasileño/a");
        paisesNacionalidades.put("Brunéi", "Bruneano/a");
        paisesNacionalidades.put("Bulgaria", "Búlgaro/a");
        paisesNacionalidades.put("Burkina Faso", "Burkinés/a");
        paisesNacionalidades.put("Burundi", "Burundés/a");
        paisesNacionalidades.put("Bután", "Butanés/a");
        paisesNacionalidades.put("Cabo Verde", "Caboverdiano/a");
        paisesNacionalidades.put("Camboya", "Camboyano/a");
        paisesNacionalidades.put("Camerún", "Camerunés/a");
        paisesNacionalidades.put("Canadá", "Canadiense");
        paisesNacionalidades.put("Catar", "Catarí");
        paisesNacionalidades.put("Chad", "Chadiano/a");
        paisesNacionalidades.put("Chile", "Chileno/a");
        paisesNacionalidades.put("China", "Chino/a");
        paisesNacionalidades.put("Chipre", "Chipriota");
        paisesNacionalidades.put("Ciudad del Vaticano", "Ciudadano/a del Vaticano");
        paisesNacionalidades.put("Colombia", "Colombiano/a");
        paisesNacionalidades.put("Comoras", "Comorense");
        paisesNacionalidades.put("Corea del Norte", "Norcoreano/a");
        paisesNacionalidades.put("Corea del Sur", "Surcoreano/a");
        paisesNacionalidades.put("Costa de Marfil", "Marfileño/a");
        paisesNacionalidades.put("Costa Rica", "Costarricense");
        paisesNacionalidades.put("Croacia", "Croata");
        paisesNacionalidades.put("Cuba", "Cubano/a");
        paisesNacionalidades.put("Dinamarca", "Danés/a");
        paisesNacionalidades.put("Dominica", "Dominiqués/a");
        paisesNacionalidades.put("Ecuador", "Ecuatoriano/a");
        paisesNacionalidades.put("Egipto", "Egipcio/a");
        paisesNacionalidades.put("El Salvador", "Salvadoreño/a");
        paisesNacionalidades.put("Emiratos Árabes Unidos", "Emiratí");
        paisesNacionalidades.put("Eritrea", "Eritreo/a");
        paisesNacionalidades.put("Eslovaquia", "Eslovaco/a");
        paisesNacionalidades.put("Eslovenia", "Esloveno/a");
        paisesNacionalidades.put("España", "Español/a");
        paisesNacionalidades.put("Estados Unidos", "Estadounidense");
        paisesNacionalidades.put("Estonia", "Estonio/a");
        paisesNacionalidades.put("Etiopía", "Etíope");
        paisesNacionalidades.put("Filipinas", "Filipino/a");
        paisesNacionalidades.put("Finlandia", "Finlandés/a");
        paisesNacionalidades.put("Fiyi", "Fiyiano/a");
        paisesNacionalidades.put("Francia", "Francés/a");
        paisesNacionalidades.put("Gabón", "Gabonés/a");
        paisesNacionalidades.put("Gambia", "Gambiano/a");
        paisesNacionalidades.put("Georgia", "Georgiano/a");
        paisesNacionalidades.put("Ghana", "Ghanés/a");
        paisesNacionalidades.put("Granada", "Granadino/a");
        paisesNacionalidades.put("Grecia", "Griego/a");
        paisesNacionalidades.put("Guatemala", "Guatemalteco/a");
        paisesNacionalidades.put("Guyana", "Guyanés/a");
        paisesNacionalidades.put("Guinea", "Guineano/a");
        paisesNacionalidades.put("Guinea ecuatorial", "Ecuatoguineano/a");
        paisesNacionalidades.put("Guinea", "Guineano/a");
        paisesNacionalidades.put("Haití", "Haitiano/a");
        paisesNacionalidades.put("Honduras", "Hondureño/a");
        paisesNacionalidades.put("Hungría", "Húngaro/a");
        paisesNacionalidades.put("India", "Indio/a");
        paisesNacionalidades.put("Indonesia", "Indonesio/a");
        paisesNacionalidades.put("Irak", "Iraquí");
        paisesNacionalidades.put("Irán", "Iraní");
        paisesNacionalidades.put("Irlanda", "Irlandés/a");
        paisesNacionalidades.put("Islandia", "Islandés/a");
        paisesNacionalidades.put("Islas Marshall", "Marshalés/a");
        paisesNacionalidades.put("Islas Salomón", "Salomonense");
        paisesNacionalidades.put("Israel", "Israelí");
        paisesNacionalidades.put("Italia", "Italiano/a");
        paisesNacionalidades.put("Jamaica", "Jamaicano/a");
        paisesNacionalidades.put("Japón", "Japonés/a");
        paisesNacionalidades.put("Jordania", "Jordano/a");
        paisesNacionalidades.put("Kazajistán", "Kazajo/a");
        paisesNacionalidades.put("Kenia", "Keniano/a");
        paisesNacionalidades.put("Kirguistán", "Kirguís");
        paisesNacionalidades.put("Kiribati", "Kiribatiano/a");
        paisesNacionalidades.put("Kuwait", "Kuwaití");
        paisesNacionalidades.put("Laos", "Laosiano/a");
        paisesNacionalidades.put("Lesoto", "Lesotense");
        paisesNacionalidades.put("Letonia", "Letón/a");
        paisesNacionalidades.put("Líbano", "Libanés/a");
        paisesNacionalidades.put("Liberia", "Liberiano/a");
        paisesNacionalidades.put("Libia", "Libio/a");
        paisesNacionalidades.put("Liechtenstein", "Liechtensteiniano/a");
        paisesNacionalidades.put("Lituania", "Lituano/a");
        paisesNacionalidades.put("Luxemburgo", "Luxemburgués/a");
        paisesNacionalidades.put("Madagascar", "Malgache");
        paisesNacionalidades.put("Malasia", "Malasio/a");
        paisesNacionalidades.put("Malaui", "Malauí");
        paisesNacionalidades.put("Maldivas", "Maldivo/a");
        paisesNacionalidades.put("Malí", "Maliense");
        paisesNacionalidades.put("Malta", "Maltés/a");
        paisesNacionalidades.put("Marruecos", "Marroquí");
        paisesNacionalidades.put("Mauricio", "Mauriciano/a");
        paisesNacionalidades.put("Mauritania", "Mauritano/a");
        paisesNacionalidades.put("México", "Mexicano/a");
        paisesNacionalidades.put("Micronesia", "Micronesio/a");
        paisesNacionalidades.put("Moldavia", "Moldavo/a");
        paisesNacionalidades.put("Mónaco", "Monegasco/a");
        paisesNacionalidades.put("Mongolia", "Mongol/a");
        paisesNacionalidades.put("Montenegro", "Montenegrino/a");
        paisesNacionalidades.put("Mozambique", "Mozambiqueño/a");
        paisesNacionalidades.put("Namibia", "Namibio/a");
        paisesNacionalidades.put("Nauru", "Nauruano/a");
        paisesNacionalidades.put("Nepal", "Nepalí");
        paisesNacionalidades.put("Nicaragua", "Nicaragüense");
        paisesNacionalidades.put("Níger", "Nigerino/a");
        paisesNacionalidades.put("Nigeria", "Nigeriano/a");
        paisesNacionalidades.put("Noruega", "Noruego/a");
        paisesNacionalidades.put("Nueva Zelanda", "Neozelandés/a");
        paisesNacionalidades.put("Omán", "Omaní");
        paisesNacionalidades.put("Países Bajos", "Neerlandés/a");
        paisesNacionalidades.put("Pakistán", "Pakistani/a");
        paisesNacionalidades.put("Palaos", "Palauano/a");
        paisesNacionalidades.put("Palestina", "Palestino/a");
        paisesNacionalidades.put("Panamá", "Panameño/a");
        paisesNacionalidades.put("Papúa Nueva Guinea", "Papú/a");
        paisesNacionalidades.put("Paraguay", "Paraguayo/a");
        paisesNacionalidades.put("Perú", "Peruano/a");
        paisesNacionalidades.put("Polonia", "Polaco/a");
        paisesNacionalidades.put("Portugal", "Portugués/a");
        paisesNacionalidades.put("Reino Unido", "Británico/a");
        paisesNacionalidades.put("República Centroafricana", "Centroafricano/a");
        paisesNacionalidades.put("República Checa", "Checo/a");
        paisesNacionalidades.put("República de Macedonia", "Macedonio/a");
        paisesNacionalidades.put("República del Congo", "Congoleño/a");
        paisesNacionalidades.put("República Democrática del Congo", "Congoleño/a");
        paisesNacionalidades.put("República Dominicana", "Dominicano/a");
        paisesNacionalidades.put("República Sudafricana", "Sudafricano/a");
        paisesNacionalidades.put("Ruanda", "Ruandés/a");
        paisesNacionalidades.put("Rumanía", "Rumano/a");
        paisesNacionalidades.put("Rusia", "Ruso/a");
        paisesNacionalidades.put("Samoa", "Samoano/a");
        paisesNacionalidades.put("San Cristóbal y Nieves", "San Cristobaleño/a y Nievesiano/a");
        paisesNacionalidades.put("San Marino", "Sanmarinense");
        paisesNacionalidades.put("San Vicente y las Granadinas", "Sanvicentino/a y Granadino/a");
        paisesNacionalidades.put("Santa Lucía", "Santa Lucense");
        paisesNacionalidades.put("Santo Tomé y Príncipe", "Santotomense y Principeño/a");
        paisesNacionalidades.put("Senegal", "Senegalés/a");
        paisesNacionalidades.put("Serbia", "Serbio/a");
        paisesNacionalidades.put("Seychelles", "Seychellense");
        paisesNacionalidades.put("Sierra Leona", "Sierraleonés/a");
        paisesNacionalidades.put("Singapur", "Singapuriano/a");
        paisesNacionalidades.put("Siria", "Sirio/a");
        paisesNacionalidades.put("Somalia", "Somalí");
        paisesNacionalidades.put("Sri Lanka", "Ceilanés/a");
        paisesNacionalidades.put("Suazilandia", "Suazi");
        paisesNacionalidades.put("Sudán", "Sudanés/a");
        paisesNacionalidades.put("Sudán del Sur", "Sursudanés/a");
        paisesNacionalidades.put("Suecia", "Sueco/a");
        paisesNacionalidades.put("Suiza", "Suizo/a");
        paisesNacionalidades.put("Surinam", "Surinamés/a");
        paisesNacionalidades.put("Tailandia", "Tailandés/a");
        paisesNacionalidades.put("Tanzania", "Tanzano/a");
        paisesNacionalidades.put("Tayikistán", "Tayiko/a");
        paisesNacionalidades.put("Timor Oriental", "Timorense");
        paisesNacionalidades.put("Togo", "Togolés/a");
        paisesNacionalidades.put("Tonga", "Tongano/a");
        paisesNacionalidades.put("Trinidad y Tobago", "Trinitense y Tobagense");
        paisesNacionalidades.put("Túnez", "Tunecino/a");
        paisesNacionalidades.put("Turkmenistán", "Turcomano/a");
        paisesNacionalidades.put("Turquía", "Turco/a");
        paisesNacionalidades.put("Tuvalu", "Tuvaluano/a");
        paisesNacionalidades.put("Ucrania", "Ucraniano/a");
        paisesNacionalidades.put("Uganda", "Ugandés/a");
        paisesNacionalidades.put("Uruguay", "Uruguayo/a");
        paisesNacionalidades.put("Uzbekistán", "Uzbeko/a");
        paisesNacionalidades.put("Vanuatu", "Vanuatuense");
        paisesNacionalidades.put("Venezuela", "Venezolano/a");
        paisesNacionalidades.put("Vietnam", "Vietnamita");
        paisesNacionalidades.put("Yemen", "Yemení");
        paisesNacionalidades.put("Yibuti", "Yibutiano/a");
        paisesNacionalidades.put("Zambia", "Zambiano/a");
        paisesNacionalidades.put("Zimbabue", "Zimbabuense");
    }

    public HashMap<String, String> getPaisesNacionalidades() {
        rellenarPaisesNacionalidades();
        return paisesNacionalidades;
    }

    public boolean accesoPermitido(String nombrePermiso, String[] array) {
        boolean esPermitido = false;
        for (String permiso : array) {
            if (permiso.equals(nombrePermiso) || permiso.equals("admin")) {
                esPermitido = true;
            }
        }
        return esPermitido;
    }
    
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(parent, message);
    }

    public void showMessagePerimissionError() {
        JOptionPane.showMessageDialog(parent, "No tienes permisos para acceder a esta función");
    }
    
    public int showConfirmDialog(String message, String title) {
        return JOptionPane.showConfirmDialog(parent, message, title, JOptionPane.OK_CANCEL_OPTION);
    }
    
    public int showConfirmCombo(String message, JComboBox combo){
        return JOptionPane.showConfirmDialog(parent, combo, message, JOptionPane.OK_CANCEL_OPTION);
    }
    
    public String showInputDialog(String message){
        return JOptionPane.showInputDialog(parent, message);
    }

    public void openMainScreen(int idUser, JDialog pantalla) {
        MainScreen main = (MainScreen) pantalla.getParent();
        main.cerrarFrame();
        MainScreen p = new MainScreen(idUser);
        p.setVisible(true);
        pantalla.setVisible(false);
    }
    
    public String generateVerificationCode() {
        StringBuilder codeBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            codeBuilder.append((int) (Math.random() * 9));
        }
        return codeBuilder.toString();
    }
}
