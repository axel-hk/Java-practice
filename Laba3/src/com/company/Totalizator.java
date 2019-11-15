package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Totalizator {
    private static ArrayList<User> users = new ArrayList<User>();
    private static ArrayList<Parlay> parlays = new ArrayList<Parlay>();
    private static User currentUser;
    private static Client currentClient;
    public static void main(String[] args) {
        load();
        Parlay[] horse = new Parlay[7];
        for (Parlay parlay : parlays) {
            System.out.println(parlay.getHorse() +" " + parlay.getSum());
        }
        int operationNumber = 0;
        String login;
        String name;
        String password;
        do {
            System.out.println(
                    "1. Вход в систему\n" +
                            "2. Регистрация\n" +
                            "3. Выход из программы\n"
            );
            System.out.println("Введите номер операции: ");
            Scanner sc = new Scanner(System.in);
            operationNumber = sc.nextInt();
            if (operationNumber >= 1 && operationNumber <= 3) {
                switch (operationNumber) {
                    case (1):
                        System.out.println("Введите логин");
                        login = sc.next();
                        System.out.println("Введите пароль");
                        password = sc.next();
                        currentUser = findUser(login, password);
                        if (currentUser == null) {
                            continue;
                        } else {
                            System.out.println("Здраствуйте, " + currentUser.getName());
                            do {
                                System.out.println(
                                        "1. Приём ставки\n" +
                                                "2. Расчетать сумму выигрыша\n" +
                                                "3. Выход"
                                );
                                System.out.println("Введите номер операции: ");
                                operationNumber = sc.nextInt();
                                if (operationNumber >= 1 && operationNumber <= 3) {
                                    switch (operationNumber) {
                                        case (1):
                                            System.out.println("Введите номер лошади: ");
                                            int num = sc.nextInt();
                                            System.out.println("Введите сумму ставки: ");
                                            int sum = sc.nextInt();
                                            Parlay parlay = new Parlay(new Client(currentUser.getName(),
                                                    currentUser.getLogin(), currentUser.getPassword()), num, sum);

                                            break;
                                        case (2):
                                            int rand = 0+(int)(Math.random()*6);
                                            for (int i = 0; i<rand; i++)
                                            {
                                                horse[rand].addSum(horse[i].getSum());
                                            }
                                            for (int j = rand; j<6; j++)
                                            {
                                                horse[rand].addSum(horse[j].getSum());
                                            }
                                            currentClient.getParlay(horse[rand],currentUser);
                                            break;
                                        case (3):
                                            save();
                                            System.exit(0);
                                            break;
                                    }
                                }
                            } while (true);
                        }
                    case (2):
                        System.out.println("Введите имя");
                        name = sc.next();
                        System.out.println("Введите логин");
                        do {
                            boolean exists = false;
                            login = sc.next();
                            for (User user : users) {
                                if (user.getLogin().equals(login)) {
                                    System.out.println("Данный логин уже существует");
                                    exists = true;
                                    break;
                                }
                            }
                            if (!exists) {
                                break;
                            }
                        } while (true);
                        System.out.println("Введите пароль");
                        password = sc.next();
                        User user = new User(name, login, password);
                        addUser(user);
                        System.out.println("Теперь вы можете зайти под своим логином и паролем");
                        break;
                    case (3):
                        save();
                        System.exit(0);
                        break;
                }
            }
        } while (true);
    }

    public static void addUser(User user) {
        users.add(user);
    }

    public static User findUser(String login, String password) {
        for (User user : users) {
            if (user.enter(login, password)) {
                return user;
            }
        }
        System.out.println("Неверный логин или пароль");
        return null;
    }

    public static void save() {
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
    public static void load() {
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



