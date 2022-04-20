/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package be.jrutten.todoapp.view;

import be.jrutten.todoapp.internalstate.Category;
import be.jrutten.todoapp.internalstate.InternalListCollection;
import be.jrutten.todoapp.internalstate.StateSaverAndLoader;
import be.jrutten.todoapp.internalstate.Task;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.MutableComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Jrutt
 */
public class ListEditor extends javax.swing.JPanel {
    boolean showDoneSelected = false;
    /**
     * Creates new form ListEditor
     */
    public ListEditor() {
        System.out.println("be.jrutten.todoapp.view.ListEditor\tmethod=="+ "constructor");        

        initComponents();
        
        //building the selectionbox
        //String[] catNames = (String[]) categories.keySet().toArray();
        String[] toArray = InternalListCollection.getCategories().keySet().toArray(new String[InternalListCollection.getCategories().keySet().size()]);
        
        MutableComboBoxModel<String> catModel = new DefaultComboBoxModel<String>(toArray);
        this.catSelectionBox.setModel(catModel);
        this.catSelectionBox.validate();
    }
    
    private void changeTabelView(boolean showDone){
        System.out.println("be.jrutten.todoapp.view.ListEditor\tmethod=="+ "changeTabelView");
         String cat = this.catSelectionBox.getModel().getSelectedItem().toString();
        List<Category> catTree = InternalListCollection.getFromTree(InternalListCollection.getNode(cat));
        
        
        
        //this creates the model
        DefaultTableModel dataModel = new DefaultTableModel();
        dataModel.addColumn("Category");
        dataModel.addColumn("Task Id");
        dataModel.addColumn("Task name");
        
        if(catTree.size() > 0){
            for(Category category : catTree){
                
                for(Task task: category.getToDo().values()){
                    if(task.isIsDone()) continue;
                    dataModel.addRow(new Object[]{category.getName(), task.getTask_id(), task.getName()});
                    System.out.println("Row added");
                }
                    
            }
        } else {
            System.out.println("Default model creation");
            dataModel.addRow(new Object[]{"N","0", "....."});
        }
        

        this.jTableTasks.setModel(dataModel);
        this.jTableTasks.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        catSelectionBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldTaskCreationName = new javax.swing.JTextField();
        jButtonCreateTask = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTasks = new javax.swing.JTable();
        jButtonMarkSelectedAsDone = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(400, 300));
        setMinimumSize(new java.awt.Dimension(400, 300));
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        catSelectionBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        catSelectionBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                catSelectionBoxItemStateChanged(evt);
            }
        });
        catSelectionBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                catSelectionBoxMouseClicked(evt);
            }
        });
        catSelectionBox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                catSelectionBoxPropertyChange(evt);
            }
        });

        jLabel1.setText("ToDo view");

        jTextFieldTaskCreationName.setText("taskDescription");

        jButtonCreateTask.setText("Create");
        jButtonCreateTask.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCreateTaskMouseClicked(evt);
            }
        });

        jTableTasks.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTableTasks);
        jTableTasks.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jButtonMarkSelectedAsDone.setText("Mark selected as done");
        jButtonMarkSelectedAsDone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonMarkSelectedAsDoneMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(catSelectionBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTaskCreationName, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(16, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCreateTask)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonMarkSelectedAsDone)
                        .addGap(65, 65, 65))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addComponent(catSelectionBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldTaskCreationName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCreateTask)
                    .addComponent(jButtonMarkSelectedAsDone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        System.out.println("be.jrutten.todoapp.view.ListEditor\tmethod=="+ "formFocusGained");
        this.formComponentShown(evt);
    }//GEN-LAST:event_formFocusGained

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
       System.out.println("be.jrutten.todoapp.view.ListEditor\tmethod=="+ "formComponentShown");
       String[] toArray = InternalListCollection.getCategories().keySet().toArray(new String[InternalListCollection.getCategories().keySet().size()]);
        
       MutableComboBoxModel<String> catModel = new DefaultComboBoxModel<String>(toArray);
       this.catSelectionBox.setModel(catModel);
       this.catSelectionBox.validate(); 
       
       this.changeTabelView(showDoneSelected);
    }//GEN-LAST:event_formComponentShown

    private void jButtonCreateTaskMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCreateTaskMouseClicked
        System.out.println("be.jrutten.todoapp.view.ListEditor\tmethod=="+ "jButtonCreateTaskMouseClicked");
        String cat = this.catSelectionBox.getModel().getSelectedItem().toString();
        Task task = new Task(this.jTextFieldTaskCreationName.getText());
        InternalListCollection.getCategories().get(cat).getToDo().put(task.getTask_id(), task);
        System.out.println("Created task: " + this.jTextFieldTaskCreationName.getText() + " for category: " + cat);
        
        StateSaverAndLoader sal = new StateSaverAndLoader();
        sal.new Categories().saveList(InternalListCollection.getCategories(), InternalListCollection.getCatRoot());
        this.changeTabelView(showDoneSelected);
    }//GEN-LAST:event_jButtonCreateTaskMouseClicked

    private void catSelectionBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_catSelectionBoxMouseClicked
        System.out.println("be.jrutten.todoapp.view.ListEditor\tmethod=="+ "catSelectionBoxMouseClicked");
    }//GEN-LAST:event_catSelectionBoxMouseClicked

    private void catSelectionBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_catSelectionBoxPropertyChange
        System.out.println("be.jrutten.todoapp.view.ListEditor\tmethod=="+ "catSelectionBoxPropertyChange");
    }//GEN-LAST:event_catSelectionBoxPropertyChange

    private void catSelectionBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_catSelectionBoxItemStateChanged
        System.out.println("be.jrutten.todoapp.view.ListEditor\tmethod=="+ "catSelectionBoxItemStateChanged");
        this.changeTabelView(showDoneSelected);
        
        String toFind = (String) this.catSelectionBox.getModel().getSelectedItem();
        List<Category> fromTree = InternalListCollection.getFromTree(InternalListCollection.getNode(toFind));
        
        
    }//GEN-LAST:event_catSelectionBoxItemStateChanged

    private void jButtonMarkSelectedAsDoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMarkSelectedAsDoneMouseClicked
        System.out.println("be.jrutten.todoapp.view.ListEditor\tmethod=="+ "jButtonMarkSelectedAsDoneMouseClicked");
        int[] selectedRows = this.jTableTasks.getSelectedRows();
        
        for(int i : selectedRows){
            long id = (long) this.jTableTasks.getValueAt(i, 1);
            String catName = (String) this.jTableTasks.getValueAt(i, 0);
            InternalListCollection.getCategories().get(catName).getToDo().get(id).setIsDone(true);
        }
        
        StateSaverAndLoader sal = new StateSaverAndLoader();
        sal.new Categories().saveList(InternalListCollection.getCategories(), InternalListCollection.getCatRoot());
                
        this.changeTabelView(showDoneSelected);
    }//GEN-LAST:event_jButtonMarkSelectedAsDoneMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> catSelectionBox;
    private javax.swing.JButton jButtonCreateTask;
    private javax.swing.JButton jButtonMarkSelectedAsDone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTasks;
    private javax.swing.JTextField jTextFieldTaskCreationName;
    // End of variables declaration//GEN-END:variables
}
