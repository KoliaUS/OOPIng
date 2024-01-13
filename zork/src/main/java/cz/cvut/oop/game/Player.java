package cz.cvut.oop.game;

public class Player {
    private String name;
    private double health;
    private Weapon currentWeapon;
    private Inventory inventory;

    // Možná další atributy jako štít, lektvary a další vlastnosti

    public Player() {
        this.health = 100;
        this.currentWeapon = startWeapon();
        this.inventory = new Inventory();
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

    public Weapon startWeapon() {
        // Vytvoření instance startovací zbraně s názvem "Startovací meč" a poškozením 10
        Weapon startWeapon = new Weapon("Startovací meč", 30);

        // Nastavení startovací zbraně hráči


        return startWeapon;
    }

    public void receiveDamage(double damage) {
        double currentHealth = getHealth();
        double newHealth = currentHealth - damage;
        setHealth(newHealth);
    }

    public boolean isDead() {
        if (health <= 0.0){
            return true;
        }
        return false;
    }
}
