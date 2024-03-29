/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.DAOException;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Collection;
import javax.swing.JOptionPane;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.exception.ConstraintsViolatedException;

/**
 *
 * @author teewa743
 */
public class ProductEditor extends javax.swing.JDialog {

	final dao.ProductDAO productsList;
	helpers.SimpleListModel categoriesModel = new helpers.SimpleListModel();

	/**
	 * Creates new form ProductEditor
	 */
	public ProductEditor(java.awt.Frame parent, boolean modal, dao.ProductDAO productsList) {
		super(parent, modal);
		initComponents();
		this.productsList = productsList;
		categorycombobox.setEditable(true);
		Collection<String> categories = productsList.getCategories();
		categoriesModel.updateItems(categories);
		categorycombobox.setModel(categoriesModel);

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        productID = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        productName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        productDescription = new javax.swing.JLabel();
        scrollDescription = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        productPrice = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        productQuantity = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        productCategory = new javax.swing.JLabel();
        categorycombobox = new javax.swing.JComboBox<>();
        producteditor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        productID.setText("ID:");
        productID.setName("productID"); // NOI18N

        txtId.setName("txtId"); // NOI18N

        productName.setText("Name:");
        productName.setName("productName"); // NOI18N

        txtName.setName("txtName"); // NOI18N

        productDescription.setText("Desciption:");
        productDescription.setName("productDescription"); // NOI18N

        scrollDescription.setName("scrollDescription"); // NOI18N

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        txtDescription.setName("txtDescription"); // NOI18N
        txtDescription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescriptionKeyPressed(evt);
            }
        });
        scrollDescription.setViewportView(txtDescription);

        productPrice.setText("Price:");
        productPrice.setName("productPrice"); // NOI18N

        txtPrice.setName("txtPrice"); // NOI18N

        productQuantity.setText("Quantity in Stock:");
        productQuantity.setName("productQuantity"); // NOI18N

        txtQuantity.setName("txtQuantity"); // NOI18N

        saveButton.setText("Save");
        saveButton.setName("saveButton"); // NOI18N
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.setName("cancelButton"); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        productCategory.setText("Category:");
        productCategory.setName("productCategory"); // NOI18N

        categorycombobox.setName("categorycombobox"); // NOI18N

        producteditor.setText("Product Editor");
        producteditor.setName("producteditor"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(producteditor)
                        .addGap(0, 140, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(productID, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(productName, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(productDescription, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(productCategory, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(productPrice, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(productQuantity, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(saveButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cancelButton))
                            .addComponent(txtName)
                            .addComponent(scrollDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                            .addComponent(txtPrice)
                            .addComponent(txtQuantity)
                            .addComponent(categorycombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtId))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(producteditor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(productDescription))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categorycombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productCategory))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productPrice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productQuantity)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancelButton)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
		try {
			String id = txtId.getText();
			String name = txtName.getText();
			String description = txtDescription.getText();
			String category = (String) categorycombobox.getSelectedItem();
			String price = txtPrice.getText();
			String quantity = txtQuantity.getText();
			BigDecimal p = new BigDecimal(price);
			BigDecimal q = new BigDecimal(quantity);
			domain.Product product = new domain.Product();
			product.setProductID(id);
			product.setListPrice(p);
			product.setProductName(name);
			product.setCategory(category);
			product.setDescription(description);
			product.setQuantityInStock(q);
			new Validator().assertValid(product);
			productsList.saveProduct(product);
			dispose();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this,
					  "You have entered a price or quantity that is not a valid number.",
					  "Input Error", JOptionPane.ERROR_MESSAGE);
		} catch (ConstraintsViolatedException ex) {

			// get the violated constraints from the exception
			ConstraintViolation[] violations = ex.getConstraintViolations();

			 //create a nice error message for the user
			String msg = "Please fix the following input problems:";
			for (ConstraintViolation cv : violations) {
				msg += "\n  - " + cv.getMessage();
			}

			// display the message to the user
			JOptionPane.showMessageDialog(this, msg, "Input Error", JOptionPane.ERROR_MESSAGE);
		}	catch(DAOException ex) {
		JOptionPane.showMessageDialog(this, ex.getMessage(), "Data Access Error", JOptionPane.ERROR_MESSAGE);
}
   }//GEN-LAST:event_saveButtonActionPerformed

   private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
		dispose();
   }//GEN-LAST:event_cancelButtonActionPerformed

    private void txtDescriptionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescriptionKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            // consume the key press so that a tab character does not get entered into the text area
            evt.consume();

            // transfer the focus
            txtDescription.transferFocus();
        }
    }//GEN-LAST:event_txtDescriptionKeyPressed


	

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<String> categorycombobox;
    private javax.swing.JLabel productCategory;
    private javax.swing.JLabel productDescription;
    private javax.swing.JLabel productID;
    private javax.swing.JLabel productName;
    private javax.swing.JLabel productPrice;
    private javax.swing.JLabel productQuantity;
    private javax.swing.JLabel producteditor;
    private javax.swing.JButton saveButton;
    private javax.swing.JScrollPane scrollDescription;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
