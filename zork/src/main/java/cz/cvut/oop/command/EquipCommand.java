package cz.cvut.oop.command;

import cz.cvut.oop.game.GameData;
import cz.cvut.oop.game.Weapon;

import java.util.List;

public class EquipCommand implements Command {
    private Weapon currentWeapon;
    private List<Weapon> weaponsInRoom;

    public EquipCommand(List<Weapon> weaponsInRoom) {
        this.weaponsInRoom = weaponsInRoom;
    }

    @Override
    public String getName() {
        return "nasaď";
    }



    @Override
    public String execute(String[] arguments, GameData gameData) {

        if (arguments.length < 2) {
            return "Neplatný příkaz 'nasaď'. Musíte zadat název zbraně.";
        }

        String weaponName = arguments[1];

        Weapon newWeapon = null;
        for (Weapon weapon : weaponsInRoom) {
            if (weapon.getName().equalsIgnoreCase(weaponName)) {
                newWeapon = weapon;
                break;
            }
        }

        if (newWeapon == null) {
            return "Zbraň '" + weaponName + "' není v místnosti.";
        }

        if (currentWeapon != null) {
            weaponsInRoom.add(currentWeapon);
        }

        weaponsInRoom.remove(newWeapon);
        currentWeapon = newWeapon;

        return "Zbraň '" + weaponName + "' nasazena.";
    }
}
