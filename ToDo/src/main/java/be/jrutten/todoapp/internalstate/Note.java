/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.jrutten.todoapp.internalstate;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Jrutt
 */


class Note implements java.io.Serializable{
    final long serialVersionUID = 20220216L;
    private static long lastId = 0;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long note_id;
    
    private Date date;
    private long person_id;
    private String text;
    
    

    public Note(){}
    
    public Note(long person_id, String text){
        this.date = Date.from(Instant.now());
        this.person_id = person_id;
        this.text = text;
        this.note_id = ++lastId;
    }

    public static long getLastId() {
        return lastId;
    }

    public static void setLastId(long lastId) {
        Note.lastId = lastId;
    }

    public long getNote_id() {
        return note_id;
    }

    public void setNote_id(long note_id) {
        this.note_id = note_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getPerson() {
        return person_id;
    }

    public void setPerson(long person_id) {
        this.person_id = person_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (this.note_id ^ (this.note_id >>> 32));
        hash = 29 * hash + Objects.hashCode(this.person_id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Note other = (Note) obj;
        if (this.note_id != other.note_id) {
            return false;
        }
        return true;
    }
    
    
    
    

}
