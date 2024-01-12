package cz.cvut.oop.game;

public class Player {
    private String name;
    private double health;
    private Weapon currentWeapon;
    // Možná další atributy jako štít, lektvary a další vlastnosti

    public Player(String name, int health) {
        this.name = name;
        this.health = health;
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

}
