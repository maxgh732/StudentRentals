package service;

import java.util.ArrayList;
import java.util.List;
import model.*;

public class ListingService {
    private List<Listing> listings = new ArrayList<>();
    private int nextId = 1;

    public void createListing(String title, double price, Homeowner owner) {
        Listing l = new Listing(nextId++, title, price, owner);
        listings.add(l);
        System.out.println("Listing created: " + l.getTitle());
    }

    public void viewListings() {
        if (listings.isEmpty()) {
            System.out.println("No listings available.");
            return;
        }
        for (Listing l : listings) {
            System.out.println(l.getId() + ": " + l.getTitle() + " (£" + l.getPrice() + ")");
        }
    }

    public void searchListingsByKeyword(String keyword) {
        boolean found = false;
        for (Listing l : listings) {
            if (l.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(l.getId() + ": " + l.getTitle() + " (£" + l.getPrice() + ")");
                found = true;
            }
        }
        if (!found) System.out.println("No listings found.");
    }

    public void searchListingsByPrice(double min, double max) {
        boolean found = false;
        for (Listing l : listings) {
            if (l.getPrice() >= min && l.getPrice() <= max) {
                System.out.println(l.getId() + ": " + l.getTitle() + " (£" + l.getPrice() + ")");
                found = true;
            }
        }
        if (!found) System.out.println("No listings found in this price range.");
    }

    public void searchListings(String keyword) {
        boolean found = false;
        for (Listing l : listings) {
            if (l.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(l.getId() + ": " + l.getTitle() + " (£" + l.getPrice() + ")");
                found = true;
            }
        }
        if (!found) System.out.println("No listings found.");
    }

    public List<Listing> getListings() {
        return listings;
    }
}
