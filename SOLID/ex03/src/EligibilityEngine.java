import java.util.ArrayList;
import java.util.List;

public class EligibilityEngine {
    private final List<EligibilityRule> rules;
    private final EligibilityStore store;

    public EligibilityEngine(List<EligibilityRule> rules, EligibilityStore store) {
        this.rules = rules;
        this.store = store;
    }

    public void runAndPrint(StudentProfile profile) {
        EligibilityResult result = evaluate(profile);
        new EligibilityReportPrinter().print(profile, result);
        store.save(profile.rollNo, result.status);
    }

    public EligibilityResult evaluate(StudentProfile profile) {
        List<String> reasons = new ArrayList<>();
        for (EligibilityRule rule : rules) {
            String reason = rule.check(profile);
            if (reason != null) {
                reasons.add(reason);
                return new EligibilityResult("NOT_ELIGIBLE", reasons);
            }
        }
        return new EligibilityResult("ELIGIBLE", reasons);
    }
}
