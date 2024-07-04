/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package swingguide.panels.jscrollpane;

import swingguide.helpers.ComponentPanel;
import swingguide.helpers.ComponentTemplate;
import java.awt.Component;
import javax.swing.JScrollPane;

/**
 *
 * @author Light
 */
public class JScrollPanePanel_08_Other extends ComponentPanel {

    private int itemCounter = 0;
    
    private JScrollPane jScrollPane1;
    private JScrollPanePanel jScrollPanePanel;
    
    /**
     * Creates new form NewJPanel
     */
    public JScrollPanePanel_08_Other() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 262, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    private String getNextItemPrefix(){
        String prefix = "";
        int tempCounter = itemCounter;
        do{
            int temp = tempCounter % 26;
            tempCounter = (tempCounter-temp)/26;
            if(temp >= 0){
                prefix = ((char)(temp+65))+prefix; 
            }
        }while(tempCounter > 0);
        itemCounter++;
        return prefix+" - ";
    }
    
    @Override
    public String getTitle() {
        return "Other";
    }
    
    @Override
    public void setup(Component primaryComponent, ComponentTemplate componentTemplate) {
        
        jScrollPane1 = (JScrollPane)primaryComponent;
        jScrollPanePanel = (JScrollPanePanel)componentTemplate;

        
    }
}