package service;

import java.util.ArrayList;
import java.util.List;
import model.*;

//the service class is responsible for managing property listings
public class ListingService {
    //stores listings in the system
    private List<Listing> listings = new ArrayList<>();
    private int nextId = 1;
    
    //creates new listing
    public void createListing(String title, double price, Homeowner owner) {
        Listing l = new Listing(nextId++, title, price, owner);
        listings.add(l); //adds listing to the system
        System.out.println("Listing created: " + l.getTitle());
    }

    //displays all avaible listings
    public void viewListings() {
        if (listings.isEmpty()) {
            System.out.println("No listings available.");
            return;
        }
        for (Listing l : listings) {
            System.out.println(l.getId() + ": " + l.getTitle() + " (GBP " + l.getPrice() + ")");
        }
    }

    //searches listings by key word
    public void searchListingsByKeyword(String keyword) {
        boolean found = false;
        for (Listing l : listings) {
            if (l.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(l.getId() + ": " + l.getTitle() + " (GBP " + l.getPrice() + ")");
                found = true;
            }
        }
        if (!found) System.out.println("No listings found.");
    }

    //searches listing by price
    public void searchListingsByPrice(double min, double max) {
        boolean found = false;
        for (Listing l : listings) {
            if (l.getPrice() >= min && l.getPrice() <= max) {
                System.out.println(l.getId() + ": " + l.getTitle() + " (GBP " + l.getPrice() + ")");
                found = true;
            }
        }
        if (!found) System.out.println("No listings found in this price range.");
    }

    public void searchListings(String keyword) {
        boolean found = false;
        for (Listing l : listings) {
            if (l.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(l.getId() + ": " + l.getTitle() + " (GBP " + l.getPrice() + ")");
                found = true;
            }
        }
        if (!found) System.out.println("No listings found.");
    }

    //returns listings
    public List<Listing> getListings() {
        return listings;
    }
}
