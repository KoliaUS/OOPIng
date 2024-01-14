package cz.cvut.oop.command;

import cz.cvut.oop.game.*;

public class DropCommand implements Command {

    @Override
    public String getName() {
        return "polož";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {

        if (arguments.length < 2) {
            return "Musíte zadat název předmětu k položení.";
        }


        String itemName = arguments[1];

        Room currentRoom = gameData.getCurrentRoom();
        Player player = gameData.getPlayer();
        EnemyAction.performEnemyAction(gameData);

        Weapon currentWeapon = player.getCurrentWeapon();
        if (currentWeapon != null) {
            currentRoom.addItem(currentWeapon);
            player.setCurrentWeapon(null);
            return "Zbraň byla uspešně odebrána";
        }


        Item itemToDrop = player.getInventory().getItemByName(itemName);


        if (itemToDrop == null) {
            return "Předmět '" + itemName + "' není ve vašem inventáři.";
        }


        currentRoom.addItem(itemToDrop);
        player.getInventory().removeFromInventory(itemToDrop);

        return "Položil(a) jsi předmět '" + itemName + "' do místnosti.";
    }
}
