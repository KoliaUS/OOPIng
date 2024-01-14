package cz.cvut.oop.command;

import cz.cvut.oop.game.*;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;


public class DropCommandTest {
    @Test
    public void testDropCommandWithWeapon() {
        DropCommand dropCommand = new DropCommand();
        GameDataImpl gameData = Mockito.spy(new GameDataImpl());


        Weapon currentWeapon = new Weapon("TestWeapon", 10);
        Player player = new Player();
        player.setCurrentWeapon(currentWeapon);
        gameData.getPlayer().getInventory().addToInventory(currentWeapon);


        Room room = new RoomImpl("TestRoom", "Test Room Description");
        gameData.setCurrentRoom(room);

        String[] arguments = {"drop", "TestWeapon"};
        String result = dropCommand.execute(arguments, gameData);

        System.out.println(result);


        Assert.assertTrue(result.contains("Položil(a) jsi předmět"));
        Assert.assertTrue(room.getItems().contains(currentWeapon));

    }

    @Test
    public void testDropCommandWithoutItem() {
        DropCommand dropCommand = new DropCommand();
        GameDataImpl gameData = Mockito.spy(new GameDataImpl());



        gameData.getPlayer().getInventory();


        Room room = new RoomImpl("TestRoom", "Test Room Description");
        gameData.setCurrentRoom(room);

        String[] arguments = {"drop", "Random"};
        String result = dropCommand.execute(arguments, gameData);




        Assert.assertTrue(result.contains("Předmět 'Random' není ve vašem inventáři."));
        Assert.assertTrue(room.getItems().isEmpty());
    }
}
