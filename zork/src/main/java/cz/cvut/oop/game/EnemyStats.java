package cz.cvut.oop.game;

public class EnemyStats {
    private final int damageMin;
    private final int damageMax;
    private final int health;

    public EnemyStats(int damageMin, int damageMax, int health) {
        this.damageMin = damageMin;
        this.damageMax = damageMax;
        this.health = health;
    }

    public int getDamageMin() {
        return damageMin;
    }

    public int getDamageMax() {
        return damageMax;
    }

    public int getHealth() {
        return health;
    }
}

