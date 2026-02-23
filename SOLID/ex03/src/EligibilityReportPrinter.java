public class EligibilityReportPrinter {
    public void print(StudentProfile profile, EligibilityResult result) {
        System.out.println("Student: " + profile.name
                + " (CGR=" + String.format("%.2f", profile.cgr)
                + ", attendance=" + profile.attendancePct
                + ", credits=" + profile.earnedCredits
                + ", flag=" + LegacyFlags.nameOf(profile.disciplinaryFlag) + ")");
        System.out.println("RESULT: " + result.status);
        for (String reason : result.reasons) {
            System.out.println("- " + reason);
        }
    }
}
