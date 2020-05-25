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
import java.util.Date;
import javax.swing.SpinnerDateModel;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

public class Agendar extends javax.swing.JPanel {
    
    private Usuario usuario; //Se meteria en el constructor de Agendar y de FrameUsuario para poder asignarlo en cita
    private SucursalDAO sdao = new SucursalDAO();
    private UsuarioDAO udao = new UsuarioDAO();
    private CitaDAO cdao = new CitaDAO();

    public Agendar(Usuario usuario) {
        initComponents();
        this.usuario = usuario;
        List<Sucursal> sucursales = sdao.obtener();
        for (Sucursal s : sucursales){
            sucursalCB.addItem(s.getLugar_s());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        fechaDC = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        sucursalCB = new javax.swing.JComboBox<>();
        motivoCB = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        agendarB = new javax.swing.JButton();
        horaS = new javax.swing.JComboBox<>();

        jButton1.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        fechaDC.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel1.setText("Fecha");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel2.setText("Hora");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel3.setText("Sucursal");

        sucursalCB.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        sucursalCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sucursalCBActionPerformed(evt);
            }
        });

        motivoCB.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        motivoCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Creacion cuenta bancaria", "", "Cambio o perdida de tarjeta", "Otros" }));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel4.setText("Motivo");

        agendarB.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        agendarB.setText("Agendar");
        agendarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendarBActionPerformed(evt);
            }
        });

        horaS.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        horaS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "09:00", "09:15", "09:30", "09:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45", "14:00", "14:15", "14:30", "14:45", "15:00" }));
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
                .addGap(188, 188, 188)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(agendarB)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(sucursalCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fechaDC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(motivoCB, 0, 214, Short.MAX_VALUE)
                                .addComponent(horaS, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(190, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechaDC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(horaS, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sucursalCB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(motivoCB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(agendarB)
                .addContainerGap(165, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void agendarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendarBActionPerformed

        //Temporal :v
        List<Cita> citas = cdao.obtener();
        for (Cita c : citas){
            c.toString();
            System.out.println("\n");
        }
        
        
        //long id_usuario = ;
        String nombre_sucursal = (String) sucursalCB.getSelectedItem();
        Date fecha = fechaDC.getDate();
        if (fecha == null){
            fecha = new Date(1900, 1, 1);
        }
        DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String fecha2 = f.format(fecha);
        String hora = horaS.getSelectedItem().toString();
        ValidarSolicitarCita validarSolicitudCita = new ValidarSolicitarCita();
        
        //Conseguir cual Sucursal es
        List<Sucursal> sucursales = sdao.obtener();
        Sucursal sucursal = sucursales.get(0);
        for (Sucursal s : sucursales){
            if (s.getLugar_s().equals(nombre_sucursal)){
                sucursal = s;
                break;
            }
        }
        
        //Conseguir cual Usuario es
        List<Usuario> usuarios = udao.obtener();
        for (Usuario u : usuarios){
            if (u.getUsuario().equals(usuario.getUsuario())){ //No deberian haber dos nombres de usuario iguales
                usuario = u;
                break;
            }
        }
        
        //Se crea la cita
        Cita cita = new Cita(sucursal, usuario,LocalDate.parse(fecha2), LocalTime.parse(hora), 0);
        
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

        switch (validarSolicitudCita.verificarSolicitarCita(cita)){
            case 0:
                System.out.println("Cita registrada exitosamente");
                System.out.println(fecha2);
                cdao.registrar(cita);
                System.out.println(cita.toString());
                JOptionPane.showMessageDialog(agendarB, "Registro Exitoso", "Registro", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 1:
                break;
            case 2:
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
    private javax.swing.JComboBox<String> motivoCB;
    private javax.swing.JComboBox<String> sucursalCB;
    // End of variables declaration//GEN-END:variables
}
