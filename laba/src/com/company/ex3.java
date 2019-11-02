package com.company;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ex3 {
    private String[] array;
    public boolean isDate(String date) {
        Pattern pattern = Pattern.compile("^([0-2][0-9]||3[0-1]).(0[0-9]||1[0-2]).([0-9][0-9])?[0-9][0-9]$");
        return pattern.matcher(date).matches();
    }
    public String[] change(String date){
        this.array = date.split(" ");
        Pattern pattern = Pattern.compile("^([0-2][0-9]||3[0-1]).(0[0-9]||1[0-2]).([0-9][0-9])?[0-9][0-9]$");
        String[] newarr = new String[this.array.length];
        int i = 0;
        for(String s: this.array) {
            if (pattern.matcher(s).matches()) {
                s = pattern.matcher(date).replaceAll("11.02.2019");

            }
            newarr[i]=s;
            i++;
        }
        return newarr;
    }
}
