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
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

public class Autorizar extends javax.swing.JPanel {

    CitaDAO citaDAO = new CitaDAO();
    ComplimentDAO complimentDAO = new ComplimentDAO();
    
    private LookAndFeel previousLF;

    int selectedIDCita = 0;

    public Autorizar() {
        previousLF = UIManager.getLookAndFeel();
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
            aprobadaFilter = RowFilter.regexFilter("[^(Aprobada)]", 8);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}
        jCheckBox1 = new javax.swing.JCheckBox();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}
        horaS = new javax.swing.JComboBox<>();
        identificacionTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        try {
            UIManager.setLookAndFeel(previousLF);
        } catch (Exception e) {}
        searchButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        try {
            UIManager.setLookAndFeel(previousLF);
        } catch (Exception e) {}
        noEfectuadaB = new javax.swing.JButton();
        try {
            UIManager.setLookAndFeel(previousLF);
        } catch (Exception e) {}
        rechazarB = new javax.swing.JButton();
        efectuadaB = new javax.swing.JButton();
        aprobarB = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(650, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Citas");

        try {
            UIManager.setLookAndFeel(previousLF);
        } catch (Exception e) {}
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
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
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setMaximumSize(new java.awt.Dimension(2147483647, 400));
        jTable1.setMinimumSize(new java.awt.Dimension(120, 400));
        jTable1.setOpaque(false);
        jTable1.setPreferredSize(new java.awt.Dimension(600, 400));
        jTable1.setRowHeight(25);
        jTable1.setRowMargin(0);
        jTable1.setSelectionBackground(new java.awt.Color(116, 79, 198));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Buscar");

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

        jPanel5.setLayout(new java.awt.GridBagLayout());

        try {
            UIManager.setLookAndFeel(previousLF);
        } catch (Exception e) {}
        jCheckBox1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jCheckBox1.setText("Sin aprobar");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        try {
            UIManager.setLookAndFeel(previousLF);
        } catch (Exception e) {}
        horaS.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        horaS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "09:00", "09:15", "09:30", "09:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45", "14:00", "14:15", "14:30", "14:45", "15:00" }));
        horaS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horaSActionPerformed(evt);
            }
        });

        identificacionTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                identificacionTextFieldKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Hora");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Identificación");

        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Fecha");

        searchButton.setBackground(new java.awt.Color(9, 12, 2));
        searchButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Filtrar");
        searchButton.setMaximumSize(new java.awt.Dimension(61, 30));
        searchButton.setMinimumSize(new java.awt.Dimension(61, 30));
        searchButton.setPreferredSize(new java.awt.Dimension(73, 39));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(identificacionTextField)
                            .addComponent(horaS, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jCheckBox1)
                        .addGap(33, 33, 33)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(identificacionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(horaS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.add(jPanel4, new java.awt.GridBagConstraints());

        jPanel6.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        noEfectuadaB.setBackground(new java.awt.Color(9, 12, 2));
        noEfectuadaB.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        noEfectuadaB.setForeground(new java.awt.Color(255, 255, 255));
        noEfectuadaB.setText("No Efectuada");
        noEfectuadaB.setToolTipText("Cambia el estado de la cita a efectuada/realiozada con exito");
        noEfectuadaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noEfectuadaBActionPerformed(evt);
            }
        });
        jPanel6.add(noEfectuadaB);

        rechazarB.setBackground(new java.awt.Color(9, 12, 2));
        rechazarB.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rechazarB.setForeground(new java.awt.Color(255, 255, 255));
        rechazarB.setText("Rechazar");
        rechazarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechazarBActionPerformed(evt);
            }
        });
        jPanel6.add(rechazarB);

        efectuadaB.setBackground(new java.awt.Color(9, 12, 2));
        efectuadaB.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        efectuadaB.setForeground(new java.awt.Color(255, 255, 255));
        efectuadaB.setText("Efectuada");
        efectuadaB.setToolTipText("Cambia el estado de la cita a efectuada/realiozada con exito");
        efectuadaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                efectuadaBActionPerformed(evt);
            }
        });
        jPanel6.add(efectuadaB);

        aprobarB.setBackground(new java.awt.Color(9, 12, 2));
        aprobarB.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        aprobarB.setForeground(new java.awt.Color(255, 255, 255));
        aprobarB.setText("Aprobar");
        aprobarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aprobarBActionPerformed(evt);
            }
        });
        jPanel6.add(aprobarB);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1)
                        .addContainerGap())
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel3.add(jPanel2, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void noEfectuadaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noEfectuadaBActionPerformed
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
                    citaDAO.actualizarEstado(c, "NO CUMPLIDA");
                    citasList = (ArrayList<Cita>) citaDAO.obtener();
                    complimentList = (ArrayList<Cita>) complimentDAO.obtener();
                    uwu = true;
                    System.out.println(uwu);
                }
            }
            if (complimentList.size() != 0 && comp < complimentList.size()) {
                if (complimentList.get(comp).getId_cita() == selectedIDCita) {
                    Cita c = complimentList.get(comp);
                    complimentDAO.actualizarEstado(c, "NO CUMPLIDA");
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
        citasList = (ArrayList<Cita>) citaDAO.obtener();
        complimentList = (ArrayList<Cita>) complimentDAO.obtener();
        showUsersinTable();
    }//GEN-LAST:event_noEfectuadaBActionPerformed

    private void horaSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horaSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horaSActionPerformed

    private void efectuadaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_efectuadaBActionPerformed
        // TODO add your handling code here:
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
    private javax.swing.JComboBox<String> horaS;
    private javax.swing.JTextField identificacionTextField;
    private javax.swing.JCheckBox jCheckBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton noEfectuadaB;
    private javax.swing.JButton rechazarB;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables
}
