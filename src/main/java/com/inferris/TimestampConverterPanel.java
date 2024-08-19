package com.inferris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class TimestampConverterPanel extends JPanel {
    private JTextField timestampField;
    private JTextField resultField;

    public TimestampConverterPanel(TimestampApp parent) {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2, 10, 10));

        JLabel timestampLabel = new JLabel("Enter Unix Timestamp:");
        timestampField = new JTextField();

        inputPanel.add(timestampLabel);
        inputPanel.add(timestampField);

        resultField = new JTextField();
        resultField.setEditable(false);
        resultField.setHorizontalAlignment(JTextField.CENTER);

        JButton convertButton = new JButton("Convert to Date/Time");
        convertButton.addActionListener(new ConvertButtonListener());

        JButton backButton = new JButton("Back to Menu");
        backButton.addActionListener(e -> parent.switchPanel("Menu"));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(resultField, BorderLayout.CENTER);
        bottomPanel.add(convertButton, BorderLayout.NORTH);
        bottomPanel.add(backButton, BorderLayout.SOUTH);

        add(inputPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private class ConvertButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                long timestamp = Long.parseLong(timestampField.getText().trim());
                LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneOffset.UTC);
                String formattedDateTime = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                resultField.setText(formattedDateTime);
            } catch (NumberFormatException ex) {
                resultField.setText("Invalid timestamp format.");
            } catch (Exception ex) {
                resultField.setText("Error: " + ex.getMessage());
            }
        }
    }
}