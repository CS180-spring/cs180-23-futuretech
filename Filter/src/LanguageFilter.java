import java.util.ArrayList;
import java.util.List;
public class LanguageFilter {
    public static List<Item> filterItemsByLanguage(List<Item> itemList, String language) {
        List<Item> filteredItems = new ArrayList<>();

        for (Item item : itemList) {
            if (item.getLanguages().equalsIgnoreCase(language)) {
                filteredItems.add(item);
            }
        }

        return filteredItems;
    }
}
