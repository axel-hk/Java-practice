package com.company;

public class Client extends User {

    public Client(String name, String login, String password) {
        super(name, login, password);
    }

    public String takeResult(int number) {
        return this.getName() + " номер телефона " + number;
    }
}