import java.util.List;
import java.util.Random;

public class HostelFeeCalculator {
    private final BookingRepository repo;
    private final FeeCalculator calculator;

    public HostelFeeCalculator(BookingRepository repo) {
        this.repo = repo;
        this.calculator = new FeeCalculator();
    }

    public void process(BookingRequest request) {
        RoomPricing roomPricing = RoomPricingFactory.get(request.roomType);
        List<AddOnPricing> addOnPricings = AddOnPricingFactory.getAll(request.addOns);

        Money monthly = calculator.calculateMonthly(roomPricing, addOnPricings);
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(request, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000));
        repo.save(bookingId, request, monthly, deposit);
    }
}
