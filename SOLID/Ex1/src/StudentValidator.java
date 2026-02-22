import java.util.List;
import java.util.Map;

public class StudentValidator {
    private final List<String> allowedPrograms;

    public StudentValidator(List<String> allowedPrograms) {
        this.allowedPrograms = allowedPrograms;
    }

    public void validate(Map<String, String> data) {
        if (!data.containsKey("name") || data.get("name").isBlank()) {
            throw new IllegalArgumentException("Name is required.");
        }
        if (!data.containsKey("email") || !data.get("email").contains("@")) {
            throw new IllegalArgumentException("Valid email is required.");
        }
        if (!data.containsKey("phone") || !data.get("phone").matches("\\d+")) {
            throw new IllegalArgumentException("Valid phone is required.");
        }
        if(!data.containsKey("program") || !allowedPrograms.contains(data.get("program"))) {
            throw new IllegalArgumentException("Program must be one of: " + allowedPrograms);
        }
    }
}