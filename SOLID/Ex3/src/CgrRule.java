public class CgrRule implements EligibilityRule {
    private final double minCgr;
    public CgrRule(double minCgr) { this.minCgr = minCgr; }

    @Override
    public String evaluate(StudentProfile s) {
        if (s.cgr < minCgr) return "CGR below " + minCgr;
        return null;
    }
}