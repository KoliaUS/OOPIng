package cz.cvut.oop.command;

import cz.cvut.oop.game.*;

public class TakeCommand implements Command {

    @Override
    public String getName() {
        return "vezmi";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        if (arguments.length < 2) {
            return "Musíte zadat název předmětu k sebrání.";
        }

        String itemName = arguments[1];


        Room currentRoom = gameData.getCurrentRoom();
        Player player = gameData.getPlayer();

        EnemyAction.performEnemyAction(gameData);

        Item itemToTake = null;
        for (Item item : currentRoom.getItems()) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                itemToTake = item;
                break;
            }
        }

        if (itemToTake == null) {
            return "Předmět '" + itemName + "' není v této místnosti.";
        }

        if (itemToTake instanceof Weapon) {
            Weapon weaponToTake = (Weapon) itemToTake;

            // Přidání původní zbraně do místnosti
            Weapon originalWeapon = player.getCurrentWeapon();
            if (originalWeapon != null) {
                currentRoom.addItem(originalWeapon);
            }


            player.setCurrentWeapon(weaponToTake);
            currentRoom.removeItem(itemToTake);

            return "Vzal(a) jsi zbraň '" + itemName + "'.";
        } else {
            player.getInventory().addToInventory(itemToTake);
            currentRoom.removeItem(itemToTake);
            return "Vzal(a) jsi předmět '" + itemName + "' a položil(a) jej do inventáře.";
        }
    }

}
