package pe.edu.uni.mecafab.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.edu.uni.mecafab.controller.EmpleadoController;
import pe.edu.uni.mecafab.controller.PedidoController;
import pe.edu.uni.mecafab.dto.AsignacionDto;
import pe.edu.uni.mecafab.dto.EmpleadoConsultaDto;
import pe.edu.uni.mecafab.dto.PedidoConsultaDto;
import pe.edu.uni.mecafab.util.StringUtil;

public class D2_AsignarPedidoView extends javax.swing.JFrame {

	public D2_AsignarPedidoView() {
		initComponents();
		setLocationRelativeTo(null);
		inicializarFormulario();
		listarPedidos();
	}

	EmpleadoController empleadoControl = new EmpleadoController();
	PedidoController pedidoControl = new PedidoController();
	
	@SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel6 = new javax.swing.JLabel();
    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    txtIdPedido = new javax.swing.JTextField();
    txtIdEmpleado = new javax.swing.JTextField();
    btnAsignar = new javax.swing.JButton();
    jScrollPane3 = new javax.swing.JScrollPane();
    tblPedidos = new javax.swing.JTable();
    jScrollPane4 = new javax.swing.JScrollPane();
    tblEmpleados = new javax.swing.JTable();
    jLabel4 = new javax.swing.JLabel();
    txtEmpleado = new javax.swing.JTextField();
    btnBuscar = new javax.swing.JButton();
    jLabel5 = new javax.swing.JLabel();

    jLabel6.setText("jLabel6");

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Asignar Pedido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 36), new java.awt.Color(0, 153, 255))); // NOI18N

    jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    jLabel1.setText("ID Pedido:");

    jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    jLabel2.setText("ID Empleado:");

    txtIdPedido.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

    txtIdEmpleado.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

    btnAsignar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
    btnAsignar.setText("Asignar");
    btnAsignar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnAsignarActionPerformed(evt);
      }
    });

    tblPedidos.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null, null, null},
        {null, null, null, null, null, null},
        {null, null, null, null, null, null},
        {null, null, null, null, null, null}
      },
      new String [] {
        "Codigo", "Cliente", "Descripcion", "Fecha Solicitud", "Fecha Comprometida", "Estado"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }
    });
    jScrollPane3.setViewportView(tblPedidos);

    tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null},
        {null, null, null},
        {null, null, null},
        {null, null, null}
      },
      new String [] {
        "Codigo", "Empleado", "Rol"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.String.class, java.lang.String.class, java.lang.String.class
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }
    });
    jScrollPane4.setViewportView(tblEmpleados);

    jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    jLabel4.setText("Lista de Pedidos");

    txtEmpleado.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    txtEmpleado.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtEmpleadoActionPerformed(evt);
      }
    });

    btnBuscar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
    btnBuscar.setText("Buscar");
    btnBuscar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnBuscarActionPerformed(evt);
      }
    });

    jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    jLabel5.setText("Empleado:");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(29, 29, 29)
            .addComponent(txtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(jScrollPane4)
          .addComponent(jScrollPane3)
          .addComponent(btnAsignar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(25, 25, 25)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(92, 92, 92)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(txtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(24, 24, 24)))
        .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel4)
        .addGap(7, 7, 7)
        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btnBuscar)
          .addComponent(txtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel5))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(jLabel2)
          .addComponent(txtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(txtIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(btnAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(175, 175, 175))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap(17, Short.MAX_VALUE)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(15, 15, 15))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(19, 19, 19)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(23, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void btnAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarActionPerformed
		try {

			// Datos
			int idPedido = StringUtil.limpiarInt(txtIdPedido.getText());
			int idEmpleado = StringUtil.limpiarInt(txtIdEmpleado.getText());
			LocalDateTime fechaAsignacion = LocalDateTime.now();
			AsignacionDto dto = new AsignacionDto(idPedido, idEmpleado, fechaAsignacion);
			
			// Proceso
			pedidoControl.procesarAsignarPedido(dto);
			
			// Reporte
			JOptionPane.showMessageDialog(null, "Pedido Asignado Correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

			inicializarFormulario();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		listarPedidos(); // Actualiza la lista

  }//GEN-LAST:event_btnAsignarActionPerformed

  private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
    try {
			// Datos
			String patron = StringUtil.limCap(txtEmpleado.getText());
			
			// Reporte
			DefaultTableModel tabla;
			tabla = (DefaultTableModel) tblEmpleados.getModel();
			tabla.setRowCount(0);
			for (EmpleadoConsultaDto empleado : empleadoControl.procesarConsultarEmpleado(patron)) {
				Object[] row = {
					empleado.getCodigoEmpleado(),
					empleado.getEmpleado(),
					empleado.getDescripcionRol(), 
				};
				tabla.addRow(row);
			}
			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
  }//GEN-LAST:event_btnBuscarActionPerformed

  private void txtEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpleadoActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_txtEmpleadoActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new D2_AsignarPedidoView().setVisible(true);
			}
		});
	}

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnAsignar;
  private javax.swing.JButton btnBuscar;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JScrollPane jScrollPane4;
  private javax.swing.JTable tblEmpleados;
  private javax.swing.JTable tblPedidos;
  private javax.swing.JTextField txtEmpleado;
  private javax.swing.JTextField txtIdEmpleado;
  private javax.swing.JTextField txtIdPedido;
  // End of variables declaration//GEN-END:variables

	private void inicializarFormulario() {
		// Datos de entrada
		txtEmpleado.setText("");
		txtIdPedido.setText("");
		txtIdEmpleado.setText("");
		// Enfoque del cursor
		txtEmpleado.requestFocus();
	}

	private void listarPedidos() {
		try {
			DefaultTableModel tabla;
			tabla = (DefaultTableModel) tblPedidos.getModel();
			tabla.setRowCount(0);
			for (PedidoConsultaDto pedido : pedidoControl.procesarListarPedidosRegistrados()) {
				Object[] row = {
					pedido.getCodigoPedido(),
					pedido.getCliente(), 
					pedido.getDescripcion(),
					pedido.getFechaSolicitud().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
					pedido.getFechaComprometida(),
					pedido.getEstado()
				};
				tabla.addRow(row);
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
