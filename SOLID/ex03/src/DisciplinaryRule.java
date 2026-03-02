public class DisciplinaryRule implements EligibilityRule {
    public String check(StudentProfile profile) {
        if (profile.disciplinaryFlag != LegacyFlags.NONE) {
            return "disciplinary flag present";
        }
        return null;
    }
}
