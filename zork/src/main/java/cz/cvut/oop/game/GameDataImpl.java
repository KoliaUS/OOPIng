package cz.cvut.oop.game;

import java.util.ArrayList;
import java.util.List;

/**
 *  All mutable game data should exist within this class
 *  e.g. room map, finished, inventory, weapons..
 */
public class GameDataImpl implements GameData {

    private Room currentRoom;
    private boolean finished;
    private List<Room> rooms;

    /**
     *  Room map registration in constructor
     */
    public GameDataImpl(){
        this.init();
    }

    public void init(){
        this.rooms = new ArrayList<>();
        Room baseRoom = new RoomImpl("vchod do jeskyně", "temná jeskyně plná nepřátel");
        Room tombs = new RoomImpl("Hrobky", "Hrobka s kostlivcem");
        baseRoom.registerExit(tombs);

        Room mine = new RoomImpl("Důl", "Důl s nemrtvým");
        tombs.registerExit(mine);

        Room magicTower = new RoomImpl("Magická věž", "Magická věž, kterou ochraňuje starý mág");
        mine.registerExit(magicTower);

        Room tortureChamber = new RoomImpl("Mučírna", "Mučírna plná mrtvých těl, kterou ochraňuje dáblův sluha");
        magicTower.registerExit(tortureChamber);

        Room ruin = new RoomImpl("Ruina", "Sídlo dábla");
        magicTower.registerExit(ruin);

        rooms.add(baseRoom);
        rooms.add(tombs);
        rooms.add(mine);
        rooms.add(magicTower);
        rooms.add(tortureChamber);
        rooms.add(ruin);


        this.currentRoom = baseRoom;
    }

    @Override
    public List<Room> getRooms() {
        return rooms;
    }

    @Override
    public Player getPlayer() {
        return null;
    }

    /**
     *  Sets room, where the user currently resides
     */
    @Override
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    @Override
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     *  Sets finished flag, indicating game is done/finished
     */
    @Override
    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    /**
     *  Retrieves finished flag -> parent components decides whether to end the game
     *  based on this method
     */
    @Override
    public boolean isFinished() {
        return finished;
    }
}
