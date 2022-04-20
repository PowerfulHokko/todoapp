/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.jrutten.ideatesting;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.beans.*;
import java.sql.*;
import java.util.*;
import javax.persistence.*;
import org.postgresql.*;

/**
 *
 * @author Jrutt
 */
public class App {
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("note");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Note note = new Note(1, "test");
        em.persist(note);
        em.getTransaction().commit();
        emf.close();
        em.close();
        
        java.sql.Driver driver = new org.postgresql.Driver();
        
        
    }       
    
   
    
    public static DefaultMutableTreeNode createRoot(){
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Books");
                DefaultMutableTreeNode programming = new DefaultMutableTreeNode("Programming"); 
                    DefaultMutableTreeNode java = new DefaultMutableTreeNode("Java");
                        DefaultMutableTreeNode concurrency = new DefaultMutableTreeNode("Concurrency in practice");
                        DefaultMutableTreeNode dsa = new DefaultMutableTreeNode("DSA in java");
                        DefaultMutableTreeNode reflection = new DefaultMutableTreeNode("Dynamic app development");
                    DefaultMutableTreeNode sql = new DefaultMutableTreeNode("Sql");
                        DefaultMutableTreeNode gis = new DefaultMutableTreeNode("PostGIS");
                DefaultMutableTreeNode math = new DefaultMutableTreeNode("Mathematics");
                    DefaultMutableTreeNode discrete = new DefaultMutableTreeNode("Discrete mathematics");
                        DefaultMutableTreeNode adm = new DefaultMutableTreeNode("Application of discrete mathematics");
                        DefaultMutableTreeNode adf = new DefaultMutableTreeNode("Discrete analysis");
                    DefaultMutableTreeNode graph = new DefaultMutableTreeNode("Graph theory");
                        DefaultMutableTreeNode gtp = new DefaultMutableTreeNode("Graph theory in practice");
                    DefaultMutableTreeNode linear = new DefaultMutableTreeNode("Linear Algebra");
                DefaultMutableTreeNode inspirational = new DefaultMutableTreeNode("Inspirational");
                    DefaultMutableTreeNode fm = new DefaultMutableTreeNode("Surely you're joking mr. Feynmann");
                    DefaultMutableTreeNode aa = new DefaultMutableTreeNode("In the mind of Albert Einstein");
                    DefaultMutableTreeNode ac = new DefaultMutableTreeNode("Unfuck yourself");
            
            root.add(programming);
                programming.add(java);
                    java.add(concurrency);
                    java.add(dsa);
                    java.add(reflection);
                programming.add(sql);
                    sql.add(gis);
                root.add(math);
                    math.add(discrete);
                        discrete.add(adm);
                        discrete.add(adf);
                    math.add(graph);
                        graph.add(gtp);
                    math.add(linear);
                root.add(inspirational);
                    inspirational.add(fm);
                    inspirational.add(aa);
                    inspirational.add(ac);
                    
                    
                    
                    
          return root;
    }

    private static void saveToFile(DefaultMutableTreeNode root, String filename) throws FileNotFoundException, IOException {
         FileOutputStream fos = new FileOutputStream(new File(filename + ".bin"));
         ObjectOutputStream oos = new ObjectOutputStream(fos);
         
         oos.writeObject(root);
         oos.flush();
         oos.close();
    }
    
    private static DefaultMutableTreeNode getFromFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(new File(fileName + ".bin"));
        ObjectInputStream ois = new ObjectInputStream(fis);
        System.out.println("::::: Tree from file!");
        return (DefaultMutableTreeNode) ois.readObject();
    }
    
    private static void saveTreeNodeToXMLBean(DefaultMutableTreeNode root, String filename) throws FileNotFoundException{
        XMLEncoder enc = new XMLEncoder(new FileOutputStream(new File(filename + ".xml")));
        enc.writeObject(root);
        enc.flush();
        enc.close();
        }  
    
    private static DefaultMutableTreeNode getTreeNodeFromXML(String filename) throws FileNotFoundException{
        XMLDecoder dec = new XMLDecoder(new FileInputStream(new File(filename + ".xml")));
        DefaultMutableTreeNode out = (DefaultMutableTreeNode) dec.readObject();
        dec.close();
        return out;
        }   
    
    
    private static void saveObjectToXML(Object obj, String filename) throws FileNotFoundException{
        try (XMLEncoder enc = new XMLEncoder(new FileOutputStream(new File(filename + ".xml")))) {
            enc.writeObject(obj);
            enc.flush();
        }
     }  
    
    private static Object getObjectFromXML(String filename) throws FileNotFoundException{
        Object obj;
        try (XMLDecoder dec = new XMLDecoder(new FileInputStream(new File(filename + ".xml")))) {
            obj = dec.readObject();
        }
        return obj;
    }  
    
    
}


