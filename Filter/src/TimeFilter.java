import java.util.ArrayList;
import java.util.List;

public class TimeFilter {
    public static List<Item> filterItemsByTime(List<Item> itemList, String time) {
        List<Item> filteredItems = new ArrayList<>();

        for (Item item : itemList) {
            if (item.getTime().equalsIgnoreCase(time)) {
                filteredItems.add(item);
            }
        }

        return filteredItems;
    }
}
