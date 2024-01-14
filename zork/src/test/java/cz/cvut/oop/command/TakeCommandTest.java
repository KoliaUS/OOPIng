package cz.cvut.oop.command;

import cz.cvut.oop.game.*;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;


public class TakeCommandTest {
    @Test
    public void testTakeCommandWithWeapon() {
        TakeCommand takeCommand = new TakeCommand();
        GameDataImpl gameData = Mockito.spy(new GameDataImpl());


        Room room = new RoomImpl("TestRoom", "Test Room Description");
        Weapon weaponToTake = new Weapon("TestWeapon", 10);
        room.addItem(weaponToTake);
        gameData.setCurrentRoom(room);



        gameData.getPlayer().setCurrentWeapon(null);

        String[] arguments = {"take", "TestWeapon"};
        String result = takeCommand.execute(arguments, gameData);


        Assert.assertTrue(result.contains("Vzal(a) jsi zbraň 'TestWeapon'."));
        Assert.assertEquals("TestWeapon", gameData.getPlayer().getCurrentWeapon().getName());
        Assert.assertFalse(room.getItems().contains(weaponToTake));
    }

    @Test
    public void testTakeCommandWithItem() {
        TakeCommand takeCommand = new TakeCommand();
        GameDataImpl gameData = Mockito.spy(new GameDataImpl());

        Room room = new RoomImpl("TestRoom", "Test Room Description");
        Key itemToTake = new Key("TestKey");
        room.addItem(itemToTake);
        gameData.setCurrentRoom(room);


        String[] arguments = {"take", "TestKey"};
        String result = takeCommand.execute(arguments, gameData);
        System.out.println(result);


        Assert.assertTrue(result.contains("Vzal(a) jsi předmět 'TestKey' a položil(a) jej do inventáře."));
        Assert.assertTrue(gameData.getPlayer().getInventory().getItemArrayList().contains(itemToTake));
        Assert.assertFalse(room.getItems().contains(itemToTake));
    }

    @Test
    public void testTakeCommandWithoutItem() {
        TakeCommand takeCommand = new TakeCommand();
        GameDataImpl gameData = Mockito.spy(new GameDataImpl());


        Room room = new RoomImpl("TestRoom", "Test Room Description");
        gameData.setCurrentRoom(room);



        String[] arguments = {"take", "NonExistingItem"};
        String result = takeCommand.execute(arguments, gameData);


        Assert.assertTrue(result.contains("Předmět 'NonExistingItem' není v této místnosti."));
        Assert.assertTrue(gameData.getPlayer().getInventory().getItemArrayList().isEmpty());
    }


}
