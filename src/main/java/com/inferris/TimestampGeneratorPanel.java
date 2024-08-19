package com.inferris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TimestampGeneratorPanel extends JPanel {
    private JTextField dateField;
    private JTextField timeField;
    private JTextField resultField;

    public TimestampGeneratorPanel(TimestampApp parent) {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel dateLabel = new JLabel("Enter Date (yyyy-MM-dd):");
        dateField = new JTextField();
        JLabel timeLabel = new JLabel("Enter Time (HH:mm:ss):");
        timeField = new JTextField();

        inputPanel.add(dateLabel);
        inputPanel.add(dateField);
        inputPanel.add(timeLabel);
        inputPanel.add(timeField);

        resultField = new JTextField();
        resultField.setEditable(false);
        resultField.setHorizontalAlignment(JTextField.CENTER);

        JButton generateButton = new JButton("Generate Timestamp");
        generateButton.addActionListener(new GenerateButtonListener());

        JButton backButton = new JButton("Back to Menu");
        backButton.addActionListener(e -> parent.switchPanel("Menu"));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(resultField, BorderLayout.CENTER);
        bottomPanel.add(generateButton, BorderLayout.NORTH);
        bottomPanel.add(backButton, BorderLayout.SOUTH);

        add(inputPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private class GenerateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String dateInput = dateField.getText().trim();
                String timeInput = timeField.getText().trim();

                LocalDate date = LocalDate.parse(dateInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                LocalTime time = LocalTime.parse(timeInput, DateTimeFormatter.ofPattern("HH:mm:ss"));
                LocalDateTime dateTime = LocalDateTime.of(date, time);

                long timestamp = dateTime.toEpochSecond(ZoneOffset.UTC);
                resultField.setText(String.valueOf(timestamp));
            } catch (DateTimeParseException ex) {
                resultField.setText("Invalid date or time format.");
            } catch (Exception ex) {
                resultField.setText("Error: " + ex.getMessage());
            }
        }
    }
}