package cz.cvut.oop.game;

import java.util.Collection;
import java.util.List;

public interface Room {

    String getName();
    String getDescription();
    String getDescriptionWithExits();
    Collection<Room> getExits();
    Room getExitByName(String name);
    void registerExit(Room room);
    Enemy getEnemy();
    String getDescriptionRoom();
    void addItemFromEnemy(Collection<Item> items);
    List<Item> getItems();

    void addItem(Item item);

    void removeItem(Item item);
}
