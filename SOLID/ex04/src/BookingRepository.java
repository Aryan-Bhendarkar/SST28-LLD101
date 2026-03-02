public interface BookingRepository {
    void save(String bookingId, BookingRequest request, Money monthly, Money deposit);
}
