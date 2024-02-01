package cz.cvut.oop.game;

import java.util.Random;

public class Enemy {
    private final String name;
    private final EnemyStats stats;
    private double currentHealth;
    private Inventory inventory;

    private Enemy(EnemyBuilder builder) {
        this.name = builder.name;
        this.stats = builder.stats;
        this.currentHealth = builder.stats.getHealth();
        this.inventory = initInventory(builder.item);
    }

    public static class EnemyBuilder {
        private final String name;
        private final EnemyStats stats;
        private final Item item;

        public EnemyBuilder(String name, EnemyStats stats, Item item) {
            this.name = name;
            this.stats = stats;
            this.item = item;
        }

        public Enemy build() {
            return new Enemy(this);
        }
    }

    public String getName() {
        return name;
    }

    public EnemyStats getStats() {
        return stats;
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
        double enemyDamage = 1.0 + rand.nextDouble() * 10 + stats.getEnemyDamage();
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