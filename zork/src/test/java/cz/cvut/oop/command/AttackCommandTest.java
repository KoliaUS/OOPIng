package cz.cvut.oop.command;
import cz.cvut.oop.game.*;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class AttackCommandTest {

    @Test
    public void testAttackCommand() {
        Command attackCommand = new AttackCommand();
        GameDataImpl gameData = Mockito.spy(new GameDataImpl());

        Room room = new RoomImpl("TestRoom", "Test Room Description", new Enemy("TestEnemy", new EnemyStats(10, 20), new Weapon("test", 30)));
        gameData.setCurrentRoom(room);


        Weapon weapon = new Weapon("HráčovaZbraň", 30);
        gameData.getPlayer().setCurrentWeapon(weapon);


        String[] arguments = {"útok"};
        String result = attackCommand.execute(arguments, gameData);


        Assert.assertTrue(result.contains("Nepřítel byl poražen!"));
        Assert.assertTrue(result.contains("Zbývající životy hráče"));
        Assert.assertFalse(room.getItems().isEmpty());
    }

    @Test
    public void testAttackCommandWithDeadPlayer() {
        Command attackCommand = new AttackCommand();
        GameDataImpl gameData = Mockito.spy(new GameDataImpl());

        Room room = new RoomImpl("TestRoom", "Test Room Description", new Enemy("TestEnemy", new EnemyStats(2000, 200), new Weapon("test", 30)));
        gameData.setCurrentRoom(room);

        String[] arguments = {"attack"};
        gameData.getPlayer().setCurrentWeapon(new Weapon("Mec", 2));
        String result = attackCommand.execute(arguments, gameData);


        Assert.assertTrue(result.contains("Zemřel jste. Hra skončila."));

    }

    @Test
    public void testAttackCommandWithoutWeapon() {
        Command attackCommand = new AttackCommand();
        GameDataImpl gameData = Mockito.spy(new GameDataImpl());

        Room room = new RoomImpl("TestRoom", "Test Room Description", new Enemy("TestEnemy", new EnemyStats(2000, 200), new Weapon("test", 30)));


        gameData.setCurrentRoom(room);

        String[] arguments = {"attack"};
        String result = attackCommand.execute(arguments, gameData);


        Assert.assertTrue(result.contains("Není nasazena žádná zbraň."));


    }
}
