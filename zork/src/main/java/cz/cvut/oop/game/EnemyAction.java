package cz.cvut.oop.game;

import java.text.DecimalFormat;

public class EnemyAction {

    public static void performEnemyAction(GameData gameData) {
        Player player = gameData.getPlayer();
        Room currentRoom = gameData.getCurrentRoom();

        if (player != null && currentRoom != null) {
            Enemy enemy = currentRoom.getEnemy();

            if (enemy != null && !enemy.isDead()) {
                double enemyDamage = enemy.getDamage();
                player.receiveDamage(enemyDamage);

                if (player.isDead()) {
                    gameData.setFinished(true);
                    System.out.println("Zemřel jste. Hra skončila.");
                } else {
                    System.out.println("Nepřítel útočí a způsobil " + formatDamage(enemyDamage) + " poškození Vám. Zbývající životy hráče: " + formatHealth(player.getHealth()));
                }
            }
        }
    }



    private static String formatHealth(double health) {
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        return decimalFormat.format(health);
    }

    private static String formatDamage(double enemyDamage) {
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        return decimalFormat.format(enemyDamage);
    }
}
