package com.revature.purrfectbarkery.models;

public class Treats {
    private String id;
    private String name;
    private String flavor;
    private String color;
    private String shape;

    public Treats(){

    }

    public Treats(String id, String name, String flavor, String color, String shape) {
        this.id = id;
        this.name = name;
        this.flavor = flavor;
        this.color = color;
        this.shape = shape;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    @Override
    public String toString() {
        return "Treats{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", flavor='" + flavor + '\'' +
                ", color='" + color + '\'' +
                ", shape='" + shape + '\'' +
                '}';
    }
}
