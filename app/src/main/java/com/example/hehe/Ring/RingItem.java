package com.example.hehe.Ring;

public class RingItem {

    String name;
    int resId;


    public RingItem(String name, int resId){
        this.name=name;
        this.resId=resId;
    }

    public String getName(){
        return name;
    }

    public int getResId(){
        return resId;
    }

    @Override
    public String toString(){
        return "RingItem{" +
                "name='"+name+'\''+
                '}';
    }
}
