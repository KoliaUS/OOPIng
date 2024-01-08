package org.example.model;

public class Sklad {
    private String itemName;
    private int count;


    public Sklad(String itemName, int count){
        this.itemName = itemName;
        this.count = count;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setCount(int count) {
        this.count = count;
    }
}