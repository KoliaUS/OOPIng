package cz.cvut.oop.game;

import java.util.Random;

// Třída reprezentující zbraň
public class Weapon {
    private String name;
    private final int minDamage;
    private final int maxDamage;

    public Weapon(String name,int minDamage, int maxDamage) {
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public int getDamage() {
        Random rand = new Random();
        return rand.nextInt(maxDamage - minDamage + 1) + minDamage;
    }

    public String getName(){
        return name;
    }
}
