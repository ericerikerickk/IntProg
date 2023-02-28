package net.codejava.swing.jpanel;
 
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
 
/**
 * This program demonstrates how to use JPanel in Swing.
 * @author www.codejava.net
 */
public class SwingJPanelDemo extends JFrame {
     
    private JLabel labelSetA = new JLabel("Enter an element of Set A: ");
    private JLabel labelSetB = new JLabel("Enter an element of Set B: ");
    private JTextField textSetA = new JTextField(2);
    private JTextField textSetB = new JTextField(2);
    private JButton buttonSetA = new JButton("Enter");
    private JButton buttonSetB = new JButton("Enter");
     
    public SwingJPanelDemo() {
        super("Set Operation Program");
         
        // create a new panel with GridBagLayout manager
        JPanel newPanel = new JPanel(new GridBagLayout());
         
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
         
        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;     
        newPanel.add(labelSetA, constraints);
 
        constraints.gridx = 1;
        newPanel.add(textSetA, constraints);
         
        constraints.gridx = 0;
        constraints.gridy = 1;     
        newPanel.add(labelSetB, constraints);
         
        constraints.gridx = 1;
        newPanel.add(textSetB, constraints);
         
        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        newPanel.add(buttonSetA, constraints);
        
        constraints.gridx = 3;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        newPanel.add(buttonSetB, constraints);
         
        // set border for the panel
        newPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Set Operation Panel"));
         
        // add the panel to this frame
        add(newPanel);
         
        pack();
        setLocationRelativeTo(null);
    }
     
    public static void main(String[] args) {
        // set look and feel to the system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
         
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingJPanelDemo().setVisible(true);
            }
        });
        SwingJPanelDemo jpanel = new SwingJPanelDemo();

    }
}