package cz.cvut.oop.game;
import java.util.List;
interface InventoryListener {
     void onItemAdded(Item item);

     void onItemRemoved(Item item);
}
