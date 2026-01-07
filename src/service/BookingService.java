package service;

import java.util.ArrayList;
import java.util.List;
import model.*;

public class BookingService {
    private List<Booking> bookings = new ArrayList<>();

    public void requestBooking(int listingId, Student student, ListingService listingService) {
        Listing target = null;
        for (Listing l : listingService.getListings()) {
            if (l.getId() == listingId) {
                target = l;
                break;
            }
        }

        if (target == null) {
            System.out.println("Listing ID not found.");
            return;
        }

        Booking b = new Booking(student, target);
        bookings.add(b);
        System.out.println("Booking requested for '" + target.getTitle() + "'. Status: " + b.getStatus());
    }
}
