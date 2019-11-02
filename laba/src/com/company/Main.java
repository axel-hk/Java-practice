package com.company;
import java.util.Arrays;
import  java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int task;
        do {
            System.out.println(
                    "1. Задание 1\n" +
                            "2. Задание 2\n" +
                            "3. Задание 3\n" +
                            "4. Выход из программы\n"
            );
            System.out.println("Введите номер задания: ");
            Scanner sc = new Scanner(System.in);
            task = sc.nextInt();
            if (task >= 1 && task <= 4) {
                System.out.println("Введите текст: ");
                Scanner text = new Scanner(System.in);
                String str = text.nextLine();
                switch (task) {
                    case 1:
                        ex1 E = new ex1(str);
                        System.out.println(E.sum());
                        System.out.println(E.firstUpperCase());
                        System.out.println(E.list());
                        System.out.println(E.rate());
                        System.out.println(E.search());
                        break;
                    case 2:
                        StringBuilder strb = new StringBuilder(str);
                        ex2 E2 = new ex2(strb);
                        System.out.println(E2.del());
                        System.out.println(Arrays.toString(E2.change()));
                        System.out.println("Введите информацию о новой продаже: ");
                        Scanner scan = new Scanner(System.in);
                        String strin = scan.nextLine();
                        System.out.println(E2.add(strin));
                        break;
                    case 3:
                        ex3 E3 = new ex3();
                        if (E3.isDate(str)) {
                            System.out.println("Строка является датой");
                        }
                        else {
                            System.out.println("Строка не является датой");
                        }
                        E3.change(str);
                        break;
                    case 4:
                        break;
                }
            }
        } while (task != 4);


    }
}
