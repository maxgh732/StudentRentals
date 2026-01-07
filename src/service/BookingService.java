package service;

import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 *service class responsible for handling booking-related operations.
 *This class manages the creation and storage of booking objects
 *and implements the booking request for students.
 */
public class BookingService {
    //stores all bookings made in the system
    private List<Booking> bookings = new ArrayList<>();

    public void requestBooking(int listingId, Student student, ListingService listingService) {
        //finds the listing that matches the provided ID
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

        //creates a new booking for the student and selected listing
        Booking b = new Booking(student, target);
        //stores the booking in the system
        bookings.add(b);
        System.out.println("Booking requested for '" + target.getTitle() + "'. Status: " + b.getStatus());
    }
}
