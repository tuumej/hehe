package com.example.hehe.Ring;

public class RingItem {
    String text;
    int resid;

    public RingItem(String text, int resid){
        this.text = text;
        this.resid = resid;
    }

    public String getName(){
        return text;
    }

    public void setText(String text){
        this.text =text;
    }

    public int getResid(){
        return resid;
    }

    @Override
    public String toString(){
        return "RingItem{" +
                "text= '" + text+'\''+
                '}';
    }

}
