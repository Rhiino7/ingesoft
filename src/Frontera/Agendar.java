package Frontera;

import Control.ValidarSolicitarCita;
import DAO.CitaDAO;
import DAO.SucursalDAO;
import DAO.UsuarioDAO;
import Entidad.Cita;
import Entidad.Sucursal;
import Entidad.Usuario;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.SpinnerDateModel;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;

public class Agendar extends javax.swing.JPanel {

    private Usuario usuario; //Se meteria en el constructor de Agendar y de FrameUsuario para poder asignarlo en cita
    private SucursalDAO sdao = new SucursalDAO();
    private UsuarioDAO udao = new UsuarioDAO();
    private CitaDAO cdao = new CitaDAO();
    private ArrayList<Cita> citasList = (ArrayList<Cita>) cdao.obtener();
    private LookAndFeel previousLF;

    public Agendar(Usuario usuario) {
        previousLF = UIManager.getLookAndFeel();
        initComponents();
        dateSet();
        this.usuario = usuario;
        System.out.println(usuario);
        List<Sucursal> sucursales = sdao.obtener();
        for (Sucursal s : sucursales) {
            sucursalCB.addItem(s.getLugar_s());
        }
    }

    public void dateSet(){
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate fecha;
        fecha = LocalDate.now();
        fecha = fecha.plusDays(1);
        Date date = Date.from(fecha.atStartOfDay(defaultZoneId).toInstant());
        fechaDC.getJCalendar().setMinSelectableDate(date);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        agendarB = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}
        sucursalCB = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}
        horaS = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        motivoCB = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        fechaDC = new com.toedter.calendar.JDateChooser();

        jButton1.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel5.setText(" Agendar una cita");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        agendarB.setBackground(new java.awt.Color(9, 12, 2));
        agendarB.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        agendarB.setForeground(new java.awt.Color(255, 255, 255));
        agendarB.setText("Agendar");
        agendarB.setBorder(null);
        agendarB.setFocusable(false);
        agendarB.setPreferredSize(new java.awt.Dimension(120, 50));
        agendarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendarBActionPerformed(evt);
            }
        });
        jPanel4.add(agendarB, new java.awt.GridBagConstraints());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel5.setPreferredSize(new java.awt.Dimension(500, 224));

        try {
            UIManager.setLookAndFeel(previousLF);
        } catch (Exception e) {}
        sucursalCB.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        sucursalCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sucursalCBActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Sucursal");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Fecha");

        try{
            UIManager.setLookAndFeel(previousLF);
        } catch (Exception e) {}
        horaS.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        horaS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "09:00", "09:15", "09:30", "09:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45", "14:00", "14:15", "14:30", "14:45", "15:00" }));
        horaS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horaSActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Hora");

        motivoCB.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        motivoCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Creacion cuenta bancaria", "creditos de vivienda", "Cambio o perdida de tarjeta","Creditos de Negocio","Inversiones","Seguros","Productos Complementarios","Asesoria", "Otros" }));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Motivo");

        fechaDC.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(horaS, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addComponent(sucursalCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(motivoCB, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(fechaDC, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(horaS, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaDC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sucursalCB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(motivoCB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 10, 40, 10);
        jPanel1.add(jPanel5, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(573, 573, 573)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void agendarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendarBActionPerformed

        //long id_usuario = ;
        String nombre_sucursal = (String) sucursalCB.getSelectedItem();
        Date fecha = fechaDC.getDate();
        if (fecha == null) {
            fecha = new Date(1900, 1, 1);
        }
        DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String fecha2 = f.format(fecha);
        String hora = horaS.getSelectedItem().toString();
        ValidarSolicitarCita validarSolicitudCita = new ValidarSolicitarCita();

        //Conseguir cual Sucursal es
        List<Sucursal> sucursales = sdao.obtener();
        Sucursal sucursal = new Sucursal();
        for (Sucursal s : sucursales) {
            if (s.getLugar_s().equals(nombre_sucursal)) {
                sucursal = s;
                break;
            }
        }

        //Conseguir cual Usuario es
        List<Usuario> usuarios = udao.obtener();
        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(usuario.getUsuario())) { //No deberian haber dos nombres de usuario iguales
                usuario = u;
                break;
            }
        }

        //Se crea la cita
        //Cita cita = new Cita(citasList.size() + 1, sucursal, usuario, LocalDate.parse(fecha2), LocalTime.parse(hora), 0);
        Cita cita = new Cita(citasList.size() + 1, sucursal, usuario, LocalDate.parse(fecha2), LocalTime.parse(hora),motivoCB.getSelectedIndex(),0);

        System.out.println(cita);

        //System.out.println("" + nombre_sucursal + fecha2 +  hora);
        //hacer que perdure en cita(entidad)
        //llaves primarias
//        AgendarPopUp dialog = new AgendarPopUp(new javax.swing.JFrame(), true);
//
//        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//            @Override
//            public void windowClosing(java.awt.event.WindowEvent e) {
//                //System.exit(0);
//            }
//        });
//        dialog.setVisible(true);
        switch (validarSolicitudCita.verificarSolicitarCita(cita)) {
            case 0:
//                System.out.println("Cita registrada exitosamente");
//                System.out.println(fecha2);
//                System.out.println(cita.toString());
                cdao.registrar(cita);
                JOptionPane.showMessageDialog(agendarB, "Registro Exitoso", "Registro", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 1:
                System.out.println("Error 1");
                break;
            case 2:
                System.out.println("Error 2");
                break;
            case 3:
                JOptionPane.showMessageDialog(agendarB, "Fecha nula", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            case 4:
                JOptionPane.showMessageDialog(agendarB, "Fecha anterior a la actual", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            case 5:
                JOptionPane.showMessageDialog(agendarB, "Ya existe una cita en esa sucursal, fecha y hora", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            case 6:
                JOptionPane.showMessageDialog(agendarB, "Usted ya tiene una cita en esta sucursal", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            case 7:
                JOptionPane.showMessageDialog(agendarB, "Usted ya tiene una cita programada o en espera de aprobacion", "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }//GEN-LAST:event_agendarBActionPerformed

    private void horaSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horaSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horaSActionPerformed

    private void sucursalCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sucursalCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sucursalCBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agendarB;
    private com.toedter.calendar.JDateChooser fechaDC;
    private javax.swing.JComboBox<String> horaS;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JComboBox<String> motivoCB;
    private javax.swing.JComboBox<String> sucursalCB;
    // End of variables declaration//GEN-END:variables
}
