package pe.edu.uni.mecafab.view;

import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.edu.uni.mecafab.controller.PedidoController;
import pe.edu.uni.mecafab.dto.EstadoPedidoDto;
import pe.edu.uni.mecafab.dto.PedidoConsultaDto;
import pe.edu.uni.mecafab.util.StringUtil;

public class D3_ActualizarPedidoView extends javax.swing.JFrame {

	public D3_ActualizarPedidoView() {
		initComponents();
		setLocationRelativeTo(null);
		inicializarFormulario();
		listarPedidos();
		llenarCombo();
	}

	PedidoController pedidoControl = new PedidoController();
	private List<EstadoPedidoDto> listaEstados;
	
	@SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel6 = new javax.swing.JLabel();
    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    txtIdPedido = new javax.swing.JTextField();
    btnAsignar = new javax.swing.JButton();
    jScrollPane3 = new javax.swing.JScrollPane();
    tblPedidos = new javax.swing.JTable();
    jLabel4 = new javax.swing.JLabel();
    cboEstado = new javax.swing.JComboBox<>();

    jLabel6.setText("jLabel6");

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actualizar Pedido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 36), new java.awt.Color(0, 153, 255))); // NOI18N

    jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    jLabel1.setText("ID Pedido:");

    jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    jLabel2.setText("Estado");

    txtIdPedido.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

    btnAsignar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
    btnAsignar.setText("Actualizar");
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

    jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    jLabel4.setText("Lista de Pedidos");

    cboEstado.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    cboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
          .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
          .addComponent(btnAsignar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(50, 50, 50)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(26, 26, 26)
            .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel4)
        .addGap(7, 7, 7)
        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addGap(6, 6, 6))
          .addComponent(txtIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel2)
            .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addComponent(btnAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(23, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(15, 15, 15))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(19, 19, 19)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(23, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void btnAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarActionPerformed
		try {

			// Datos
			int idPedido = StringUtil.limpiarInt(txtIdPedido.getText());
			
			// Hallamos el indice del item seleccionado en el combo: 0,1,2,3,4,5
			int index = cboEstado.getSelectedIndex();
			// .get(index) devuelve el objeto(EstadoPedidoDto) que está en la posición index de listaRoles
			int idEstado = listaEstados.get(index).getIdEstado();
			
			// Proceso
			pedidoControl.procesarActualizarPedido(idPedido, idEstado);
			
			// Reporte
			JOptionPane.showMessageDialog(null, "Pedido Actualizado Correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

			inicializarFormulario();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		listarPedidos(); // Actualiza la lista

  }//GEN-LAST:event_btnAsignarActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new D3_ActualizarPedidoView().setVisible(true);
			}
		});
	}

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnAsignar;
  private javax.swing.JComboBox<String> cboEstado;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JTable tblPedidos;
  private javax.swing.JTextField txtIdPedido;
  // End of variables declaration//GEN-END:variables

	private void inicializarFormulario() {
		// Datos de entrada
		txtIdPedido.setText("");
		// Enfoque del cursor
		txtIdPedido.requestFocus();
	}

	private void listarPedidos() {
		try {
			DefaultTableModel tabla;
			tabla = (DefaultTableModel) tblPedidos.getModel();
			tabla.setRowCount(0);
			for (PedidoConsultaDto pedido : pedidoControl.procesarListarPedidos()) {
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
	
	private void llenarCombo() {
		try {
			// Datos
			listaEstados = pedidoControl.procesarListarEstados();
			// Proceso
			cboEstado.removeAllItems();
			for (EstadoPedidoDto rol : listaEstados) {
				cboEstado.addItem(rol.getDescripcion());
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error al cargar roles");
		}
	}
	
}
