package com.example.trailtrekker;

public class HistoryItem {
    private String title;
    private String destination, distance, calories, steps;
//    private String longitude;
//    private String latitude;


    public HistoryItem(String title, String destination, String distance, String calories, String steps) {
        this.title = title;
        this.destination = destination;
        this.distance = distance;
        this.calories = calories;
        this.steps = steps;
//        this.longitude = longitude;
//        this.latitude = latitude;
    }

    public String getTitle() {
        return title;
    }
    public String getDestination() {
        return destination;
    }
    public String getDistance() {
        return distance;
    }
    public String getCalories() {
        return calories;
    }
    public String getSteps() {
        return steps;
    }

}


