package com.company;

import java.util.Scanner;
import java.io.*;
public class Main {


    public static void main(String[] args) throws IOException, Exception, FileNotFoundException{


        try {
            //exer 1
            File F1 = new File("File1.txt");
            F1.createNewFile(); //Создать файл в папке приложения с именем MyFile1.txt.
            File F2 = new File("D://", "File2.txt");
            F2.createNewFile(); //Создать файл с именем MyFile2.txt в корне определенного диска.
            File F3 = new File("D://ООП", "File3.txt");
            F3.createNewFile(); //Создать файл с именем MyFile3.txt
            File F4 = new File("D://ООП//laba4//new");
            F4.mkdir();//Создать папку третьего уровня, например, Первая\\Вторая\\Третья

            //exer 2
            if (F2.isFile()){ //	Проверить, что вызывающий объект содержит имя файла, а не папки и отобразить имя файла, вызывающего объекта и его родительскую папку.

                System.out.println("Имя "+F2.getName() + " Родительская папка " + F2.getParent());
            }
            if (F1.exists()){//Проверить, что в папке приложения существует файл с именем MyFile1.txt.
                System.out.println("file(MyFile1.txt) exists");
            }
            System.out.println("Полный путь к файлу File3.txt: " + F3.getPath());//Отобразить полный путь к файлу или папке объекта.
            System.out.println("Размер файла File3.txt: " + F3.length() + " byte");//Отобразить размер файла

            // 3 exer
            File newfold = new File("D");//1.	Добавить в папку приложения еще одну папку.
            newfold.mkdir();

            File newf = new File("D://ООП//laba4");//2.	Сформировать массив файлов, находящихся в папке приложения, используя метод list(). Отобразить содержимое массива.
            String[] mass;
            mass = newf.list();
            System.out.println(mass);


            File[] mass1;//3.	Сформировать массив файлов, находящихся в папке приложения, используя метод listFiles( ). Отобразить содержимое массива.
            mass1 = newf.listFiles();
            int S = 0;
            if (mass1!=null) {
             for (int i  = 0; i<mass1.length; i++){
                    System.out.println(mass1[i].toString() + ' ');
                    if (mass1[i].isDirectory())//Определить количество папок, содержащихся в файле приложения.
                        S++;
                }
            }
            System.out.println("Кол-во папок: "+ S);

            F1.delete();//4.	Удалить папки и файлы созданные во всех трех упражнениях
            F2.delete();
            F3.delete();
            F4.delete();
            newfold.delete();



        } finally {

            System.out.println("Программа завершена");

        }



        // упражнение 2
        System.out.print("Введите название файла");
        Scanner in = new Scanner(System.in);
        String name = in.next();

        fil f = new fil(name);
        Book b1 = new Book("Annenkov","Alexander", "Moscow", 789876876, 2000);
        f.add3(b1);
        Book b2 = new Book("Chaykina","Alyona", "Novosib", 78955876, 2002);
        f.add3(b2);
        System.out.println(f.get1());
// Упражнение 3
        t3 t = new t3();
        File f1 = new File("aa.txt");
        File f2 = new File("b.txt");
        t.ex3(f1);
//Упражнение 4
        text4 ex4 = new text4("inf.txt");
        t4 tsk = new t4("hum.dat");
        tsk.addl(ex4.transcript());
        tsk.put();
        tsk.take();


    }

}
