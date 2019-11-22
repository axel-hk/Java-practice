package com.company;
import java.io.RandomAccessFile;
import java.io.*;


public class fil {
    File  file;
    int size;
    public fil(String name)throws IOException, Exception, FileNotFoundException{
        file = new File(name);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void add(Book bok)throws IOException, Exception, FileNotFoundException{//Перезапись
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(file.getPath(),true)))
        {
            // записываем значения
            dos.writeUTF(bok.Sername);
            dos.writeUTF(bok.Name);
            dos.writeUTF(bok.adress);
            dos.writeInt(bok.number);
            dos.writeInt(bok.birth);
            size = 1;
            dos.close();

        }

    }
    public void add2(Book bok)throws IOException, Exception, FileNotFoundException{//Запись в конец
        try(FileOutputStream dos = new FileOutputStream(file.getPath(),true))
        {
            // записываем значения
            dos.write(bok.Sername.getBytes());
            dos.write(bok.Name.getBytes());
            dos.write(bok.adress.getBytes());
            dos.write(bok.number);
            dos.write(bok.birth);
            size++;
            dos.close();
        }

    }
    public String findbySername(String Sername)throws IOException, Exception, FileNotFoundException{//найти по имени
        try(DataInputStream dos = new DataInputStream(new FileInputStream(file.getPath())))
        {
            byte[] buffer = new byte[dos.available()];
            int i = 0;
            int number=0;
            int birth=0;
            String S = "";
            String sername= "";
            String name = "";
            String adress = "";
            while(i<size) {
                sername = dos.readUTF();
                name = dos.readUTF();
                adress = dos.readUTF();
                number = dos.readInt();
                birth = dos.readInt();
                i++;
                if (Sername.equals(sername))
                    S += "Фамилия "+ sername + " Имя " + name + " адрес " + adress +" номер телефона "+ number + "дата рождения"+birth +"\n" ;
            }

            return S;
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        return null;
    }
    public void exchange(String Sername)throws IOException, Exception, FileNotFoundException{   //Уменьшить вдвое цену на игрушки для детей до определенного возраста
        Book[] mass = new Book[size];
        try(DataInputStream dos = new DataInputStream(new FileInputStream(file.getPath())))
        {

            int i = 0;
            int number=0;
            int birth=0;
            String S = "";
            String sername= "";
            String name = "";
            String adress = "";
            while(i<size) {
                sername = dos.readUTF();
                name = dos.readUTF();
                adress = dos.readUTF();
                number = dos.readInt();
                birth = dos.readInt();
                if (sername == Sername)
                    mass[i] = new Book(Sername,name,adress,number,birth);
                else
                    mass[i] = new Book(sername,name,adress,number,birth);

            }


        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(file.getPath(),true)))
        {
            size =0;
            // записываем значения
            dos.writeUTF(mass[0].Sername);
            dos.writeUTF(mass[0].Name);
            dos.writeUTF(mass[0].adress);
            dos.writeInt(mass[0].number);
            dos.writeInt(mass[0].birth);
            size = 1;
            dos.close();

        }
        for (int i = 1; i<mass.length;i++){
            try(FileOutputStream dos = new FileOutputStream(file.getPath(),true))
            {
                // записываем значения
                dos.write(mass[i].Sername.getBytes());
                dos.write(mass[i].Name.getBytes());
                dos.write(mass[i].adress.getBytes());
                dos.write(mass[i].number);
                dos.write(mass[i].birth);
                size++;
                dos.close();
            }
        }

    }


    public String get()throws IOException, Exception, FileNotFoundException{ //распечатать файл
        try(DataInputStream dos = new DataInputStream(new FileInputStream(file.getPath())))
        {
            byte[] buffer = new byte[dos.available()];
            int i = 0;
            int number=0;
            int birth=0;
            String S = "";
            String sername= "";
            String name = "";
            String adress = "";
            while(i<size) {
                sername = dos.readUTF();
                name = dos.readUTF();
                adress = dos.readUTF();
                number = dos.readInt();
                birth = dos.readInt();
                i++;
                S += "Фамилия "+ sername + " Имя " + name + " адрес " + adress +" номер телефона "+ number + "дата рождения"+birth +"\n" ;
            }

            return S;
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        return null;
    }




    public String get1() throws IOException {//вывести файл RandomAccessFile
        RandomAccessFile raf = new RandomAccessFile("file.txt", "r");

        raf.seek(0);
        String text1 = raf.readLine();
        raf.close();
        return text1;
    }
    public void add(int i,Book smth) throws IOException {//вставить в определенное место файла RandomAccessFile
        RandomAccessFile raf = new RandomAccessFile("file.txt", "r");

        raf.seek(i*42);
        String text1 = raf.readLine();
        raf.close();
        RandomAccessFile raf1 = new RandomAccessFile("file.txt", "rw");
        raf1.seek(i*42);
        raf.writeBytes(("Sername: "+ smth.Sername));
        raf.writeBytes(" Name: "+smth.Name );
        raf.writeBytes("Number ");
        raf.writeBytes(String.valueOf(smth.number));
        raf.writeBytes(" Date of birth ");
        raf.writeBytes(String.valueOf(smth.birth));
        raf.writeBytes(" Adress "+smth.adress);
        raf.writeBytes(text1);


    }

    public void add3(Book smth) throws IOException{//добавить в конец RandomAccessFile
        RandomAccessFile raf = new RandomAccessFile("file.txt", "rw");
        raf.seek(raf.length());
        raf.writeBytes(("Sername: "+ smth.Sername));
        raf.writeBytes(" Name: "+smth.Name );
        raf.writeBytes("Number ");
        raf.writeBytes(String.valueOf(smth.number));
        raf.writeBytes(" Date of birth ");
        raf.writeBytes(String.valueOf(smth.birth));
        raf.writeBytes(" Adress "+smth.adress);
        raf.close();

    }

}
