package cz.cvut.oop.command;

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

        gameData.setCurrentRoom(exitByName);
        return "Přesunut do místnosti " + gameData.getCurrentRoom().getDescriptionWithExits();
    }

}

