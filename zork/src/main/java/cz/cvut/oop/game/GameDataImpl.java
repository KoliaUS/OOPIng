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
    private Player player;

    /**
     *  Room map registration in constructor
     */
    public GameDataImpl(){
        this.init();
    }

    public void init(){
        this.rooms = new ArrayList<>();
        Room baseRoom = new RoomImpl("vchod do jeskyně", "temná jeskyně a před sebou vidíš dveře do Hrobky");
        Room tombs = new RoomImpl("Hrobka", "Hrobka s kostlivcem",new Enemy("Kostlivec",new EnemyStats(10,75), new Weapon("ZMec",10)));
        baseRoom.registerExit(tombs);

        Room mine = new RoomImpl("Důl", "Důl s nemrtvým", new Enemy("Nemtrvý",new EnemyStats(15,85), new Weapon("ZMec",10)));
        tombs.registerExit(mine);

        Room magicTower = new RoomImpl("Magickávěž", "Magická věž, kterou ochraňuje starý mág",new Enemy("Mág",new EnemyStats(20,95), new Weapon("ZMec",10)));
        mine.registerExit(magicTower);

        Room tortureChamber = new RoomImpl("Mučírna", "Mučírna plná mrtvých těl, kterou ochraňuje dáblův sluha", new Enemy("Čert",new EnemyStats(25,105), new Key("Klic")));
        magicTower.registerExit(tortureChamber);

        Room ruin = new RoomImpl("Ruina", "Sídlo dábla", new Enemy("Diablo", new EnemyStats(35,120),null));
        tortureChamber.registerExit(ruin);

        rooms.add(baseRoom);
        rooms.add(tombs);
        rooms.add(mine);
        rooms.add(magicTower);
        rooms.add(tortureChamber);
        rooms.add(ruin);

        player = new Player();

        this.currentRoom = baseRoom;
    }

    @Override
    public List<Room> getRooms() {
        return rooms;
    }

    @Override
    public Player getPlayer() {
        return player;
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
