package cz.cvut.oop.command;

import cz.cvut.oop.game.*;
import org.junit.Assert;
import org.junit.Test;

public class GoCommandTest {

    @Test
    public void testGoCommandWithValidRoom() {
        Command goCommand = new GoCommand();
        GameDataImpl gameData = new GameDataImpl();


        RoomImpl room1 = new RoomImpl("Room1", "Description1");
        RoomImpl room2 = new RoomImpl("Room2", "Description2");

        room1.registerExit(room2);

        gameData.setCurrentRoom(room1);

        String[] arguments = {"jdi", "Room2"};
        String result = goCommand.execute(arguments, gameData);


        Assert.assertTrue(result.contains("Přesunut do místnosti Room2"));
        Assert.assertEquals(room2, gameData.getCurrentRoom());
    }

    @Test
    public void testGoCommandWithInvalidRoom() {
        Command goCommand = new GoCommand();
        GameDataImpl gameData = new GameDataImpl();


        RoomImpl room1 = new RoomImpl("Room1", "Description1");
        gameData.setCurrentRoom(room1);

        String[] arguments = {"jdi", "NoexistRoom"};
        String result = goCommand.execute(arguments, gameData);



        Assert.assertTrue(result.contains("Exit do místnosti 'NoexistRoom' neexistuje."));
        Assert.assertEquals(room1, gameData.getCurrentRoom());
    }

    @Test
    public void testGoCommandWithLockedRoomWithoutKey() {
        Command goCommand = new GoCommand();
        GameDataImpl gameData = new GameDataImpl();


        RoomImpl room1 = new RoomImpl("Room1", "Description1");
        RoomImpl room2 = new RoomImpl("Ruina", "Description2");

        room1.registerExit(room2);

        gameData.setCurrentRoom(room1);

        gameData.getPlayer().getInventory().addToInventory(new Weapon("Neco",50));

        String[] arguments = {"jdi", "Ruina"};
        String result = goCommand.execute(arguments, gameData);
        System.out.println(result);


        Assert.assertTrue(result.contains("K přístupu do Ruiny potřebuješ klíč!"));
        Assert.assertEquals(room1, gameData.getCurrentRoom());
    }
@Test
    public void testGoCommandWithEnemyInRoom() {
        Command goCommand = new GoCommand();
        GameDataImpl gameData = new GameDataImpl();


        Room room1 = new RoomImpl("room1", "Test Room Description", new Enemy("TestEnemy", new EnemyStats(2000, 200), new Weapon("test", 30)));
        RoomImpl room2 = new RoomImpl("Room2", "Description2");

        room1.registerExit(room2);
        gameData.setCurrentRoom(room1);



        String[] arguments = {"jdi", "Room2"};
        String result = goCommand.execute(arguments, gameData);


        Assert.assertTrue(result.contains("Nemůžeš jít do nové místnosti, dokud nezabiješ nepřítele v této místnosti!"));
        Assert.assertEquals(room1, gameData.getCurrentRoom());
    }


}