/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package be.jrutten.todoapp.view;

import be.jrutten.todoapp.internalstate.Category;
import be.jrutten.todoapp.internalstate.InternalListCollection;
import be.jrutten.todoapp.internalstate.StateSaverAndLoader;
import be.jrutten.todoapp.internalstate.Task;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author Jrutt
 */



/*
TO DO HERE:
    - Tree instance should be saved to mapping in the running instance, and should have auto feature
    - Don't allow two elements with the same name to be created
    - If an element gets deleted and the mapping contains Tasks, prompt the user to remove all or move to the upper node. (or other node?)
    - ...

*/
public class CatView extends javax.swing.JPanel {

    private DefaultMutableTreeNode currentlySelected;
    
    /**
     * Creates new form CatView
     */
    public CatView() {
        System.out.println("be.jrutten.todoapp.view.CatView\tmethod=="+ "constructor");
        initComponents();
        
        /*
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) this.catTree.getModel().getRoot();
        Enumeration<TreeNode> bfe = root.breadthFirstEnumeration();
        
        Map<String, Category> catMap = new HashMap<>();
        
        while(bfe.hasMoreElements()){
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) bfe.nextElement();
            catMap.put(node.toString(), new Category(node.toString()));
        }
        
        InternalListCollection.setCategories(catMap);
        
        for(String st: InternalListCollection.getCategories().keySet()){
            System.out.println(st + " -> " + catMap.get(st));
        }
        */
        
        //loads the lists of tasks in Categories
        InternalListCollection.getCategories();
        
        
        
        //this loads the root from file, but it's a bit retarded. Put into a method.
        DefaultMutableTreeNode catRoot = InternalListCollection.getCatRoot();
        this.remove(this.catTree);
        
        this.add(new javax.swing.JTree(catRoot));
        catTree.setModel(new javax.swing.tree.DefaultTreeModel(catRoot));
        catTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                catTreeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(catTree);
        this.catTree.validate();
        this.catTree.repaint();
        this.catTree.revalidate();

        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        categoriesMenuLabel = new javax.swing.JLabel();
        currentlySelectedLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        catTree = new javax.swing.JTree();
        editField = new javax.swing.JTextField();
        createButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        infoLabel = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(400, 300));
        setMinimumSize(new java.awt.Dimension(400, 300));

        categoriesMenuLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        categoriesMenuLabel.setText("Categories");

        currentlySelectedLabel.setText("...........");

        jLabel2.setText("Currently selected:");

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("All");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Home");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Work");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Projects");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Hobby");
        treeNode1.add(treeNode2);
        catTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        catTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                catTreeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(catTree);

        editField.setText("...................");
        editField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editFieldActionPerformed(evt);
            }
        });

        createButton.setText("Create");
        createButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createButtonMouseClicked(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButtonMouseClicked(evt);
            }
        });

        updateButton.setText("Update");

        infoLabel.setText(" ");
        infoLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(categoriesMenuLabel))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addComponent(currentlySelectedLabel))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(editField)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(infoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(createButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateButton))
                            .addComponent(deleteButton))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(categoriesMenuLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(currentlySelectedLabel)
                        .addGap(18, 18, 18)
                        .addComponent(editField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createButton)
                            .addComponent(updateButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addGap(18, 18, 18)
                        .addComponent(infoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("CatView");
    }// </editor-fold>//GEN-END:initComponents

    private void catTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_catTreeMouseClicked
        System.out.println("be.jrutten.todoapp.view.CatView\tmethod=="+ "catTreeMouseClicked");
        TreePath selectionPath = this.catTree.getSelectionPath();
        String sps = selectionPath.toString();
        this.currentlySelected = (DefaultMutableTreeNode) selectionPath.getLastPathComponent();
        String lastComp = selectionPath.getLastPathComponent().toString();
        this.currentlySelectedLabel.setText(lastComp);
    }//GEN-LAST:event_catTreeMouseClicked

    private void editFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editFieldActionPerformed
        System.out.println("be.jrutten.todoapp.view.CatView\tmethod=="+ "editFieldActionPerformed");
        // TODO add your handling code here:
    }//GEN-LAST:event_editFieldActionPerformed

    private void createButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createButtonMouseClicked
        System.out.println("be.jrutten.todoapp.view.CatView\tmethod=="+ "createMouseButtonClicked");
        String toInsert = this.editField.getText();
        
            if(toInsert.isBlank() || toInsert.contains("...................")) return;
            
            if(InternalListCollection.getCategories().containsKey(toInsert)){
                this.infoLabel.setText("The category with name:\n\t" + toInsert + "\nalready exists.");
                return;               
            } else {
                InternalListCollection.getCategories().put(toInsert, new Category(toInsert));
                this.currentlySelected.add(new DefaultMutableTreeNode(toInsert));
                
                InternalListCollection.getCategories().forEach( (x,y) -> {
                    System.out.println(x + " -> "  + y.toString());
                } );
                
                StateSaverAndLoader sal = new StateSaverAndLoader();
                StateSaverAndLoader.Categories catsav = sal.new Categories();
                catsav.saveList(InternalListCollection.getCategories(), (DefaultMutableTreeNode) this.catTree.getModel().getRoot());
            }
            
        
        //this refreshes the tree, but is retarted and consumes too much mem. 
        //Put in seperate method and refactor
        //Als put loading and saving in seperate threads to prevent congestion.
        DefaultMutableTreeNode catRoot = InternalListCollection.getCatRoot();
        this.remove(this.catTree);
        
        this.add(new javax.swing.JTree(catRoot));
        catTree.setModel(new javax.swing.tree.DefaultTreeModel(catRoot));
        catTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                catTreeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(catTree);
        this.catTree.validate();
        this.catTree.repaint();
        this.catTree.revalidate();
    }//GEN-LAST:event_createButtonMouseClicked

    private void deleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseClicked
       System.out.println("be.jrutten.todoapp.view.CatView\tmethod=="+ "deleteMouseButtonClicked");
        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) this.currentlySelected.getParent();
       
       //if parent == null it's root and should NEVER be deleted
       if(parent == null){
           return;
       }
       

       DefaultMutableTreeNode current = this.currentlySelected;
       
       /*
       Below this line is very convoluted
       */
       
       System.out.println("Preparing to remove: " + current.toString());
       Category currentCat = InternalListCollection.getCategories().get(current.toString());
       Map<Long, Task> currentToDo = currentCat.getToDo();
       
       Category parentCat = InternalListCollection.getCategories().get(parent.toString());
       parentCat.getToDo().putAll(currentToDo);
       
       InternalListCollection.getCategories().remove(current.toString());
       
       parent.remove(current);
       this.currentlySelected = parent;
       this.currentlySelectedLabel.setText(parent.toString());
       
       StateSaverAndLoader.Categories.fileRemover(current.toString());
       TreeNode root = parent.getRoot();
       
       TreeModel newModel = new DefaultTreeModel(root);
       this.catTree.setModel(newModel);
       
       StateSaverAndLoader sal = new StateSaverAndLoader();
       StateSaverAndLoader.Categories catsav = sal.new Categories();
       
       catsav.saveList(InternalListCollection.getCategories(), (DefaultMutableTreeNode) root);
       
       this.catTree.validate();
       this.catTree.repaint();
       this.catTree.revalidate();
    }//GEN-LAST:event_deleteButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree catTree;
    private javax.swing.JLabel categoriesMenuLabel;
    private javax.swing.JButton createButton;
    private javax.swing.JLabel currentlySelectedLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField editField;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}