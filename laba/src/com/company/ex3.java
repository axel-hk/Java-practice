package com.company;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ex3 {
    private String[] array;
    public boolean isDate(String date) {
        Pattern pattern = Pattern.compile("^[1-31|1-12]+.[1-12|1-31]+.[0-45000000000]+$");
        return pattern.matcher(date).matches();
    }
    public void change(String date){
        this.array = date.split(" ");
        Pattern pattern = Pattern.compile("^[1-12]+.[1-31]+.[0-45000000000]");
        for(String s: this.array) {
            System.out.println(s);
            String news = "";
            if (pattern.matcher(s).matches()) {
                news = s.substring(3,4)+"."+s.substring(0,1)+"."+s.substring(5);

            }
        System.out.println(news);

        }

    }
}
