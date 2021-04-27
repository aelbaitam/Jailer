/*
 * Copyright 2007 - 2021 Ralf Wisser.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.sf.jailer.ui;

import java.awt.Color;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * New Data Model Dialog.
 * 
 * @author Ralf Wisser
 */
public class NewDataModelDialog extends javax.swing.JDialog {

	private static final long serialVersionUID = 486596745983098673L;

	private final Set<String> existingFoldersLC;
	
	private Color initialFGColor;
	private String nameEntered = null;
	
	/** Creates new form NewDataModelDialog */
	public NewDataModelDialog(java.awt.Frame parent, List<String> existingFolders) {
		super(parent, true);
		this.existingFoldersLC = new HashSet<String>();
		
		for (String s: existingFolders) {
			existingFoldersLC.add(s.toLowerCase(Locale.ENGLISH));
		}
		
		initComponents();
		pack();
		setSize(Math.max(400, getWidth()), getHeight());
		setLocation(parent.getX() + (parent.getWidth() - getWidth()) / 2, parent.getY() + (parent.getHeight() - getHeight()) / 2);
		UIUtil.fit(this);
		
		initialFGColor = folderTextField.getForeground();
		nameTextField.setText("");
		
		nameTextField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent e) {
				checkName();
			}
			@Override
			public void insertUpdate(DocumentEvent e) {
				checkName();
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				checkName();
			}
		});

		checkName();

		setVisible(true);
	}

	private boolean checkName() {
		Color red = Color.red;
		folderTextField.setText(folderName(nameTextField.getText()));
		if (nameTextField.getText().trim().length() == 0) {
			createButton.setEnabled(false);
			folderTextField.setForeground(initialFGColor);
			return false;
		} else {
			if (existingFoldersLC.contains(folderTextField.getText().toLowerCase(Locale.ENGLISH))) {
				createButton.setEnabled(false);
				folderTextField.setForeground(red);
				return false;
			} else {
				createButton.setEnabled(true);
				folderTextField.setForeground(initialFGColor);
				return true;
			}
		}
	}

	private String folderName(String name) {
		name = name.trim().replaceAll("[^ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789]+", "-");
		return name;
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		jPanel1 = new javax.swing.JPanel();
		createButton = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jPanel2 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		nameTextField = new javax.swing.JTextField();
		folderTextField = new javax.swing.JTextField();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("New Data Model");
		getContentPane().setLayout(new java.awt.GridBagLayout());

		jPanel1.setLayout(new java.awt.GridBagLayout());

		createButton.setText("Create New Data Model");
		createButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				createButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.weightx = 1.0;
		jPanel1.add(createButton, gridBagConstraints);

		jButton2.setText("Cancel");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		jPanel1.add(jButton2, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 10;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
		getContentPane().add(jPanel1, gridBagConstraints);

		jPanel2.setLayout(new java.awt.GridBagLayout());

		jLabel1.setText("Name");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		jPanel2.add(jLabel1, gridBagConstraints);

		jLabel2.setText("Folder  ");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		jPanel2.add(jLabel2, gridBagConstraints);

		nameTextField.setText("jTextField1");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.weightx = 1.0;
		jPanel2.add(nameTextField, gridBagConstraints);

		folderTextField.setEditable(false);
		folderTextField.setText("jTextField1");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.weightx = 1.0;
		jPanel2.add(folderTextField, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.insets = new java.awt.Insets(14, 4, 14, 4);
		getContentPane().add(jPanel2, gridBagConstraints);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
		setVisible(false);
	}//GEN-LAST:event_jButton2ActionPerformed

	private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
		if (checkName()) {
			nameEntered = nameTextField.getText().trim();
		}
		setVisible(false);
	}//GEN-LAST:event_createButtonActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton createButton;
	private javax.swing.JTextField folderTextField;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JTextField nameTextField;
	// End of variables declaration//GEN-END:variables

	/**
	 * Gets the name entered, or <code>null</code> if no name has entered.
	 */
	public String getNameEntered() {
		return nameEntered;
	}

	public String getFolderName() {
		return folderName(nameEntered);
	}

}
