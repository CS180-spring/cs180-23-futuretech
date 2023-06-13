package com.futuretech180.document;

// The SingleReview class represents a review entity with properties such as first name, time, language, item, rating, and description.
// It provides methods for retrieving and setting the property values, as well as methods for searching based on keywords and ratings.

public class SingleReview {
    private String firstName;
    private String time;
    private String language;
    private String item;
    private double rating;
    private String description;

    // The class has two constructors: a default constructor and a parameterized constructor.
    // The default constructor does not take any arguments.
    // The parameterized constructor takes values for all the properties of a review and initializes the corresponding instance variables.

    public SingleReview(){
    }
    
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
    // toString() Method:
    // The toString() method is overridden to provide a string representation of the SingleReview object.
    // It returns a formatted string containing the values of the review properties.

    public String toString()
    {
        return firstName + " " + time + " " + language + " "
        + item + " " + (rating) + " " + description;
    }
    
    // keyWordSearch() Methods:
    // The class has two keyWordSearch() methods.
    // The first keyWordSearch(String str) method takes a search string as input and checks if the search string is present in any of the review properties.
    // The second keyWordSearch(double expectRating) method takes an expected rating as input and checks if the rating of the review matches the expected rating.

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
    
    // Getter and Setter Methods:
    // The class provides getter and setter methods for each of the review properties.
    // The getter methods are used to retrieve the values of the properties.
    // The setter methods are used to set the values of the properties.

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

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public void setTime(String time){
        this.time = time;
    }
    
    public void setLanguage(String language){
        this.language = language;
    }
    
    public void setItem(String item){
        this.item = item;
    }
    
    public void setRating(double rating){
        this.rating = rating;
    }
    
    public void setDescription(String description){
        this.description = description;
    }

}
