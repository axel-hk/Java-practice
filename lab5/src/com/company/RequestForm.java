package com.company;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class RequestForm extends JPanel {
    private final String[] specs = {"ЗАписная книга", "Человек"};
    private JComboBox<String> specsComboBox = new JComboBox<>(specs);
    private final JLabel surnameLabel = new JLabel("Имя и фамилия");
    private final JLabel numberLabel = new JLabel("Номер телефона");
    private final JLabel birthLabel = new JLabel("Дата рождения");
    private final JLabel adressLabel = new JLabel("адресс");
    private JTextField numberField = new JTextField();
    private JTextField birthField = new JTextField();
    private JTextField surnameField = new JTextField();
    private JTextField adressField = new JTextField();
    private JButton addButton = new JButton("Добавить");
    private JLabel errorLabel = new JLabel("");

    public RequestForm(User currentUser) {
        this.setLayout(new GridLayout(5, 2));

        this.add(adressLabel);
        this.add(adressField);
        this.add(surnameLabel);
        this.add(surnameField);
        this.add(birthLabel);
        this.add(birthField);
        this.add(numberLabel);
        this.add(numberField);
        this.add(addButton);
        this.add(errorLabel);

        addButton.addActionListener(e -> {
            try {
                int number = Integer.valueOf(numberField.getText());
                int birth = Integer.valueOf(birthField.getText());
                Request request = new Request(new Client(currentUser.getName(),
                        currentUser.getLogin(), currentUser.getPassword()), surnameField.getText(), number, birth, adressField.getText());

                Main.bookRequests.add(request);

                errorLabel.setText("Ок");
            } catch (Exception ex) {
                errorLabel.setText("Ошибка!\nПроверьте корректность введённых данных");
            }
        });
    }
}