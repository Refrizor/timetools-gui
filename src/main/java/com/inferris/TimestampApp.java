package com.inferris;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;

public class TimestampApp extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public TimestampApp() {
        setTitle("Timestamp Master");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png"));
        setIconImage(icon);

        // Initialize CardLayout and the main panel that uses it
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Add the panels to the main panel
        mainPanel.add(createMenuPanel(), "Menu");
        mainPanel.add(new TimestampGeneratorPanel(this), "Generate");
        mainPanel.add(new TimestampConverterPanel(this), "Convert");

        // Add the main panel to the frame
        add(mainPanel);

        setVisible(true);
    }

    // Method to switch panels
    public void switchPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    // Create  main menu panel
    private JPanel createMenuPanel() {
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(2, 1, 10, 10));

        JButton generateButton = new JButton("Generate Unix Timestamp");
        JButton convertButton = new JButton("Convert Unix Timestamp");

        generateButton.addActionListener(e -> switchPanel("Generate"));
        convertButton.addActionListener(e -> switchPanel("Convert"));

        menuPanel.add(generateButton);
        menuPanel.add(convertButton);

        return menuPanel;
    }

    public static void main(String[] args) {
        FlatLightLaf.setup();
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(TimestampApp::new);
    }
}
