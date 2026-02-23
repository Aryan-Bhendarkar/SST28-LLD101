import java.util.HashMap;
import java.util.Map;

public class InMemoryInvoiceStore implements InvoiceStore {
    private final Map<String, String> files = new HashMap<>();

    public void save(String invoiceId, String content) {
        files.put(invoiceId, content);
    }

    public int countLines(String invoiceId) {
        String content = files.getOrDefault(invoiceId, "");
        if (content.isEmpty()) return 0;
        return content.split("\n").length;
    }
}
