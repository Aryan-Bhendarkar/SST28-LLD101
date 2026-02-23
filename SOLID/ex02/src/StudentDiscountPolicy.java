public class StudentDiscountPolicy implements DiscountPolicy {
    public double discountAmount(double subtotal, int lineCount) {
        if (subtotal >= 180.0) {
            return 10.0;
        }
        return 0.0;
    }
}
