import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String jsonFilePath = "/Users/zipengzhu/IdeaProjects/Filter/src/items_list.json";
        List<Item> itemList = JsonFileReader.readItemsFromJsonFile(jsonFilePath);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose filter criteria:");
            System.out.println("1. Language");
            System.out.println("2. Name");
            System.out.println("3. Item Name");
            System.out.println("4. Rating");
            System.out.println("5. Time");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character left by nextInt()

            if (choice == 0) {
                break;
            }



            List<Item> filteredItems;

            switch (choice) {
                case 1:
                    System.out.print("Enter the filter Language: ");
                    String filterLanguage = scanner.nextLine();
                    filteredItems = LanguageFilter.filterItemsByLanguage(itemList, filterLanguage);
                    break;
                case 2:
                    System.out.print("Enter the filter name: ");
                    String filterName = scanner.nextLine();
                    filteredItems = NameFilter.filterItemsByName(itemList, filterName);
                    break;
                case 3:
                    System.out.print("Enter the filter item name: ");
                    String filterItemName = scanner.nextLine();
                    filteredItems = ItemNameFilter.filterItemsByItemName(itemList, filterItemName);
                    break;
                case 4:
                    System.out.print("Enter the filter rating: ");
                    String filterRating = scanner.nextLine();
                    double ratingValue = Double.parseDouble(filterRating);
                    filteredItems = RatingFilter.filterItemsByRating(itemList, ratingValue);
                    break;
                case 5:
                    System.out.print("Enter the filter time: ");
                    String filterTime = scanner.nextLine();
                    filteredItems = TimeFilter.filterItemsByTime(itemList, filterTime);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }

            System.out.println("Filtered items:");
            for (Item item : filteredItems) {
                System.out.println(item);
            }
        }

        scanner.close();
    }
}

