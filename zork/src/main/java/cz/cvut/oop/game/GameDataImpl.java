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

    private List<Room> visitedRooms;

    /**
     *  Room map registration in constructor
     */
    public GameDataImpl(){
        this.init();
    }

    public void init(){
        this.rooms = new ArrayList<>();
        Room baseRoom = new RoomImpl("VchodJeskyně", "temná jeskyně a před sebou vidíš dveře do Hrobky");
        Weapon sword = new Weapon("Meč", 10);
        baseRoom.addItem(sword);
        Room tombs = new RoomImpl("Hrobka", "Hrobka s kostlivcem",new Enemy("Kostlivec",new EnemyStats(4,20), new Weapon("StribrnyMec",20)));
        baseRoom.registerExit(tombs);
        tombs.registerExit(baseRoom);

        Room mine = new RoomImpl("Důl", "Důl s nemrtvým", new Enemy("Nemtrvý",new EnemyStats(6,30), new Weapon("ZlatyMec",30)));
        tombs.registerExit(mine);


        Room magicTower = new RoomImpl("Magickávěž", "Magická věž, kterou ochraňuje starý mág",new Enemy("Mág",new EnemyStats(10,35), new Weapon("KouzelnaHulka",40)));
        mine.registerExit(magicTower);
        mine.registerExit(tombs);

        Room secretRoom = new RoomImpl("TajnáMístnost", "Tajná místnost, kterou ochraňuje zlý duch kličníka",new Enemy("DuchKličník",new EnemyStats(20,60), new Key("Klic")));


        Room tortureChamber = new RoomImpl("Mučírna", "Mučírna plná mrtvých těl, kterou ochraňuje dáblův sluha", new Enemy("Čert",new EnemyStats(12,45), new Weapon("OhnivyMec", 50)));
        magicTower.registerExit(tortureChamber);
        magicTower.registerExit(mine);
        magicTower.registerExit(secretRoom);
        secretRoom.registerExit(magicTower);

        Room ruin = new RoomImpl("Ruina", "Sídlo dábla", new Enemy("Diablo", new EnemyStats(25,100),null));
        tortureChamber.registerExit(ruin);
        tortureChamber.registerExit(magicTower);

        rooms.add(baseRoom);
        rooms.add(tombs);
        rooms.add(mine);
        rooms.add(magicTower);
        rooms.add(secretRoom);
        rooms.add(tortureChamber);
        rooms.add(ruin);

        player = new Player();

        this.currentRoom = baseRoom;
        visitedRooms = new ArrayList<>();
        addVisitedRoom(currentRoom);
    }


    /**
     * Sets room, where the user currently resides
     */
    @Override
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
        addVisitedRoom(currentRoom);
    }

    private void addVisitedRoom(Room room) {
        if (!visitedRooms.contains(room) && room.equals(currentRoom)) {
            visitedRooms.add(room);

        }
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

    @Override
    public boolean hasVisitedRoom(Room room) {
        return visitedRooms.contains(room);
    }


}
