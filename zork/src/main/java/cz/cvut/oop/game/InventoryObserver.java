package cz.cvut.oop.game;

import java.util.ArrayList;

public class InventoryObserver implements InventoryListener {
    private Player player;

    public InventoryObserver(Player player) {
        this.player = player;
    }
    public void printFullInventory(ArrayList<Item> items) {
        System.out.println("Obsah inventáře:");
        for (Item item : items) {
            System.out.println(item.getName());
        }

        Weapon currentWeapon = player.getCurrentWeapon();
        if (currentWeapon != null) {
            System.out.println(currentWeapon.getName());
        }


        System.out.println();


    }
}
