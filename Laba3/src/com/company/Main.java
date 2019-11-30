package com.company;

import javax.lang.model.type.NullType;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Totalizator T = new Totalizator();
        T.load();
        Parlay[] horse = new Parlay[7];
        for (Parlay parlay : T.parlays) {
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
                        T.currentUser = T.findUser(login, password);
                        if (T.currentUser == null) {
                            continue;
                        } else {
                            System.out.println("Здраствуйте, " + T.currentUser.getName());
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
                                            Parlay parlay = new Parlay(new Client(T.currentUser.getName(),
                                                    T.currentUser.getLogin(), T.currentUser.getPassword()), num, sum);

                                            break;
                                        case (2):
                                            int rand = 0+(int)(Math.random()*6);
                                            for (int i = 0; i<rand; i++)
                                            {   if(horse[i] == null) {
                                                horse[rand].addSum(0);
                                            }
                                            else {
                                                horse[rand].addSum(horse[i].getSum());
                                            }
                                            }
                                            for (int j = rand; j<6; j++)
                                            {
                                                if(horse[j] == null) {
                                                    horse[rand].addSum(0);
                                                }
                                                else {
                                                    horse[rand].addSum(horse[j].getSum());
                                                }
                                            }

                                            T.currentClient.getParlay(horse[rand],T.currentUser);
                                            break;
                                        case (3):
                                            T.save();
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
                            for (User user : T.users) {
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
                        T.addUser(user);
                        System.out.println("Теперь вы можете зайти под своим логином и паролем");
                        break;
                    case (3):
                        T.save();
                        System.exit(0);
                        break;
                }
            }
        } while (true);
    }




    }



