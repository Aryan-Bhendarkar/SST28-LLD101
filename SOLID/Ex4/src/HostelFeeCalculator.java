import java.util.*;

public class HostelFeeCalculator { 
    private final List<FeeComponent> components;

    public HostelFeeCalculator(List<FeeComponent> components) { 
        this.components = components; 
    }

    public Money calculateMonthly(BookingRequest req) {
        Money total = new Money(0);
        for (FeeComponent component : components) {
            total = total.plus(component.calculate(req));
        }
        return total;
    }
}
