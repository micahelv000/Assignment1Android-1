package com.example.assigemnt1_recycler_view;

public class DataModel {
    private final String shortDesc;
    private final String name;
    private final String episodesNum;
    private final int image; // Integer
    private final String desc;

    public DataModel(String name, String episodesNum, int image, String desc, String shortDesc) {
        this.name = name;
        this.episodesNum = episodesNum;
        this.image = image;
        this.desc = desc;
        this.shortDesc = shortDesc;
    }

    public String getName() {
        return name;
    }
    public String getDesc() {
        return desc;
    }
    public String getShortDesc() { return shortDesc; }
    public String getEpisodesNum() {
        return episodesNum;
    }
    public int getImage() {
        return image;
    }
}
