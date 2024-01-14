package cz.cvut.oop.command;

import cz.cvut.oop.game.GameData;
import cz.cvut.oop.game.Item;
import cz.cvut.oop.game.Room;

import cz.cvut.oop.game.*;

import java.util.ArrayList;
import java.util.List;


public class LookCommand implements Command {
    @Override
    public String getName() {
        return "hledat";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        Room currentRoom = gameData.getCurrentRoom();
        List<Item> itemsInRoom = currentRoom.getItems();
        List<Room> exits = new ArrayList<>(currentRoom.getExits());

        StringBuilder result = new StringBuilder("Momentálně jsi v místnosti: " + currentRoom.getName() + "\n");

        if (!itemsInRoom.isEmpty()) {
            result.append("V místnosti se nachází tyto předměty:\n");
            for (Item item : itemsInRoom) {
                result.append("- ").append(item.getName()).append("\n");
            }
        } else {
            result.append("V místnosti není žádný předmět.\n");
        }

        if (currentRoom.getEnemy() != null && !currentRoom.getEnemy().isDead()) {
            result.append("V místnosti je nepřítel: ").append(currentRoom.getEnemy().getName()).append("\n");
        }
        else{
            result.append("V místnosti není nepřítel.\n");
        }
        EnemyAction.performEnemyAction(gameData);

        if (!exits.isEmpty()) {
            result.append("Můžeš jít do následujících místností:\n");
            for (Room exit : exits) {
                result.append("- ").append(exit.getName()).append("\n");
            }
        } else {
            result.append("V této místnosti nejsou žádné východy.\n");
        }

        return result.toString();
    }


}
