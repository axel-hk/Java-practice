package com.company;
import java.io.Serializable;

public class Request implements Serializable {
    private Client requester;
    private String surname;
    private int number;
    private int birth;
    private String adress;

    public Request(Client requester, String surname, int number, int birth, String adress) {
        this.requester = requester;
        this.surname = surname;
        this.number = number;
        this.birth = birth;
        this.adress = adress;
    }

    public Client getRequester() {
        return this.requester;
    }

    public String getSurname() {
        return this.surname;
    }

    public int getNumber() {
        return this.number;
    }

    public int getBirth() {
        return this.birth;
    }

    public String getAdress() { return this.adress; }
}
