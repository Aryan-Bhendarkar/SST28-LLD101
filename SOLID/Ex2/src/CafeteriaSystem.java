import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final InvoiceStore store;
    private final InvoiceFormatter formatter;
    private final TaxCalculator taxCalc;
    private final DiscountCalculator discountCalc;
    private int invoiceSeq = 1000;

    public CafeteriaSystem(InvoiceStore store, InvoiceFormatter formatter, TaxCalculator taxCalc, DiscountCalculator discountCalc) {
        this.store = store;
        this.formatter = formatter;
        this.taxCalc = taxCalc;
        this.discountCalc = discountCalc;
    }

    public void addToMenu(MenuItem i) { menu.put(i.id, i); }

    // Intentionally SRP-violating: menu mgmt + tax + discount + format + persistence.
    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);
        
        double subtotal = 0.0;
        List<InvoiceLine> invLines = new ArrayList<>();
        
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            subtotal += lineTotal;
            invLines.add(new InvoiceLine(item.name, l.qty, lineTotal));
        }

        double taxPct = taxCalc.taxPercent(customerType);
        double tax = subtotal * (taxPct / 100.0);
        double discount = discountCalc.discountAmount(customerType, subtotal, lines.size());
        double total = subtotal + tax - discount;

        Invoice invoice = new Invoice(invId, invLines, subtotal, taxPct, tax, discount, total);
        
        String printable = formatter.format(invoice);
        System.out.print(printable);

        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")\n");
    }
}
