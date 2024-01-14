package cz.cvut.oop.game;

import java.util.Objects;

public class Key extends Item {


    public Key(String name) {
        super(name);
    }

    @Override
    public ItemType getType() {
        return ItemType.KEY;
    }

    // Ve třídě Key
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Key otherKey = (Key) obj;
        return Objects.equals(getName(), otherKey.getName());
    }



}
