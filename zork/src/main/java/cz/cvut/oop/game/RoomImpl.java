package cz.cvut.oop.game;

import java.util.*;
import java.util.stream.Collectors;

/**
 *  Class represents Room, e.g. space in our game. It contains exits and can form a map of Rooms
 */
public class RoomImpl implements Room {

    private String name;
    private String description;
    private Map<String,Room> exits = new HashMap<>();

    private Collection<Item> items = new ArrayList<>();


    private Enemy enemy;


    public RoomImpl(String name, String description){
        this.name = name;
        this.description = description;
    }

    public RoomImpl(String name, String description, Enemy enemy){
        this.name = name;
        this.description = description;
        this.enemy = enemy;
    }

    public void addItem(Item item)
    {
        items.add(item);
    }

    @Override
    public void removeItem(Item item) {
        items.remove(item);
    }

    @Override
    public void addItemFromEnemy(Collection<Item> items)
    {
        this.items.addAll(items);
    }

    @Override
    public List<Item> getItems() {
        return Collections.unmodifiableList(new ArrayList<>(items));
    }



    /**
     *  Adds new exit to map
     */
    @Override
    public void registerExit(Room room){
        exits.put(room.getName(), room);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescriptionRoom(){
        if(enemy==null){
            return "Popisek: "+description;
        }
        return "V místnosti se nachází: "+enemy.getName()+ " popisek: " + description;
    }

    /**
     *  Method returns description of this room (from getDescription call)
     *  and should add possible exit names
     */
    @Override
    public String getDescriptionWithExits() {
        return "východy: " + String.join(", ", this.exits.keySet());
    }

    /**
     *  Method returns description of this room
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     *  Return unmodifiable view of our map
     */
    @Override
    public Collection<Room> getExits() {
        return Collections.unmodifiableCollection(exits.values());
    }

    /**
     *  Returns room based on entered room (exit) name
     */
    @Override
    public Room getExitByName(String name) {
        return exits.getOrDefault(name, null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomImpl room = (RoomImpl) o;
        return Objects.equals(name, room.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


    @Override
    public Enemy getEnemy() {
        return enemy;
    }
}
