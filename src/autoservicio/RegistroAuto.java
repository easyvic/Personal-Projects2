package autoservicio;

import java.sql.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;

import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;

import com.toedter.calendar.JDateChooser;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RegistroAuto extends javax.swing.JFrame {

    private Connection conexion;
    private JDateChooser dateChooserCambioAceite;
    private Map<String, String[]> modelosPorMarca = new HashMap<>();
    private IntGeneral intGeneral;
    
    private Date fechaAceite;
    private Date fechaAfinacion;
    private Date fechaLavadoExterno;
    private Date fechaLavadoInterior;
    private Date fechaLavadoMotor;
    private Date fechaServicioFrenos;
    private Date fechaCambioAnticongelante;
    
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/icono png.png"));
        return retValue;
    }
    
    public RegistroAuto(Connection conexion) {
        
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.conexion = conexion;
        this.intGeneral = intGeneral;
        verificarConexion();
        configurarModelosPorMarca();
        agregarListeners();
        ComboBoxModelo();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
    }
    
    public void verificarConexion() {
    if (conexion != null) {
        System.out.println("SI");
    } else {
        System.out.println("NO");
    }
    }
    
    /*
    public void llenarCBMarca(){
        String[] marcas = {"Acura", "Alfa Romeo", "Aston Martin", "Audi", "Bentley", "BMW", "Bugatti", "Buick", 
                       "Cadillac", "Chevrolet", "Chrysler", "Citroën", "Dodge", "Ferrari", "Fiat", "Ford", 
                       "Genesis", "GMC", "Honda", "Hyundai", "Infiniti", "Isuzu", "Jaguar", "Jeep", "Kia", 
                       "Koenigsegg", "Lamborghini", "Land Rover", "Lexus", "Lincoln", "Lotus", "Maserati", 
                       "Mazda", "McLaren", "Mercedes-Benz", "Mini", "Mitsubishi", "Nissan", "Pagani", "Peugeot", 
                       "Pontiac", "Porsche", "RAM", "Renault", "Rolls-Royce", "Saab", "SEAT", "Skoda", "Smart", 
                       "Subaru", "Suzuki", "Tesla", "Toyota", "Volkswagen", "Volvo"};
                       
        for (String marca : marcas) {
            Marca.addItem(marca);
        }
    }
    */
    
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
        Marca.addActionListener(evt -> actualizarModelosLinea());
        jDateChooser1.addPropertyChangeListener(evt -> sugerirFecha(jDateChooser1, "Cambio de Aceite", "fechaAceite"));
        jDateChooser2.addPropertyChangeListener(evt -> sugerirFecha(jDateChooser2, "Afinación", "fechaAfinacion"));
        jDateChooser3.addPropertyChangeListener(evt -> sugerirFecha(jDateChooser3, "Lavado Externo", "fechaLavadoExterno"));
        jDateChooser4.addPropertyChangeListener(evt -> sugerirFecha(jDateChooser4, "Lavado Interior", "fechaLavadoInterior"));
        jDateChooser5.addPropertyChangeListener(evt -> sugerirFecha(jDateChooser5, "Lavado de Motor", "fechaLavadoMotor"));
        jDateChooser6.addPropertyChangeListener(evt -> sugerirFecha(jDateChooser6, "Servicio de Frenos", "fechaServicioFrenos"));
        jDateChooser7.addPropertyChangeListener(evt -> sugerirFecha(jDateChooser7, "Cambio de Anticongelante", "fechaCambioAnticongelante"));
    }

    private void actualizarModelosLinea() {
        String marcaSeleccionada = (String) Marca.getSelectedItem();
        String[] modelos = modelosPorMarca.getOrDefault(marcaSeleccionada, new String[]{});

        jComboBoxLinea.setModel(new DefaultComboBoxModel<>(modelos));
    }
    
    private void ComboBoxModelo() {
    for (int año = 1800; año <= 2030; año++) {
        jComboBoxModelo.addItem(String.valueOf(año));
    }
    }
    
    private void sugerirFechaAceite(JDateChooser dateChooser) {
    sugerirFecha(dateChooser, "Cambio de Aceite", "fechaAceite");
}

    private void sugerirFechaAfinacion(JDateChooser dateChooser) {
    sugerirFecha(dateChooser, "Afinación", "fechaAfinacion");
}

    private void sugerirFechaLavadoExterno(JDateChooser dateChooser) {
    sugerirFecha(dateChooser, "Lavado Externo", "fechaLavadoExterno");
}

    private void sugerirFechaLavadoInterior(JDateChooser dateChooser) {
    sugerirFecha(dateChooser, "Lavado Interior", "fechaLavadoInterior");
}

    private void sugerirFechaLavadoMotor(JDateChooser dateChooser) {
    sugerirFecha(dateChooser, "Lavado de Motor", "fechaLavadoMotor");
}

    private void sugerirFechaServicioFrenos(JDateChooser dateChooser) {
    sugerirFecha(dateChooser, "Servicio de Frenos", "fechaServicioFrenos");
}

    private void sugerirFechaCambioAnticongelante(JDateChooser dateChooser) {
    sugerirFecha(dateChooser, "Cambio de Anticongelante", "fechaCambioAnticongelante");
}

    private void sugerirFecha(JDateChooser dateChooser, String servicio, String variable) {
        Date selectedDate = dateChooser.getDate();
        Calendar suggestedCalendar = Calendar.getInstance();

        if (selectedDate != null) {
            suggestedCalendar.setTime(selectedDate);
            suggestedCalendar.add(Calendar.YEAR, 3);
            Calendar currentDate = Calendar.getInstance();
            currentDate.setTime(new Date());

            if (suggestedCalendar.before(currentDate)) {
                suggestedCalendar.setTime(new Date()); 
            }

            String message = "Se sugiere la fecha " + new SimpleDateFormat("dd/MM/yyyy").format(suggestedCalendar.getTime()) + 
                         " para el siguiente servicio: " + servicio + ".";           
            JOptionPane.showMessageDialog(this, message, "Sugerencia de Fecha", JOptionPane.INFORMATION_MESSAGE);
            guardarFecha(suggestedCalendar.getTime(), variable);
        } else {
            System.out.println("");
            //JOptionPane.showMessageDialog(this, "Por favor, seleccione una fecha válida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
}

   
    private void guardarFecha(Date suggestedCalendar, String variable) {
        switch (variable) {
            case "fechaAceite":
                fechaAceite = suggestedCalendar;
                break;
            case "fechaAfinacion":
                fechaAfinacion = suggestedCalendar;
                break;
            case "fechaLavadoExterno":
                fechaLavadoExterno = suggestedCalendar;
                break;
            case "fechaLavadoInterior":
                fechaLavadoInterior = suggestedCalendar;
                break;
            case "fechaLavadoMotor":
                fechaLavadoMotor = suggestedCalendar;
                break;
            case "fechaServicioFrenos":
                fechaServicioFrenos = suggestedCalendar;
                break;
            case "fechaCambioAnticongelante":
                fechaCambioAnticongelante = suggestedCalendar;
                break;
        }
    }
    
    private void limpiarCampos() {
        
        if (Marca.getItemCount() > 0) {
        Marca.setSelectedIndex(0);
        }
        if (jComboBoxLinea.getItemCount() > 0) {
        jComboBoxLinea.setSelectedIndex(0);
        }
        if (jComboBoxTipo.getItemCount() > 0) {
        jComboBoxTipo.setSelectedIndex(0);
        }
        if (jComboBoxModelo.getItemCount() > 0) {
        jComboBoxModelo.setSelectedIndex(0);
        }
        if (jComboBoxCilindros1.getItemCount() > 0) {
        jComboBoxCilindros1.setSelectedIndex(0);
        }
        if (jComboBoxMotor.getItemCount() > 0) {
        jComboBoxMotor.setSelectedIndex(0);
        }
        if (jComboBoxPuertas.getItemCount() > 0) {
        jComboBoxPuertas.setSelectedIndex(0);
        }
    
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
        jDateChooser3.setDate(null);
        jDateChooser4.setDate(null);
        jDateChooser5.setDate(null);
        jDateChooser6.setDate(null);
        jDateChooser7.setDate(null);
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanelSINFECHA = new javax.swing.JPanel();
        jComboBoxModelo = new javax.swing.JComboBox<>();
        jComboBoxMotor = new javax.swing.JComboBox<>();
        jComboBoxPuertas = new javax.swing.JComboBox<>();
        jComboBoxCilindros1 = new javax.swing.JComboBox<>();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        Marca = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxLinea = new javax.swing.JComboBox<>();
        jPanelFecha = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jDateChooser7 = new com.toedter.calendar.JDateChooser();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jDateChooser6 = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REGISTRO DE VEHICULO");
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("INFORMACION DEL VEHICULO");
        getContentPane().add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TIPO");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("MODELO");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CILINDROS");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("MOTOR");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("PUERTAS");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        jButton1.setText("LIMPIAR CAMPOS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, -1, -1));

        jButton2.setText("AGREGAR VEHICULO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, -1, -1));

        jButton3.setText("CANCELAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 120, -1));
        getContentPane().add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 160, -1));
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 160, -1));

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

        Marca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"","Acura", "Alfa Romeo", "Aston Martin", "Audi", "Bentley", "BMW", "Bugatti", "Buick",
            "Cadillac", "Chevrolet", "Chrysler", "Citroën", "Dodge", "Ferrari", "Fiat", "Ford",
            "Genesis", "GMC", "Honda", "Hyundai", "Infiniti", "Isuzu", "Jaguar", "Jeep", "Kia",
            "Koenigsegg", "Lamborghini", "Land Rover", "Lexus", "Lincoln", "Lotus", "Maserati",
            "Mazda", "McLaren", "Mercedes-Benz", "Mini", "Mitsubishi", "Nissan", "Pagani", "Peugeot",
            "Pontiac", "Porsche", "RAM", "Renault", "Rolls-Royce", "Saab", "SEAT", "Skoda", "Smart",
            "Subaru", "Suzuki", "Tesla", "Toyota", "Volkswagen", "Volvo"}));
Marca.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        MarcaActionPerformed(evt);
    }
    });
    jPanelSINFECHA.add(Marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 100, -1));

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

    getContentPane().add(jPanelSINFECHA, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 210, 220));

    jPanelFecha.setBackground(new java.awt.Color(102, 102, 102));
    jPanelFecha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jPanelFecha.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(255, 255, 255));
    jLabel9.setText("CAMBIO DE ACEITE");
    jPanelFecha.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

    jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(255, 255, 255));
    jLabel8.setText("AFINACION");
    jPanelFecha.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

    jLabel10.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
    jLabel10.setForeground(new java.awt.Color(255, 255, 255));
    jLabel10.setText("LAVADO EXTERNO");
    jPanelFecha.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

    jLabel11.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
    jLabel11.setForeground(new java.awt.Color(255, 255, 255));
    jLabel11.setText("LAVADO INTERIOR");
    jPanelFecha.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

    jLabel12.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
    jLabel12.setForeground(new java.awt.Color(255, 255, 255));
    jLabel12.setText("LAVADO DE MOTOR");
    jPanelFecha.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

    jLabel13.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
    jLabel13.setForeground(new java.awt.Color(255, 255, 255));
    jLabel13.setText("SERVICIO DE FRENOS");
    jPanelFecha.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

    jLabel14.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
    jLabel14.setForeground(new java.awt.Color(255, 255, 255));
    jLabel14.setText("CAMBIO DE ANTICONGELANTE");
    jPanelFecha.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));
    jPanelFecha.add(jDateChooser3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 160, -1));
    jPanelFecha.add(jDateChooser7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 160, -1));
    jPanelFecha.add(jDateChooser4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 160, -1));
    jPanelFecha.add(jDateChooser5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 160, -1));
    jPanelFecha.add(jDateChooser6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 160, -1));

    getContentPane().add(jPanelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 420, 220));

    jLabel15.setBackground(new java.awt.Color(102, 102, 102));
    jLabel15.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
    jLabel15.setForeground(new java.awt.Color(255, 255, 255));
    jLabel15.setText("ULTIMO SERVICIO DE:");
    jLabel15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
    getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 230, -1));

    jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Wallpaper 800,600.png"))); // NOI18N
    getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (conexion != null) {
        try {
            
            String sql = "INSERT INTO autos (linea, marca, tipo, modelo, cilindros, motor, puertas, cambioaceite, afinacion, " +
                "lavadoexterno, lavadointerior, lavadomotor, servfrenos, anticongelante) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = conexion.prepareStatement(sql);

            statement.setString(1, (String) jComboBoxLinea.getSelectedItem());
            statement.setString(2, (String) Marca.getSelectedItem());
            statement.setString(3, (String) jComboBoxTipo.getSelectedItem());
            statement.setInt(4, Integer.parseInt((String) jComboBoxModelo.getSelectedItem()));
            statement.setInt(5, Integer.parseInt((String) jComboBoxCilindros1.getSelectedItem()));
            statement.setFloat(6, Float.parseFloat((String) jComboBoxMotor.getSelectedItem()));
            statement.setInt(7, Integer.parseInt((String) jComboBoxPuertas.getSelectedItem()));

            statement.setDate(8, new java.sql.Date(fechaAceite.getTime()));
            statement.setDate(9, new java.sql.Date(fechaAfinacion.getTime()));
            statement.setDate(10, new java.sql.Date(fechaLavadoExterno.getTime()));
            statement.setDate(11, new java.sql.Date(fechaLavadoInterior.getTime()));
            statement.setDate(12, new java.sql.Date(fechaLavadoMotor.getTime()));
            statement.setDate(13, new java.sql.Date(fechaServicioFrenos.getTime()));
            statement.setDate(14, new java.sql.Date(fechaCambioAnticongelante.getTime()));

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Registro agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al insertar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "No hay conexión a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
    }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBoxModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxModeloActionPerformed

    private void jComboBoxCilindros1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCilindros1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCilindros1ActionPerformed

    private void MarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MarcaActionPerformed

    private void jComboBoxLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLineaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxLineaActionPerformed

    private void jComboBoxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTipoActionPerformed

    private void jComboBoxMotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMotorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxMotorActionPerformed

    private void jComboBoxPuertasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPuertasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPuertasActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpiarCampos();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new RegistroAuto(null).setVisible(true));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Marca;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBoxCilindros1;
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
    private javax.swing.JPanel jPanelFecha;
    private javax.swing.JPanel jPanelSINFECHA;
    // End of variables declaration//GEN-END:variables
}
