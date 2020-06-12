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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
        System.out.println(usuario.toString());
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
        jButton2 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel1.setText("Sus citas:");

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton2.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jButton2.setText("Cancelar Cita");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                        .addComponent(jLabel1)
                        .addGap(0, 569, Short.MAX_VALUE)))
                .addGap(8, 8, 8))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(252, 252, 252))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
