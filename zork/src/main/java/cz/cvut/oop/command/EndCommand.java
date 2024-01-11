package cz.cvut.oop.command;

import cz.cvut.oop.game.GameData;

public class EndCommand implements Command {
    @Override
    public String getName(){
        return "Konec Hry";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        gameData.setFinished(true); // Nastaví flag označující, že hra je dokončena
        return "Hra byla ukončena.";
    }

}
