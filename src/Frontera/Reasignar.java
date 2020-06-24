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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SpinnerDateModel;
import javax.swing.JSpinner;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author cdgn2
 */
public class Reasignar extends javax.swing.JPanel {

    public CitaDAO citaDAO = new CitaDAO();
    public ComplimentDAO complimentDAO = new ComplimentDAO();

    int selectedIDCita = 0;
    
    /**
     * Creates new form Citaciones
     */
    public Reasignar() {
        initComponents();
        showUsersinTable();
    }
    
    public void filtrarTable(String search) {
        DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }

    public void searchInTable() {
        RowFilter<TableModel, Object> idFilter = RowFilter.regexFilter("", 3);
        if (!identificacionTextField.getText().equals("")) {
            idFilter = RowFilter.regexFilter(identificacionTextField.getText(), 3);
        }

        RowFilter<TableModel, Object> fechaFilter = RowFilter.regexFilter("", 4);
        DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        if (jDateChooser1.getDate() != null) {
            fechaFilter = RowFilter.regexFilter(f.format(jDateChooser1.getDate()), 4);
        }

        RowFilter<TableModel, Object> horaFilter = RowFilter.regexFilter("", 5);
        if (!horaS.getSelectedItem().toString().equals(" ")) {
            horaFilter = RowFilter.regexFilter(horaS.getSelectedItem().toString(), 5);
        }

        RowFilter<TableModel, Object> aprobadaFilter = RowFilter.regexFilter("", 8);
        if (jCheckBox1.isSelected()) {
            aprobadaFilter = RowFilter.regexFilter("[^(Reasignada)]", 8);
        }

        List<RowFilter<TableModel, Object>> filters = new ArrayList<RowFilter<TableModel, Object>>();

        filters.add(idFilter);
        filters.add(fechaFilter);
        filters.add(horaFilter);
        filters.add(aprobadaFilter);

        RowFilter<TableModel, Object> compoundRowFilter = RowFilter.andFilter(filters);

        DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);

        tr.setRowFilter(compoundRowFilter);

        jTable1.setRowSorter(tr);
    }
    
    public void showUsersinTable() {

        ArrayList<Cita> citasList = (ArrayList<Cita>) citaDAO.obtener();
        ArrayList<Cita> complimentList = (ArrayList<Cita>) complimentDAO.obtener();
        Object[][] citasMatrix = new Object[citasList.size() + complimentList.size()][9];

        int cita = 0;
        int comp = 0;
        String estado = "none";
        String motivo = "otro";
        System.out.println(citasList.size() + " + " + complimentList.size() + " = " + (citasList.size() + complimentList.size()));

        for (int i = 0; i < citasList.size() + complimentList.size(); i++) {
            System.out.println("i: " + i);
            System.out.println("cita: " + cita);
            System.out.println("comp: " + comp);
            if (cita < citasList.size()) {
                if (citasList.get(cita).getId_cita() == i + 1) {
                    System.out.println("cita que compara: " + citasList.get(cita).getId_cita());
                    if (citasList.get(cita).getEstado() == 0) {
                        estado = "Pendiente";
                    } else if (citasList.get(cita).getEstado() == 1) {
                        estado = "Aprobada";
                    } else if (citasList.get(cita).getEstado() == 2) {
                        estado = "Cancelada";
                    } else if (citasList.get(cita).getEstado() == 3) {
                        estado = "Rechazada";
                    } else if (citasList.get(cita).getEstado() == 4) {
                        estado = "Cumplida";
                    }else if (citasList.get(cita).getEstado() == 5){
                        estado = "No cumplida";
                    }else if (citasList.get(cita).getEstado() == 6){
                        estado = "Reasignada";
                    }

                    //motivo
                    /*
            0.Creacion cuenta bancaria
            1.creditos de vivienda
            2.Cambio o perdida de tarjeta
            3.Creditos de Negocio
            4.Inversiones
            5.Seguros
            6.Productos Complementarios
            7.Asesoria
            8.Otros*/
                    if (citasList.get(cita).getMotivo() == 0) {
                        motivo = "Creacion cuenta bancaria";
                    } else if (citasList.get(cita).getMotivo() == 1) {
                        motivo = "Creditos de vivienda";
                    } else if (citasList.get(cita).getMotivo() == 2) {
                        motivo = "Cambio o perdida de tarjeta";
                    } else if (citasList.get(cita).getMotivo() == 3) {
                        motivo = "Creditos de Negocio";
                    } else if (citasList.get(cita).getMotivo() == 4) {
                        motivo = "Inversiones";
                    } else if (citasList.get(cita).getMotivo() == 5) {
                        motivo = "Seguros";
                    } else if (citasList.get(cita).getMotivo() == 6) {
                        motivo = "Productos Complementarios";
                    } else if (citasList.get(cita).getMotivo() == 7) {
                        motivo = "Asesoria";
                    } else {
                        motivo = "otro";
                    }

                    citasMatrix[i][0] = citasList.get(cita).getId_cita();
                    citasMatrix[i][1] = citasList.get(cita).getUsuario().getNombre();
                    citasMatrix[i][2] = citasList.get(cita).getUsuario().getApellido();
                    citasMatrix[i][3] = citasList.get(cita).getUsuario().getIdentificacion();
                    citasMatrix[i][4] = citasList.get(cita).getFecha();
                    citasMatrix[i][5] = citasList.get(cita).getHora();
                    citasMatrix[i][6] = citasList.get(cita).getSucursal().getLugar_s();
                    citasMatrix[i][7] = motivo;
                    citasMatrix[i][8] = estado;

                    cita++;
                }
            }
            if (comp < complimentList.size()) {
                if (complimentList.get(comp).getId_cita() == i + 1) {
                    System.out.println("comp que compara: " + complimentList.get(comp).getId_cita());
                    if (complimentList.get(comp).getEstado() == 0) {
                        estado = "Pendiente";
                    } else if (complimentList.get(comp).getEstado() == 1) {
                        estado = "Aprobada";
                    } else if (complimentList.get(comp).getEstado() == 2) {
                        estado = "Cancelada";
                    } else if (complimentList.get(comp).getEstado() == 3) {
                        estado = "Rechazada";
                    } else if (complimentList.get(comp).getEstado() == 4) {
                        estado = "Cumplida";
                    }else if (complimentList.get(comp).getEstado() == 5) {
                        estado = "No cumplida";
                    }else if (complimentList.get(cita).getEstado() == 6){
                        estado = "Reasignada";
                    }

                    //motivo
                    /*
            0.Creacion cuenta bancaria
            1.creditos de vivienda
            2.Cambio o perdida de tarjeta
            3.Creditos de Negocio
            4.Inversiones
            5.Seguros
            6.Productos Complementarios
            7.Asesoria
            8.Otros*/
                    if (complimentList.get(comp).getMotivo() == 0) {
                        motivo = "Creacion cuenta bancaria";
                    } else if (complimentList.get(comp).getMotivo() == 1) {
                        motivo = "Creditos de vivienda";
                    } else if (complimentList.get(comp).getMotivo() == 2) {
                        motivo = "Cambio o perdida de tarjeta";
                    } else if (complimentList.get(comp).getMotivo() == 3) {
                        motivo = "Creditos de Negocio";
                    } else if (complimentList.get(comp).getMotivo() == 4) {
                        motivo = "Inversiones";
                    } else if (complimentList.get(comp).getMotivo() == 5) {
                        motivo = "Seguros";
                    } else if (complimentList.get(comp).getMotivo() == 6) {
                        motivo = "Productos Complementarios";
                    } else if (complimentList.get(comp).getMotivo() == 7) {
                        motivo = "Asesoria";
                    } else {
                        motivo = "otro";
                    }

                    citasMatrix[i][0] = complimentList.get(comp).getId_cita();
                    citasMatrix[i][1] = complimentList.get(comp).getUsuario().getNombre();
                    citasMatrix[i][2] = complimentList.get(comp).getUsuario().getApellido();
                    citasMatrix[i][3] = complimentList.get(comp).getUsuario().getIdentificacion();
                    citasMatrix[i][4] = complimentList.get(comp).getFecha();
                    citasMatrix[i][5] = complimentList.get(comp).getHora();
                    citasMatrix[i][6] = complimentList.get(comp).getSucursal().getLugar_s();
                    citasMatrix[i][7] = motivo;
                    citasMatrix[i][8] = estado;
                    comp++;
                }
            }

        }
        
        jTable1.setModel(
                new DefaultTableModel(
                        citasMatrix,
                        new Object[]{
                            "ID Cita", "Nombre", "Apellido", "Identificación", "Fecha", "Hora", "Lugar", "Motivo", "Estado"
                        }
                ));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        identificacionTextField = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ReasignarB = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        horaS = new javax.swing.JComboBox<>();

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel4.setText("Identificacion");

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel1.setText("Reasignaciones");

        jTable1.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Identificación", "Fecha", "Hora", "lugar", "Motivo", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel2.setText("Filtrar Por:");

        jCheckBox1.setText("Sin reasignar");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel3.setText("Identificacion");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel5.setText("Fecha");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel6.setText("Hora");

        ReasignarB.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        ReasignarB.setText("Reasignar");
        ReasignarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReasignarBActionPerformed(evt);
            }
        });

        searchButton.setText("Filtrar");
        searchButton.setMaximumSize(new java.awt.Dimension(61, 30));
        searchButton.setMinimumSize(new java.awt.Dimension(61, 30));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel7.setText("Buscar");

        horaS.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        horaS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "09:00", "09:15", "09:30", "09:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45", "14:00", "14:15", "14:30", "14:45", "15:00" }));
        horaS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horaSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(horaS, 0, 222, Short.MAX_VALUE)
                            .addComponent(identificacionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addGap(18, 18, 18)
                                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(173, 173, 173)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(257, 257, 257)
                                .addComponent(ReasignarB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(identificacionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(horaS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCheckBox1)
                                .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(ReasignarB)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void ReasignarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReasignarBActionPerformed
        // TODO add your handling code here:
        if(selectedIDCita == 0){
            JOptionPane.showMessageDialog(this, "Seleccione una cita de la tabla.", "Ninguna cita fue seleccionada", JOptionPane.INFORMATION_MESSAGE);
        }
        ReasignarPopUpAdmin pop = new ReasignarPopUpAdmin(selectedIDCita, this);
        pop.setVisible(true);
    }//GEN-LAST:event_ReasignarBActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        searchInTable();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        String search = jTextField1.getText();
        filtrarTable(search);
    }//GEN-LAST:event_jTextField1KeyReleased

    private void horaSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horaSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horaSActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        String idCitaTabla = jTable1.getValueAt(selectedRow, 0).toString();
        selectedIDCita = Integer.parseInt(idCitaTabla);
        System.out.println(selectedIDCita);
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ReasignarB;
    private javax.swing.JComboBox<String> horaS;
    private javax.swing.JTextField identificacionTextField;
    private javax.swing.JCheckBox jCheckBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables
}
