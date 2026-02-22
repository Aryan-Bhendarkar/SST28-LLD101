import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Cafeteria Billing ===");

        InvoiceStore store = new FileStore();
        InvoiceFormatter formatter = new InvoiceFormatter();
        TaxCalculator taxCalc = new TaxRules();
        DiscountCalculator discountCalc = new DiscountRules();

        CafeteriaSystem sys = new CafeteriaSystem(store, formatter, taxCalc, discountCalc);

        sys.addToMenu(new MenuItem("M1", "Veg Thali", 80.00));
        sys.addToMenu(new MenuItem("C1", "Coffee", 30.00));
        sys.addToMenu(new MenuItem("S1", "Sandwich", 60.00));

        List<OrderLine> order1 = List.of(
                new OrderLine("M1", 2),
                new OrderLine("C1", 1)
        );

        sys.checkout("student", order1);
        
        List<OrderLine> order2 = List.of(
                new OrderLine("M1", 1),
                new OrderLine("S1", 1),
                new OrderLine("C1", 1)
        );
        sys.checkout("staff", order2);
    }
}
