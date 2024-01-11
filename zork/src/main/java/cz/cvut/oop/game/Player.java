package cz.cvut.oop.game;

public class Player {
    private String name;
    private int health;
    private Weapon currentWeapon;
    // Možná další atributy jako štít, lektvary a další vlastnosti

    public Player(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    public void receiveDamage(int damage) {
        int currentHealth = getHealth();
        int newHealth = currentHealth - damage;
        setHealth(newHealth);
    }

}
