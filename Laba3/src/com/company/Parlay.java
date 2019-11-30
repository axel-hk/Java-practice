package com.company;

import javax.lang.model.type.NullType;

public class Parlay {
    private int horse;
    private int sum;
    public Parlay(Client client, int horse, int sum)
    {
        this.horse = horse;
        this.sum = sum;
    }
    public int getHorse()
    {
        return this.horse;
    }
    public int getSum()
    { if (this.sum != 0){
        return this.sum;}
        else{return 0;}}
    public int addSum(int sum){ this.sum = sum; return this.sum;}

}
