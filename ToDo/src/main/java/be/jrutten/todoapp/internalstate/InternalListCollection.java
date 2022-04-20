/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.jrutten.todoapp.internalstate;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 *
 * @author Jrutt
 */
public class InternalListCollection {
    private static Map<String, Category> categories;
    private static DefaultMutableTreeNode catRoot;
    
    private InternalListCollection(){
        System.out.println("be.jrutten.todoapp.internalstate.InternalListCollection\tmethod == " + "constructor()");
    };

    public static Map<String, Category> getCategories() {
        System.out.println("be.jrutten.todoapp.internalstate.Category\tmethod == " + "getCategories()");
        if(InternalListCollection.categories == null){
            StateSaverAndLoader sl = new StateSaverAndLoader();
            Map<String, Category> cl = sl.new Categories().loadCategoryToDoLists();
            InternalListCollection.setCategories(cl);
        }
        
        return categories;
    }

    public static void setCategories(Map<String, Category> categories) {
        System.out.println("be.jrutten.todoapp.internalstate.Category\tmethod == " + "setCategories()");
        InternalListCollection.categories = categories;
    }

    public static DefaultMutableTreeNode getCatRoot() {
        System.out.println("be.jrutten.todoapp.internalstate.Category\tmethod == " + "getCatRoot()");
        if(InternalListCollection.catRoot == null){
            StateSaverAndLoader sl = new StateSaverAndLoader();
            DefaultMutableTreeNode lct = sl.new Categories().loadCategoryTree();
            InternalListCollection.setCatRoot(lct);
        }
        return catRoot;
    }
    
    public static List<Category> getFromTree(DefaultMutableTreeNode node){
        System.out.println("be.jrutten.todoapp.internalstate.Category\tmethod == " + "getFromTree()");
        Enumeration<TreeNode> bfe = node.breadthFirstEnumeration();
        Iterator<TreeNode> asIterator = bfe.asIterator();
        
        List<Category> res = new ArrayList<>();
        while(asIterator.hasNext()){
            DefaultMutableTreeNode temp = (DefaultMutableTreeNode) asIterator.next();
            String st = temp.toString(); 
                System.out.println(st);
            Category get = InternalListCollection.getCategories().get(st);
            res.add(get);
        }
        
        return res;
    }
    
    public static DefaultMutableTreeNode getNode(String name){
        System.out.println("be.jrutten.todoapp.internalstate.Category\tmethod == " + "getNode()");
        Enumeration<TreeNode> bfe = InternalListCollection.getCatRoot().breadthFirstEnumeration();
        while(bfe.hasMoreElements()){
            DefaultMutableTreeNode temp = (DefaultMutableTreeNode) bfe.nextElement();
            String st = temp.toString();
            System.out.println(st);
            if(st.contentEquals(name)){
                System.out.println(st + " == " + name);
                return temp;
            }
        }
        
        return null;
    }

    public static void setCatRoot(DefaultMutableTreeNode catRoot) {
        System.out.println("be.jrutten.todoapp.internalstate.Category\tmethod == " + "setCatRoot()");
        InternalListCollection.catRoot = catRoot;
    }
    
    
    
    
    
}
