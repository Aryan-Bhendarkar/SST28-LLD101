public class StudentIdGenerator {
    public String generate(int currentCount) {
        int next = currentCount + 1;
        return "SST-2026-" + String.format("%04d", next);
    }
}
