/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swingguide.panels.jscrollpane;

import swingguide.helpers.ComponentPanel;
import swingguide.helpers.ComponentTemplate;
import swingguide.helpers.EventButton;
import java.awt.GridBagConstraints;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Light
 */
public class JScrollPanePanel extends ComponentTemplate{

    private JScrollPane jScrollPane1;
    private JScrollPanePanel jScrollPanePanel;
    
    public JScrollPanePanel() {
        super();
        
        jScrollPane1 = new JScrollPane();

        primaryComponent = jScrollPane1;

        constraints = new GridBagConstraints();
        ((GridBagConstraints)constraints).gridx = 0;
        ((GridBagConstraints)constraints).gridy = 0;
        ((GridBagConstraints)constraints).fill = java.awt.GridBagConstraints.BOTH;
        ((GridBagConstraints)constraints).anchor = java.awt.GridBagConstraints.NORTHWEST;
        ((GridBagConstraints)constraints).weightx = 100.0;
        ((GridBagConstraints)constraints).weighty = 100.0;
        ((GridBagConstraints)constraints).insets = new java.awt.Insets(10, 10, 10, 10);
    }
   
    @Override
    protected String getPrimaryComponentPanelTitle() {
        return "JScrollPane";
    }
    
    @Override
    protected void customSetup() {
        componentPanels.add(new JScrollPanePanel_01_Viewport());
        componentPanels.add(new JScrollPanePanel_02_RowHeader());
        componentPanels.add(new JScrollPanePanel_03_ColumnHeader());
        componentPanels.add(new JScrollPanePanel_04_Corners());
        componentPanels.add(new JScrollPanePanel_05_Scrolling());
        componentPanels.add(new JScrollPanePanel_06_OverllLook());
        componentPanels.add(new JScrollPanePanel_07_Disable());
        componentPanels.add(new JScrollPanePanel_08_Other());

        for (ComponentPanel compPanel : componentPanels) {
            compPanel.setup(jScrollPane1, this);
            getTabbedPane().addTab(compPanel.getTitle(), compPanel);
        }

        jSplitPaneComponent.setDividerLocation(480);
    }
    
    @Override
    protected void setupEventLabels() {

        for(int index = 0; index < 13; index++){
            eventButtons.add(new EventButton());
        }
        
        visibleEventButtons.addAll(eventButtons);
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JScrollPanePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JScrollPanePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JScrollPanePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JScrollPanePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                JScrollPanePanel panel = new JScrollPanePanel();
                frame.add(panel);
                frame.setTitle("JScrollPane Example");
                frame.setSize(1200, 950);
                panel.additionalSetup();
                frame.setVisible(true);
            }
        });
    }
}
