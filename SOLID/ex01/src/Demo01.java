public class Demo01 {
    public static void main(String[] args) {
        System.out.println("=== Student Onboarding ===");
        InMemoryStudentRepo repo = new InMemoryStudentRepo();
        OnboardingService svc = new OnboardingService(repo);

        String raw = "name=Riya;email=riya@sst.edu;phone=9876543210;program=CSE";
        svc.registerFromRawInput(raw);

        System.out.println();
        System.out.println("-- DB DUMP --");
        System.out.print(new TablePrinter().render(repo));
    }
}
