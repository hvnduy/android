package com.example.demoandroidanimationview;

public class ItemDetail {
    private int id;
    private String descr;
 
    public ItemDetail(int id, String descr) {
        this.id = id;
        this.descr = descr;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getDescr() {
        return descr;
    }
 
    public void setDescr(String descr) {
        this.descr = descr;
    }
 
    @Override
    public String toString() {
        return descr;
    }
}