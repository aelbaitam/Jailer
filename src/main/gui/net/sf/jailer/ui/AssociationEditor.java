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

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;

import org.fife.ui.rtextarea.RTextScrollPane;

import net.sf.jailer.database.Session;
import net.sf.jailer.datamodel.Association;
import net.sf.jailer.datamodel.Column;
import net.sf.jailer.ui.syntaxtextarea.RSyntaxTextAreaWithSQLSyntaxStyle;
import net.sf.jailer.ui.syntaxtextarea.SQLAutoCompletion;
import net.sf.jailer.ui.syntaxtextarea.SQLCompletionProvider;
import net.sf.jailer.util.CsvFile.Line;

/**
 * Editor for single tables. Part of {@link DataModelEditor}.
 *
 * @author Ralf Wisser
 */
public class AssociationEditor extends javax.swing.JDialog {
	
	/**
	 * All tables (as csv-lines).
	 */
	private Collection<Line> tables;

	/**
	 * All associations (as csv-lines).
	 */
	private Collection<Line> associations;

	/**
	 * All columns.
	 */
	private Map<String, Line> columns;

	private RSyntaxTextAreaWithSQLSyntaxStyle joinCondition;
	
	/** 
	 * Creates new form TableEditor
	 * 
	 * @param tables all tables (as csv-lines)
	 * @param associations all associations (as csv-line)
	 * @param columns 
	 */
	public AssociationEditor(java.awt.Dialog parent, Collection<Line> tables, List<Line> associations, Map<String, Line> columns) {
		super(parent, true);
		this.tables = tables;
		this.associations = associations;
		this.columns = columns;
		initComponents();
		AutoCompletion.enable(destination);
		AutoCompletion.enable(source);
		
		joinCondition = new RSyntaxTextAreaWithSQLSyntaxStyle(false, false) {
			@Override
			protected void runBlock() {
				super.runBlock();
				onOk();
			}
		};
		
		try {
			provider = new CompletionProvider(null, null);
			provider.setDefaultClause(SQLCompletionProvider.Clause.WHERE);
			new SQLAutoCompletion(provider, joinCondition);
		} catch (SQLException e) {
		}
		
		joinCondition.setRows(3);
		RTextScrollPane jScrollPane = new RTextScrollPane();
        jScrollPane.setViewportView(joinCondition);
        
		GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 9;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		getContentPane().add(jScrollPane, gridBagConstraints);

		ItemListener itemListener = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				provider.updateAliases();
			}
		};
		source.addItemListener(itemListener);
		destination.addItemListener(itemListener);
		
		type.setRenderer(createTypeRenderer());
		pack();
		setSize(Math.max(480, getWidth()), getHeight());
		setLocation(parent.getLocation().x + parent.getSize().width/2 - getPreferredSize().width/2,
				parent.getLocation().y + parent.getSize().height/2 - getPreferredSize().height/2);
		UIUtil.initPeer();
	}

	private CompletionProvider provider;
	
	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        source = new JComboBox2();
        type = new JComboBox2();
        destination = new JComboBox2();
        cardinality = new JComboBox2();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Association");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        source.setMaximumRowCount(20);
        source.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 0);
        getContentPane().add(source, gridBagConstraints);

        type.setModel(createTypeModel());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 0);
        getContentPane().add(type, gridBagConstraints);

        destination.setMaximumRowCount(20);
        destination.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 0);
        getContentPane().add(destination, gridBagConstraints);

        cardinality.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "1:n", "n:1", "1:1", "n:m" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 0);
        getContentPane().add(cardinality, gridBagConstraints);

        jLabel1.setText(" Name ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(jLabel1, gridBagConstraints);

        jLabel2.setText(" Join condition* ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jLabel2, gridBagConstraints);

        jLabel6.setText(" From A");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(jLabel6, gridBagConstraints);

        jLabel7.setText(" To B");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(jLabel7, gridBagConstraints);

        jLabel8.setText(" Type");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(jLabel8, gridBagConstraints);

        nameField.setText("jTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(nameField, gridBagConstraints);

        jLabel9.setText(" Cardinality ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(jLabel9, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jButton1.setText("Ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 0);
        jPanel1.add(jButton1, gridBagConstraints);

        jLabel3.setFont(jLabel3.getFont().deriveFont(jLabel3.getFont().getSize()+1f));
        jLabel3.setText("<html>&nbsp;* <i>Ctrl+Space</i> for code completion.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 0);
        jPanel1.add(jLabel3, gridBagConstraints);

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jButton2ComponentResized(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 0);
        jPanel1.add(jButton2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 40;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
		setVisible(false);
	}//GEN-LAST:event_jButton2ActionPerformed

	/**
	 * On OK.
	 */
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		onOk();
	}//GEN-LAST:event_jButton1ActionPerformed

	private void onOk() {
		String msg = null;
		if (nameField.getText().trim().length() == 0) {
			msg = "No association name";
		} else {
			for (Line l: associations) {
				if (l != currentAssociation && l.cells.get(5).equalsIgnoreCase(nameField.getText().trim())) {
					msg = "Association with same name exists";
					break;
				}
			}
		}
		if (joinCondition.getText().trim().length() == 0) {
			msg = "No join condition";
		}if (msg != null) {
			JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			isOk = true;
			setVisible(false);
		}
	}

	private void jButton2ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jButton2ComponentResized
	}//GEN-LAST:event_jButton2ComponentResized

	/**
	 * Creates model for {@link AssociationEditor#type}.
	 * 
	 * @return model for {@link AssociationEditor#type}
	 */
	private ComboBoxModel createTypeModel() {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		model.addElement("");
		model.addElement("A");
		model.addElement("B");
		return model;
	}

	/**
	 * Creates renderer for {@link AssociationEditor#type}.
	 * 
	 * @return renderer for {@link AssociationEditor#type}
	 */
	private ListCellRenderer createTypeRenderer() {
		DefaultListCellRenderer renderer = new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList list,
					Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				if ("".equals(value)) {
					value = "associates";
				} else if ("A".equals(value)) {
					value = "has dependent (has child)";
				} else if ("B".equals(value)) {
					value = "depends on (has parent)";
				}
			return super.getListCellRendererComponent(list, value, index, isSelected,
						cellHasFocus);
			}
			private static final long serialVersionUID = 1992399605806444015L;
		};
		return renderer;
	}
	
	/**
	 * Set to <code>true</code> if ok-button is clicked.
	 */
	private boolean isOk;
	
	/**
	 * Currently edited {@link Association}.
	 */
	private Line currentAssociation;
	
	/**
	 * Edits an association (as csv-line).
	 * 
	 * @param association the association-line
	 * @return <code>true</code> if association was modified
	 */
	public boolean edit(Line association) {
		currentAssociation = association;
		nameField.setText(association.cells.get(5));
		DefaultComboBoxModel tablesModel1 = new DefaultComboBoxModel();
		DefaultComboBoxModel tablesModel2 = new DefaultComboBoxModel();
		Set<String> sortedTableNames = new TreeSet<String>();
		for (Line table: tables) {
			sortedTableNames.add(table.cells.get(0));
		}
		sortedTableNames.add(association.cells.get(0));
		sortedTableNames.add(association.cells.get(1));
		for (String tableName: sortedTableNames) {
			tablesModel1.addElement(tableName);
			tablesModel2.addElement(tableName);
		}
		source.setModel(tablesModel1);
		destination.setModel(tablesModel2);

		source.setSelectedItem(association.cells.get(0));
		destination.setSelectedItem(association.cells.get(1));
		type.setSelectedItem(association.cells.get(2));
		joinCondition.setText(association.cells.get(4) + "\n");
		joinCondition.setCaretPosition(0);
		String cardinality = association.cells.get(3);
		this.cardinality.setSelectedItem(cardinality);
		nameField.setText(association.cells.get(5));
		
		Object origSource = source.getSelectedItem();
		Object origDestination = destination.getSelectedItem();
		Object origType = type.getSelectedItem();
		Object origCardinality = this.cardinality.getSelectedItem();
		String origJoinCondition = joinCondition.getText();
		String origName = nameField.getText();

		provider.updateAliases();

		isOk = false;
		setVisible(true);
		if (isOk && !(origName.equals(nameField.getText()) 
				&& origSource.equals(source.getSelectedItem())
				&& origDestination.equals(destination.getSelectedItem())
				&& origType.equals(type.getSelectedItem())
				&& origCardinality.equals(this.cardinality.getSelectedItem())
				&& origJoinCondition.equals(joinCondition.getText()))) {
			
			association.cells.set(0, (String) source.getSelectedItem());
			association.cells.set(1, (String) destination.getSelectedItem());
			association.cells.set(2, (String) type.getSelectedItem());
			association.cells.set(3, (String) this.cardinality.getSelectedItem());
			association.cells.set(4, joinCondition.getText().replaceAll("\\s*\\n", " ").trim());
			association.cells.set(5, nameField.getText());
			association.cells.set(6, "Data Model Editor");
			association.length = 6;
			return true;
		}
		return false;
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JComboBox2 cardinality;
    private JComboBox2 destination;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameField;
    private JComboBox2 source;
    private JComboBox2 type;
    // End of variables declaration//GEN-END:variables

	private class TableModel {
    	String schema;
    	String name;
		String origName;
    	List<String> columns;
    }
	
	private class CompletionProvider extends SQLCompletionProvider<String, String, TableModel> {

		private final List<TableModel> tableModels = new ArrayList<TableModel>();

		public CompletionProvider(Session session, String metaDataSource) throws SQLException {
			super(session, metaDataSource);
			for (Line tabLine: tables) {
				TableModel tableModel = new TableModel();
				tableModel.origName = tabLine.cells.get(0);
				tableModel.name = tableModel.origName;
				int iDot = tableModel.name.indexOf(':');
				if (iDot < 0) {
					tableModel.schema = "";
				} else {
					tableModel.schema = tableModel.name.substring(0, iDot);
					tableModel.name = tableModel.name.substring(iDot + 1);
				}
				tableModel.columns = new ArrayList<String>();
				if (columns.containsKey(tabLine.cells.get(0))) {
					Line line = columns.get(tabLine.cells.get(0));
					for (int i = 1; i < line.length; ++i) {
						try {
							Column column = Column.parse(line.cells.get(i));
							tableModel.columns.add(column.name);
						} catch (Exception e) {
							// ignore
						}
					}
				}
				tableModels.add(tableModel);
			}
		}

		@Override
		protected List<String> getColumns(TableModel table, long timeOut, JComponent waitCursorSubject) {
			return table.columns;
		}

		@Override
		protected String getDefaultSchema(String metaDataSource) {
			return "";
		}

		@Override
		protected String findSchema(String metaDataSource, String name) {
			return name;
		}

		@Override
		protected TableModel findTable(String schema, String name) {
			for (TableModel tab: tableModels) {
				if (tab.schema.equals(schema) && tab.name.equals(name)) {
					return tab;
				}
			}
			return null;
		}

		@Override
		protected String getTableName(TableModel table) {
			return table.name;
		}

		@Override
		protected List<TableModel> getTables(String schema) {
			List<TableModel> result = new ArrayList<TableModel>();
			for (TableModel tab: tableModels) {
				if (tab.schema.equals(schema)) {
					result.add(tab);
				}
			}
			return result;
		}

		@Override
		protected String getSchemaName(String schema) {
			return schema;
		}

		@Override
		protected List<String> getSchemas(String metaDataSource) {
			Set<String> result = new HashSet<String>();
			result.add("");
			for (TableModel tab : tableModels) {
				result.add(tab.schema);
			}
			return new ArrayList<String>(result);
		}

		@Override
		protected List<Association> getAssociations(TableModel source, TableModel destination) {
			return Collections.emptyList();		
		}
		
		private void updateAliases() {
			removeAliases();
			String sName = String.valueOf(source.getSelectedItem());
			String dName = String.valueOf(destination.getSelectedItem());
			for (TableModel tab: tableModels) {
				if (tab.origName.equals(sName)) {
					provider.addAlias("A", tab);
				}
				if (tab.origName.equals(dName)) {
					provider.addAlias("B", tab);
				}
			}
		}

		@Override
		protected boolean isInitialized() {
			return true;
		}
	}
	
	private static final long serialVersionUID = 603961628104674406L;
}
