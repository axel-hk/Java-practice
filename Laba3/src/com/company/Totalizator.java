package com.company;

import java.io.*;
import java.util.ArrayList;

public class Totalizator {
    public ArrayList<User> users = new ArrayList<User>();
    public  ArrayList<Parlay> parlays = new ArrayList<Parlay>();
    public  User currentUser;
    public Client currentClient;
    public Totalizator()
    {
        this.users = users;
        this.parlays = parlays;
        this.currentClient = currentClient;
        this.currentUser = currentUser;
    }

    public  void addUser(User user) {
        users.add(user);
    }

    public  User findUser(String login, String password) {
        for (User user : users) {
            if (user.enter(login, password)) {
                return user;
            }
        }
        System.out.println("Неверный логин или пароль");
        return null;
    }

    public  void save() {
        try (
                FileOutputStream usersFile = new FileOutputStream("users.dat", false);
                ObjectOutputStream oosUser = new ObjectOutputStream(usersFile)) {
            oosUser.writeObject(users);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try (
                FileOutputStream workersRequestsFile = new FileOutputStream("parlays.dat", false);
                ObjectOutputStream oosWorkerRequest = new ObjectOutputStream(workersRequestsFile)) {
            oosWorkerRequest.writeObject(parlays);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }


    }

    @SuppressWarnings("unchecked")
    public  void load() {
        try (ObjectInputStream oisUsers = new ObjectInputStream(new FileInputStream("users.dat"))) {
            users = (ArrayList<User>) oisUsers.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try (ObjectInputStream oisWorkerRequests = new ObjectInputStream(new FileInputStream("parlays.dat"))) {
            parlays = (ArrayList<Parlay>) oisWorkerRequests.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
