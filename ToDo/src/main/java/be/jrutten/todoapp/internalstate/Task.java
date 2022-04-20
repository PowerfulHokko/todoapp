/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.jrutten.todoapp.internalstate;

import java.time.Instant;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Jrutt
 */

//bean
public class Task {
    private static long lastTaskId = -1;
    
    
    //must
    private long task_id;
    private String name;
    private Date enteredAt;
    
    
    //optional
    private Date doneAt;
    private Person submitter;
    private Person doneBy;
    private boolean isDone = false;
    private List<Note> notes;
    
    public Task(){
        System.out.println("be.jrutten.todoapp.internalstate.Task\tmethod=="+ "constructor");
    }
    
    public Task(String name){
        System.out.println("be.jrutten.todoapp.internalstate.Task\tmethod=="+ "constructor");
        this.name = name;
        this.task_id = getLastTaskId()+1;
             Task.lastTaskId += 1;
        this.enteredAt = Date.from(Instant.now());
    }
    
    public static long getLastTaskId(){
        System.out.println("be.jrutten.todoapp.internalstate.Task\tmethod=="+ "getLastTaskId");
        if(Task.lastTaskId != -1) return Task.lastTaskId;
        
        for(String catName : InternalListCollection.getCategories().keySet()){
            for(Long taskId : InternalListCollection.getCategories().get(catName).getToDo().keySet()){
                if(taskId > Task.lastTaskId) lastTaskId = taskId;
            }
        }
        
        //if(Task.lastTaskId == -1) Task.lastTaskId = 0;
        System.out.println("LastTaskId=" + Task.lastTaskId);
        return Task.lastTaskId;
    }

    public long getTask_id() {
        System.out.println("be.jrutten.todoapp.internalstate.Task\tmethod=="+ "getTask_id");
        return task_id;
    }

    public void setTask_id(long task_id) {
        System.out.println("be.jrutten.todoapp.internalstate.Task\tmethod=="+ "setTask_id");
        this.task_id = task_id;
    }

    public String getName() {
        System.out.println("be.jrutten.todoapp.internalstate.Task\tmethod=="+ "getName");
        return name;
    }

    public void setName(String name) {
        System.out.println("be.jrutten.todoapp.internalstate.Task\tmethod=="+ "setName");
        this.name = name;
    }

    public Date getEnteredAt() {
        System.out.println("be.jrutten.todoapp.internalstate.Task\tmethod=="+ "getEnteredAt");
        return enteredAt;
    }

    public void setEnteredAt(Date enteredAt) {        
        System.out.println("be.jrutten.todoapp.internalstate.Task\tmethod=="+ "setEnteredAt");
        this.enteredAt = enteredAt;
    }

    public Date getDoneAt() {
        System.out.println("be.jrutten.todoapp.internalstate.Task\tmethod=="+ "getDoneAt");
        return doneAt;
    }

    public void setDoneAt(Date doneAt) {
        System.out.println("be.jrutten.todoapp.internalstate.Task\tmethod=="+ "setDoneAt");
        this.doneAt = doneAt;
    }

    public Person getSubmitter() {
        System.out.println("be.jrutten.todoapp.internalstate.Task\tmethod=="+ "getSubmitter");
        return submitter;
    }

    public void setSubmitter(Person submitter) {
        System.out.println("be.jrutten.todoapp.internalstate.Task\tmethod=="+ "setSubmitter");
        this.submitter = submitter;
    }

    public Person getDoneBy() {
        System.out.println("be.jrutten.todoapp.internalstate.Task\tmethod=="+ "getDoneBy");
        return doneBy;
    }

    public void setDoneBy(Person doneBy) {
        System.out.println("be.jrutten.todoapp.internalstate.Task\tmethod=="+ "setDoneBy");
        this.doneBy = doneBy;
    }

    public boolean isIsDone() {
        System.out.println("be.jrutten.todoapp.internalstate.Task\tmethod==" + "isDone");
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        System.out.println("be.jrutten.todoapp.internalstate.Task\tmethod=="+ "setIsDone");
        this.isDone = isDone;
    }

    public List<Note> getNotes() {
        System.out.println("be.jrutten.todoapp.internalstate.Task\tmethod=="+ "getNotes");
        return notes;
    }

    public void setNotes(List<Note> notes) {
        System.out.println("be.jrutten.todoapp.internalstate.Task\tmethod=="+ "setNotes");
        this.notes = notes;
    }
    
    
    
    
}
