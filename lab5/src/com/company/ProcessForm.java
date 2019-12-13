package com.company;
import javax.swing.*;
import java.awt.*;
public class ProcessForm extends JPanel {
    private JButton processButton = new JButton("Вывод");
    private JTextArea resultArea = new JTextArea("");
    private static  JTextField enterField = new JTextField();
    public ProcessForm() {
        this.setLayout(new GridLayout(3,1));
        this.add(enterField);
        this.add(resultArea);
        this.add(processButton);

        processButton.addActionListener(e -> {
            resultArea.setText(Main.processRequests());
        });

    }
    public static String enter()
    {
        return enterField.getText();
    }

}