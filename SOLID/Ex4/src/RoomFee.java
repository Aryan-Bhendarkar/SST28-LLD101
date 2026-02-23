import java.util.Map;

public class RoomFee implements FeeComponent {
    private final Map<Integer, Money> rates;
    private final Money defaultRate;

    public RoomFee(Map<Integer, Money> rates, Money defaultRate) {
        this.rates = rates;
        this.defaultRate = defaultRate;
    }

    @Override
    public Money calculate(BookingRequest req) {
        return rates.getOrDefault(req.roomType, defaultRate);
    }
}