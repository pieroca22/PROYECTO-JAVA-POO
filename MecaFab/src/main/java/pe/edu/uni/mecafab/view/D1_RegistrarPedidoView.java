package pe.edu.uni.mecafab.view;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.edu.uni.mecafab.controller.ClienteController;
import pe.edu.uni.mecafab.controller.PedidoController;
import pe.edu.uni.mecafab.dto.ClienteConsultaDto;
import pe.edu.uni.mecafab.dto.PedidoRegistroDto;
import pe.edu.uni.mecafab.util.StringUtil;

public class D1_RegistrarPedidoView extends javax.swing.JFrame {

	public D1_RegistrarPedidoView() {
		initComponents();
		setLocationRelativeTo(null);
		inicializarFormulario();
	}

	@SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel6 = new javax.swing.JLabel();
    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    txtIdCliente = new javax.swing.JTextField();
    btnRegistrar = new javax.swing.JButton();
    jScrollPane3 = new javax.swing.JScrollPane();
    tblReport = new javax.swing.JTable();
    jLabel7 = new javax.swing.JLabel();
    txtBuscador = new javax.swing.JTextField();
    jScrollPane2 = new javax.swing.JScrollPane();
    txtDescripcion = new javax.swing.JTextArea();
    btnBuscar = new javax.swing.JButton();
    jLabel3 = new javax.swing.JLabel();
    txtFechaComprometida = new javax.swing.JTextField();

    jLabel6.setText("jLabel6");

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registrar Pedido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 36), new java.awt.Color(0, 153, 255))); // NOI18N

    jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    jLabel1.setText("ID Cliente:");

    jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    jLabel2.setText("Descripcion:");

    txtIdCliente.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

    btnRegistrar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
    btnRegistrar.setText("Registrar");
    btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnRegistrarActionPerformed(evt);
      }
    });

    tblReport.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null},
        {null, null, null},
        {null, null, null},
        {null, null, null}
      },
      new String [] {
        "ID", "Empleado", "Rol"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Integer.class, java.lang.String.class, java.lang.String.class
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

    txtDescripcion.setColumns(20);
    txtDescripcion.setRows(5);
    jScrollPane2.setViewportView(txtDescripcion);

    btnBuscar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
    btnBuscar.setText("Buscar");
    btnBuscar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnBuscarActionPerformed(evt);
      }
    });

    jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    jLabel3.setText("Fecha Comprometida:");

    txtFechaComprometida.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(14, 14, 14)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
          .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFechaComprometida, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))
          .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel7)
            .addGap(28, 28, 28)
            .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(29, 29, 29)
            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addComponent(jScrollPane3)
          .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap(19, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel7))
        .addGap(22, 22, 22)
        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(39, 39, 39)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel1)
              .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel2))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(txtFechaComprometida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel3)))
          .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(22, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(18, 18, 18)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(50, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(21, 21, 21)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(34, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

	ClienteController clienteController = new ClienteController();
	PedidoController pedidoController = new PedidoController();
	
  private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
		try {
			
			// Datos
			int idCliente = StringUtil.limpiarInt(txtIdCliente.getText());
			String descripcion = StringUtil.limCap(txtDescripcion.getText());
			LocalDateTime fechaSolicitud = LocalDateTime.now();
			Date fechaComprometida = Date.valueOf(StringUtil.limCap(txtFechaComprometida.getText()));
			int idEstado = 1; // En espera de inicio (Aun no se le asigna un empleado)
			
			PedidoRegistroDto dto = new PedidoRegistroDto();
			dto.setIdCliente(idCliente);
			dto.setDescripcion(descripcion);
			dto.setFechaSolicitud(fechaSolicitud);
			dto.setFechaComprometida(fechaComprometida);
			dto.setIdEstado(idEstado);
			
			// Proceso
			pedidoController.procesarRegistrarPedido(dto);
			
			// Reporte
			JOptionPane.showMessageDialog(null, "Pedido Registrado Correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
			
			inicializarFormulario();
			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
  }//GEN-LAST:event_btnRegistrarActionPerformed

  private void txtBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscadorActionPerformed
  }//GEN-LAST:event_txtBuscadorActionPerformed

  private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
    try {
			// Datos
			String patron = StringUtil.limCap(txtBuscador.getText());
			
			// Reporte
			DefaultTableModel tabla;
			tabla = (DefaultTableModel) tblReport.getModel();
			tabla.setRowCount(0);
			for (ClienteConsultaDto cliente : clienteController.procesarConsultarCliente(patron)) {
				Object[] row = {
					cliente.getIdCliente(),
					cliente.getCliente(),
					cliente.getTelefono(), 
					cliente.getEmail(), 
					cliente.getDireccion(),
					// Cambiar el formato de la fecha
					cliente.getFechaRegistro().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
				};
				tabla.addRow(row);
			}
			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
  }//GEN-LAST:event_btnBuscarActionPerformed

	public static void main(String args[]) {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new D1_RegistrarPedidoView().setVisible(true);
			}
		});
	}

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnBuscar;
  private javax.swing.JButton btnRegistrar;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JTable tblReport;
  private javax.swing.JTextField txtBuscador;
  private javax.swing.JTextArea txtDescripcion;
  private javax.swing.JTextField txtFechaComprometida;
  private javax.swing.JTextField txtIdCliente;
  // End of variables declaration//GEN-END:variables

	private void inicializarFormulario() {
		// Datos de entrada
		txtBuscador.setText("");
		txtIdCliente.setText("");
		txtDescripcion.setText("");
		txtFechaComprometida.setText("");
		// txtApellido.setText("");
		// Enfoque del cursor
		txtBuscador.requestFocus();
	}

}
