package cz.cvut.oop.game;

public class EnemyType {
    private final String description;
    private final double health;
    private final double damage;

    public EnemyType(String description, double health, double damage) {
        this.description = description;
        this.health = health;
        this.damage = damage;
    }

    public String getDescription() {
        return description;
    }

    public double getHealth() {
        return health;
    }

    public double getDamage() {
        return damage;
    }

}
