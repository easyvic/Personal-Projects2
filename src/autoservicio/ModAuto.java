package autoservicio;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.*;

public class ModAuto extends javax.swing.JFrame {

    private Connection conexion;
    private Map<String, String[]> modelosPorMarca = new HashMap<>();
    
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/icono png.png"));
        return retValue;
    }
    
    public ModAuto(Connection conexion) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.conexion = conexion;
        verificarConexion();
        llenarComboBoxClave();
        configurarModelosPorMarca();
        ComboBoxModelo();
        agregarListeners();
    }
    
    public void verificarConexion() {
    if (conexion != null) {
        System.out.println("SI");
    } else {
        System.out.println("NO");
    }
    }
    
    private void llenarComboBoxClave() {
        String sql = "SELECT clave FROM autos"; 
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            jComboBoxClave.removeAllItems();  
            while (rs.next()) {
                String clave = rs.getString("clave"); 
                jComboBoxClave.addItem(clave);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar las claves: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void configurarModelosPorMarca() {
    modelosPorMarca.put("Acura", new String[]{"","MDX", "RDX", "NSX", "TLX"});
    modelosPorMarca.put("Alfa Romeo", new String[]{"","Giulia", "Stelvio", "4C"});
    modelosPorMarca.put("Aston Martin", new String[]{"","DB11", "Vantage", "DBX"});
    modelosPorMarca.put("Audi", new String[]{"","A3", "A4", "Q5", "R8"});
    modelosPorMarca.put("Bentley", new String[]{"","Bentayga", "Continental GT", "Flying Spur"});
    modelosPorMarca.put("BMW", new String[]{"","Serie 3", "Serie 5", "X5", "i8"});
    modelosPorMarca.put("Bugatti", new String[]{"","Chiron", "Veyron", "Divo"});
    modelosPorMarca.put("Buick", new String[]{"","Enclave", "Encore", "Regal"});
    modelosPorMarca.put("Cadillac", new String[]{"","Escalade", "XT5", "CT6"});
    modelosPorMarca.put("Chevrolet", new String[]{"","Camaro", "Silverado", "Malibu"});
    modelosPorMarca.put("Chrysler", new String[]{"","300", "Pacifica", "Voyager"});
    modelosPorMarca.put("Citroën", new String[]{"","C3", "C4", "C5 Aircross"});
    modelosPorMarca.put("Dodge", new String[]{"","Charger", "Challenger", "Durango"});
    modelosPorMarca.put("Ferrari", new String[]{"","488", "Portofino", "Roma"});
    modelosPorMarca.put("Fiat", new String[]{"","500", "Punto", "Tipo"});
    modelosPorMarca.put("Ford", new String[]{"","Mustang", "Explorer", "F-150"});
    modelosPorMarca.put("Genesis", new String[]{"","G70", "G80", "GV80"});
    modelosPorMarca.put("GMC", new String[]{"","Sierra", "Yukon", "Acadia"});
    modelosPorMarca.put("Honda", new String[]{"","Civic", "Accord", "CR-V"});
    modelosPorMarca.put("Hyundai", new String[]{"","Elantra", "Tucson", "Santa Fe"});
    modelosPorMarca.put("Infiniti", new String[]{"","Q50", "QX50", "QX80"});
    modelosPorMarca.put("Isuzu", new String[]{"","D-Max", "MU-X"});
    modelosPorMarca.put("Jaguar", new String[]{"","XE", "XF", "F-Pace"});
    modelosPorMarca.put("Jeep", new String[]{"","Wrangler", "Cherokee", "Grand Cherokee"});
    modelosPorMarca.put("Kia", new String[]{"","Sportage", "Sorento", "Rio"});
    modelosPorMarca.put("Koenigsegg", new String[]{"","Agera", "Regera", "Jesko"});
    modelosPorMarca.put("Lamborghini", new String[]{"","Huracán", "Aventador", "Urus"});
    modelosPorMarca.put("Land Rover", new String[]{"","Range Rover", "Defender", "Discovery"});
    modelosPorMarca.put("Lexus", new String[]{"","RX", "NX", "ES"});
    modelosPorMarca.put("Lincoln", new String[]{"","Aviator", "Corsair", "Navigator"});
    modelosPorMarca.put("Lotus", new String[]{"","Evora", "Exige", "Elise"});
    modelosPorMarca.put("Maserati", new String[]{"","Ghibli", "Levante", "Quattroporte"});
    modelosPorMarca.put("Mazda", new String[]{"","Mazda3", "CX-5", "MX-5"});
    modelosPorMarca.put("McLaren", new String[]{"","720S", "GT", "Artura"});
    modelosPorMarca.put("Mercedes-Benz", new String[]{"","Clase C", "Clase E", "Clase G"});
    modelosPorMarca.put("Mini", new String[]{"","Cooper", "Countryman", "Clubman"});
    modelosPorMarca.put("Mitsubishi", new String[]{"","Outlander", "Lancer", "Eclipse Cross"});
    modelosPorMarca.put("Nissan", new String[]{"","Altima", "Murano", "GT-R"});
    modelosPorMarca.put("Pagani", new String[]{"","Huayra", "Zonda"});
    modelosPorMarca.put("Peugeot", new String[]{"","208", "3008", "5008"});
    modelosPorMarca.put("Pontiac", new String[]{"","G8", "Firebird", "GTO"});
    modelosPorMarca.put("Porsche", new String[]{"","911", "Cayenne", "Macan"});
    modelosPorMarca.put("RAM", new String[]{"","1500", "2500", "3500"});
    modelosPorMarca.put("Renault", new String[]{"","Clio", "Koleos", "Duster"});
    modelosPorMarca.put("Rolls-Royce", new String[]{"","Phantom", "Ghost", "Cullinan"});
    modelosPorMarca.put("Saab", new String[]{"","9-3", "9-5"});
    modelosPorMarca.put("SEAT", new String[]{"","Ibiza", "León", "Arona"});
    modelosPorMarca.put("Skoda", new String[]{"","Octavia", "Superb", "Kodiaq"});
    modelosPorMarca.put("Smart", new String[]{"","Fortwo", "Forfour"});
    modelosPorMarca.put("Subaru", new String[]{"","Impreza", "Outback", "Forester", "WRX", "BRZ"});
    modelosPorMarca.put("Suzuki", new String[]{"","Swift", "Vitara", "Jimny"});
    modelosPorMarca.put("Tesla", new String[]{"","Model S", "Model 3", "Model X", "Model Y"});
    modelosPorMarca.put("Toyota", new String[]{"","Corolla", "Camry", "RAV4"});
    modelosPorMarca.put("Volkswagen", new String[]{"","Golf", "Passat", "Tiguan"});
    modelosPorMarca.put("Volvo", new String[]{"","XC40", "XC60", "XC90"});
}
    
    private void agregarListeners() {
        MarcaMod.addActionListener(evt -> actualizarModelosLinea());
    }
    
    private void actualizarModelosLinea() {
        String marcaSeleccionada = (String) MarcaMod.getSelectedItem();
        String[] modelos = modelosPorMarca.getOrDefault(marcaSeleccionada, new String[]{});

        jComboBoxLinea.setModel(new DefaultComboBoxModel<>(modelos));
    }
    
    private void ComboBoxModelo() {
    for (int año = 1800; año <= 2030; año++) {
        jComboBoxModelo.addItem(String.valueOf(año));
    }
    }
    
    private void cargarInformacionAuto(String clave) {
    String sql = "SELECT marca, linea, modelo, tipo, cilindros, motor, puertas, cambioaceite, afinacion, lavadoexterno, lavadointerior, lavadomotor, servfrenos, anticongelante FROM autos WHERE clave = ?";
    try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
        pstmt.setString(1, clave);
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                MarcaMod.setSelectedItem(rs.getString("marca"));
                jComboBoxLinea.setSelectedItem(rs.getString("linea"));
                jComboBoxModelo.setSelectedItem(rs.getString("modelo"));
                jComboBoxTipo.setSelectedItem(rs.getString("tipo"));
                jComboBoxCilindros1.setSelectedItem(rs.getString("cilindros"));
                jComboBoxMotor.setSelectedItem(rs.getString("motor"));
                jComboBoxPuertas.setSelectedItem(rs.getString("puertas"));

                jDateChooser1.setDate(rs.getDate("cambioaceite"));
                jDateChooser2.setDate(rs.getDate("afinacion"));
                jDateChooser3.setDate(rs.getDate("lavadoexterno"));
                jDateChooser4.setDate(rs.getDate("lavadointerior"));
                jDateChooser5.setDate(rs.getDate("lavadomotor"));
                jDateChooser6.setDate(rs.getDate("servfrenos"));
                jDateChooser7.setDate(rs.getDate("anticongelante"));
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al cargar los detalles del auto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    private void actualizarInformacionAuto() {
    String claveSeleccionada = (String) jComboBoxClave.getSelectedItem();
    String marca = (String) MarcaMod.getSelectedItem();
    String linea = (String) jComboBoxLinea.getSelectedItem();
    String modelo = (String) jComboBoxModelo.getSelectedItem();
    String tipo = (String) jComboBoxTipo.getSelectedItem();
    String cilindros = (String) jComboBoxCilindros1.getSelectedItem();
    String motor = (String) jComboBoxMotor.getSelectedItem();
    String puertas = (String) jComboBoxPuertas.getSelectedItem();
    
    java.util.Date cambioAceite = jDateChooser1.getDate();
    java.util.Date afinacion = jDateChooser2.getDate();
    java.util.Date lavadoExterno = jDateChooser3.getDate();
    java.util.Date lavadoInterior = jDateChooser4.getDate();
    java.util.Date lavadoMotor = jDateChooser5.getDate();
    java.util.Date servFrenos = jDateChooser6.getDate();
    java.util.Date anticongelante = jDateChooser7.getDate();

    String sql = "UPDATE autos SET marca = ?, linea = ?, modelo = ?, tipo = ?, cilindros = ?, motor = ?, puertas = ?, "
               + "cambioaceite = ?, afinacion = ?, lavadoexterno = ?, lavadointerior = ?, lavadomotor = ?, servfrenos = ?, anticongelante = ? "
               + "WHERE clave = ?";

    try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {

        pstmt.setString(1, marca);
        pstmt.setString(2, linea);
        pstmt.setString(3, modelo);
        pstmt.setString(4, tipo);
        pstmt.setString(5, cilindros);
        pstmt.setString(6, motor);
        pstmt.setString(7, puertas);

        pstmt.setDate(8, new java.sql.Date(cambioAceite.getTime()));
        pstmt.setDate(9, new java.sql.Date(afinacion.getTime()));
        pstmt.setDate(10, new java.sql.Date(lavadoExterno.getTime()));
        pstmt.setDate(11, new java.sql.Date(lavadoInterior.getTime()));
        pstmt.setDate(12, new java.sql.Date(lavadoMotor.getTime()));
        pstmt.setDate(13, new java.sql.Date(servFrenos.getTime()));
        pstmt.setDate(14, new java.sql.Date(anticongelante.getTime()));

        pstmt.setString(15, claveSeleccionada); 

        int rowsUpdated = pstmt.executeUpdate();

        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(this, "Información actualizada correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo actualizar la información.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al actualizar la información: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanelSINFECHA = new javax.swing.JPanel();
        jComboBoxModelo = new javax.swing.JComboBox<>();
        jComboBoxMotor = new javax.swing.JComboBox<>();
        jComboBoxPuertas = new javax.swing.JComboBox<>();
        jComboBoxCilindros1 = new javax.swing.JComboBox<>();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        MarcaMod = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxLinea = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxClave = new javax.swing.JComboBox<>();
        jLabelTitulo = new javax.swing.JLabel();
        jPanelFecha = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jDateChooser7 = new com.toedter.calendar.JDateChooser();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jDateChooser6 = new com.toedter.calendar.JDateChooser();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonaActualizar = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("CLAVE");
        jLabel8.setBorder(new javax.swing.border.MatteBorder(null));

        jComboBox1.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MODIFICAR VEHICULO");
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelSINFECHA.setBackground(new java.awt.Color(102, 102, 102));
        jPanelSINFECHA.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelSINFECHA.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {""}));
        jComboBoxModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxModeloActionPerformed(evt);
            }
        });
        jPanelSINFECHA.add(jComboBoxModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 100, -1));

        jComboBoxMotor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "1.0", "1.2", "1.4", "1.6", "1.8", "2.0", "2.2", "2.4", "2.5", "2.8", "3.0", "3.2", "3.5", "3.6", "4.0", "4.2", "4.5", "5.0", "5.2", "5.5", "5.7", "6.0", "6.2", "7.0", "7.3", "8.0" }));
        jComboBoxMotor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMotorActionPerformed(evt);
            }
        });
        jPanelSINFECHA.add(jComboBoxMotor, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 100, -1));

        jComboBoxPuertas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "1", "2", "3", "4", "5" }));
        jComboBoxPuertas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPuertasActionPerformed(evt);
            }
        });
        jPanelSINFECHA.add(jComboBoxPuertas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 100, -1));

        jComboBoxCilindros1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "","2", "3", "4", "5", "6", "8", "10", "12", "16" }));
        jComboBoxCilindros1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCilindros1ActionPerformed(evt);
            }
        });
        jPanelSINFECHA.add(jComboBoxCilindros1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 100, -1));

        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "","Sedan", "Coupe", "Hatchback", "Citycar", "SUV", "PickUP", "Electrico" }));
        jComboBoxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoActionPerformed(evt);
            }
        });
        jPanelSINFECHA.add(jComboBoxTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 100, -1));

        MarcaMod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"","Acura", "Alfa Romeo", "Aston Martin", "Audi", "Bentley", "BMW", "Bugatti", "Buick",
            "Cadillac", "Chevrolet", "Chrysler", "Citroën", "Dodge", "Ferrari", "Fiat", "Ford",
            "Genesis", "GMC", "Honda", "Hyundai", "Infiniti", "Isuzu", "Jaguar", "Jeep", "Kia",
            "Koenigsegg", "Lamborghini", "Land Rover", "Lexus", "Lincoln", "Lotus", "Maserati",
            "Mazda", "McLaren", "Mercedes-Benz", "Mini", "Mitsubishi", "Nissan", "Pagani", "Peugeot",
            "Pontiac", "Porsche", "RAM", "Renault", "Rolls-Royce", "Saab", "SEAT", "Skoda", "Smart",
            "Subaru", "Suzuki", "Tesla", "Toyota", "Volkswagen", "Volvo"}));
MarcaMod.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        MarcaModActionPerformed(evt);
    }
    });
    jPanelSINFECHA.add(MarcaMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 100, -1));

    jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(255, 255, 255));
    jLabel1.setText("LINEA");
    jPanelSINFECHA.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

    jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(255, 255, 255));
    jLabel2.setText("MARCA");
    jPanelSINFECHA.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

    jComboBoxLinea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
    jComboBoxLinea.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBoxLineaActionPerformed(evt);
        }
    });
    jPanelSINFECHA.add(jComboBoxLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 100, -1));

    jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(255, 255, 255));
    jLabel3.setText("TIPO");
    jPanelSINFECHA.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

    jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(255, 255, 255));
    jLabel4.setText("MODELO");
    jPanelSINFECHA.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

    jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(255, 255, 255));
    jLabel5.setText("CILINDROS");
    jPanelSINFECHA.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

    jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(255, 255, 255));
    jLabel6.setText("MOTOR");
    jPanelSINFECHA.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

    jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(255, 255, 255));
    jLabel7.setText("PUERTAS");
    jPanelSINFECHA.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

    getContentPane().add(jPanelSINFECHA, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 210, 220));

    jPanel1.setBackground(new java.awt.Color(102, 102, 102));
    jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(255, 255, 255));
    jLabel9.setText("CLAVE");
    jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

    jComboBoxClave.setBackground(new java.awt.Color(255, 255, 255));
    jComboBoxClave.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
    jComboBoxClave.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBoxClaveActionPerformed(evt);
        }
    });
    jPanel1.add(jComboBoxClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 120, 30));

    getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 210, 30));

    jLabelTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
    jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
    jLabelTitulo.setText("INFORMACION DEL VEHICULO");
    getContentPane().add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

    jPanelFecha.setBackground(new java.awt.Color(102, 102, 102));
    jPanelFecha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jPanelFecha.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel10.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
    jLabel10.setForeground(new java.awt.Color(255, 255, 255));
    jLabel10.setText("CAMBIO DE ACEITE");
    jPanelFecha.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

    jLabel11.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
    jLabel11.setForeground(new java.awt.Color(255, 255, 255));
    jLabel11.setText("AFINACION");
    jPanelFecha.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

    jLabel12.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
    jLabel12.setForeground(new java.awt.Color(255, 255, 255));
    jLabel12.setText("LAVADO EXTERNO");
    jPanelFecha.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

    jLabel13.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
    jLabel13.setForeground(new java.awt.Color(255, 255, 255));
    jLabel13.setText("LAVADO INTERIOR");
    jPanelFecha.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

    jLabel14.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
    jLabel14.setForeground(new java.awt.Color(255, 255, 255));
    jLabel14.setText("LAVADO DE MOTOR");
    jPanelFecha.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

    jLabel15.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
    jLabel15.setForeground(new java.awt.Color(255, 255, 255));
    jLabel15.setText("SERVICIO DE FRENOS");
    jPanelFecha.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

    jLabel16.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
    jLabel16.setForeground(new java.awt.Color(255, 255, 255));
    jLabel16.setText("CAMBIO DE ANTICONGELANTE");
    jPanelFecha.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));
    jPanelFecha.add(jDateChooser3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 160, -1));
    jPanelFecha.add(jDateChooser7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 160, -1));
    jPanelFecha.add(jDateChooser4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 160, -1));
    jPanelFecha.add(jDateChooser5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 160, -1));
    jPanelFecha.add(jDateChooser6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 160, -1));
    jPanelFecha.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 160, -1));
    jPanelFecha.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 160, -1));

    getContentPane().add(jPanelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 420, 220));

    jLabel17.setBackground(new java.awt.Color(102, 102, 102));
    jLabel17.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
    jLabel17.setForeground(new java.awt.Color(255, 255, 255));
    jLabel17.setText("FECHA PARA SERVICIO DE:");
    jLabel17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
    getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 270, -1));

    jButtonCancelar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
    jButtonCancelar.setText("CANCELAR");
    jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonCancelarActionPerformed(evt);
        }
    });
    getContentPane().add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, -1, -1));

    jButtonaActualizar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
    jButtonaActualizar.setText("GUARDAR CAMBIOS");
    jButtonaActualizar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonaActualizarActionPerformed(evt);
        }
    });
    getContentPane().add(jButtonaActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, -1, -1));

    jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Wallpaper 800,600.png"))); // NOI18N
    getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxModeloActionPerformed

    private void jComboBoxMotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMotorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxMotorActionPerformed

    private void jComboBoxPuertasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPuertasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPuertasActionPerformed

    private void jComboBoxCilindros1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCilindros1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCilindros1ActionPerformed

    private void jComboBoxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTipoActionPerformed

    private void MarcaModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MarcaModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MarcaModActionPerformed

    private void jComboBoxLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLineaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxLineaActionPerformed

    private void jComboBoxClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxClaveActionPerformed
        String claveSeleccionada = (String) jComboBoxClave.getSelectedItem();
            if (claveSeleccionada != null && !claveSeleccionada.isEmpty()) {
            cargarInformacionAuto(claveSeleccionada);
    }
    }//GEN-LAST:event_jComboBoxClaveActionPerformed

    private void jButtonaActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonaActualizarActionPerformed
        actualizarInformacionAuto();
    }//GEN-LAST:event_jButtonaActualizarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new ModAuto(null).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> MarcaMod;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonaActualizar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBoxCilindros1;
    private javax.swing.JComboBox<String> jComboBoxClave;
    private javax.swing.JComboBox<String> jComboBoxLinea;
    private javax.swing.JComboBox<String> jComboBoxModelo;
    private javax.swing.JComboBox<String> jComboBoxMotor;
    private javax.swing.JComboBox<String> jComboBoxPuertas;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private com.toedter.calendar.JDateChooser jDateChooser6;
    private com.toedter.calendar.JDateChooser jDateChooser7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelFecha;
    private javax.swing.JPanel jPanelSINFECHA;
    // End of variables declaration//GEN-END:variables
}
