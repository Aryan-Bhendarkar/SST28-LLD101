import java.util.Map;

public class AddOnFee implements FeeComponent {
    private final Map<AddOn, Money> rates;

    public AddOnFee(Map<AddOn, Money> rates) {
        this.rates = rates;
    }

    @Override
    public Money calculate(BookingRequest req) {
        Money total = new Money(0);
        for (AddOn a : req.addOns) {
            if (rates.containsKey(a)) {
                total = total.plus(rates.get(a));
            }
        }
        return total;
    }
}