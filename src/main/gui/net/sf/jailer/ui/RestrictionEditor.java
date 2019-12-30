/*
 * Copyright 2007 - 2019 Ralf Wisser.
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
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Editor for a restricted association.
 *
 * @author Ralf Wisser
 */
public class RestrictionEditor extends javax.swing.JPanel {

	private Color origGBColor;
	
	/** Creates new form RestrictionEditor */
	public RestrictionEditor() {
		initComponents();
		
		Font font = new JLabel("normal").getFont();
		Font boldFont = new Font(font.getName(), font.getStyle() | Font.BOLD, font.getSize());
		source.setFont(boldFont);
		destination.setFont(boldFont);
		
		ButtonGroup buttonGroup = new ButtonGroup();

		buttonGroup.add(restricted);
		buttonGroup.add(ignore);
		
		Color white = new Color(255, 255, 255, 200);
		jPanel1.setBackground(white);
		jPanel4.setBackground(white);
		jPanel5.setBackground(white);
		jPanel8.setBackground(white);
		
		origGBColor = restriction.getBackground();
		restriction.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				setBG();
			}
			@Override
			public void insertUpdate(DocumentEvent e) {
				setBG();
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				setBG();
			}
			private void setBG() {
				restriction.setBackground(new Color(255, 255, 220));
			}
		});
		restriction.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == '\n') {
					apply.doClick();
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent arg0) {
			}
		});
	}

	public void resetBGColor() {
		restriction.setBackground(origGBColor);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        joinCondition2 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        ignore = new javax.swing.JRadioButton();
        restrictedDependencyWarning = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        restricted = new javax.swing.JRadioButton();
        openRestrictionConditionEditor = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        restriction = new javax.swing.JTextField();
        apply = new javax.swing.JButton();
        fkToNullCheckBox = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        columnsA = new javax.swing.JLabel();
        source = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        type = new javax.swing.JLabel();
        cardinality = new javax.swing.JLabel();
        columnsB = new javax.swing.JLabel();
        destination = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        joinCondition = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();

        joinCondition2.setEditable(false);
        joinCondition2.setText("jTextField1");
        joinCondition2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        joinCondition2.setCaretPosition(1);
        joinCondition2.setFocusable(false);
        joinCondition2.setRequestFocusEnabled(false);

        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 0);
        jPanel2.add(jPanel3, gridBagConstraints);

        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jLabel4.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 50;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        jPanel7.add(jLabel4, gridBagConstraints);

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        ignore.setText("Disabled");
        ignore.setOpaque(false);
        jPanel1.add(ignore);

        restrictedDependencyWarning.setForeground(new java.awt.Color(255, 0, 51));
        restrictedDependencyWarning.setText("   Restricted Dependency! ");
        jPanel1.add(restrictedDependencyWarning);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel7.add(jPanel1, gridBagConstraints);

        jPanel8.setBackground(java.awt.Color.white);
        jPanel8.setOpaque(false);
        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        restricted.setText("Enabled. Restricted by   ");
        restricted.setOpaque(false);
        jPanel8.add(restricted);

        openRestrictionConditionEditor.setText("jLabel5");
        openRestrictionConditionEditor.setToolTipText("open editor");
        jPanel8.add(openRestrictionConditionEditor);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        jPanel7.add(jPanel8, gridBagConstraints);

        jPanel9.setOpaque(false);
        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        restriction.setColumns(14);
        restriction.setText("jTextField1");
        restriction.setToolTipText(getConditionToolTip());
        jPanel9.add(restriction);

        apply.setText("apply");
        jPanel9.add(apply);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jPanel7.add(jPanel9, gridBagConstraints);

        fkToNullCheckBox.setText("Set foreign key columns to null");
        fkToNullCheckBox.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 0);
        jPanel7.add(fkToNullCheckBox, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 6, 0);
        jPanel2.add(jPanel7, gridBagConstraints);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 4, 0));

        columnsA.setText("V");
        jPanel4.add(columnsA);

        source.setFont(source.getFont().deriveFont(source.getFont().getSize()+1f));
        source.setText("jLabel3");
        jPanel4.add(source);

        jLabel2.setFont(jLabel2.getFont().deriveFont(jLabel2.getFont().getStyle() & ~java.awt.Font.BOLD));
        jLabel2.setText("A");
        jPanel4.add(jLabel2);

        type.setFont(type.getFont().deriveFont(type.getFont().getSize()+1f));
        type.setText("jLabel3");
        jPanel4.add(type);

        cardinality.setFont(cardinality.getFont().deriveFont(cardinality.getFont().getSize()+1f));
        cardinality.setText("jLabel3");
        jPanel4.add(cardinality);

        columnsB.setText("V");
        jPanel4.add(columnsB);

        destination.setFont(destination.getFont().deriveFont(destination.getFont().getSize()+1f));
        destination.setText("jLabel3");
        jPanel4.add(destination);

        jLabel3.setFont(jLabel3.getFont().deriveFont(jLabel3.getFont().getStyle() & ~java.awt.Font.BOLD));
        jLabel3.setText("B");
        jPanel4.add(jLabel3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel2.add(jPanel4, gridBagConstraints);

        jPanel5.setBackground(java.awt.Color.white);
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 4, 0));

        jLabel1.setText("on");
        jPanel5.add(jLabel1);

        joinCondition.setFont(joinCondition.getFont().deriveFont(joinCondition.getFont().getSize()+1f));
        joinCondition.setText("jLabel5");
        jPanel5.add(joinCondition);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 18, 0, 0);
        jPanel2.add(jPanel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 8, 0, 0);
        add(jPanel2, gridBagConstraints);

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 0);
        add(jPanel6, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

	private String getConditionToolTip() {
		return "<html><i>Ctrl+Space</i> for code completion.";
	}
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton apply;
    public javax.swing.JLabel cardinality;
    javax.swing.JLabel columnsA;
    javax.swing.JLabel columnsB;
    public javax.swing.JLabel destination;
    public javax.swing.JCheckBox fkToNullCheckBox;
    public javax.swing.JRadioButton ignore;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    javax.swing.JLabel joinCondition;
    javax.swing.JTextField joinCondition2;
    javax.swing.JLabel openRestrictionConditionEditor;
    public javax.swing.JRadioButton restricted;
    public javax.swing.JLabel restrictedDependencyWarning;
    public javax.swing.JTextField restriction;
    public javax.swing.JLabel source;
    public javax.swing.JLabel type;
    // End of variables declaration//GEN-END:variables
	
	private static final long serialVersionUID = -6735468124049608700L;

}
