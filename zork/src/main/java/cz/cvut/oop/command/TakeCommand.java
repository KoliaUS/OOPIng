package cz.cvut.oop.command;

import cz.cvut.oop.game.*;

public class TakeCommand implements Command {

    @Override
    public String getName() {
        return "vezmi";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        // Kontrola argumentů
        if (arguments.length < 2) {
            return "Musíte zadat název předmětu k sebrání.";
        }

        // Získání názvu předmětu
        String itemName = arguments[1];

        // Získání aktuální místnosti a hráče
        Room currentRoom = gameData.getCurrentRoom();
        Player player = gameData.getPlayer();

        // Hledání předmětu v místnosti
        Item itemToTake = null;
        for (Item item : currentRoom.getItems()) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                itemToTake = item;
                break;
            }
        }

        // Kontrola, zda se předmět nachází v místnosti
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

            // Nastavení nové zbraně hráči a odebrání z místnosti
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
