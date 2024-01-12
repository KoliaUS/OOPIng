package cz.cvut.oop.game;

public class EnemyStats {
    private double enemyDamage;
    private double health;

    public EnemyStats(double enemyDamage, double health) {
        this.enemyDamage = enemyDamage;
        this.health = health;
    }

    public double getEnemyDamage() {
        return enemyDamage;
    }

    public double getHealth() {
        return health;
    }
}

