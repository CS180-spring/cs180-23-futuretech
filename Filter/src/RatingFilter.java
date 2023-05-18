import java.util.ArrayList;
import java.util.List;

public class RatingFilter {
    public static List<Item> filterItemsByRating(List<Item> itemList, double rating) {
        List<Item> filteredItems = new ArrayList<>();
        double epsilon = 0.0001; // You can adjust the value of epsilon as needed

        for (Item item : itemList) {
            if (Math.abs(item.getRating() - rating) < epsilon) {
                filteredItems.add(item);
            }
        }

        return filteredItems;
    }
}
