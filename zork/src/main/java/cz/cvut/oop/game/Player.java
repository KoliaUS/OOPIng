package cz.cvut.oop.game;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collection;

public class Player {
    private String name;
    private double health;
    private Weapon currentWeapon;
    private Inventory inventory;



    // Možná další atributy jako štít, lektvary a další vlastnosti

    public Player() {
        this.health = 100;
        this.currentWeapon = null;
        this.inventory = new Inventory();
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }


    public void receiveDamage(double damage) {
        double currentHealth = getHealth();
        double newHealth = currentHealth - damage;
        setHealth(newHealth);
    }

    public boolean isDead() {
        if (health <= 0.0){
            return true;
        }
        return false;
    }


    public Inventory getInventory() {
        return inventory;
    }

    public boolean hasKey() {
        for (Item item : inventory.getItemArrayList()) {
            if (item.getType() == Item.ItemType.KEY) {
                return true;
            }
        }
        return false;
    }




}
