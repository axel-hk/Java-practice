package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class LogInForm extends JFrame {
    private final JLabel LOGIN_LABEL = new JLabel("Логин");
    private final JLabel PASSWORD_LABEL = new JLabel("Пароль");
    private JTextField loginField = new JTextField("", 1);
    private JTextField passwordField = new JTextField("", 1);
    private JButton registerButton = new JButton("Регистрация");
    private JButton loginButton = new JButton("Вход");
    private JLabel errorLabel = new JLabel("");

    private User currentUser;
    private ArrayList<User> users;

    public LogInForm() {
        super("Логин");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(300, 300, 300, 150);


        Container container = this.getContentPane();
        container.setLayout(new GridLayout(4, 2));
        container.add(LOGIN_LABEL);
        container.add(loginField);
        container.add(PASSWORD_LABEL);
        container.add(passwordField);
        container.add(registerButton);
        container.add(loginButton);
        container.add(errorLabel);

        setVisible(true);

        registerButton.addActionListener(e -> {
            boolean exists = false;
            for (User user : Main.users) {
                if (user.getLogin().equals(loginField.getText())) {
                    errorLabel.setText("Этот логин уже используется");
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                currentUser = new User("Анонимус", loginField.getText(), passwordField.getText());
                Main.addUser(currentUser);
                errorLabel.setText("Теперь вы можете войти");
            }
        });

        loginButton.addActionListener(e -> {
            currentUser = Main.findUser(loginField.getText(), passwordField.getText());
            if (currentUser == null) {
                errorLabel.setText("Неккоректны логин или пароль");
            }
            else {
                this.setVisible(false);
                new MainForm(currentUser);
            }
        });
    }


}

