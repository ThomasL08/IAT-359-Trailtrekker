package com.example.trailtrekker;

public class HistoryItem {
    private String title;
//    private String longitude;
//    private String latitude;
    private String destination;

    public HistoryItem(String title, String destination) {
        this.title = title;
        this.destination = destination;
//        this.longitude = longitude;
//        this.latitude = latitude;
    }

    public String getTitle() {
        return title;
    }
    public String getDestination() {
        return destination;
    }
//    public String getDistance() {
//        return distance;
//    }

//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getLongitude() {
//        return longitude;
//    }
//
//    public void setLongitude(String longitude) {
//        this.longitude = longitude;
//    }
//
//    public String getLatitude() {
//        return latitude;
//    }
//
//    public void setLatitude(String latitude) {
//        this.latitude = latitude;
//    }
}


