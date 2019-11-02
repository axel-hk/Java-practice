package com.company;

import java.util.Scanner;

public class ex2 {
    private StringBuilder sentences;
    private String[] sentencesArr;

    public ex2(StringBuilder sentences) {
        this.sentences = sentences;
        this.sentencesArr = sentences.toString().split("; ");

    }
    public StringBuilder del() {
        int first = sentences.indexOf(" ", sentences.indexOf(" ") + 1);
        int second = sentences.indexOf("0")+2;
        sentences.delete(first, second);
        return sentences;

    }
    public String[] change(){
        String temp = "";
        for(int i = 0; i< this.sentencesArr.length; i++){
            for (int j = this.sentencesArr.length-1; j > i; j--) {
                String somedec = (this.sentencesArr[j-1].split(" "))[1];
                int dec = Integer.parseInt(somedec);
                String somedec2 = (this.sentencesArr[j].split(" "))[1];
                int dec2 = Integer.parseInt(somedec2);
                if(dec<dec2) {
                    temp = this.sentencesArr[j - 1];
                    this.sentencesArr[j - 1] = this.sentencesArr[j];
                    this.sentencesArr[j] = temp;


                }
            }
        }
        this.sentencesArr[sentencesArr.length-1] = this.sentencesArr[0];
        /*for(int q = 0; q< this.sentencesArr.length; q++){
            System.out.println(q+1+". "+this.sentencesArr[q]);*/
        return  this.sentencesArr;


    }
    public StringBuilder add(String str)
    {
        /*System.out.println("Введите информацию о новой продаже: ");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();*/
        StringBuilder strb = new StringBuilder(str);
        sentences.append(strb);
        return sentences;
    }

}
