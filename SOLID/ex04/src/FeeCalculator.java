import java.util.List;

public class FeeCalculator {
    public Money calculateMonthly(RoomPricing roomPricing, List<AddOnPricing> addOnPricings) {
        Money total = roomPricing.monthlyBase();
        for (AddOnPricing addOn : addOnPricings) {
            total = total.plus(addOn.monthly());
        }
        return total;
    }
}
