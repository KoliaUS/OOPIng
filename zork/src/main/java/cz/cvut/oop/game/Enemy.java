package cz.cvut.oop.game;

import java.util.Random;

public class Enemy {
    private final String name;
    private final EnemyStats stats;
    private int currentHealth;

    private Enemy(String name, EnemyStats stats) {
        this.name = name;
        this.stats = stats;
        this.currentHealth = stats.getHealth();
    }

    public String getName() {
        return name;
    }

    public EnemyStats getStats() {
        return stats;
    }

    public boolean receiveDamage(int damage) {
        currentHealth -= damage;
        if (currentHealth <= 0) {
            currentHealth = 0;
            return true; // Enemy was killed
        }
        return false; // Enemy survived
    }

    public int getMaxDamage() {
        return stats.getDamageMax();
    }

    public int getMinDamage() {
        return stats.getDamageMin();
    }

    public int getCurrentHealth() {
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
            return new Enemy(name, stats);
        }
    }
}
