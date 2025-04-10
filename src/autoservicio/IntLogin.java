package autoservicio;

import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.Toolkit;

public class IntLogin extends javax.swing.JFrame {

    public IntLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/icono png.png"));
        return retValue;
    }
    
//    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButtonLog = new javax.swing.JButton();
        jUser1 = new javax.swing.JLabel();
        jTextFieldPass = new javax.swing.JTextField();
        jTextFieldUser = new javax.swing.JTextField();
        jUser = new javax.swing.JLabel();
        jLabelTIT = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonSalir.setBackground(new java.awt.Color(233, 106, 106));
        jButtonSalir.setFont(new java.awt.Font("Comic Sans MS", 1, 10)); // NOI18N
        jButtonSalir.setForeground(new java.awt.Color(0, 0, 0));
        jButtonSalir.setText("X");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 40, 40));

        jPanel1.setBackground(new java.awt.Color(44, 44, 44));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButtonLog.setBackground(new java.awt.Color(102, 102, 102));
        jButtonLog.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
        jButtonLog.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLog.setText("INICIAR SESION");
        jButtonLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogActionPerformed(evt);
            }
        });

        jUser1.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jUser1.setForeground(new java.awt.Color(255, 255, 255));
        jUser1.setText("CONTRASEÑA:");

        jTextFieldPass.setBackground(new java.awt.Color(102, 102, 102));
        jTextFieldPass.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jTextFieldPass.setForeground(new java.awt.Color(255, 255, 255));

        jTextFieldUser.setBackground(new java.awt.Color(102, 102, 102));
        jTextFieldUser.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jTextFieldUser.setForeground(new java.awt.Color(255, 255, 255));

        jUser.setBackground(new java.awt.Color(102, 102, 102));
        jUser.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jUser.setForeground(new java.awt.Color(255, 255, 255));
        jUser.setText("USUARIO:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jUser)
                .addGap(13, 13, 13)
                .addComponent(jTextFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jUser1)
                .addGap(8, 8, 8)
                .addComponent(jTextFieldPass, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonLog, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldPass)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jUser1)
                        .addComponent(jUser, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonLog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 690, 40));

        jLabelTIT.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabelTIT.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTIT.setText("AUTOSERVICIOS");
        getContentPane().add(jLabelTIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 320, 50));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Wallpaper 800,600.png"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        
        System.exit(0);
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogActionPerformed
        String usuario = jTextFieldUser.getText();
        String contraseña = jTextFieldPass.getText();

        if (usuario.equals("root") && contraseña.equals("")) {
            JOptionPane.showMessageDialog(this, "INICIO DE SESION EXITOSO.");
            IntGeneral ventanaGeneral = new IntGeneral();
            ventanaGeneral.setVisible(true); 
            dispose();
            
        } else {
            JOptionPane.showMessageDialog(this, "USUARIO O CONTRASEÑA INCORRECTOS.");
        }
                
    }//GEN-LAST:event_jButtonLogActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IntLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLog;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelTIT;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldPass;
    private javax.swing.JTextField jTextFieldUser;
    private javax.swing.JLabel jUser;
    private javax.swing.JLabel jUser1;
    // End of variables declaration//GEN-END:variables
}
