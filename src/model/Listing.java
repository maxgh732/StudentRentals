package model;

public class Listing {
    private int id;
    private String title;
    private double price;
    private Homeowner owner;

    public Listing(int id, String title, double price, Homeowner owner) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.owner = owner;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public double getPrice() { return price; }
    public Homeowner getOwner() { return owner; }
}
