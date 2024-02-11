package com.example.assigemnt1_recycler_view;

public class DataModel {
    private String name;
    private String version;
    private int image; // Integer
    private int id_;
    private String desc;

    public DataModel(String name, String version, int image, int id_ , String desc) {
        this.name = name;
        this.version = version;
        this.image = image;
        this.id_ = id_;
        this.desc = desc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }
    public String getDesc() {
        return desc;
    }

    public String getVersion() {
        return version;
    }

    public int getId_() {
        return id_;
    }

    public int getImage() {
        return image;
    }
}
