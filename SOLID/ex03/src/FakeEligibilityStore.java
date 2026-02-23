public class FakeEligibilityStore implements EligibilityStore {
    public void save(String rollNo, String status) {
        System.out.println("Saved evaluation for roll=" + rollNo);
    }
}
