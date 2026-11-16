/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package proyectofinal;

/**
 *
 * @author LENOVO
 */
public class Autenticacion extends javax.swing.JPanel {

    private Principal principal;

    
    public void setPrincipal(Principal principal) {
    this.principal = principal;
    }
    
    public Autenticacion() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rbAdministrador = new javax.swing.JRadioButton();
        rbBibliotecario = new javax.swing.JRadioButton();
        rbAlumno = new javax.swing.JRadioButton();
        btnIniciar = new javax.swing.JButton();
        txtNombres = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setText("INICIO DE SESIÖN");

        rbAdministrador.setText("Administrador");
        rbAdministrador.addActionListener(this::rbAdministradorActionPerformed);

        rbBibliotecario.setText("Bibliotecario");
        rbBibliotecario.addActionListener(this::rbBibliotecarioActionPerformed);

        rbAlumno.setText("Alumno");

        btnIniciar.setText("Iniciar Sesión");
        btnIniciar.addActionListener(this::btnIniciarActionPerformed);

        txtNombres.addActionListener(this::txtNombresActionPerformed);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(this::btnSalirActionPerformed);

        jLabel2.setText("Nombres completos:");

        jLabel3.setText("Código:");

        jLabel4.setText("Elija su rol:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE))
                .addGap(131, 131, 131))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(rbAdministrador)
                            .addComponent(rbBibliotecario)
                            .addComponent(rbAlumno))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbAdministrador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbBibliotecario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbAlumno)
                .addGap(20, 20, 20)
                .addComponent(btnIniciar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalir)
                .addContainerGap(157, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
         String nombre = txtNombres.getText().trim();
    String codigo = txtCodigo.getText().trim();

    if (nombre.isEmpty() || codigo.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Ingrese su nombre completo y su código.");
        return;
    }
    if (!rbAdministrador.isSelected() && !rbBibliotecario.isSelected() && !rbAlumno.isSelected()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Elija su rol.");
        return;
    }

    String rol;
    if (rbAdministrador.isSelected()) {
        String profesor = new AutenticacionDAO().validarAdministrador(codigo);
        if (profesor == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Código de administrador no válido.");
            txtCodigo.setText("");
            return;
        }
        rol = "Administrador";
        nombre = profesor;
    } else if (rbBibliotecario.isSelected()) {
        rol = "Bibliotecario";
    } else {
        rol = "Alumno";
    }

    principal.iniciarSesion(rol, nombre);


    }//GEN-LAST:event_btnIniciarActionPerformed

    private void rbAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAdministradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbAdministradorActionPerformed

    private void rbBibliotecarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbBibliotecarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbBibliotecarioActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed

    int r = javax.swing.JOptionPane.showConfirmDialog(this,
        "¿Seguro que deseas salir de la aplicación?", "Salir",
        javax.swing.JOptionPane.YES_NO_OPTION);
    if (r == javax.swing.JOptionPane.YES_OPTION) {
        System.exit(0);
    }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rbAdministrador;
    private javax.swing.JRadioButton rbAlumno;
    private javax.swing.JRadioButton rbBibliotecario;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
