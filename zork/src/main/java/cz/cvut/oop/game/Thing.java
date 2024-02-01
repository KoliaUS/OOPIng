package cz.cvut.oop.game;

public class Thing extends Item{
    public Thing(String name) {
        super(name);
    }

    @Override
    public ItemType getType() {
        return ItemType.THING;
    }
}
