/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swingguide.panels.jbutton;

import swingguide.helpers.ComponentPanel;
import swingguide.helpers.ComponentTemplate;
import swingguide.helpers.EventButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Light
 */
public class JButtonPanel extends ComponentTemplate{

    final static int EVALUATE_STATE = 0;
    
    private JButton jButton1;
    
    public JButtonPanel() {
        super();
        
        jButton1 = new JButton("JButton");
        
        primaryComponent = jButton1;
    }
   
    @Override
    protected String getPrimaryComponentPanelTitle() {
        return "JButton";
    }
    
    @Override
    protected void customSetup() {
        componentPanels.add(new JButtonPanel_01_TextAndIcons());
        componentPanels.add(new JButtonPanel_02_Alignment());
        componentPanels.add(new JButtonPanel_03_State());
        componentPanels.add(new JButtonPanel_04_OverallLook());
        componentPanels.add(new JButtonPanel_05_Other());
        
        for (ComponentPanel compPanel : componentPanels) {
            compPanel.setup(jButton1, this);
            getTabbedPane().addTab(compPanel.getTitle(),compPanel);
        }

        jButton1.getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sendMessage(EVALUATE_STATE, null);
            }
        });
        
        jSplitPaneComponent.setDividerLocation(450);
        
        sendMessage(EVALUATE_STATE, null);
    }
    
    @Override
    protected void setupEventLabels() {

        for(int index = 0; index < 27; index++){
            eventButtons.add(new EventButton());
        }
        
        visibleEventButtons.addAll(eventButtons);

        //Action Fired
        jButton1.addActionListener(new ActionListener() {
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
                        + "jButton1.addActionListener(new ActionListener() {\n"
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

        //Change Listener
        jButton1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent evt) {
                eventFiredActions(eventButtons.get(1), evt);
            }
        });
        eventButtons.get(1).setButtonAction(new AbstractAction("Change Listener") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Change Listener  */\n\n"
                        + "jButton1.addChangeListener(new ChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void stateChanged(ChangeEvent evt) {\n"
                        + "        System.out.println(\"Source (hash): \" + evt.getSource().getClass().getSimpleName() + \"(\" + evt.getSource().hashCode() + \")\");\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Item Listener
        jButton1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                eventFiredActions(eventButtons.get(2), evt);
            }
        });
        eventButtons.get(2).setButtonAction(new AbstractAction("Item Listener") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Item Listener  */\n\n"
                        + "jButton1.addItemListener(new ItemListener() {\n"
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
                        + "\n"
                        + "\n"
                        + "/*\n"
                        + "Notes:\n"
                        + "    Doesn't do much for JButton ... see JToggleButton\n"
                        + "*/\n"
                );
            }
        });

        //Text Changed
        jButton1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo(AbstractButton.TEXT_CHANGED_PROPERTY) == 0) {
                    eventFiredActions(eventButtons.get(3), evt);
                }
            }
        });
        eventButtons.get(3).setButtonAction(new AbstractAction("Text Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Text Changed  */\n\n"
                        + "jButton1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(AbstractButton.TEXT_CHANGED_PROPERTY) == 0) {\n"
                        + "            System.out.println(\"New \\\"Text Changed\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Text Changed\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Icon Changed
        jButton1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo(AbstractButton.ICON_CHANGED_PROPERTY) == 0) {
                    eventFiredActions(eventButtons.get(4), evt);
                }
            }
        });
        eventButtons.get(4).setButtonAction(new AbstractAction("Icon Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Icon Changed  */\n\n"
                        + "jButton1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(AbstractButton.ICON_CHANGED_PROPERTY) == 0) {\n"
                        + "            System.out.println(\"New \\\"Icon Changed\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Icon Changed\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Pressed Icon Changed
        jButton1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo(AbstractButton.PRESSED_ICON_CHANGED_PROPERTY) == 0) {
                    eventFiredActions(eventButtons.get(5), evt);
                }
            }
        });
        eventButtons.get(5).setButtonAction(new AbstractAction("Pressed Icon Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Pressed Icon Changed  */\n\n"
                        + "jButton1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(AbstractButton.PRESSED_ICON_CHANGED_PROPERTY) == 0) {\n"
                        + "            System.out.println(\"New \\\"Pressed Icon\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Pressed Icon\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Rollover Icon Changed
        jButton1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo(AbstractButton.ROLLOVER_ICON_CHANGED_PROPERTY) == 0) {
                    eventFiredActions(eventButtons.get(6), evt);
                }
            }
        });
        eventButtons.get(6).setButtonAction(new AbstractAction("Rollover Icon Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Rollover Icon Changed  */\n\n"
                        + "jButton1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(AbstractButton.ROLLOVER_ICON_CHANGED_PROPERTY) == 0) {\n"
                        + "            System.out.println(\"New \\\"Rollover Icon\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Rollover Icon\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Disabled Icon Changed
        jButton1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo(AbstractButton.DISABLED_ICON_CHANGED_PROPERTY) == 0) {
                    eventFiredActions(eventButtons.get(7), evt);
                }
            }
        });
        eventButtons.get(7).setButtonAction(new AbstractAction("Disabled Icon Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Disabled Icon Changed  */\n\n"
                        + "jButton1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(AbstractButton.DISABLED_ICON_CHANGED_PROPERTY) == 0) {\n"
                        + "            System.out.println(\"New \\\"Disabled Icon\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Disabled Icon\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Selected Icon Changed
        jButton1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo(AbstractButton.SELECTED_ICON_CHANGED_PROPERTY) == 0) {
                    eventFiredActions(eventButtons.get(8), evt);
                }
            }
        });
        eventButtons.get(8).setButtonAction(new AbstractAction("Selected Icon Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Selected Icon Changed  */\n\n"
                        + "jButton1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(AbstractButton.SELECTED_ICON_CHANGED_PROPERTY) == 0) {\n"
                        + "            System.out.println(\"New \\\"Selected Icon\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Selected Icon\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Rollover Selected Icon Changed
        jButton1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo(AbstractButton.ROLLOVER_SELECTED_ICON_CHANGED_PROPERTY) == 0) {
                    eventFiredActions(eventButtons.get(9), evt);
                }
            }
        });
        eventButtons.get(9).setButtonAction(new AbstractAction("Rollover Selected Icon Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Rollover Selected Icon Changed  */\n\n"
                        + "jButton1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(AbstractButton.ROLLOVER_SELECTED_ICON_CHANGED_PROPERTY) == 0) {\n"
                        + "            System.out.println(\"New \\\"Rollover Selected Icon\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Rollover Selected Icon\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Disabled Selected Icon Changed
        jButton1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo(AbstractButton.DISABLED_SELECTED_ICON_CHANGED_PROPERTY) == 0) {
                    eventFiredActions(eventButtons.get(10), evt);
                }
            }
        });
        eventButtons.get(10).setButtonAction(new AbstractAction("Disabled Selected Icon Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Disabled Selected Icon Changed  */\n\n"
                        + "jButton1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(AbstractButton.DISABLED_SELECTED_ICON_CHANGED_PROPERTY) == 0) {\n"
                        + "            System.out.println(\"New \\\"Disabled Selected Icon\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Disabled Selected Icon\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Rollover Enabled Flag Changed
        jButton1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo(AbstractButton.ROLLOVER_ENABLED_CHANGED_PROPERTY) == 0) {
                    eventFiredActions(eventButtons.get(11), evt);
                }
            }
        });
        eventButtons.get(11).setButtonAction(new AbstractAction("Rollover Enabled Flag Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Rollover Enabled Flag Changed  */\n\n"
                        + "jButton1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(AbstractButton.ROLLOVER_ENABLED_CHANGED_PROPERTY) == 0) {\n"
                        + "            System.out.println(\"New \\\"Rollover Enabled\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Rollover Enabled\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Horizontal Alignment Property Changed
        jButton1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo(AbstractButton.HORIZONTAL_ALIGNMENT_CHANGED_PROPERTY) == 0) {
                    eventFiredActions(eventButtons.get(12), evt);
                }
            }
        });
        eventButtons.get(12).setButtonAction(new AbstractAction("Horizontal Alignment Property Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Horizontal Alignment Property Changed  */\n\n"
                        + "jButton1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(AbstractButton.HORIZONTAL_ALIGNMENT_CHANGED_PROPERTY) == 0) {\n"
                        + "            System.out.println(\"New \\\"Horizontal Alignment\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Horizontal Alignment\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Vertical Alignment Property Changed
        jButton1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo(AbstractButton.VERTICAL_ALIGNMENT_CHANGED_PROPERTY) == 0) {
                    eventFiredActions(eventButtons.get(13), evt);
                }
            }
        });
        eventButtons.get(13).setButtonAction(new AbstractAction("Vertical Alignment Property Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Vertical Alignment Property Changed  */\n\n"
                        + "jButton1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(AbstractButton.VERTICAL_ALIGNMENT_CHANGED_PROPERTY) == 0) {\n"
                        + "            System.out.println(\"New \\\"Vertical Alignment\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Vertical Alignment\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Horizontal Text Position Property Changed
        jButton1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo(AbstractButton.HORIZONTAL_TEXT_POSITION_CHANGED_PROPERTY) == 0) {
                    eventFiredActions(eventButtons.get(14), evt);
                }
            }
        });
        eventButtons.get(14).setButtonAction(new AbstractAction("Horizontal Text Position Property Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Horizontal Text Position Property Changed  */\n\n"
                        + "jButton1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(AbstractButton.HORIZONTAL_TEXT_POSITION_CHANGED_PROPERTY) == 0) {\n"
                        + "            System.out.println(\"New \\\"Horizontal Text Position\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Horizontal Text Position\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Vertical Text Position Property Changed
        jButton1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo(AbstractButton.VERTICAL_TEXT_POSITION_CHANGED_PROPERTY) == 0) {
                    eventFiredActions(eventButtons.get(15), evt);
                }
            }
        });
        eventButtons.get(15).setButtonAction(new AbstractAction("Vertical Text Position Property Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Vertical Text Position Property Changed  */\n\n"
                        + "jButton1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(AbstractButton.VERTICAL_TEXT_POSITION_CHANGED_PROPERTY) == 0) {\n"
                        + "            System.out.println(\"New \\\"Vertical Text Position\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Vertical Text Position\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Border Painted Flag Changed
        jButton1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo(AbstractButton.BORDER_PAINTED_CHANGED_PROPERTY) == 0) {
                    eventFiredActions(eventButtons.get(16), evt);
                }
            }
        });
        eventButtons.get(16).setButtonAction(new AbstractAction("Border Painted Flag Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Border Painted Flag Changed  */\n\n"
                        + "jButton1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(AbstractButton.BORDER_PAINTED_CHANGED_PROPERTY) == 0) {\n"
                        + "            System.out.println(\"New \\\"Border Painted\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Border Painted\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Focus Border Painted Flag Changed
        jButton1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo(AbstractButton.FOCUS_PAINTED_CHANGED_PROPERTY) == 0) {
                    eventFiredActions(eventButtons.get(17), evt);
                }
            }
        });
        eventButtons.get(17).setButtonAction(new AbstractAction("Focus Border Painted Flag Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Focus Border Painted Flag Changed  */\n\n"
                        + "jButton1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(AbstractButton.FOCUS_PAINTED_CHANGED_PROPERTY) == 0) {\n"
                        + "            System.out.println(\"New \\\"Focus Border Painted\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Focus Border Painted\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Margin Property Changed
        jButton1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo(AbstractButton.MARGIN_CHANGED_PROPERTY) == 0) {
                    eventFiredActions(eventButtons.get(18), evt);
                }
            }
        });
        eventButtons.get(18).setButtonAction(new AbstractAction("Margin Property Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Margin Property Changed  */\n\n"
                        + "jButton1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(AbstractButton.MARGIN_CHANGED_PROPERTY) == 0) {\n"
                        + "            System.out.println(\"New \\\"Margin\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Margin\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Content Area Filled Flag Changed
        jButton1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo(AbstractButton.CONTENT_AREA_FILLED_CHANGED_PROPERTY) == 0) {
                    eventFiredActions(eventButtons.get(19), evt);
                }
            }
        });
        eventButtons.get(19).setButtonAction(new AbstractAction("Content Area Filled Flag Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Content Area Filled Flag Changed  */\n\n"
                        + "jButton1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(AbstractButton.CONTENT_AREA_FILLED_CHANGED_PROPERTY) == 0) {\n"
                        + "            System.out.println(\"New \\\"Content Area Filled\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Content Area Filled\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Icon Text Gap Value Changed
        jButton1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo("iconTextGap") == 0) {
                    eventFiredActions(eventButtons.get(20), evt);
                }
            }
        });
        eventButtons.get(20).setButtonAction(new AbstractAction("Icon Text Gap Value Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Icon Text Gap Value Changed  */\n\n"
                        + "jButton1.addPropertyChangeListener(new PropertyChangeListener() {\n"
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

        //Action Object Changed
        jButton1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo("action") == 0) {
                    eventFiredActions(eventButtons.get(21), evt);
                }
            }
        });
        eventButtons.get(21).setButtonAction(new AbstractAction("Action Object Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Action Object Changed  */\n\n"
                        + "jButton1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(\"action\") == 0) {\n"
                        + "            System.out.println(\"New \\\"Action Object\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Action Object\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Hide Action Text Flag Changed
        jButton1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo("hideActionText") == 0) {
                    eventFiredActions(eventButtons.get(22), evt);
                }
            }
        });
        eventButtons.get(22).setButtonAction(new AbstractAction("Hide Action Text Flag Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Hide Action Text Flag Changed  */\n\n"
                        + "jButton1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(\"hideActionText\") == 0) {\n"
                        + "            System.out.println(\"New \\\"Hide Action Text\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Hide Action Text\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Default Capable Flag Changed
        jButton1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo("defaultCapable") == 0) {
                    eventFiredActions(eventButtons.get(23), evt);
                }
            }
        });
        eventButtons.get(23).setButtonAction(new AbstractAction("Default Capable Flag Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Default Capable Flag Changed  */\n\n"
                        + "jButton1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(\"defaultCapable\") == 0) {\n"
                        + "            System.out.println(\"New \\\"Default Capable\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Default Capable\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Mnemonic Property Changed
        jButton1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo(AbstractButton.MNEMONIC_CHANGED_PROPERTY) == 0) {
                    eventFiredActions(eventButtons.get(24), evt);
                }
            }
        });
        eventButtons.get(24).setButtonAction(new AbstractAction("Mnemonic Property Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Mnemonic Property Changed  */\n\n"
                        + "jButton1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(AbstractButton.MNEMONIC_CHANGED_PROPERTY) == 0) {\n"
                        + "            System.out.println(\"New \\\"Mnemonic\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Mnemonic\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });

        //Displayed Mnemonic Index Value Changed
        jButton1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo("displayedMnemonicIndex") == 0) {
                    eventFiredActions(eventButtons.get(25), evt);
                }
            }
        });
        eventButtons.get(25).setButtonAction(new AbstractAction("Displayed Mnemonic Index Value Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Displayed Mnemonic Index Value Changed  */\n\n"
                        + "jButton1.addPropertyChangeListener(new PropertyChangeListener() {\n"
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

        //Button Model Changed
        jButton1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().compareTo(AbstractButton.MODEL_CHANGED_PROPERTY) == 0) {
                    eventFiredActions(eventButtons.get(26), evt);
                }
            }
        });
        eventButtons.get(26).setButtonAction(new AbstractAction("Button Model Changed") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCodeTextArea(
                        "/*  Button Model Changed  */\n\n"
                        + "jButton1.addPropertyChangeListener(new PropertyChangeListener() {\n"
                        + "    @Override\n"
                        + "    public void propertyChange(PropertyChangeEvent evt) {\n"
                        + "        if (evt.getPropertyName().compareTo(AbstractButton.MODEL_CHANGED_PROPERTY) == 0) {\n"
                        + "            System.out.println(\"New \\\"Button Model\\\" Value: \" + evt.getNewValue());\n"
                        + "            System.out.println(\"Old \\\"Button Model\\\" Value: \" + evt.getOldValue());\n"
                        + "        }\n"
                        + "    }\n"
                        + "});\n"
                );
            }
        });
    }
}
