package com.company;
import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class t3 {// методы задания 3
    public  void ex1(File file, File file1){//упражнение 1
        try(FileInputStream fin=new FileInputStream(file.getPath());
            FileOutputStream fos=new FileOutputStream(file1.getPath()))
        {
            byte[] buffer = new byte[fin.available()];
            // считываем буфер
            fin.read(buffer, 0, buffer.length);
            // записываем из буфера в файл
            fos.write(buffer, 0, buffer.length);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }


    }
    public  void ex3(File file){//упражнение 3
        try(BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "Cp1251"));)
        {

            String line;
            while((line = in.readLine()) != null){
                System.out.println(line);


            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }


    }
    public  void ex2(File file,File fil){//упражнение 2
        try(
                FileReader fileReader = new FileReader(file);
                FileWriter fileWriter = new FileWriter(fil);
                BufferedReader inb  = new  BufferedReader(fileReader , 128);
                BufferedWriter outb  = new BufferedWriter(fileWriter, 128))
        {
            char[] buffer = new char[128];
            String line;
            while((line = inb.readLine()) != null){
                buffer = line.toCharArray();
                inb.read(buffer);
                outb.write(buffer);
            }


        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }


    }
}
