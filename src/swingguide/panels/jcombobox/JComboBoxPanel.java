/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swingguide.panels.jcombobox;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.AbstractAction;
import swingguide.helpers.ComponentPanel;
import swingguide.helpers.ComponentTemplate;
import swingguide.helpers.EventButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

/**
 *
 * @author Light
 */
public class JComboBoxPanel extends ComponentTemplate {

    private JComboBox jComboBox1;
    private JComboBoxPanel jComboBoxPanel;

    public JComboBoxPanel() {
        super();

        jComboBox1 = new JComboBox();

        primaryComponent = jComboBox1;
    }

    @Override
    protected String getPrimaryComponentPanelTitle() {
        return "JComboBox";
    }

    @Override
    protected void customSetup() {
        componentPanels.add(new JComboBoxPanel_01_Elements());
        componentPanels.add(new JComboBoxPanel_02_Selection());
        componentPanels.add(new JComboBoxPanel_03_RendererAndEditor());
        componentPanels.add(new JComboBoxPanel_04_UIModifications());
        componentPanels.add(new JComboBoxPanel_05_Other());

        for (ComponentPanel compPanel : componentPanels) {
            compPanel.setup(jComboBox1, this);
            getTabbedPane().addTab(compPanel.getTitle(), compPanel);
        }

        jSplitPaneComponent.setDividerLocation(480);
    }

    @Override
    protected void setupEventLabels() {

        for (int index = 0; index < 12; index++) {
            eventButtons.add(new EventButton());
        }

        visibleEventButtons.addAll(eventButtons);
        
        //Action Fired
        jComboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                eventFiredActions(eventButtons.get(0), evt);
            }
        });
        eventButtons.get(0).setButtonAction(new AbstractAction("Action Fired") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Action Fired  */\n\n"
                        + "jComboBox1.addActionListener(new ActionListener() {\n"
                        + "    @Override\n"
                        + "    public void actionPerformed(ActionEvent evt) {\n"
                        + "        System.out.println(\"Action Command: \" + evt.getActionCommand());\n"
                        + "        System.out.println(\"Modifier Keys\");\n"
                        + "        System.out.println(\"    SHIFT: \" + ((evt.getModifiers()& ActionEvent.SHIFT_MASK)>0));\n"
                        + "        System.out.println(\"     CTRL: \" + ((evt.getModifiers()& ActionEvent.CTRL_MASK)>0));\n"
                        + "        System.out.println(\"     META: \" + ((evt.getModifiers()& ActionEvent.META_MASK)>0));\n"
                        + "        System.out.println(\"      ALT: \" + ((evt.getModifiers()& ActionEvent.ALT_MASK)>0));\n"
                        + "        System.out.println(\"Timestamp of when this occured: \" + (new Date(evt.getWhen())));\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Item Selection Changed
        jComboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                eventFiredActions(eventButtons.get(1), evt);
            }
        });
        eventButtons.get(1).setButtonAction(new AbstractAction("Item Selection Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Item Selection Changed  */\n\n"
                        + "jComboBox1.addItemListener(new ItemListener() {\n"
                        + "    @Override\n"
                        + "    public void itemStateChanged(ItemEvent evt) {\n"
                        + "        System.out.println(\"Item: \" + evt.getPropertyName());\n"
                        + "        \n"
                        + "        String stateString = \"unknown\";\n"
                        + "        if(state == ItemEvent.SELECTED){\n"
                        + "            stateString = \"SELECTED\";\n"
                        + "        }else if(state == ItemEvent.DESELECTED){\n"
                        + "            stateString = \"DESELECTED\";\n"
                        + "        }\n"
                        + "        \n"
                        + "        System.out.println(\"State Change: \" + stateString);\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Popup Menu will become Visible
        jComboBox1.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent evt) {
                eventFiredActions(eventButtons.get(2), evt);
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent evt) {
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent evt) {
            }
        });
        eventButtons.get(2).setButtonAction(new AbstractAction("Popup Menu will become Visible") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Popup Menu will become Visible  */\n\n"
                        + "jComboBox1.addPopupMenuListener(new PopupMenuListener() {\n"
                        + "    @Override\n"
                        + "    public void popupMenuWillBecomeVisible(PopupMenuEvent evt) {\n"
                        + "        System.out.println(\"Source (hash): \" + evt.getSource().getClass().getSimpleName() + \"(\" + evt.getSource().hashCode() + \")\");\n"
                        + "    }\n"
                        + "    @Override\n"
                        + "    public void popupMenuWillBecomeInvisible(PopupMenuEvent evt) {\n"
                        + "    }\n"
                        + "    @Override\n"
                        + "    public void popupMenuCanceled(PopupMenuEvent evt) {\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Popup Menu will become Invisible
        jComboBox1.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent evt) {
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent evt) {
                eventFiredActions(eventButtons.get(3), evt);
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent evt) {
            }
        });
        eventButtons.get(3).setButtonAction(new AbstractAction("Popup Menu will become Invisible") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Popup Menu will become Invisible  */\n\n"
                        + "jComboBox1.addPopupMenuListener(new PopupMenuListener() {\n"
                        + "    @Override\n"
                        + "    public void popupMenuWillBecomeVisible(PopupMenuEvent evt) {\n"
                        + "    }\n"
                        + "    @Override\n"
                        + "    public void popupMenuWillBecomeInvisible(PopupMenuEvent evt) {\n"
                        + "        System.out.println(\"Source (hash): \" + evt.getSource().getClass().getSimpleName() + \"(\" + evt.getSource().hashCode() + \")\");\n"
                        + "    }\n"
                        + "    @Override\n"
                        + "    public void popupMenuCanceled(PopupMenuEvent evt) {\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Popup Menu is Canceled
        jComboBox1.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent evt) {
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent evt) {
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent evt) {
                eventFiredActions(eventButtons.get(4), evt);
            }
        });
        eventButtons.get(4).setButtonAction(new AbstractAction("Popup Menu is Canceled") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Popup Menu is Canceled  */\n\n"
                        + "jComboBox1.addPopupMenuListener(new PopupMenuListener() {\n"
                        + "    @Override\n"
                        + "    public void popupMenuWillBecomeVisible(PopupMenuEvent evt) {\n"
                        + "    }\n"
                        + "    @Override\n"
                        + "    public void popupMenuWillBecomeInvisible(PopupMenuEvent evt) {\n"
                        + "    }\n"
                        + "    @Override\n"
                        + "    public void popupMenuCanceled(PopupMenuEvent evt) {\n"
                        + "        System.out.println(\"Source (hash): \" + evt.getSource().getClass().getSimpleName() + \"(\" + evt.getSource().hashCode() + \")\");\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //List Interval Added
        jComboBox1.getModel().addListDataListener(new ListDataListener() {
            @Override
            public void intervalAdded(ListDataEvent evt) {
                eventFiredActions(eventButtons.get(5), evt);
            }

            @Override
            public void intervalRemoved(ListDataEvent evt) {
            }

            @Override
            public void contentsChanged(ListDataEvent evt) {
            }
        });
        eventButtons.get(5).setButtonAction(new AbstractAction("List Interval Added") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  List Interval Added  */\n\n"
                        + "jComboBox1.addListDataListener(new ListDataListener() {\n"
                        + "    @Override\n"
                        + "    public void intervalAdded(ListDataEvent evt) {\n"
                        + "    }\n"
                        + "    @Override\n"
                        + "    public void intervalRemoved(ListDataEvent evt) {\n"
                        + "    }\n"
                        + "    @Override\n"
                        + "    public void contentsChanged(ListDataEvent evt) {\n"
                        + "        System.out.println(\"Type: \" + evt.getType());\n"
                        + "        System.out.println(\"Lower Index: \" + evt.getIndex0());\n"
                        + "        System.out.println(\"Upper Index: \" + evt.getIndex1());\n"
                        + "    }\n"
                        + "});\n"
                        + "\n"
                        + "\n"
                        + "/*\n"
                        + "Type Values:\n"
                        + "    ListDataEvent.CONTENTS_CHANGED = 0\n"
                        + "    ListDataEvent.INTERVAL_ADDED = 1\n"
                        + "    ListDataEvent.INTERVAL_REMOVED = 2\n"
                        + "*/\n"
                );
            }
        });

        //List Interval Removed
        jComboBox1.getModel().addListDataListener(new ListDataListener() {
            @Override
            public void intervalAdded(ListDataEvent evt) {
            }

            @Override
            public void intervalRemoved(ListDataEvent evt) {
                eventFiredActions(eventButtons.get(6), evt);
            }

            @Override
            public void contentsChanged(ListDataEvent evt) {
            }
        });
        eventButtons.get(6).setButtonAction(new AbstractAction("List Interval Removed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  List Interval Removed  */\n\n"
                        + "jComboBox1.getModel().addListDataListener(new ListDataListener() {\n"
                        + "    @Override\n"
                        + "    public void intervalAdded(ListDataEvent evt) {\n"
                        + "    }\n"
                        + "    @Override\n"
                        + "    public void intervalRemoved(ListDataEvent evt) {\n"
                        + "        System.out.println(\"Type: \" + evt.getType());\n"
                        + "        System.out.println(\"Lower Index: \" + evt.getIndex0());\n"
                        + "        System.out.println(\"Upper Index: \" + evt.getIndex1());\n"
                        + "    }\n"
                        + "    @Override\n"
                        + "    public void contentsChanged(ListDataEvent evt) {\n"
                        + "    }\n"
                        + "});\n"
                        + "\n"
                        + "\n"
                        + "/*\n"
                        + "Type Values:\n"
                        + "    ListDataEvent.CONTENTS_CHANGED = 0\n"
                        + "    ListDataEvent.INTERVAL_ADDED = 1\n"
                        + "    ListDataEvent.INTERVAL_REMOVED = 2\n"
                        + "*/\n"
                );
            }
        });

        //List Contents Changed
        jComboBox1.getModel().addListDataListener(new ListDataListener() {
            @Override
            public void intervalAdded(ListDataEvent evt) {
            }

            @Override
            public void intervalRemoved(ListDataEvent evt) {
            }

            @Override
            public void contentsChanged(ListDataEvent evt) {
                eventFiredActions(eventButtons.get(7), evt);
            }
        });
        eventButtons.get(7).setButtonAction(new AbstractAction("List Contents Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  List Contents Changed  */\n\n"
                        + "jComboBox1.getModel().addListDataListener(new ListDataListener() {\n"
                        + "    @Override\n"
                        + "    public void intervalAdded(ListDataEvent evt) {\n"
                        + "    }\n"
                        + "    @Override\n"
                        + "    public void intervalRemoved(ListDataEvent evt) {\n"
                        + "    }\n"
                        + "    @Override\n"
                        + "    public void contentsChanged(ListDataEvent evt) {\n"
                        + "        System.out.println(\"Type: \" + evt.getType());\n"
                        + "        System.out.println(\"Lower Index: \" + evt.getIndex0());\n"
                        + "        System.out.println(\"Upper Index: \" + evt.getIndex1());\n"
                        + "    }\n"
                        + "});\n"
                        + "\n"
                        + "\n"
                        + "/*\n"
                        + "Type Values:\n"
                        + "    ListDataEvent.CONTENTS_CHANGED = 0\n"
                        + "    ListDataEvent.INTERVAL_ADDED = 1\n"
                        + "    ListDataEvent.INTERVAL_REMOVED = 2\n"
                        + "*/\n"
                );
            }
        });

        //Editor Action Fired
        jComboBox1.getEditor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                eventFiredActions(eventButtons.get(8), evt);
            }
        });
        eventButtons.get(8).setButtonAction(new AbstractAction("Editor Action Fired") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Editor Action Fired  */\n\n"
                        + "jComboBox1.getEditor().addActionListener(new ActionListener() {\n"
                        + "    @Override\n"
                        + "    public void actionPerformed(ActionEvent evt) {\n"
                        + "        System.out.println(\"Action Command: \" + evt.getActionCommand());\n"
                        + "        System.out.println(\"Modifier Keys\");\n"
                        + "        System.out.println(\"    SHIFT: \" + ((evt.getModifiers()& ActionEvent.SHIFT_MASK)>0));\n"
                        + "        System.out.println(\"     CTRL: \" + ((evt.getModifiers()& ActionEvent.CTRL_MASK)>0));\n"
                        + "        System.out.println(\"     META: \" + ((evt.getModifiers()& ActionEvent.META_MASK)>0));\n"
                        + "        System.out.println(\"      ALT: \" + ((evt.getModifiers()& ActionEvent.ALT_MASK)>0));\n"
                        + "        System.out.println(\"Timestamp of when this occured: \" + (new Date(evt.getWhen())));\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Light Weight Popup Flag Changed
        jComboBox1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo("lightWeightPopupEnabled") == 0) {
                    eventFiredActions(eventButtons.get(9), evt);
                }
            }
        });
        eventButtons.get(9).setButtonAction(new AbstractAction("Light Weight Popup Flag Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Light Weight Popup Flag Changed  */\n\n"
                        + "jComboBox1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(\"lightWeightPopupEnabled\") == 0) {\n"
                        + "            System.out.println(\"New \\\"Light Weight Popup Enabled\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Light Weight Popup Enabled\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Width changed due to Prototype Display Value Changed
        jComboBox1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo("prototypeDisplayValue") == 0) {
                    eventFiredActions(eventButtons.get(10), evt);
                }
            }
        });
        eventButtons.get(10).setButtonAction(new AbstractAction("Width changed due to Prototype Display Value Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Width changed due to Prototype Display Value Changed  */\n\n"
                        + "jComboBox1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(\"prototypeDisplayValue\") == 0) {\n"
                        + "            System.out.println(\"New \\\"Prototype Display\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Prototype Display\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Action Changed
        jComboBox1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo("action") == 0) {
                    eventFiredActions(eventButtons.get(11), evt);
                }
            }
        });
        eventButtons.get(11).setButtonAction(new AbstractAction("Action Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Action Changed  */\n\n"
                        + "jComboBox1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(\"action\") == 0) {\n"
                        + "            System.out.println(\"New \\\"Action\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Action\\\" Value: \" + evt.getOldValue());\n"
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
            java.util.logging.Logger.getLogger(JComboBoxPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JComboBoxPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JComboBoxPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JComboBoxPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                JComboBoxPanel panel = new JComboBoxPanel();
                frame.add(panel);
                frame.setTitle("JComboBox Example");
                frame.setSize(1200, 950);
                panel.additionalSetup();
                frame.setVisible(true);
            }
        });
    }
}
