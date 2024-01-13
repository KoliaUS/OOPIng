package cz.cvut.oop.game;

import java.util.ArrayList;
import java.util.Iterator;

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

    public ArrayList<Item> getItemArrayList() {
        return itemArrayList;
    }

    public void removeFromInventory(Item item) {
        itemArrayList.remove(item);
    }

    public Item getItemByName(String itemName) {
        for (Item item : itemArrayList) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }
}
