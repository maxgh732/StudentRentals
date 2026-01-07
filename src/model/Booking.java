package model;

/**
 *represents a booking made by a student for a property listing.
 *A booking links a student to a listing and tracks the
 *current status of the booking (e.g. confirmed, cancelled).
 */
public class Booking {
    private Student student;
    private Listing listing;
    private String status;

    public Booking(Student student, Listing listing) {
        this.student = student;
        this.listing = listing;
        this.status = "CONFIRMED"; 
    }

    public String getStatus() { return status; }
    public Student getStudent() { return student; }
    public Listing getListing() { return listing; }
}
