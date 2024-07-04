/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swingguide.panels.jlabel;

import swingguide.helpers.ComponentPanel;
import swingguide.helpers.ComponentTemplate;
import swingguide.helpers.EventButton;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author Light
 */
public class JLabelPanel extends ComponentTemplate{

    private JLabel jLabel1;
    
    public JLabelPanel() {
        super();
        
        jLabel1 = new JLabel("JLabel Text");
        
        primaryComponent = jLabel1;
    }
    
    
    @Override
    protected String getPrimaryComponentPanelTitle() {
        return "JLabel";
    }
    
    @Override
    protected void customSetup() {
        componentPanels.add(new JLabelPanel_01_TextAndIcons());
        componentPanels.add(new JLabelPanel_02_Alignment());
        componentPanels.add(new JLabelPanel_03_State());
        componentPanels.add(new JLabelPanel_04_OverallLook());
        componentPanels.add(new JLabelPanel_05_Mnemonic());
        
        for (ComponentPanel compPanel : componentPanels) {
            compPanel.setup(jLabel1, this);
            getTabbedPane().addTab(compPanel.getTitle(),compPanel);
        }

        jSplitPaneComponent.setDividerLocation(450);
    }
    
    @Override
    protected void setupEventLabels() {

        for(int index = 0; index < 11; index++){
            eventButtons.add(new EventButton());
        }
        
        visibleEventButtons.addAll(eventButtons);
        
        //Text Changed
        jLabel1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo("text") == 0) {
                    eventFiredActions(eventButtons.get(0), evt);
                }
            }
        });
        eventButtons.get(0).setButtonAction(new AbstractAction("Text Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Text Changed  */\n\n"
                        + "jLabel1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(\"text\") == 0) {\n"
                        + "            System.out.println(\"New \\\"Text\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Text\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Icon Changed
        jLabel1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo("icon") == 0) {
                    eventFiredActions(eventButtons.get(1), evt);
                }
            }
        });
        eventButtons.get(1).setButtonAction(new AbstractAction("Icon Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Icon Changed  */\n\n"
                        + "jLabel1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(\"icon\") == 0) {\n"
                        + "            System.out.println(\"New \\\"Icon\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Icon\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Disabled Icon Changed
        jLabel1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo("disabledIcon") == 0) {
                    eventFiredActions(eventButtons.get(2), evt);
                }
            }
        });
        eventButtons.get(2).setButtonAction(new AbstractAction("Disabled Icon Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Disabled Icon Changed  */\n\n"
                        + "jLabel1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(\"disabledIcon\") == 0) {\n"
                        + "            System.out.println(\"New \\\"Disabled Icon\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Disabled Icon\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Displayed Mnemonic State Changed
        jLabel1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo("displayedMnemonic") == 0) {
                    eventFiredActions(eventButtons.get(3), evt);
                }
            }
        });
        eventButtons.get(3).setButtonAction(new AbstractAction("Displayed Mnemonic State Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Displayed Mnemonic State Changed  */\n\n"
                        + "jLabel1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(\"displayedMnemonic\") == 0) {\n"
                        + "            System.out.println(\"New \\\"Displayed Mnemonic\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Displayed Mnemonic\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Displayed Mnemonic Index Changed
        jLabel1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo("displayedMnemonicIndex") == 0) {
                    eventFiredActions(eventButtons.get(4), evt);
                }
            }
        });
        eventButtons.get(4).setButtonAction(new AbstractAction("Displayed Mnemonic Index Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Displayed Mnemonic Index Changed  */\n\n"
                        + "jLabel1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(\"displayedMnemonicIndex\") == 0) {\n"
                        + "            System.out.println(\"New \\\"Displayed Mnemonic Index\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Displayed Mnemonic Index\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Icon Text Gap Changed
        jLabel1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo("iconTextGap") == 0) {
                    eventFiredActions(eventButtons.get(5), evt);
                }
            }
        });
        eventButtons.get(5).setButtonAction(new AbstractAction("Icon Text Gap Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Icon Text Gap Changed  */\n\n"
                        + "jLabel1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(\"iconTextGap\") == 0) {\n"
                        + "            System.out.println(\"New \\\"Icon Text Gap\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Icon Text Gap\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Horizontal Alignment Changed
        jLabel1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo("horizontalAlignment") == 0) {
                    eventFiredActions(eventButtons.get(6), evt);
                }
            }
        });
        eventButtons.get(6).setButtonAction(new AbstractAction("Horizontal Alignment Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Horizontal Alignment Changed  */\n\n"
                        + "jLabel1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(\"horizontalAlignment\") == 0) {\n"
                        + "            System.out.println(\"New \\\"Horizontal Alignment\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Horizontal Alignment\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Vertical Alignment Changed
        jLabel1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo("verticalAlignment") == 0) {
                    eventFiredActions(eventButtons.get(7), evt);
                }
            }
        });
        eventButtons.get(7).setButtonAction(new AbstractAction("Vertical Alignment Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Vertical Alignment Changed  */\n\n"
                        + "jLabel1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(\"verticalAlignment\") == 0) {\n"
                        + "            System.out.println(\"New \\\"Vertical Alignment\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Vertical Alignment\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Horizontal Text Position Changed
        jLabel1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo("horizontalTextPosition") == 0) {
                    eventFiredActions(eventButtons.get(8), evt);
                }
            }
        });
        eventButtons.get(8).setButtonAction(new AbstractAction("Horizontal Text Position Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Horizontal Text Position Changed  */\n\n"
                        + "jLabel1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(\"horizontalTextPosition\") == 0) {\n"
                        + "            System.out.println(\"New \\\"Horizontal Text Position\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Horizontal Text Position\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Vertical Text Position Changed
        jLabel1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo("verticalTextPosition") == 0) {
                    eventFiredActions(eventButtons.get(9), evt);
                }
            }
        });
        eventButtons.get(9).setButtonAction(new AbstractAction("Vertical Text Position Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Vertical Text Position Changed  */\n\n"
                        + "jLabel1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(\"verticalTextPosition\") == 0) {\n"
                        + "            System.out.println(\"New \\\"Vertical Text Position\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Vertical Text Position\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Label For Changed
        jLabel1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo("labelFor") == 0) {
                    eventFiredActions(eventButtons.get(10), evt);
                }
            }
        });
        eventButtons.get(10).setButtonAction(new AbstractAction("Label For Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Label For Changed  */\n\n"
                        + "jLabel1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(\"labelFor\") == 0) {\n"
                        + "            System.out.println(\"New \\\"Label For\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Label For\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });


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
            java.util.logging.Logger.getLogger(JLabelPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JLabelPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JLabelPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JLabelPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                JLabelPanel panel = new JLabelPanel();
                frame.add(panel);
                frame.setTitle("JLabel Example");
                frame.setSize(1200, 950);
                panel.additionalSetup();
                frame.setVisible(true);
            }
        });
    }
}
