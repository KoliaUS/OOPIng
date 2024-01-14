package cz.cvut.oop.command;

import cz.cvut.oop.game.GameDataImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

public class HelpCommandTest {
    @Test
    public void HelpCommandTextTest(){


        Map<String, Command> commands = new HashMap<>();
        HelpCommand helpCommand = new HelpCommand(commands);

        GameDataImpl gameData = Mockito.spy(new GameDataImpl());

        String result = helpCommand.execute(null, gameData);

        Command help = new HelpCommand(commands);
        Command reset = new ResetCommand();
        GoCommand go = new GoCommand();
        EndCommand end = new EndCommand();
        AttackCommand attack = new AttackCommand();
        LookCommand look = new LookCommand();
        TakeCommand take = new TakeCommand();
        DropCommand drop = new DropCommand();


        commands.put(help.getName(), help);
        commands.put(reset.getName(), reset);
        commands.put(go.getName(), go);
        commands.put(end.getName(), end);
        commands.put(attack.getName(),attack);
        commands.put(look.getName(),look);
        commands.put(take.getName(),take);
        commands.put(drop.getName(),drop);

        Assert.assertTrue(result.contains("Možné příkazy:\n" +
                "help - Vysvětlení příkazů\n" +
                "polož - Příkaz po kterém se položí předmět na zem\n" +
                "útok - Útočíš na protivníka\n" +
                "reset - Resetuje/restartuje hru\n" +
                "vezmi - Vezmeš věci ze země\n" +
                "jdi - Půjdeš do vybrané místnosti\n" +
                "konec - Konec hry\n" +
                "hledat - Prohledáváš prostor kolem sebe"));
    }


}
