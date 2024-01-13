package cz.cvut.oop.game;

class Key extends Item {


    public Key(String name) {
        super(name);
    }

    @Override
    public ItemType getType() {
        return ItemType.KEY;
    }


}
