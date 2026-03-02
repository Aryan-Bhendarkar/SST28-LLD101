import java.util.ArrayList;
import java.util.List;

public class AddOnPricingFactory {
    public static List<AddOnPricing> getAll(List<AddOn> addOns) {
        List<AddOnPricing> pricings = new ArrayList<>();
        for (AddOn addOn : addOns) {
            pricings.add(get(addOn));
        }
        return pricings;
    }

    public static AddOnPricing get(AddOn addOn) {
        return switch (addOn) {
            case MESS -> new MessPricing();
            case LAUNDRY -> new LaundryPricing();
            case GYM -> new GymPricing();
        };
    }
}
