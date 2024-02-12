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

        EnemyType skeletonType = new EnemyType("Kostlivec", 20, 5);
        EnemyType undeadType = new EnemyType("Nemrtvý", 30, 6);
        EnemyType ghostType = new EnemyType("Duch",20,60);
        EnemyType servantDiabloType = new EnemyType("Čert", 20,60);
        EnemyType bossType = new EnemyType("Diablo", 25,100);

        Enemy kostlivec = new Enemy.EnemyBuilder("Kostlivec", skeletonType, null).build();
        Enemy kostlivecMec = new Enemy.EnemyBuilder("Kostlivec s Mečem",skeletonType,new Weapon("StribrnyMec",20)).build();

        Enemy nemrtvyMec = new Enemy.EnemyBuilder("Nemrtvy",undeadType,new Weapon("ZlatyMec",35)).build();
        Enemy duch = new Enemy.EnemyBuilder("Duch", ghostType, new Key("Klic")).build();
        Enemy cert = new Enemy.EnemyBuilder("Čert", servantDiabloType,new Weapon("OhnivyMec", 50)).build();
        Enemy diablo = new Enemy.EnemyBuilder("Diablo",bossType,null).build();


        baseRoom.addItem(sword);


        Room tombs = new RoomImpl("Hrobka", "Hrobka s kostlivcem",kostlivecMec);
        baseRoom.registerExit(tombs);
        tombs.registerExit(baseRoom);

        Room mine = new RoomImpl("Důl", "Důl s nemrtvým", nemrtvyMec);
        tombs.registerExit(mine);


        Room magicTower = new RoomImpl("Magickávěž", "Magická věž, kterou ochraňuje kostlivec",kostlivec);
        mine.registerExit(magicTower);
        mine.registerExit(tombs);

        Room secretRoom = new RoomImpl("TajnáMístnost", "Tajná místnost, kterou ochraňuje zlý duch kličníka",duch);


        Room tortureChamber = new RoomImpl("Mučírna", "Mučírna plná mrtvých těl, kterou ochraňuje dáblův sluha",cert);
        magicTower.registerExit(tortureChamber);
        magicTower.registerExit(mine);
        magicTower.registerExit(secretRoom);
        secretRoom.registerExit(magicTower);

        Room ruin = new RoomImpl("Ruina", "Sídlo dábla", diablo);
        tortureChamber.registerExit(ruin);
        tortureChamber.registerExit(magicTower);


        baseRoom.addItem(new Thing("Kost"));
        tombs.addItem(new Thing("Mince"));
        mine.addItem(new Thing("Prach"));
        magicTower.addItem(new Thing("Diamant"));
        magicTower.addItem(new Thing("Obleceni"));
        secretRoom.addItem(new Thing("Prsten"));

        rooms.add(baseRoom);
        rooms.add(tombs);
        rooms.add(mine);
        rooms.add(magicTower);
        rooms.add(secretRoom);
        rooms.add(tortureChamber);
        rooms.add(ruin);

        player = new Player();
        player.getInventory().addListener(new InventoryObserver(player));


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
