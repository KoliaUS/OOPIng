package cz.cvut.oop.command;

import cz.cvut.oop.game.Enemy;
import cz.cvut.oop.game.GameData;
import cz.cvut.oop.game.Weapon;

import java.util.Random;

public class AttackCommand implements Command {
    private Weapon currentWeapon;
    private Enemy enemy;

    public AttackCommand(Weapon currentWeapon, Enemy enemy) {
        this.currentWeapon = currentWeapon;
        this.enemy = enemy;
    }

    @Override
    public String getName() {
        return "útok";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        if (currentWeapon == null) {
            return "Není nasazena žádná zbraň.";
        }

        int damage = currentWeapon.getDamage();
        boolean killedEnemy = enemy.receiveDamage(damage);

        if (killedEnemy) {
            return "Nepřítel byl poražen! Útok způsobil " + damage + " poškození.";
        } else {
            // Pokud nepřítele nezabijeme, útočí na nás
            Random rand = new Random();
            int enemyDamage = rand.nextInt(enemy.getMaxDamage() - enemy.getMinDamage() + 1) + enemy.getMinDamage();
            gameData.getPlayer().receiveDamage(enemyDamage);
            return "Nepřítel utrpěl " + damage + " poškození. Nepřítel útočí zpět a způsobil " + enemyDamage + " poškození.";
        }
    }
}
