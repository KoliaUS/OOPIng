package cz.cvut.oop.command;

import cz.cvut.oop.game.Enemy;
import cz.cvut.oop.game.GameData;
import cz.cvut.oop.game.*;

import java.text.DecimalFormat;
import java.util.Random;

public class AttackCommand implements Command {


    @Override
    public String getName() {
        return "útok";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        Player player = gameData.getPlayer();
        Enemy enemy = gameData.getCurrentRoom().getEnemy();
        Weapon currentWeapon = player.getCurrentWeapon();

        if (currentWeapon == null) {
            EnemyAction.performEnemyAction(gameData);
            return "Není nasazena žádná zbraň.";
        }

        if (enemy == null) {
            return "V místnosti není žádný nepřítel.";
        }

        double damage = currentWeapon.getDamage();
        boolean killedEnemy = enemy.receiveDamage(damage);

        if (killedEnemy) {

            if (player.isDead()) {
                return "Nepřítel byl poražen, ale bohužel jste zemřel.";
            } else if (enemy.getName().equals("Diablo")) {
                gameData.setFinished(true);
                return "Diablo byl poražen! Gratuluji, vyhrál jsi!";
            } else {
                gameData.getCurrentRoom().addItemFromEnemy(enemy.getInventory().getItemArrayList());
                gameData.getCurrentRoom().removeEnemy();
                return "Nepřítel byl poražen! Zbývající životy hráče: " + formatHealth(player.getHealth());
            }
        } else {
            double enemyDamage = enemy.getDamage();
            player.receiveDamage(enemyDamage);

            if (player.isDead()) {
                gameData.setFinished(true);
                return "Zemřel jste. Hra skončila.";
            } else {

                return "Nepřítel utrpěl " + formatDamage(damage) +
                        " poškození. Nepřítel útočí zpět a způsobil " + formatDamage(enemyDamage) + " poškození Vám. Zbývající životy hráče: " + formatHealth(player.getHealth()) +
                        ". Zbývající životy nepřítele: " + formatHealth(enemy.getCurrentHealth());
            }
        }
    }




    private String formatDamage(double damage) {
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        return decimalFormat.format(damage);
    }

    private String formatHealth(double health) {
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        return decimalFormat.format(health);
    }
}

