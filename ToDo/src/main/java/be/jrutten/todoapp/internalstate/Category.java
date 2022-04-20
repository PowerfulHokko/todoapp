/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.jrutten.todoapp.internalstate;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jrutt
 */

//isBean
public class Category {
    private String name;
    private Map<Long, Task> toDo;
    

    public Category(){
        System.out.println("be.jrutten.todoapp.internalstate.Category\t method == " + "constructor()");
        this.name = "undefined";
        this.toDo = new HashMap<>();
       
    }
    
    public Category(String name){
        System.out.println("be.jrutten.todoapp.internalstate.Category\t method == " + "constructor(" + name +")");
        this.name = name;
        this.toDo = new HashMap<>();
    }

    public String getName() {
        System.out.println("be.jrutten.todoapp.internalstate.Category\t $Instance=" + this.name + "\tmethod == " + "getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println("be.jrutten.todoapp.internalstate.Category\t $Instance=" + this.name + "\tmethod == " + "setName()");
        this.name = name;
    }

    public Map<Long, Task> getToDo() {
        System.out.println("be.jrutten.todoapp.internalstate.Category\t $Instance=" + this.name + "\tmethod == " + "getToDo()");
        return toDo;
    }

    public void setToDo(Map<Long, Task> toDo) {
        System.out.println("be.jrutten.todoapp.internalstate.Category\t $Instance=" + this.name + "\tmethod == " + "setToDo()");
        this.toDo = toDo;
    }


    
    
            
}
