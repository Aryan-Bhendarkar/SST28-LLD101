import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final TaxPolicy taxPolicy;
    private final DiscountPolicy discountPolicy;
    private final InvoiceStore store;
    private final InvoicePrinter printer;
    private int invoiceSeq = 1000;

    public CafeteriaSystem(TaxPolicy taxPolicy, DiscountPolicy discountPolicy, InvoiceStore store) {
        this.taxPolicy = taxPolicy;
        this.discountPolicy = discountPolicy;
        this.store = store;
        this.printer = new InvoicePrinter();
    }

    public void addToMenu(MenuItem item) {
        menu.put(item.id, item);
    }

    public void checkout(List<OrderLine> lines) {
        String invoiceId = "INV-" + (++invoiceSeq);

        double subtotal = 0.0;
        for (OrderLine l : lines) {
            subtotal += menu.get(l.itemId).price * l.qty;
        }

        double taxPct = taxPolicy.taxPercent();
        double tax = subtotal * (taxPct / 100.0);
        double discount = discountPolicy.discountAmount(subtotal, lines.size());
        double total = subtotal + tax - discount;

        String formatted = printer.format(invoiceId, lines, menu, subtotal, taxPct, tax, discount, total);
        System.out.print(formatted);

        store.save(invoiceId, formatted);
        System.out.println("Saved invoice: " + invoiceId + " (lines=" + store.countLines(invoiceId) + ")");
    }
}
