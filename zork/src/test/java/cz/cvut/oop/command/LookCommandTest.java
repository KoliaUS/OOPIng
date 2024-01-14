package cz.cvut.oop.command;

import cz.cvut.oop.game.*;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class LookCommandTest {

    @Test
    public void LookItemsTest() {
        Map<String, Command> commands = new HashMap<>();
        LookCommand lookCommand = new LookCommand();

        GameDataImpl gameData = new GameDataImpl();

        Room room = new RoomImpl("TestRoom", "Test Room");
        Item weapon = new Weapon("Mec", 50);
        room.addItem(weapon);


        gameData.getRooms().add(room);


        gameData.setCurrentRoom(room);


        String result = lookCommand.execute(null, gameData);
        System.out.println(result);

        Assert.assertTrue(result.contains("Momentálně jsi v místnosti: TestRoom\n"
                + "V místnosti se nachází tyto předměty:\n"
                + "- Mec\n"
                + "V místnosti není nepřítel.\n"
                + "V této místnosti nejsou žádné východy.\n"));
    }

    @Test
    public void testLookCommandWithEnemy() {
        LookCommand lookCommand = new LookCommand();
        GameDataImpl gameData = Mockito.spy(new GameDataImpl());


        Room room = new RoomImpl("TestRoom", "Test Room Description", new Enemy("TestEnemy", new EnemyStats(10,20),new Weapon("test",30)));

        gameData.setCurrentRoom(room);

        String result = lookCommand.execute(null, gameData);


        Assert.assertTrue(result.contains("TestEnemy"));
        Assert.assertTrue(result.contains("TestRoom"));
        Assert.assertTrue(result.contains("V této místnosti nejsou žádné východy."));

    }

    @Test
    public void testLookCommandWithoutItemsAndEnemy(){
        LookCommand lookCommand = new LookCommand();
        GameDataImpl gameData = Mockito.spy(new GameDataImpl());
        Room room = new RoomImpl("TestRoom", "Test Room Description");
        gameData.setCurrentRoom(room);
        String result = lookCommand.execute(null, gameData);


        Assert.assertTrue(result.contains("V místnosti není žádný předmět."));
        Assert.assertTrue(result.contains("V místnosti není nepřítel."));

    }



}
