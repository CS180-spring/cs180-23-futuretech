import java.util.ArrayList;
import java.util.List;
public class NameFilter {
    public static List<Item> filterItemsByName(List<Item> itemList, String name) {
        List<Item> filteredItems = new ArrayList<>();

        for (Item item : itemList) {
            if (item.getName().equalsIgnoreCase(name)) {
                filteredItems.add(item);
            }
        }

        return filteredItems;
    }
}
