/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontera;

import DAO.CitaDAO;
import DAO.ComplimentDAO;
import Entidad.Cita;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.SpinnerDateModel;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.WindowConstants;

/**
 *
 * @author cdgn2
 */
public class ReasignarPopUpAdmin extends javax.swing.JDialog {

    CitaDAO citaDAO = new CitaDAO();
    ComplimentDAO complimentDAO = new ComplimentDAO();
    Reasignar reasignar;
    int selectedIDCita = 0;
    int id;

    /**
     * Creates new form ReasignarPopUp
     */
    public ReasignarPopUpAdmin(int citaID, Reasignar r) {
        ArrayList<Cita> citasList = (ArrayList<Cita>) citaDAO.obtener();
        ArrayList<Cita> complimentList = (ArrayList<Cita>) complimentDAO.obtener();
        reasignar = r;
//        citaDAO = reasignar.citaDAO;
//        complimentDAO = reasignar.complimentDAO;
        initComponents();
        this.selectedIDCita = citaID;
        System.out.println(selectedIDCita + " AQUI ES EL POP UP");
        String jl1, jl2, jl3;
        boolean uwu= false;
        boolean unu = false;
        int cita = 0;
        int comp = 0;
        for (int i = 0; i < selectedIDCita; i++) {
                if (citasList.size() != 0 && cita < citasList.size()) {
                    if (citasList.get(cita).getId_cita() == selectedIDCita) {
                        id = cita;
                        uwu = true;
                        unu = true;
                    }
                }
                
                if(complimentList.size() != 0 && comp < complimentList.size()){
                    if(complimentList.get(comp).getId_cita() == selectedIDCita){
                        id = comp;
                        uwu = true;
                    }
                }
                

                System.out.println(uwu);
                if (uwu) {
                    i = selectedIDCita;
                } else {
                    if (citasList.size() != 0 && cita < citasList.size()) {
                        if (citasList.get(cita).getId_cita() == i + 1) {
                            cita++;
                        }
                    }
                    
                    if (complimentList.size() != 0 && comp < complimentList.size()) {
                        if (complimentList.get(comp).getId_cita() == i + 1) {
                            comp++;
                        }
                    }
                }
            }
        
        if(unu){
            jl1 = "Nombre: " + citasList.get(id).getUsuario().getNombre() + " " + citasList.get(id).getUsuario().getApellido();
            jl2 = "Motivo: " + citasList.get(id).getMotivo();
            jl3 = "Sucursal: " + citasList.get(id).getSucursal().getNombre_s();
        }else{
            jl1 = "Nombre: " + complimentList.get(id).getUsuario().getNombre() + " " + complimentList.get(id).getUsuario().getApellido();
            jl2 = "Motivo: " + complimentList.get(id).getMotivo();
            jl3 = "Sucursal: " + complimentList.get(id).getSucursal().getNombre_s();
        }
        jLabel1.setText(jl1);
        jLabel2.setText(jl2);
        jLabel3.setText(jl3);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        Jlabel4 = new javax.swing.JLabel();
        horaS = new javax.swing.JComboBox<>();
        fechaDC = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jButton2.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jButton2.setText("Agendar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel1.setText("Nombre: XXXXXXXX XXXXXXX");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel2.setText("Motivo:  XXXXXXXX XXXXXXX");

        jButton3.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jButton3.setText("Reasignar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Jlabel4.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        Jlabel4.setText("Hora");

        horaS.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        horaS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "09:00", "09:15", "09:30", "09:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45", "14:00", "14:15", "14:30", "14:45", "15:00" }));
        horaS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horaSActionPerformed(evt);
            }
        });

        fechaDC.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel5.setText("Fecha");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel3.setText("Sucursal:  XXXXXXXX XXXXXXX");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Jlabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(horaS, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fechaDC, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))))))
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(117, 117, 117))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechaDC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(horaS, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jlabel4))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void horaSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horaSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horaSActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ArrayList<Cita> citasList = (ArrayList<Cita>) citaDAO.obtener();
        ArrayList<Cita> complimentList = (ArrayList<Cita>) complimentDAO.obtener();
        int cita = 0;
        int comp = 0;
        boolean uwu = false;

        Date fecha = null;
        try {
            fecha = fechaDC.getDate();
            System.out.println(fecha.getTime());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ingrese una fecha valida.", "Fecha invalida", JOptionPane.INFORMATION_MESSAGE);
        }

        LocalDateTime fechaLocalTime = LocalDateTime.ofInstant(fecha.toInstant(), ZoneId.systemDefault());
        if (fechaLocalTime.isBefore(LocalDateTime.now())) {
            JOptionPane.showMessageDialog(this, "Ingrese una fecha valida no anterior a la fecha actual.", "Fecha invalida", JOptionPane.INFORMATION_MESSAGE);
        } else {
            for (int i = 0; i < selectedIDCita; i++) {
                System.out.println("cita:" + cita);
                System.out.println("compliment:" + comp);
                System.out.println("i:" + i);
                System.out.println("selectedIDCita:" + selectedIDCita);
                if (citasList.size() != 0 && cita < citasList.size()) {
                    if (citasList.get(cita).getId_cita() == selectedIDCita) {
                        Cita c = citasList.get(cita);

//                        if (fecha == null) {
//                            fecha = new Date(1900, 1, 1);
//                        }
                        DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
                        String fecha2 = f.format(fecha);
                        String hora = horaS.getSelectedItem().toString();
                        c.setFecha(LocalDate.parse(fecha2));
                        c.setHora(LocalTime.parse(hora));

                        System.out.println("----------------------------");
                        citaDAO.actualizar(c);
                        System.out.println(c.getUsuario());
                        citaDAO.actualizarEstado(c, "REASIGNADA");
                        System.out.println(c.getEstado());
                        uwu = true;
                        System.out.println(uwu);

                    }
                }
                if (complimentList.size() != 0 && comp < complimentList.size()) {
                    if (complimentList.get(comp).getId_cita() == selectedIDCita) {
                        Cita c = complimentList.get(comp);

//                        if (fecha == null) {
//                            fecha = new Date(1900, 1, 1);
//                        }
                        DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
                        String fecha2 = f.format(fecha);
                        String hora = horaS.getSelectedItem().toString();
                        c.setFecha(LocalDate.parse(fecha2));
                        c.setHora(LocalTime.parse(hora));
                        complimentDAO.actualizar(c);
                        complimentDAO.actualizarEstado(c, "REASIGNADA");
                        uwu = true;
                        System.out.println(uwu);
                    }
                }

                System.out.println(uwu);
                if (uwu) {
                    i = selectedIDCita;
                } else {
                    if (citasList.size() != 0 && cita < citasList.size()) {
                        if (citasList.get(cita).getId_cita() == i + 1) {
                            cita++;
                        }
                    }
                    if (complimentList.size() != 0 && comp < complimentList.size()) {
                        if (complimentList.get(comp).getId_cita() == i + 1) {
                            comp++;
                        }
                    }
                }
            }
        }
        citasList = (ArrayList<Cita>) citaDAO.obtener();
        complimentList = (ArrayList<Cita>) complimentDAO.obtener();
        reasignar.showUsersinTable();
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jlabel4;
    private com.toedter.calendar.JDateChooser fechaDC;
    private javax.swing.JComboBox<String> horaS;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
