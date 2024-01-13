package cz.cvut.oop.command;

import cz.cvut.oop.game.GameData;

import java.util.Map;

public class HelpCommand implements Command {

    private Map<String, Command> commands;

    public HelpCommand(Map<String, Command> commands){
        this.commands = commands;
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        return "Možné příkazy:\n" +
                "help - Vysvětlení příkazů\n" +
                "polož - Příkaz po kterém se položí předmět na zem\n" +
                "útok - Útočíš na protivníka\n" +
                "reset - Resetuje/restartuje hru\n" +
                "vezmi - Vezmeš věci ze země\n" +
                "jdi - Půjdeš do vybrané místnosti\n" +
                "konec - Konec hry\n" +
                "hledat - Prohledáváš prostor kolem sebe";
    }
}

