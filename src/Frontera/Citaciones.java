/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontera;

import Entidad.Cita;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import DAO.CitaDAO;
import DAO.ComplimentDAO;
import DAO.UsuarioDAO;
import Entidad.Usuario;
import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author cdgn2
 */
public class Citaciones extends javax.swing.JPanel {

    CitaDAO citaDAO = new CitaDAO();
    ComplimentDAO complimentDAO = new ComplimentDAO();
    UsuarioDAO udao = new UsuarioDAO();
    private Usuario usuario;
    int selectedIDCita;
    //CancelarPopUp cancel = new CancelarPopUp();

    public void showUsersinTable() {

        List<Usuario> usuarios = udao.obtener();
        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(usuario.getUsuario())) { //No deberian haber dos nombres de usuario iguales
                usuario = u;
                break;
            }
        }

        ArrayList<Cita> citasList = (ArrayList<Cita>) citaDAO.obtener();

        int citas = 0;
        int j = 0;
        for (int i = 0; i < citasList.size(); i++) {
            if (citasList.get(i).getUsuario().getIdentificacion() == this.usuario.getIdentificacion()) {
                citas++;
            }
        }

        Object[][] citasMatrix = new Object[citas][6];

        String estado = "none";
        String motivo = "otro";

        for (int i = 0; i < citasList.size(); i++) {
            System.out.println("i: " + i);
            if (citasList.get(i).getUsuario().getIdentificacion() == this.usuario.getIdentificacion()) {
                System.out.println("cita que compara: " + citasList.get(i).getId_cita());
                if (citasList.get(i).getEstado() == 0) {
                    estado = "Pendiente";
                } else if (citasList.get(i).getEstado() == 1) {
                    estado = "Aprobada";
                } else if (citasList.get(i).getEstado() == 2) {
                    estado = "Cancelada";
                } else if (citasList.get(i).getEstado() == 3) {
                    estado = "Rechazada";
                } else if (citasList.get(i).getEstado() == 4) {
                    estado = "Cumplida";
                }else if (citasList.get(i).getEstado() == 6){
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
                if (citasList.get(i).getMotivo() == 0) {
                    motivo = "Creacion cuenta bancaria";
                } else if (citasList.get(i).getMotivo() == 1) {
                    motivo = "Creditos de vivienda";
                } else if (citasList.get(i).getMotivo() == 2) {
                    motivo = "Cambio o perdida de tarjeta";
                } else if (citasList.get(i).getMotivo() == 3) {
                    motivo = "Creditos de Negocio";
                } else if (citasList.get(i).getMotivo() == 4) {
                    motivo = "Inversiones";
                } else if (citasList.get(i).getMotivo() == 5) {
                    motivo = "Seguros";
                } else if (citasList.get(i).getMotivo() == 6) {
                    motivo = "Productos Complementarios";
                } else if (citasList.get(i).getMotivo() == 7) {
                    motivo = "Asesoria";
                } else {
                    motivo = "otro";
                }
                
                System.out.println(citasList.get(i).toString());
                
                citasMatrix[j][0] = citasList.get(i).getId_cita();
                citasMatrix[j][1] = citasList.get(i).getFecha();
                citasMatrix[j][2] = citasList.get(i).getHora();
                citasMatrix[j][3] = citasList.get(i).getSucursal().getLugar_s();
                citasMatrix[j][4] = motivo;
                citasMatrix[j][5] = estado;
                j++;

            }

        }

        jTable1.setModel(
                new DefaultTableModel(
                        citasMatrix,
                        new Object[]{
                            "ID", "Fecha", "Hora", "Lugar", "Motivo", "Estado"
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

    /**
     * Creates new form Citaciones
     */
    public Citaciones(Usuario u) {
        initComponents();
        this.usuario = u;
        showUsersinTable();
        
        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        jTable1.getTableHeader().setBackground(Color.white);
        jTable1.getTableHeader().setOpaque(false);
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        LookAndFeel previousLF = UIManager.getLookAndFeel();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        try{
            UIManager.setLookAndFeel(previousLF);
        } catch (Exception e) {}
        jButton2 = new javax.swing.JButton();

        setRequestFocusEnabled(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setText("Sus citas:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        try{
            UIManager.setLookAndFeel(previousLF);
        } catch (Exception e) {}
        jTable1.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Hora", "Lugar", "Motivo", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(25);
        jTable1.setRowMargin(0);
        jTable1.setSelectionBackground(new java.awt.Color(116, 79, 198));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jButton2.setBackground(new java.awt.Color(9, 12, 2));
        jButton2.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cancelar cita");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setFocusPainted(false);
        jButton2.setPreferredSize(new java.awt.Dimension(150, 50));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ArrayList<Cita> citasList = (ArrayList<Cita>) citaDAO.obtener();

        int cita = 0;
        boolean uwu = false;
        boolean tiempo = false;
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate fecha;
        fecha = LocalDate.now();
        fecha = fecha.plusDays(1);
        
            for (int i = 0; i < selectedIDCita; i++) {
                if (citasList.size() != 0 && cita < citasList.size()) {
                    if (citasList.get(cita).getId_cita() == selectedIDCita) {
                        Cita c = citasList.get(cita);
                        if(c.getFecha().compareTo(fecha)>0){
                            citaDAO.actualizarEstado(c, "CANCELADA");
                            uwu = true;
                        }else{
                            JOptionPane.showMessageDialog(jTable1, "Usted solo puede cancelar una cita con un dia de anticipacion", "Cancelacion no efectuada", JOptionPane.ERROR_MESSAGE);
                            System.out.println("esto solo se deberia imprimir una vez?");
                            uwu=true;
                        }
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
                }
            }
            try {
                //Ponemos a "Dormir" el programa durante los ms que queremos
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
            citasList = (ArrayList<Cita>) citaDAO.obtener();
            showUsersinTable();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        String idCitaTabla = jTable1.getValueAt(selectedRow, 0).toString();
        selectedIDCita = Integer.parseInt(idCitaTabla);
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
