/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.jrutten.ideatesting;

/**
 *
 * @author Jrutt
 */
public class TestObject implements java.io.Serializable {
    private String valName;
    private int value;
    
    public TestObject(){};

    public String getValName() {
        return valName;
    }

    public void setValName(String valName) {
        this.valName = valName;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
}
