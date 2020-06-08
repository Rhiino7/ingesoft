/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontera;

import Control.ValidarRegistro;
import DAO.UsuarioDAO;
import Entidad.Admin;
import Entidad.Usuario;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author cdgn2
 */
public class Registro extends javax.swing.JPanel {

    public Registro() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        registrarseB = new javax.swing.JButton();
        usuarioTF = new javax.swing.JTextField();
        usuariotxt = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        apellidoTF = new javax.swing.JTextField();
        identificacionTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nombreTF = new javax.swing.JTextField();
        contraseniaPF = new javax.swing.JPasswordField();
        repetirContraseniaPF = new javax.swing.JPasswordField();
        longitudesL = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel1.setText("Contraseña");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel2.setText("Repetir contraseña");

        registrarseB.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        registrarseB.setText("Registrarse");
        registrarseB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarseBActionPerformed(evt);
            }
        });

        usuarioTF.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        usuarioTF.setToolTipText("Escriba el nombre de usuario aqui");
        usuarioTF.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
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

        usuariotxt.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        usuariotxt.setText("Usuario");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel4.setText("Apellido");

        apellidoTF.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        apellidoTF.setToolTipText("Escriba el nombre de usuario aqui");
        apellidoTF.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        apellidoTF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                apellidoTFMouseClicked(evt);
            }
        });
        apellidoTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidoTFActionPerformed(evt);
            }
        });

        identificacionTF.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        identificacionTF.setToolTipText("Escriba el nombre de usuario aqui");
        identificacionTF.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        identificacionTF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                identificacionTFMouseClicked(evt);
            }
        });
        identificacionTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identificacionTFActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel5.setText("Identificación");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel6.setText("Nombre");

        nombreTF.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        nombreTF.setToolTipText("Escriba el nombre de usuario aqui");
        nombreTF.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        nombreTF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nombreTFMouseClicked(evt);
            }
        });
        nombreTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTFActionPerformed(evt);
            }
        });

        repetirContraseniaPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repetirContraseniaPFActionPerformed(evt);
            }
        });

        longitudesL.setBackground(new java.awt.Color(255, 0, 51));
        longitudesL.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        longitudesL.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(154, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(usuariotxt)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(14, 14, 14)))
                                .addGap(53, 53, 53))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nombreTF, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(apellidoTF, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(identificacionTF, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(usuarioTF, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(contraseniaPF, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(repetirContraseniaPF, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(longitudesL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(registrarseB))
                .addGap(141, 141, 141))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreTF, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellidoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(identificacionTF, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuarioTF, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuariotxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(contraseniaPF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(repetirContraseniaPF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(longitudesL, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(registrarseB, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void registrarseBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarseBActionPerformed
        String nombre = nombreTF.getText();
        String apellido = apellidoTF.getText();
        String id = identificacionTF.getText();
        String usuario = usuarioTF.getText();
        String contrasenia = contraseniaPF.getText();
        String contraseniaConf = repetirContraseniaPF.getText();

        ValidarRegistro validar = new ValidarRegistro();
        boolean registroCorrecto = validar.registroCompleto(nombre, apellido, identificacionTF.getText(), usuario, contrasenia, contraseniaConf);
        boolean longNombre = validar.verificarLongitudNombre(nombre);
        boolean longApellido = validar.verificarLongitudApellido(apellido);
        boolean longPassword = validar.verificarLongitudPassword(contrasenia);
        boolean identNumerico = validar.identificacionNumerica(identificacionTF.getText());
        boolean nombreNumerico = validar.nombreNumerico(nombre);
        boolean apellidoNumerico = validar.apellidoNumerico(apellido);
        System.out.println("Nombre: "+nombre+"nombreNumerico: "+ nombreNumerico);
        System.out.println("Apellido: "+apellido+" apellidoNumerico: "+ apellidoNumerico);
        if(registroCorrecto){
            if (!longNombre) {
                JOptionPane.showMessageDialog(usuarioTF, "Verifique la longitud del usuario y la contraseña", "Usuario o contraseña no validos", JOptionPane.ERROR_MESSAGE);
                if (validar.verificarLongitudNombre(usuario) != true) {
                    longitudesL.setText("la nombre debe tener entre 3 y 11 caracteres");
                } else if (validar.verificarLongitudPassword(contrasenia) != true) {
                    longitudesL.setText("la contraseña debe tener entre 4 y 13 caracteres");
                }
            }else{
                UsuarioDAO dao = new UsuarioDAO();
                boolean existe = false;
                boolean usuarioExiste = false;
                boolean adminExiste = false;
                /*List<Usuario> lista = dao.obtener();
                */

                Usuario u = new Usuario(nombre, apellido, Integer.parseInt(id), usuario, contrasenia);
                Admin admin = new Admin(usuario, contrasenia, Long.parseLong(id));
                
                if (validar.identificacionNumerica(identificacionTF.getText())) {
                    long identificacion = Long.parseLong(identificacionTF.getText());
                    int adminE = validar.verificarRegistro(admin);
                    int usuarioE = validar.verificarRegistro(u, admin);
                    if(usuarioE ==  3){
                         usuarioExiste = true;
                    }
                    if(adminE ==  4){
                        adminExiste = true;
                    }
//                    for (int i = 0; i < lista.size(); i++) {
//                        if (lista.get(i).getIdentificacion() == identificacion) {
//                            existe = true;
//                            break;
//                        }
//                    }
                    System.out.println(adminExiste);
                    System.out.println(usuarioExiste);

                    if (!adminExiste &&  registroCorrecto) {
                        if (contrasenia.equals(contraseniaConf)) {
                            if (validar.verificarUsuarioYPassword(usuario, contrasenia)) {
                                JOptionPane.showMessageDialog(usuarioTF, "Registro Exitoso", "Registro", JOptionPane.INFORMATION_MESSAGE);
                                Usuario user = new Usuario(nombre, apellido, (int) identificacion, usuario, contrasenia);
                                dao.registrar(user);
                                nombreTF.setText(null);
                                apellidoTF.setText(null);
                                identificacionTF.setText(null);
                                usuarioTF.setText(null);
                                contraseniaPF.setText(null);
                                repetirContraseniaPF.setText(null);
                            } else {
                                JOptionPane.showMessageDialog(usuarioTF, "Verifique la longitud del usuario y la contraseña", "Usuario o contraseña no validos", JOptionPane.ERROR_MESSAGE);
                                if (validar.verificarLongitudNombre(usuario) != true) {
                                    longitudesL.setText("el nombre debe tener entre 3 y 11 caracteres");
                                } else if (validar.verificarLongitudPassword(contrasenia) != true) {
                                    longitudesL.setText("la contraseña debe tener entre 4 y 13 caracteres");
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(usuarioTF, "Contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(usuarioTF, "El usuario ya esta registrado", "Error", JOptionPane.ERROR_MESSAGE);
                        longitudesL.setText("usuario ya registrado");
                    }
                } else {
                    JOptionPane.showMessageDialog(usuarioTF, "Identificación invalida", "Error", JOptionPane.ERROR_MESSAGE);
                    longitudesL.setText("Identificacion debe ser un numero");
                } 
            }  
        }else {
            if (!longNombre) {
                JOptionPane.showMessageDialog(usuarioTF, "Verifique la longitud del nombre", "Nombre no valido", JOptionPane.ERROR_MESSAGE);
                if (validar.verificarLongitudNombre(usuario) != true) {
                    longitudesL.setText("El nombre debe tener entre 3 y 11 caracteres");
                }
            }
            if (!longApellido) {
                JOptionPane.showMessageDialog(usuarioTF, "Verifique la longitud del apellido", "Apellido no valido", JOptionPane.ERROR_MESSAGE);
                if (validar.verificarLongitudApellido(apellido) != true) {
                    longitudesL.setText("El apellido debe tener entre 3 y 11 caracteres");
                }
            }
            if (!longPassword) {
                JOptionPane.showMessageDialog(usuarioTF, "Verifique la longitud de la contraseña", "Contraseña no valida", JOptionPane.ERROR_MESSAGE);
                if (validar.verificarLongitudPassword(contrasenia) != true) {
                    longitudesL.setText("La contraseña debe tener entre 4 y 12 caracteres");
                }
            }
            if (!identNumerico) {
                JOptionPane.showMessageDialog(usuarioTF, "La identificacion tiene que ser un numero", "Identificacion no valida", JOptionPane.ERROR_MESSAGE);
                longitudesL.setText("La identificacion debe ser numerica.");
            }
            System.out.println(nombreNumerico);
            if (nombreNumerico) {
                JOptionPane.showMessageDialog(usuarioTF, "El nombre tienen que ser letras", "Nombre no valido", JOptionPane.ERROR_MESSAGE);
                longitudesL.setText("El nombre no debe contener numeros.");
            }else if(!nombreNumerico && !registroCorrecto){
                JOptionPane.showMessageDialog(usuarioTF, "El nombre tienen que ser solo letras", "Nombre no valido", JOptionPane.ERROR_MESSAGE);
                longitudesL.setText("El nombre no debe contener numeros.");
            }
            System.out.println(apellidoNumerico);
            if (apellidoNumerico) {
                JOptionPane.showMessageDialog(usuarioTF, "El apellido tienen que ser letras", "Apellido no valido", JOptionPane.ERROR_MESSAGE);
                longitudesL.setText("El apellido no debe contener numeros.");
            }else if(!apellidoNumerico && !registroCorrecto){
                JOptionPane.showMessageDialog(usuarioTF, "El apellido tienen que ser solo letras", "Apellido no valido", JOptionPane.ERROR_MESSAGE);
                longitudesL.setText("El apellido no debe contener numeros.");
            }
            if(!validar.verificarLongitudNombre(usuario)){
                JOptionPane.showMessageDialog(usuarioTF, "Verifique la longitud del usuario", "Usuario no valido", JOptionPane.ERROR_MESSAGE);
                longitudesL.setText("El usuario debe tener entre 3 y 11 caracteres");
            }
            
            
            
            if (nombreTF.getText().equals("") || apellidoTF.getText().equals("")
                    || identificacionTF.getText().equals("") || usuarioTF.getText().equals("")
                    || contraseniaPF.getText().equals("") || repetirContraseniaPF.getText().equals("")) {
                JOptionPane.showMessageDialog(usuarioTF, "Campos Vacios", "Error", JOptionPane.ERROR_MESSAGE);
                longitudesL.setText("Campos vacios");
            }
        }
        

        
        
//        if (!identificacionTF.getText().equals("") && !(nombreTF.getText().equals("") || apellidoTF.getText().equals("")
//                || identificacionTF.getText().equals("") || usuarioTF.getText().equals("")
//                || contraseniaPF.getText().equals("") || repetirContraseniaPF.getText().equals(""))) {//que sea solo numerico
//
//            if (validar.identificacionNumerica(identificacionTF.getText())) {
//                long identificacion = Long.parseLong(identificacionTF.getText());
//                for (int i = 0; i < lista.size(); i++) {
//                    if (lista.get(i).getIdentificacion() == identificacion) {
//                        existe = true;
//                        break;
//                    }
//                }
//
//                if (existe == false) {
//                    JOptionPane.showMessageDialog(usuarioTF, "Registro Exitoso", "Registro", JOptionPane.INFORMATION_MESSAGE);
//                    if (contrasenia.equals(contraseniaConf)) {
//                        if (validar.verificarUsuarioYPassword(usuario, contrasenia)) {
//                            Usuario user = new Usuario(nombre, apellido, (int) identificacion, usuario, contrasenia);
//                            dao.registrar(user);
//                            nombreTF.setText(null);
//                            apellidoTF.setText(null);
//                            identificacionTF.setText(null);
//                            usuarioTF.setText(null);
//                            contraseniaPF.setText(null);
//                            repetirContraseniaPF.setText(null);
//                        } else {
//                            JOptionPane.showMessageDialog(usuarioTF, "Verifique la longitud del usuario y la contraseña", "Usuario o contraseña no validos", JOptionPane.ERROR_MESSAGE);
//                            if (validar.verificarLongitudNombre(usuario) != true) {
//                                longitudesL.setText("la nombre debe tener entre 3 y 11 caracteres");
//                            } else if (validar.verificarLongitudPassword(contrasenia) != true) {
//                                longitudesL.setText("la contraseña debe tener entre 4 y 13 caracteres");
//                            }
//                        }
//                    } else {
//                        JOptionPane.showMessageDialog(usuarioTF, "Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(usuarioTF, "El usuario ya esta registrado", "Error", JOptionPane.ERROR_MESSAGE);
//                    longitudesL.setText("usuario ya registrado");
//                }
//            } else {
//                JOptionPane.showMessageDialog(usuarioTF, "Identificación invalida", "Error", JOptionPane.ERROR_MESSAGE);
//                longitudesL.setText("Identificacion debe ser un numero");
//            }
//        } else {
//            if (nombreTF.getText().equals("") || apellidoTF.getText().equals("")
//                    || identificacionTF.getText().equals("") || usuarioTF.getText().equals("")
//                    || contraseniaPF.getText().equals("") || repetirContraseniaPF.getText().equals("")) {
//                JOptionPane.showMessageDialog(usuarioTF, "Campos Vacios", "Error", JOptionPane.ERROR_MESSAGE);
//                longitudesL.setText("Campos vacios");
//            }
//        }
    }//GEN-LAST:event_registrarseBActionPerformed

    private void usuarioTFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuarioTFMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioTFMouseClicked

    private void usuarioTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioTFActionPerformed

    private void apellidoTFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_apellidoTFMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidoTFMouseClicked

    private void apellidoTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidoTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidoTFActionPerformed

    private void identificacionTFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_identificacionTFMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_identificacionTFMouseClicked

    private void identificacionTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_identificacionTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_identificacionTFActionPerformed

    private void nombreTFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nombreTFMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTFMouseClicked

    private void nombreTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTFActionPerformed

    private void repetirContraseniaPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repetirContraseniaPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repetirContraseniaPFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidoTF;
    private javax.swing.JPasswordField contraseniaPF;
    private javax.swing.JTextField identificacionTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel longitudesL;
    private javax.swing.JTextField nombreTF;
    private javax.swing.JButton registrarseB;
    private javax.swing.JPasswordField repetirContraseniaPF;
    private javax.swing.JTextField usuarioTF;
    private javax.swing.JLabel usuariotxt;
    // End of variables declaration//GEN-END:variables
}
