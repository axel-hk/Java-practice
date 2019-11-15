package com.company;

import javax.lang.model.type.NullType;
import java.util.List;

public class Client extends User {

    public Client(String name, String login, String password) {
        super(name, login, password);
    }
    private List parlays ;
    public void getParlay(Parlay parlay, User user) {
        System.out.println(user.getName() + " выиграл " + parlay.getSum());
    }

}
