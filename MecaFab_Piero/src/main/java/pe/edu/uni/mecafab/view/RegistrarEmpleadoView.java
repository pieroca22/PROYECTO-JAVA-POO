package pe.edu.uni.mecafab.view;

import java.util.List;
import javax.swing.JOptionPane;
import pe.edu.uni.mecafab.controller.EmpleadoController;
import pe.edu.uni.mecafab.controller.RolController;
import pe.edu.uni.mecafab.dto.EmpleadoDto;
import pe.edu.uni.mecafab.dto.RolDto;

public class RegistrarEmpleadoView extends javax.swing.JFrame {

	EmpleadoController controlEmpleado = new EmpleadoController();
	RolController controlRol = new RolController();
	// Creamos un List antes de llamarlo en "llenarCombo" para poder usarlo en btnRegistrar
	private List<RolDto> listaRoles;

	public RegistrarEmpleadoView() {
		initComponents();
		setLocationRelativeTo(null);
		inicializarFormulario();
		llenarCombo();
	}

	@SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel6 = new javax.swing.JLabel();
    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    txtNombre = new javax.swing.JTextField();
    txtApellido = new javax.swing.JTextField();
    btnRegistrar = new javax.swing.JButton();
    cboRol = new javax.swing.JComboBox<>();
    jLabel3 = new javax.swing.JLabel();

    jLabel6.setText("jLabel6");

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registrar Empleado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 36), new java.awt.Color(0, 153, 255))); // NOI18N

    jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    jLabel1.setText("Nombre:");

    jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    jLabel2.setText("Apellido:");

    txtNombre.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

    txtApellido.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

    btnRegistrar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
    btnRegistrar.setText("Registrar");
    btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnRegistrarActionPerformed(evt);
      }
    });

    cboRol.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    cboRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
    cboRol.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cboRolActionPerformed(evt);
      }
    });

    jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    jLabel3.setText("Rol:");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(14, 14, 14)
        .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(29, 29, 29)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(36, 36, 36)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(txtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
          .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
          .addComponent(cboRol, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGap(0, 32, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(12, 12, 12)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(28, 28, 28)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(31, 31, 31)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(cboRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel3))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(31, 31, 31))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(24, 24, 24)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(12, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(21, 21, 21)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(45, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
		try {

			// Datos
			EmpleadoDto dto = new EmpleadoDto();
			dto.setNombre(txtNombre.getText());
			dto.setApellido(txtApellido.getText());
			
			// Hallamos el indice del item seleccionado en el combo: 1,2,3
			int index = cboRol.getSelectedIndex();
			// .get(index) devuelve el objeto(RolDto) que está en la posición index de listaRoles
			//			0,1,2
			int idRol = listaRoles.get(index).getIdRol();
			
			dto.setIdRol(idRol);
			
			// Proceso
			controlEmpleado.procesarRegistrarEmpleado(dto);

			// Reporte
			JOptionPane.showMessageDialog(null, "Empleado Registrado Correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

			inicializarFormulario();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

  }//GEN-LAST:event_btnRegistrarActionPerformed

  private void cboRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboRolActionPerformed

  }//GEN-LAST:event_cboRolActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(RegistrarEmpleadoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(RegistrarEmpleadoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(RegistrarEmpleadoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(RegistrarEmpleadoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new RegistrarEmpleadoView().setVisible(true);
			}
		});
	}

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnRegistrar;
  private javax.swing.JComboBox<String> cboRol;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JTextField txtApellido;
  private javax.swing.JTextField txtNombre;
  // End of variables declaration//GEN-END:variables

	private void inicializarFormulario() {
		// Datos de entrada
		txtNombre.setText("");
		txtApellido.setText("");
		// Enfoque del cursor
		txtNombre.requestFocus();
	}

	// LLenar combo
	private void llenarCombo() {
		try {
			// Datos
			listaRoles = controlRol.obtenerRoles();
			// Proceso
			cboRol.removeAllItems();
			for (RolDto rol : listaRoles) {
				cboRol.addItem(rol.getDescripcion());
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error al cargar roles");
		}
	}

}
