package cz.cvut.oop.game;

import java.util.Random;

// Třída reprezentující zbraň
public class Weapon extends Item {
    private int damage;

    public Weapon(String name, int damage) {
        super(name);
        this.damage = damage;
    }


    @Override
    public ItemType getType() {
        return ItemType.WEAPON;
    }

    public double getDamage()
    {
        Random rand = new Random();
        double weaponDamage = 1.0 + rand.nextDouble() * 10 + damage;
        return weaponDamage;
    }
}


/*public class Weapon {
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
*/