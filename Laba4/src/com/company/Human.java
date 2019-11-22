package com.company;
import java.io.*;

public class Human implements Serializable {// класс для задания 4

    String  Name;
    String  Sername;
    int Age;
    public Human(String name,String sername, int age){
        Name = name;
        Sername = sername;
        Age = age;

    }

}