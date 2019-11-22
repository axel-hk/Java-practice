package com.company;
import java.util.ArrayList;
import java.io.*;

public class t4 {
    String path;
    ArrayList<Human> people = new ArrayList<Human>();

    public t4(String path){

        this.path = path;
    }

    public  void add(Human human){
        people.add(human);
    }// добавить в список
    public  void addl(ArrayList<Human> people){
        this.people = people;
    }

    public void del(String name){// удалить из списка
        for (int i = 0; i< people.size();i++){
            if (people.get(i).Name ==name)
                people.remove(i);
        }
    }

    public  void put(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path)))//добавить в файл
        {
            for (int i = 0; i< people.size();i++) {

                oos.writeObject(people.get(i));
            }
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }

    public  void take(){//вывести файл

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path)))
        {
            for (int i = 0; i< people.size();i++) {
                Human h=(Human)ois.readObject();
                System.out.printf("Name: %s \t Age: %d \n", h.Name, h.Age);

            }
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
}
