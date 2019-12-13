package com.company;

import javax.swing.*;
import java.awt.*;
public class ProfileForm extends JPanel {
    private final JLabel NAME_LABEL = new JLabel("Имя");
    private final JLabel LOGIN_LABEL = new JLabel("Логин");
    private final JLabel PASSWORD_LABEL = new JLabel("Пароль");
    private JTextField nameField = new JTextField("", 1);
    private JTextField loginField = new JTextField("", 1);
    private JTextField passwordField = new JTextField("", 1);
    private JButton saveButton = new JButton("Сохранить");
    private JLabel errorLabel = new JLabel("");

    public ProfileForm(User currentUser) {

        this.setLayout(new GridLayout(4, 2));
        this.add(NAME_LABEL);
        this.add(nameField);
        this.add(LOGIN_LABEL);
        this.add(loginField);
        this.add(PASSWORD_LABEL);
        this.add(passwordField);
        this.add(saveButton);
        this.add(errorLabel);

        nameField.setText(currentUser.getName());
        loginField.setText(currentUser.getLogin());
        passwordField.setText(currentUser.getPassword());

        this.saveButton.addActionListener(e -> {
            currentUser.setName(nameField.getText());
            if (Main.findUser(loginField.getText(), passwordField.getText()) != null) {
                currentUser.setLogin(loginField.getText());
            }
            else {
                errorLabel.setText("Этот логин уже используется");
            }
            currentUser.setPassword(passwordField.getText());
        });
    }
}
