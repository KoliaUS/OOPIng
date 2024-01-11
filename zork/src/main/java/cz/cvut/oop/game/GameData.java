package cz.cvut.oop.game;

import java.util.List;

public interface GameData {

    boolean isFinished();
    void setFinished(boolean finished);
    Room getCurrentRoom();
    List<Room> getRooms();
    Player getPlayer();
    void setCurrentRoom(Room currentRoom);
    void init();
}
