package com.company;

public class Book {
    String Sername;
    String Name;
    String adress;
    int number;
    int birth;
    public Book(String Sername, String Name, String adress, int number, int birth){
        this.Sername = Sername;
        this.Name = Name;
        this.adress = adress;
        this.number = number;
        this.birth = birth;
    }
    public int compare(Book sub){
        if (sub.adress ==this.adress){

            return 1;

        }
        return 0;
    }
    public int getNum( String Sername, String Name){
        if ((this.Name == Name) && (this.Sername==Sername)) {
            return this.number;
        }
        else {
            return 0;
        }

    }

}