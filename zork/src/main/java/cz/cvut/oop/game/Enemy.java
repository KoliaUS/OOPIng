package cz.cvut.oop.game;

import java.util.Random;

public class Enemy {
    private final String name;
    private final EnemyStats stats;
    private double currentHealth;
    private Inventory inventory;

    public Enemy(String name, EnemyStats stats, Item item) {
        this.name = name;
        this.stats = stats;
        this.currentHealth = stats.getHealth();
        this.inventory = initInventory(item);
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
            return true; // Enemy was killed
        }
        return false; // Enemy survived
    }

    public double getDamage()
    {
        Random rand = new Random();
        double enemyDamage = 1.0 + rand.nextDouble() * 10 + stats.getEnemyDamage();
        return enemyDamage;
    }

    public Inventory initInventory(Item item){
        inventory = new Inventory();
        inventory.addToInventory(item);
        return inventory;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public double getCurrentHealth() {
        return currentHealth;
    }

    public static class EnemyBuilder {
        private final String name;
        private final EnemyStats stats;

        public EnemyBuilder(String name, EnemyStats stats) {
            this.name = name;
            this.stats = stats;
        }

        public Enemy build() {
            return new Enemy(name, stats,null);
        }
    }

    public boolean isDead() {
        if (currentHealth <= 0.0){
            return true;
        }
        return false;
    }
}
