package com.androidfung.cardboard;

/**
 * Created by fung on 5/8/2016.
 */
public class Place {

    private final String name;
    private final String thumbnailUrl;
    private final String panoramaUrl;


    public Place(String name, String thumbnailUrl, String panoramaUrl) {
        this.name = name;
        this.thumbnailUrl = thumbnailUrl;
        this.panoramaUrl = panoramaUrl;
    }

    public String getName() {
        return name;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getPanoramaUrl() {
        return panoramaUrl;
    }
}
