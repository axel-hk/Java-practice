package com.company;

import java.io.RandomAccessFile;
import java.io.*;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class text4 {//класс управления файла текстового типа
    String path;
    ArrayList<Human> people = new ArrayList<Human>();
    public text4(String path){

        this.path = path;
    }
    public void add()throws IOException, Exception, FileNotFoundException{//добавить пробный элемент
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(path)))
        {
            Human human = new Human("Name", "Sername", 19);

            dos.writeUTF(human.Name);
            dos.writeUTF(human.Sername);
            dos.writeInt(human.Age);

            dos.close();

        }

    }
    public ArrayList<Human> transcript(){//создать из текста список
        try(DataInputStream dos = new DataInputStream(new FileInputStream(path)))
        {

            int i = 0;
            int age =0;
            String Name= "";
            String Sername = "";
            while(0<dos.available()) {
                Name = dos.readUTF();
                Sername = dos.readUTF();
                age = dos.readInt();
                Human human = new Human(Name, Sername,age);
                people.add(human);
                i++;

            }

            return people;
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        return null;
    }
}
