package cz.cvut.oop.game;

import java.util.HashMap;
import java.util.Map;

public class EnemyFlyweightFactory {
    private static final Map<String, Enemy> enemyFlyweights = new HashMap<>();

    public static Enemy getEnemy(String enemyType, EnemyStats stats, Item item) {
        enemyType = enemyType.toLowerCase();
        if (!enemyFlyweights.containsKey(enemyType)) {
            Enemy enemy = new Enemy.EnemyBuilder(enemyType, stats, item).build();
            enemyFlyweights.put(enemyType, enemy);
        }
        return enemyFlyweights.get(enemyType);
    }
}