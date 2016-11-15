package com.menanga.ezparking.Class;

/**
 * Created by sai on 15/11/2016.
 */

public class Contain {
    private String id;
    private String no;
    public Contain(String no, String id) {
        this.id = id;
        this.no = no;
    }

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getNo() {return no;}

    public void setNo(String no) {this.no = no;}
}

