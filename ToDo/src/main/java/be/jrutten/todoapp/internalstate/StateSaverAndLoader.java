/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.jrutten.todoapp.internalstate;

import java.beans.Encoder;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Jrutt
 */
public class StateSaverAndLoader {
    private static String saveLocation = "SaveFiles";
    private static String catTreeFileName = "CAT-TREE.xml";
    private static String catFilePrefix = "CAT_", catFileSubfix = "_list.xml";
    
    public class Categories implements ListSaver{

        public void saveList(Map mp, DefaultMutableTreeNode root) {
            System.out.println("be.jrutten.todoapp.internalstate.StateSaverAndLoader.Categories\tmethod=="+ "saveList");
            //saves the tree
            
            try {
                    File treeFile = FileSystems.getDefault().getPath(StateSaverAndLoader.saveLocation, StateSaverAndLoader.catTreeFileName).toFile();
                    XMLEncoder enc = new XMLEncoder(new FileOutputStream(treeFile));
                    enc.writeObject(root);
                    enc.flush();
                    enc.close();
            } catch (FileNotFoundException ex) {
                    System.out.println(catTreeFileName + " - " + ex.getMessage());
            }
            
            
            //saves the lists in the tree
            Map<String, Category> hmp = mp;
            for(String catName: hmp.keySet()){
                File temp = new File(
                    FileSystems.getDefault().getPath(
                        StateSaverAndLoader.saveLocation, 
                        StateSaverAndLoader.catFilePrefix + catName + StateSaverAndLoader.catFileSubfix)
                    .toString());
                
                
                try {
                    XMLEncoder enc = new XMLEncoder(new FileOutputStream(temp));
                    enc.writeObject(hmp.get(catName));
                    enc.flush();
                    enc.close();
                } catch (FileNotFoundException ex) {
                    System.out.println(catName + " - " + ex.getMessage());
                }     
            }
            
            
        }
        
         DefaultMutableTreeNode loadCategoryTree(){
             System.out.println("be.jrutten.todoapp.internalstate.StateSaverAndLoader.Categories\tmethod=="+ "loadCategoryTree");
            File treeRootFile = FileSystems.getDefault().getPath(StateSaverAndLoader.saveLocation, StateSaverAndLoader.catTreeFileName).toFile();
            System.out.println(treeRootFile.toString());
            DefaultMutableTreeNode returnValue;
            
            if(!treeRootFile.exists()){
                System.out.println("FILE NOT FOUND");
                returnValue = new DefaultMutableTreeNode("All");
                return returnValue;    
            }
            
            try {
                XMLDecoder dec = new XMLDecoder(new FileInputStream(treeRootFile));
                returnValue = (DefaultMutableTreeNode) dec.readObject();
                dec.close();
            } catch (FileNotFoundException ex) {
                System.out.println("FILE NOT FOUND EXCEPTION");
                returnValue = new DefaultMutableTreeNode("All");
            }
            
            return returnValue;
        }
        
         Map<String, Category> loadCategoryToDoLists(){
             System.out.println("be.jrutten.todoapp.internalstate.StateSaverAndLoader.Categories\tmethod=="+ "loadCategoryToDoLists");
            Map<String, Category> rt;
            File saveFolder = FileSystems.getDefault().getPath(StateSaverAndLoader.saveLocation).toFile();
            
            //checks files in the folder
            File[] catFiles = saveFolder.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.startsWith(StateSaverAndLoader.catFilePrefix);
                }
            });
                
                //if the list is null then a base list with ALL should be created and returned
                if(catFiles == null || catFiles.length == 0){
                    rt = new HashMap<>();
                    rt.put("All", new Category("All"));
                    return rt;
                }
            
                
            rt = new HashMap<>();
            //loads files to mapping
            for(File fi: catFiles){
                try {
                    XMLDecoder dec = new XMLDecoder(new FileInputStream(fi));
                    Category readObject = (Category) dec.readObject();
                    rt.put(readObject.getName(), readObject);
                    dec.close();
                } catch (FileNotFoundException ex) {
                    //if a file is not found, all files should not be loaded;
                    //this might seem weird; but otherwise i'm having really bad inconsistencies
                    System.out.println(ex.getMessage());
                    rt = new HashMap<>();
                    rt.put("All", new Category("All"));
                    break;
                }
            }
            
            
            return rt;
        }
         
         public static void fileRemover(String filename){
             System.out.println("be.jrutten.todoapp.internalstate.StateSaverAndLoader.Categories\tmethod=="+ "fileRemover");
            String fullFileName = catFilePrefix + filename + catFileSubfix;
            File toFile = FileSystems.getDefault().getPath(StateSaverAndLoader.saveLocation, fullFileName).toFile();
            boolean isDeleted = toFile.delete();
            
            System.out.println("File: " + filename + " deleted? -> " + isDeleted);
         }
        
    }
}

interface ListSaver{
    
}