package pe.edu.uni.mecafab.view;

import java.util.List;
import javax.swing.JOptionPane;
import pe.edu.uni.mecafab.controller.EmpleadoController;
import pe.edu.uni.mecafab.controller.RolController;
import pe.edu.uni.mecafab.dto.EmpleadoRegistroDto;
import pe.edu.uni.mecafab.dto.RolDto;

public class D1_RegistrarPedidoView_ENPROCESO extends javax.swing.JFrame {

	EmpleadoController controlEmpleado = new EmpleadoController();
	RolController controlRol = new RolController();
	// Creamos un List antes de llamarlo en "llenarCombo" para poder usarlo en btnRegistrar
	private List<RolDto> listaRoles;

	public D1_RegistrarPedidoView_ENPROCESO() {
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
    btnRegistrar = new javax.swing.JButton();
    jScrollPane3 = new javax.swing.JScrollPane();
    tblReport = new javax.swing.JTable();
    jLabel7 = new javax.swing.JLabel();
    txtBuscador = new javax.swing.JTextField();
    jScrollPane2 = new javax.swing.JScrollPane();
    jTextArea2 = new javax.swing.JTextArea();

    jLabel6.setText("jLabel6");

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registrar Empleado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 36), new java.awt.Color(0, 153, 255))); // NOI18N

    jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    jLabel1.setText("ID:");

    jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    jLabel2.setText("Descripcion:");

    txtNombre.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

    btnRegistrar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
    btnRegistrar.setText("Registrar");
    btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnRegistrarActionPerformed(evt);
      }
    });

    tblReport.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
      },
      new String [] {
        "ID", "Cliente", "Teléfono", "Email"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }
    });
    jScrollPane3.setViewportView(tblReport);

    jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    jLabel7.setText("Buscar Cliente: ");

    txtBuscador.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    txtBuscador.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtBuscadorActionPerformed(evt);
      }
    });

    jTextArea2.setColumns(20);
    jTextArea2.setRows(5);
    jScrollPane2.setViewportView(jTextArea2);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(14, 14, 14)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
          .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(46, 46, 46)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))
          .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel7)
            .addGap(18, 18, 18)
            .addComponent(txtBuscador))
          .addComponent(jScrollPane3)
          .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap(19, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel7)
          .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(39, 39, 39)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel1)
            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel2))
          .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(76, 76, 76))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(18, 18, 18)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(26, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(21, 21, 21)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(17, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
		/*
		try {

			// Datos
			EmpleadoRegistroDto dto = new EmpleadoRegistroDto();
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
		} */
			
  }//GEN-LAST:event_btnRegistrarActionPerformed

  private void txtBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscadorActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_txtBuscadorActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new D1_RegistrarPedidoView_ENPROCESO().setVisible(true);
			}
		});
	}

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnRegistrar;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JTextArea jTextArea2;
  private javax.swing.JTable tblReport;
  private javax.swing.JTextField txtBuscador;
  private javax.swing.JTextField txtNombre;
  // End of variables declaration//GEN-END:variables

	private void inicializarFormulario() {
		// Datos de entrada
		txtNombre.setText("");
		// txtApellido.setText("");
		// Enfoque del cursor
		txtNombre.requestFocus();
	}

	// LLenar combo
	private void llenarCombo() {
		try {
			// Datos
			listaRoles = controlRol.obtenerRoles();
			// Proceso
			//cboRol.removeAllItems();
			for (RolDto rol : listaRoles) {
				// cboRol.addItem(rol.getDescripcion());
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error al cargar roles");
		}
	}

}
