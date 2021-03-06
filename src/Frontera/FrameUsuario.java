/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontera;

import DAO.CitaDAO;
import DAO.SucursalDAO;
import DAO.UsuarioDAO;
import Entidad.Cita;
import Entidad.Usuario;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cdgn2
 */
public class FrameUsuario extends javax.swing.JFrame {

    private Usuario usuario; //Para facilitar se le pasa el usuario que ingreso sesion.
    private Agendar agendar;
    private Citaciones citas;
    private UsuarioDAO udao = new UsuarioDAO();
    private CitaDAO cdao = new CitaDAO();
    private ArrayList<Cita> citasList = (ArrayList<Cita>) cdao.obtener();
    
    boolean agendarActive = false;
    boolean citacionesActive = false;

    int estado = 0;

    /**
     * Creates new form FrameUsuario
     */
    public FrameUsuario(Usuario u) {
        this.usuario = u;
        System.out.println(usuario.toString());
        agendar = new Agendar(usuario);
        citas = new Citaciones(usuario);
        initComponents();
        setLocationRelativeTo(null);

        
        List<Usuario> usuarios = udao.obtener();
        for (Usuario a : usuarios) {
            if (a.getUsuario().equals(usuario.getUsuario())) { //No deberian haber dos nombres de usuario iguales
                usuario = a;
                break;
            }
        }

        for (int i = 0; i < citasList.size(); i++) {

            if (citasList.get(i).getUsuario().getIdentificacion() == this.usuario.getIdentificacion()) {
                Cita aux = citasList.get(i);

                if (aux.getEstado() == 6) {
                    ReasignarPopUp1 pop = new ReasignarPopUp1(this.usuario);
                    pop.setVisible(true);
                    
                }
                break;
            }
        }
        
        principalUsuarioPanel.setVisible(false);
        principalUsuarioPanel.removeAll();
        principalUsuarioPanel.add(new Agendar(usuario));
        principalUsuarioPanel.setVisible(true);
        agendarActive = true;
        float[] colortemp = new float[3];
        Color.RGBtoHSB(240,240,240,colortemp);
        agendarB.setBackground(Color.getHSBColor(colortemp[0],colortemp[1],colortemp[2]));
        agendarB.setForeground(Color.black);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        principalUsuarioPanel = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        agendarB = new javax.swing.JButton();
        citacionesB = new javax.swing.JButton();
        cerrarSesionB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(970, 700));

        principalUsuarioPanel.setMinimumSize(new java.awt.Dimension(700, 650));
        principalUsuarioPanel.setLayout(new java.awt.BorderLayout());

        menuPanel.setBackground(new java.awt.Color(9, 12, 2));
        menuPanel.setToolTipText("");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Grupo 3.1.png"))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(9, 12, 2));
        jPanel3.setLayout(new java.awt.GridLayout(3, 0));

        agendarB.setBackground(new java.awt.Color(9, 12, 2));
        agendarB.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        agendarB.setForeground(new java.awt.Color(255, 255, 255));
        agendarB.setText("AGENDAR");
        agendarB.setBorder(null);
        agendarB.setBorderPainted(false);
        agendarB.setFocusable(false);
        agendarB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        agendarB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        agendarB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                agendarBMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                agendarBMouseExited(evt);
            }
        });
        agendarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendarBActionPerformed(evt);
            }
        });
        jPanel3.add(agendarB);

        citacionesB.setBackground(new java.awt.Color(9, 12, 2));
        citacionesB.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        citacionesB.setForeground(new java.awt.Color(255, 255, 255));
        citacionesB.setText("CITACIONES");
        citacionesB.setBorder(null);
        citacionesB.setBorderPainted(false);
        citacionesB.setFocusable(false);
        citacionesB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        citacionesB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        citacionesB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                citacionesBMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                citacionesBMouseExited(evt);
            }
        });
        citacionesB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                citacionesBActionPerformed(evt);
            }
        });
        jPanel3.add(citacionesB);

        cerrarSesionB.setBackground(new java.awt.Color(9, 12, 2));
        cerrarSesionB.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cerrarSesionB.setForeground(new java.awt.Color(255, 255, 255));
        cerrarSesionB.setText("CERRAR SESIÓN");
        cerrarSesionB.setBorder(null);
        cerrarSesionB.setBorderPainted(false);
        cerrarSesionB.setFocusable(false);
        cerrarSesionB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cerrarSesionB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cerrarSesionB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cerrarSesionBMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cerrarSesionBMouseExited(evt);
            }
        });
        cerrarSesionB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarSesionBActionPerformed(evt);
            }
        });
        jPanel3.add(cerrarSesionB);

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(principalUsuarioPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 690, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principalUsuarioPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
            .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agendarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendarBActionPerformed
        // TODO add your handling code here:
        principalUsuarioPanel.setVisible(false);
        principalUsuarioPanel.removeAll();
        principalUsuarioPanel.add(agendar);
        principalUsuarioPanel.setVisible(true);
        
        float[] color = new float[3];
        Color.RGBtoHSB(240,240,240, color);
        
        agendarB.setBackground(Color.getHSBColor(color[0],color[1],color[2]));
        agendarB.setForeground(Color.black);
        agendarActive = true;
        
        Color.RGBtoHSB(9, 12, 2, color);
        
        citacionesB.setBackground(Color.getHSBColor(color[0],color[1],color[2]));
        citacionesActive = false;
        citacionesB.setForeground(Color.white);
    }//GEN-LAST:event_agendarBActionPerformed

    private void citacionesBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_citacionesBActionPerformed
        // TODO add your handling code here:
        principalUsuarioPanel.setVisible(false);
        principalUsuarioPanel.removeAll();
        principalUsuarioPanel.add(citas);
        principalUsuarioPanel.setVisible(true);
        citas.showUsersinTable();
        
        float[] color = new float[3];
        Color.RGBtoHSB(240,240,240, color);
        
        citacionesB.setBackground(Color.getHSBColor(color[0],color[1],color[2]));
        citacionesActive = true;
        citacionesB.setForeground(Color.black);
        
        Color.RGBtoHSB(9, 12, 2, color);
        
        agendarB.setBackground(Color.getHSBColor(color[0],color[1],color[2]));
        agendarActive = false;
        agendarB.setForeground(Color.white);
    }//GEN-LAST:event_citacionesBActionPerformed

    private void cerrarSesionBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesionBActionPerformed
        this.setVisible(false);
        PrincipalFrame principalFrame = new PrincipalFrame();
        principalFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cerrarSesionBActionPerformed

    private void agendarBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agendarBMouseEntered
        float[] color = new float[3];
        if (!agendarActive){
            Color.RGBtoHSB(86, 90, 91, color);
            agendarB.setBackground(Color.getHSBColor(color[0],color[1],color[2]));
        }
    }//GEN-LAST:event_agendarBMouseEntered

    private void agendarBMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agendarBMouseExited
        float[] color = new float[3];
        
        if (!agendarActive){
            Color.RGBtoHSB(9, 12, 2, color);
            agendarB.setBackground(Color.getHSBColor(color[0],color[1],color[2]));
        }
    }//GEN-LAST:event_agendarBMouseExited

    private void citacionesBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_citacionesBMouseEntered
        float[] color = new float[3];
        if (!citacionesActive){
            Color.RGBtoHSB(86, 90, 91, color);
            citacionesB.setBackground(Color.getHSBColor(color[0],color[1],color[2]));
        }
    }//GEN-LAST:event_citacionesBMouseEntered

    private void citacionesBMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_citacionesBMouseExited
        float[] color = new float[3];
        
        if (!citacionesActive){
            Color.RGBtoHSB(9, 12, 2, color);
            citacionesB.setBackground(Color.getHSBColor(color[0],color[1],color[2]));
        }
    }//GEN-LAST:event_citacionesBMouseExited

    private void cerrarSesionBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarSesionBMouseEntered
        float[] color = new float[3];
        Color.RGBtoHSB(86, 90, 91, color);
        cerrarSesionB.setBackground(Color.getHSBColor(color[0],color[1],color[2]));
    }//GEN-LAST:event_cerrarSesionBMouseEntered

    private void cerrarSesionBMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarSesionBMouseExited
        float[] color = new float[3];
        Color.RGBtoHSB(9, 12, 2, color);
        cerrarSesionB.setBackground(Color.getHSBColor(color[0],color[1],color[2]));
    }//GEN-LAST:event_cerrarSesionBMouseExited
                                           


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agendarB;
    private javax.swing.JButton cerrarSesionB;
    private javax.swing.JButton citacionesB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JPanel principalUsuarioPanel;
    // End of variables declaration//GEN-END:variables
}
