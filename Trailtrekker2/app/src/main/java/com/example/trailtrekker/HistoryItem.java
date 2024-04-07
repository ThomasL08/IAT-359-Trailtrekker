package com.example.trailtrekker;

public class HistoryItem {
    private String longitude;
    private String latitude;
    private String title;

    public HistoryItem(String longitude, String latitude, String title) {
        this.title = "Title: " + title;
        this.longitude = longitude;
        this.latitude = latitude;

    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
