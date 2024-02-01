package cz.cvut.oop.game;

import java.util.ArrayList;
import java.util.Iterator;

public class Inventory {
    private ArrayList<Item> itemArrayList;
    private int size = 5;
    private ArrayList<InventoryListener> listeners; // Seznam posluchačů

    public Inventory() {
        this.itemArrayList = new ArrayList<>();
        this.listeners = new ArrayList<>();
    }


    public void addListener(InventoryListener listener) {
        listeners.add(listener);
    }

    public void removeListener(InventoryListener listener) {
        listeners.remove(listener);
    }

    public void notifyInventory(){
        for (InventoryListener listener : listeners) {
            listener.printFullInventory(this.getItemArrayList());
        }
    }

    public String addToInventory(Item item,GameData gameData) {
        if (itemArrayList.size() < size) {
            itemArrayList.add(item);
            notifyInventory();
            if(gameData!=null) {
                gameData.getCurrentRoom().removeItem(item);
                return "Vzal(a) jsi předmět '" + item.getName() + "' a položil(a) jej do inventáře.";
            }
            return "";
        } else {
            return "Není místo v inventáři.";
        }
    }

    public ArrayList<Item> getItemArrayList() {
        return itemArrayList;
    }

    public void removeFromInventory(Item item) {
        if (itemArrayList.remove(item)) {
            notifyInventory();
        }
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
