package com.company;
import java.util.Arrays;
import java.util.Scanner;

public class ex1 {
    private String [] array;
    ex1(String str){this.array =  str.split("; "); }
    public  int sum() {
        int sum = 0;
        for (String s : this.array) {
            String somedec = (s.split(" "))[1];
            int dec = Integer.parseInt(somedec);
            sum += dec;

        }
        return sum;
    }

    public  String firstUpperCase() {
        String newstr = "";
        for (String s : this.array) {
            if (s == null || s.isEmpty()) {
                return "";
            }
            s = s.substring(0, 1).toUpperCase() + s.substring(1);
            newstr +=s+"; ";
        }
        return newstr;

    }
    public  int[] list()
    {
        int[] decimal = new int[this.array.length];
        int i =0;
        for (String s : this.array) {

            String somedec = (s.split(" "))[1];
            int dec = Integer.parseInt(somedec);
            decimal[i] = dec;
            i++;
        }
        Arrays.sort(decimal, 0, i);
        return decimal;

    }
    public  String[] rate()
    {
        String temp = "";
        String[] arr = new String[this.array.length];
        for(int i = 0; i< this.array.length; i++){
            for (int j = this.array.length-1; j > i; j--) {
                String somedec = (this.array[j-1].split(" "))[1];
                int dec = Integer.parseInt(somedec);
                String somedec2 = (this.array[j].split(" "))[1];
                int dec2 = Integer.parseInt(somedec2);
                if(dec<dec2) {
                    temp = this.array[j - 1];
                    this.array[j - 1] = this.array[j];
                    this.array[j] = temp;


                }
            }
        }
        for(int q = 0; q< this.array.length; q++){
            arr[q] = Integer.toString(q+1)+". "+this.array[q];
        }
        return arr;
    }

    public  String search()
    {
      System.out.println("Введите номер продажи: ");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        return this.array[num-1];

    }

    }



