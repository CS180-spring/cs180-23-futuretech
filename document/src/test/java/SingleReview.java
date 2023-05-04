public class SingleReview {
    private String firstName;
    private String time;
    private String language;
    private String item;
    private double rating;
    private String description;

    public SingleReview(String firstName, String lastName, String language,
                        String item, double rating, String description) {
        this.firstName = firstName;
        this.time = lastName;
        this.language = language;
        this.item = item;
        this.rating = rating;
        this.description = description;
    }
//    @Override
    public String toString()
    {
        return firstName + " " + time + " " + language + " "
                + item + " " + (rating) + " " + description;
    }

    boolean keyWordSearch(String str)
    {
        return firstName.contains(str) || time.contains(str)
                || language.contains(str) || item.contains(str)
                || description.contains(str);
    }

    boolean keyWordSearch(double expectRating)
    {
        return expectRating == rating;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getTime() {
        return time;
    }

    public String getLanguage() {
        return language;
    }

    public String getItem() {
        return item;
    }

    public double getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }
}
