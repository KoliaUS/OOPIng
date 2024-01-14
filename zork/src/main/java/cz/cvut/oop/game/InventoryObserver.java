package cz.cvut.oop.game;

import java.util.ArrayList;

public class InventoryObserver implements InventoryListener {
    public void printFullInventory(ArrayList<Item> items) {
        System.out.println("Obsah inventáře:");
        for (Item item : items) {
            System.out.println(item.getName());
        }
        System.out.println();
    }
}
