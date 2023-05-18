public class Item {
    private String name;
    private String time;
    private String languages;
    private String itemName;
    private double rating;
    private String description;

    public Item(String name, String time, String languages, String itemName, double rating, String description) {
        this.name = name;
        this.time = time;
        this.languages = languages;
        this.itemName = itemName;
        this.rating = rating;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getLanguages() {
        return languages;
    }

    public String getItemName() {
        return itemName;
    }

    public double getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Result:\n" +
                " Name: '" + name + '\'' +"\n" +
                " Time: '" + time + '\'' + "\n" +
                " Languages: '" + languages + '\'' + "\n" +
                " ItemName: '" + itemName + '\'' + "\n" +
                " Rating: " + rating + "\n" +
                " Description: '" + description + '\'' ;
    }
}
