/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.Collection;

/**
 *
 * @author teewa743
 */
public class ViewProduct extends javax.swing.JDialog {
	dao.ProductCollectionsDAO productsList = new dao.ProductCollectionsDAO();
	helpers.SimpleListModel productsModel = new helpers.SimpleListModel();
	
	/**
	 * Creates new form ViewProduct
	 */
	public ViewProduct(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		
		Collection<domain.Product> products= productsList.getProduct();
		productsModel.updateItems(products);
		jList1.setModel(productsModel);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      viewProduct = new javax.swing.JLabel();
      searchID = new javax.swing.JLabel();
      filterlabel = new javax.swing.JLabel();
      txtID = new javax.swing.JTextField();
      searchButton = new javax.swing.JButton();
      editButton = new javax.swing.JButton();
      deleteButton = new javax.swing.JButton();
      closeButton = new javax.swing.JButton();
      jScrollPane2 = new javax.swing.JScrollPane();
      jList1 = new javax.swing.JList<>();
      filtercombobox = new javax.swing.JComboBox<>();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

      viewProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      viewProduct.setText("View Product");
      viewProduct.setName("viewProduct"); // NOI18N

      searchID.setText("Search by ID:");
      searchID.setName("searchID"); // NOI18N

      filterlabel.setText("Category Filter:");
      filterlabel.setName("filterlabel"); // NOI18N

      txtID.setName("txtID"); // NOI18N

      searchButton.setText("Search");
      searchButton.setName("searchButton"); // NOI18N
      searchButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            searchButtonActionPerformed(evt);
         }
      });

      editButton.setText("Edit");
      editButton.setName("editButton"); // NOI18N

      deleteButton.setText("Delete");
      deleteButton.setName("deleteButton"); // NOI18N

      closeButton.setText("Close");
      closeButton.setName("closeButton"); // NOI18N
      closeButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            closeButtonActionPerformed(evt);
         }
      });

      jScrollPane2.setName("jScrollPane2"); // NOI18N

      jList1.setName("jList1"); // NOI18N
      jScrollPane2.setViewportView(jList1);

      filtercombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
      filtercombobox.setName("filtercombobox"); // NOI18N

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(jScrollPane2)
            .addContainerGap())
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addGap(18, 18, 18)
                  .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addGap(18, 18, 18)
                  .addComponent(closeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(searchID, javax.swing.GroupLayout.Alignment.TRAILING)
                     .addComponent(filterlabel, javax.swing.GroupLayout.Alignment.TRAILING))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                        .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(searchButton))
                     .addComponent(filtercombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                  .addContainerGap())
               .addComponent(viewProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(viewProduct)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(searchButton)
               .addComponent(searchID))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(filterlabel)
               .addComponent(filtercombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(editButton)
               .addComponent(deleteButton)
               .addComponent(closeButton))
            .addContainerGap())
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
	dispose();
   }//GEN-LAST:event_closeButtonActionPerformed

   private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
	String id = txtID.getText();
	String filter = (String) filtercombobox.getSelectedItem();
   }//GEN-LAST:event_searchButtonActionPerformed

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
			java.util.logging.Logger.getLogger(ViewProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ViewProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ViewProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ViewProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the dialog */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				ViewProduct dialog = new ViewProduct(new javax.swing.JFrame(), true);
				dialog.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override
					public void windowClosing(java.awt.event.WindowEvent e) {
						System.exit(0);
					}
				});
				dialog.setVisible(true);
			}
		});
	}

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton closeButton;
   private javax.swing.JButton deleteButton;
   private javax.swing.JButton editButton;
   private javax.swing.JComboBox<String> filtercombobox;
   private javax.swing.JLabel filterlabel;
   private javax.swing.JList<String> jList1;
   private javax.swing.JScrollPane jScrollPane2;
   private javax.swing.JButton searchButton;
   private javax.swing.JLabel searchID;
   private javax.swing.JTextField txtID;
   private javax.swing.JLabel viewProduct;
   // End of variables declaration//GEN-END:variables
}
