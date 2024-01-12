package cz.cvut.oop.game;

public abstract class Item {
    private String name;

    public Item(String name) {
        this.name = name;
    }
    enum ItemType {
        WEAPON,
        KEY
    }
    public String getName() {
        return name;
    }

    public abstract ItemType getType();


}

