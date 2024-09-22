package com.example.listview;

import android.widget.ImageView;

public class MyItems {
    private int thumnails;
    private String sName;

    public MyItems(int thumnails, String sName){
        this.thumnails = thumnails;
        this.sName = sName;
    }

    public int getThumnails() {
        return thumnails;
    }
    public String getsName(){
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public void setThumnails(int thumnails) {
        this.thumnails = thumnails;
    }
}
