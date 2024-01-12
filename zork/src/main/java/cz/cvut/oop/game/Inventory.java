package cz.cvut.oop.game;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> itemArrayList;
    private int size = 5;

    public Inventory() {
        this.itemArrayList = new ArrayList<>();
    }

    public void addToInventory(Item item) {
        if (itemArrayList.size() < size) {
            itemArrayList.add(item);
        } else {
            System.out.println("Není místo v inventáři.");
        }
    }
}
