package com.futuretech180.document;
public class SingleReview {
    private String firstName;
    private String time;
    private String language;
    private String item;
    private double rating;
    private String description;

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
