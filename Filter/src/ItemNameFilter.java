import java.util.ArrayList;
import java.util.List;

public class ItemNameFilter {
    public static List<Item> filterItemsByItemName(List<Item> itemList, String itemName) {
        List<Item> filteredItems = new ArrayList<>();

        for (Item item : itemList) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                filteredItems.add(item);
            }
        }

        return filteredItems;
    }
}
