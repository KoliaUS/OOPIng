package cz.cvut.oop.game;

import java.util.Random;

public class Enemy {
    private final String name;

    private double currentHealth;
    private final EnemyType enemyType;
    private Inventory inventory;

    private Enemy(EnemyBuilder builder) {
        this.name = builder.name;
        this.enemyType = builder.enemyType;
        this.currentHealth = builder.enemyType.getHealth();
        this.inventory = initInventory(builder.item);
    }

    public static class EnemyBuilder {
        private final String name;
        private final EnemyType enemyType;

        private final Item item;

        public EnemyBuilder(String name, EnemyType enemyType, Item item) {
            this.name = name;
            this.enemyType = enemyType;
            this.item = item;
        }

        public Enemy build() {
            return new Enemy(this);
        }
    }

    public EnemyType getEnemyType() {
        return enemyType;
    }

    public String getName() {
        return name;
    }



    public boolean receiveDamage(double damage) {
        currentHealth -= damage;
        if (currentHealth <= 0) {
            currentHealth = 0;
            return true;
        }
        return false;
    }

    public double getDamage() {
        Random rand = new Random();
        double enemyDamage = 1.0 + rand.nextDouble() * 10 + enemyType.getDamage();
        return enemyDamage;
    }

    public Inventory initInventory(Item item) {
        inventory = new Inventory();
        inventory.addToInventory(item, null);
        return inventory;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public double getCurrentHealth() {
        return currentHealth;
    }

    public boolean isDead() {
        return currentHealth <= 0.0;
    }

}