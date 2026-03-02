public class FakeBookingRepo implements BookingRepository {
    public void save(String bookingId, BookingRequest request, Money monthly, Money deposit) {
        System.out.println("Saved booking: " + bookingId);
    }
}
