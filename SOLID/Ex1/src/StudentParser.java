import java.util.HashMap;
import java.util.Map;

public class StudentParser {
    public Map<String, String> parse(String rawInput) {
        Map<String, String> data = new HashMap<>();
        if (rawInput == null || rawInput.isBlank()) {
            return data;
        }
        
        String[] pairs = rawInput.split(";");
        for (String pair : pairs) {
            String[] kv = pair.split("=");
            if (kv.length == 2) {
                data.put(kv[0].trim(), kv[1].trim());
            }
        }
        return data;
    }
}