
package Frontera;

import java.awt.Color;
import Control.ValidarLogin;
import Entidad.Admin;
import Entidad.Usuario;
import Frontera.PrincipalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Ingreso extends javax.swing.JPanel {
    
    //Una manera de que se cierre la ventana:
    public PrincipalFrame principalFrame;
    public JPanel principalPanel;

    /**
     * Creates new form FirstPanel
     */
    public Ingreso(PrincipalFrame principalFrame, JPanel panel) {
        initComponents();
        this.principalFrame = principalFrame;
        this.principalPanel = panel;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usuarioTF = new javax.swing.JTextField();
        ingresarB = new javax.swing.JButton();
        contraseniaPF = new javax.swing.JPasswordField();
        longitudesL = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(116, 79, 198));
        setPreferredSize(new java.awt.Dimension(410, 430));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usuarioTF.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        usuarioTF.setForeground(new java.awt.Color(255, 255, 255));
        usuarioTF.setToolTipText("");
        usuarioTF.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        usuarioTF.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        usuarioTF.setOpaque(false);
        usuarioTF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usuarioTFMouseClicked(evt);
            }
        });
        usuarioTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioTFActionPerformed(evt);
            }
        });
        add(usuarioTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 173, 380, 31));

        ingresarB.setBackground(new java.awt.Color(9, 12, 2));
        ingresarB.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        ingresarB.setForeground(new java.awt.Color(255, 255, 255));
        ingresarB.setText("Ingresar");
        ingresarB.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ingresarB.setBorderPainted(false);
        ingresarB.setFocusable(false);
        ingresarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarBActionPerformed(evt);
            }
        });
        add(ingresarB, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 327, 93, 34));

        contraseniaPF.setForeground(new java.awt.Color(255, 255, 255));
        contraseniaPF.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        contraseniaPF.setOpaque(false);
        add(contraseniaPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 257, 380, 31));

        longitudesL.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        longitudesL.setForeground(new java.awt.Color(255, 173, 230));
        add(longitudesL, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 297, 290, 12));

        jLabelNombre.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabelNombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelNombre.setText("NOMBRE");
        add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 127, 80, 40));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CONTRASEÑA");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 215, 107, 40));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("<html><u>Registrarse</u></html>");
        jLabel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 3, 0));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 376, 80, 20));

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("¿Aún no tiene una cuenta?");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 377, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Inicio de sesion");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 380, 110));
    }// </editor-fold>//GEN-END:initComponents

    private void usuarioTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioTFActionPerformed

    private void usuarioTFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuarioTFMouseClicked
        // TODO add your handling code here:
        usuarioTF.setText("");
    }//GEN-LAST:event_usuarioTFMouseClicked

    private void ingresarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarBActionPerformed
        //aqui toca poner ventanas emergentes diciendo contraseña incorrecta o no existe
        Usuario usuario = new Usuario();
        Admin admin = new Admin();
        usuario.setUsuario(usuarioTF.getText());
        admin.setUsuario(usuarioTF.getText());
        usuario.setContrasenia(contraseniaPF.getText());
        admin.setContrasenia(contraseniaPF.getText());

        ValidarLogin validar = new ValidarLogin();

        int resultado = validar.verificarLogin(usuario,admin);

        if (resultado == 0) {
            //longitud nombre incorrecta
            JOptionPane.showMessageDialog(usuarioTF, "Verifique la longitud del usuario y la contraseña", "Usuario o contraseña no validos", JOptionPane.ERROR_MESSAGE);
            System.out.println("La longitud del nombre de usuario es incorrecta");
            longitudesL.setText("El nombre debe tener entre 3 y 11 caracteres");
        } else if (resultado == 1) {
            //longitud contrasenia incorrecta
            JOptionPane.showMessageDialog(usuarioTF, "Verifique la longitud del usuario y la contraseña", "Usuario o contraseña no validos", JOptionPane.ERROR_MESSAGE);
            System.out.println("La longitud de la contraseña es incorrecta");
            longitudesL.setText("La contraseña debe tener entre 4 y 13 caracteres");
        } else if (resultado == 2) {
            //datos incorrectos
            System.out.println("Los Datos son incorrectos");
            JOptionPane.showMessageDialog(usuarioTF, "los datos son incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            longitudesL.setText("Datos incorrectos");
        } else if (resultado == 3) {
            //Bienvenido
            System.out.println("Bienvenido");
            FrameUsuario frameUsuario = new FrameUsuario(usuario);
            frameUsuario.setVisible(true);
            this.principalFrame.dispose();
            
//            PrincipalFrame principalFrame = new PrincipalFrame();
//            principalFrame.setVisible(false);
//            principalFrame.removeAll();
        } else {
            //Bienvenido Administrador
            System.out.println("Bienvenido Administrador");
            FrameAdmin frameAdmin = new FrameAdmin();
            frameAdmin.setVisible(true);
            this.principalFrame.setVisible(false);
            this.principalFrame.removeAll();
        }
        
        usuarioTF.setText("");
        contraseniaPF.setText("");
    }//GEN-LAST:event_ingresarBActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        principalPanel.setVisible(false);
        principalPanel.removeAll();
        principalPanel.add(new Registro(principalFrame, principalPanel));
        principalPanel.setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField contraseniaPF;
    private javax.swing.JButton ingresarB;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel longitudesL;
    private javax.swing.JTextField usuarioTF;
    // End of variables declaration//GEN-END:variables
}
