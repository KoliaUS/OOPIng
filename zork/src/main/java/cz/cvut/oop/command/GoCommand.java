package cz.cvut.oop.command;

import cz.cvut.oop.game.EnemyAction;
import cz.cvut.oop.game.GameData;
import cz.cvut.oop.game.Room;

public class GoCommand implements Command {
    private final String name = "jdi";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        if (arguments.length < 2) {
            return "Chybí cíl, kam chcete jít.";
        }

        String roomName = arguments[1];
        Room exitByName = gameData.getCurrentRoom().getExitByName(roomName);

        if (exitByName == null) {
            return "Exit do místnosti '" + roomName + "' neexistuje.";
        }


        if (gameData.getCurrentRoom().getEnemy() != null && !gameData.getCurrentRoom().getEnemy().isDead()) {
            EnemyAction.performEnemyAction(gameData);
            return "Nemůžeš jít do místnosti, dokud nezabiješ nepřítele v této místnosti!";
        }


        if (roomName.equalsIgnoreCase("Ruina") && !gameData.getPlayer().hasKey()) {
            return "K přístupu do Ruiny potřebuješ klíč!";
        }
        EnemyAction.performEnemyAction(gameData);

        gameData.setCurrentRoom(exitByName);
        return String.format("Přesunut do místnosti %s %s, \n %s",
                roomName, gameData.getCurrentRoom().getDescriptionWithExits(), gameData.getCurrentRoom().getDescriptionRoom());
    }


}
