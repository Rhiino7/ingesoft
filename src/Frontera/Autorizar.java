package Frontera;

import DAO.CitaDAO;
import DAO.ComplimentDAO;
import Entidad.Cita;
import Entidad.Usuario;
import java.awt.event.ActionEvent;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.*;

public class Autorizar extends javax.swing.JPanel {

    CitaDAO citaDAO = new CitaDAO();
    ComplimentDAO complimentDAO = new ComplimentDAO();

    int selectedIDCita = 0;

    public Autorizar() {
        initComponents();
        showUsersinTable();
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

        /*
        DefaultTableModel tModel = (DefaultTableModel) jTable1.getModel();

        Object[] fila = new Object[8];

        for (int i = 0; i < citasList.size(); i++)
        {
            fila[0] = citasList.get(i).getUsuario().getNombre();            //Columna Nombre
            fila[1] = citasList.get(i).getUsuario().getApellido();          //Columna Apellido
            fila[2] = citasList.get(i).getUsuario().getIdentificacion();    //Columna Identificacion
            fila[3] = citasList.get(i).getFecha();                          //Columna Fecha
            fila[4] = citasList.get(i).getHora();                           //Columna Hora
            fila[5] = citasList.get(i).getSucursal();                       //Columna Lugar
            fila[6] = null;                                                 //Hace falta meter la columna de Motivo
            fila[7] = citasList.get(i).getEstado();                         //Columna Estado

            tModel.addRow(fila);
        }
         */
    }

    public void filtrarTable(String search) {
        DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }

    public void searchInTable() {

        DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
        SimpleDateFormat hourToString = new SimpleDateFormat("HH:mm");
        SimpleDateFormat dateToString = new SimpleDateFormat("yyyy-MM-dd");
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        jTable1.setRowSorter(tr);

//        String textDate = dateToString.format(jDateChooser1.getDate());
//        String textHour = hourToString.format(jSpinner1.getValue());
        String textID = identificacionTextField.getText();

        tr.setRowFilter(RowFilter.regexFilter(textID));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        Date date = new Date();
        SpinnerDateModel sm =
        new SpinnerDateModel (date, null, null, Calendar.HOUR_OF_DAY);
        jSpinner1 = new javax.swing.JSpinner(sm);
        aprobarB = new javax.swing.JButton();
        rechazarB = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        efectuadaB = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(650, 500));

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel1.setText("Citas:");

        jTable1.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "Identificación", "Fecha", "Hora", "Lugar", "Motivo", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
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

        jCheckBox1.setText("Sin aprobar");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel3.setText("Identificación");

        identificacionTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                identificacionTextFieldKeyReleased(evt);
            }
        });

        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel5.setText("Fecha");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel6.setText("Hora");

        JSpinner.DateEditor de = new JSpinner.DateEditor(jSpinner1, "HH:mm");
        jSpinner1.setEditor(de);
        jSpinner1.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jSpinner1.setMinimumSize(new java.awt.Dimension(30, 30));
        jSpinner1.setPreferredSize(new java.awt.Dimension(31, 30));

        aprobarB.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        aprobarB.setText("Aprobar");
        aprobarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aprobarBActionPerformed(evt);
            }
        });

        rechazarB.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        rechazarB.setText("Rechazar");
        rechazarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechazarBActionPerformed(evt);
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

        efectuadaB.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        efectuadaB.setText("Efectuada");
        efectuadaB.setToolTipText("Cambia el estado de la cita a efectuada/realiozada con exito");
        efectuadaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                efectuadaBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(efectuadaB, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aprobarB, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rechazarB, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(identificacionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jCheckBox1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100)))))
                .addContainerGap(85, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(identificacionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aprobarB)
                    .addComponent(efectuadaB)
                    .addComponent(rechazarB))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void efectuadaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_efectuadaBActionPerformed
        ArrayList<Cita> citasList = (ArrayList<Cita>) citaDAO.obtener();
        ArrayList<Cita> complimentList = (ArrayList<Cita>) complimentDAO.obtener();
        int cita = 0;
        int comp = 0;
        boolean uwu = false;
        for (int i = 0; i < selectedIDCita; i++) {
            System.out.println("cita:" + cita);
            System.out.println("compliment:" + comp);
            System.out.println("i:" + i);
            System.out.println("selectedIDCita:" + selectedIDCita);
            if (citasList.size() != 0 && cita < citasList.size()) {
                if (citasList.get(cita).getId_cita() == selectedIDCita) {
                    Cita c = citasList.get(cita);
                    citaDAO.actualizarEstado(c, "CUMPLIDA");
                    citasList = (ArrayList<Cita>) citaDAO.obtener();
                    complimentList = (ArrayList<Cita>) complimentDAO.obtener();
                    uwu = true;
                    System.out.println(uwu);
                }
            }
            if (complimentList.size() != 0 && comp < complimentList.size()) {
                if (complimentList.get(comp).getId_cita() == selectedIDCita) {
                    Cita c = complimentList.get(comp);
                    complimentDAO.actualizarEstado(c, "CUMPLIDA");
                    uwu = true;
                    System.out.println(uwu);
                }
            }

            System.out.println(uwu);
            if (uwu) {
                i = selectedIDCita;
            } else {
                if (citasList.get(cita).getId_cita() == i + 1) {
                    cita++;
                } else {
                    comp++;
                }
            }
        }
        try {
            //Ponemos a "Dormir" el programa durante los ms que queremos
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }
        citasList = (ArrayList<Cita>) citaDAO.obtener();
        complimentList = (ArrayList<Cita>) complimentDAO.obtener();
        showUsersinTable();
    }//GEN-LAST:event_efectuadaBActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void aprobarBActionPerformed(java.awt.event.ActionEvent evt) {
        ArrayList<Cita> citasList = (ArrayList<Cita>) citaDAO.obtener();
        ArrayList<Cita> complimentList = (ArrayList<Cita>) complimentDAO.obtener();
        int cita = 0;
        int comp = 0;
        boolean uwu = false;
        for (int i = 0; i < selectedIDCita; i++) {
            System.out.println("cita:" + cita);
            System.out.println("compliment:" + comp);
            System.out.println("i:" + i);
            System.out.println("selectedIDCita:" + selectedIDCita);
            if (citasList.size() != 0 && cita < citasList.size()) {
                if (citasList.get(cita).getId_cita() == selectedIDCita) {
                    Cita c = citasList.get(cita);
                    citaDAO.actualizarEstado(c, "APROBADA");
                    uwu = true;
                    System.out.println(uwu);
                    
                }
            }
            if (complimentList.size() != 0 && comp < complimentList.size()) {
                if (complimentList.get(comp).getId_cita() == selectedIDCita) {
                    Cita c = complimentList.get(comp);
                    complimentDAO.actualizarEstado(c, "APROBADA");
                    uwu = true;
                    System.out.println(uwu);
                }
            }

            System.out.println(uwu);
            if (uwu) {
                i = selectedIDCita;
            } else {
                if (citasList.get(cita).getId_cita() == i + 1) {
                    cita++;
                } else {
                    comp++;
                }
            }
        }
        try {
            //Ponemos a "Dormir" el programa durante los ms que queremos
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }
        citasList = (ArrayList<Cita>) citaDAO.obtener();
        complimentList = (ArrayList<Cita>) complimentDAO.obtener();
        showUsersinTable();
    }

    private void rechazarBActionPerformed(java.awt.event.ActionEvent evt) {
        ArrayList<Cita> citasList = (ArrayList<Cita>) citaDAO.obtener();
        ArrayList<Cita> complimentList = (ArrayList<Cita>) complimentDAO.obtener();
        int cita = 0;
        int comp = 0;
        boolean uwu = false;
        for (int i = 0; i < selectedIDCita; i++) {
            System.out.println("cita:" + cita);
            System.out.println("compliment:" + comp);
            System.out.println("i:" + i);
            System.out.println("selectedIDCita:" + selectedIDCita);
            if (citasList.size() != 0 && cita < citasList.size()) {
                if (citasList.get(cita).getId_cita() == selectedIDCita) {
                    Cita c = citasList.get(cita);
                    citaDAO.actualizarEstado(c, "RECHAZADA");
                    uwu = true;
                    System.out.println(uwu);
                }
            }
            if (complimentList.size() != 0 && comp < complimentList.size()) {
                if (complimentList.get(comp).getId_cita() == selectedIDCita) {
                    Cita c = complimentList.get(comp);
                    complimentDAO.actualizarEstado(c, "RECHAZADA");
                    uwu = true;
                    System.out.println(uwu);
                }
            }

            System.out.println(uwu);
            if (uwu) {
                i = selectedIDCita;
            } else {
                if (citasList.get(cita).getId_cita() == i + 1) {
                    cita++;
                } else {
                    comp++;
                }
            }
        }
        try {
            //Ponemos a "Dormir" el programa durante los ms que queremos
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }
        citasList = (ArrayList<Cita>) citaDAO.obtener();
        complimentList = (ArrayList<Cita>) complimentDAO.obtener();
        showUsersinTable();
    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = jTable1.getSelectedRow();
        String idCitaTabla = jTable1.getValueAt(selectedRow, 0).toString();
        selectedIDCita = Integer.parseInt(idCitaTabla);
        System.out.println(selectedIDCita);
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {
        String search = jTextField1.getText();
        filtrarTable(search);
    }

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        searchInTable();
    }

    public void identificacionTextFieldKeyReleased(java.awt.event.KeyEvent evt) {

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aprobarB;
    private javax.swing.JButton efectuadaB;
    private javax.swing.JTextField identificacionTextField;
    private javax.swing.JCheckBox jCheckBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton rechazarB;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables
}
