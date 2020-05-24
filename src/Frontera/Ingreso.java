
package Frontera;

import java.awt.Color;
import Control.ValidarLogin;
import Entidad.Admin;
import Entidad.Usuario;
import Frontera.PrincipalFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Ingreso extends javax.swing.JPanel {

    /**
     * Creates new form FirstPanel
     */
    public Ingreso() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usuarioTF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ingresarB = new javax.swing.JButton();
        contraseniaPF = new javax.swing.JPasswordField();
        longitudesL = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(642, 487));

        usuarioTF.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        usuarioTF.setToolTipText("Escriba el nombre de usuario aqui");
        usuarioTF.setDisabledTextColor(new java.awt.Color(102, 102, 102));
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

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel1.setText("Usuario");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel2.setText("Contraseña");

        ingresarB.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        ingresarB.setText("Ingresar");
        ingresarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarBActionPerformed(evt);
            }
        });

        longitudesL.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        longitudesL.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ingresarB, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(29, 29, 29))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(contraseniaPF)
                            .addComponent(usuarioTF, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(longitudesL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(176, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuarioTF, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contraseniaPF, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(longitudesL, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ingresarB, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(179, Short.MAX_VALUE))
        );
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
            longitudesL.setText("la nombre debe tener entre 3 y 11 caracteres");
        } else if (resultado == 1) {
            //longitud contrasenia incorrecta
            JOptionPane.showMessageDialog(usuarioTF, "Verifique la longitud del usuario y la contraseña", "Usuario o contraseña no validos", JOptionPane.ERROR_MESSAGE);
            System.out.println("La longitud de la contraseña es incorrecta");
            longitudesL.setText("la contraseña debe tener entre 4 y 13 caracteres");
        } else if (resultado == 2) {
            //datos incorrectos
            System.out.println("Los Datos son incorrectos");
            JOptionPane.showMessageDialog(usuarioTF, "los datos son incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            longitudesL.setText("Datos incorrectos");
        } else if (resultado == 3) {
            //Bienvenido
            System.out.println("Bienvenido");
            FrameUsuario frameUsuario = new FrameUsuario();
            frameUsuario.setVisible(true);
            PrincipalFrame principalFrame = new PrincipalFrame();
            principalFrame.setVisible(false);
            principalFrame.removeAll();
        } else {
            //Bienvenido Administrador
            System.out.println("Bienvenido Administrador");
            FrameAdmin frameAdmin = new FrameAdmin();
            frameAdmin.setVisible(true);
            PrincipalFrame principalFrame = new PrincipalFrame();
            principalFrame.setVisible(false);
            principalFrame.removeAll();
        }
    }//GEN-LAST:event_ingresarBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField contraseniaPF;
    private javax.swing.JButton ingresarB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel longitudesL;
    private javax.swing.JTextField usuarioTF;
    // End of variables declaration//GEN-END:variables
}
