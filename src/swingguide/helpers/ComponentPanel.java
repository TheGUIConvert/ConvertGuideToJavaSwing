/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swingguide.helpers;

import java.awt.Component;

/**
 *
 * @author Light
 */
public abstract class ComponentPanel extends javax.swing.JPanel {
    abstract public String getTitle();
    abstract public void setup(Component primaryComponent, ComponentTemplate componentTemplate);
    public void processMessage(int message, Object parameter){
        
    }
}
