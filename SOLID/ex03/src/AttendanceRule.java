public class AttendanceRule implements EligibilityRule {
    public String check(StudentProfile profile) {
        if (profile.attendancePct < 75) {
            return "attendance below 75";
        }
        return null;
    }
}
