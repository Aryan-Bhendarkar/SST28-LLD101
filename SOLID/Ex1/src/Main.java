
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FakeDb db = new FakeDb(); 
        StudentParser parser = new StudentParser();
        StudentValidator validator = new StudentValidator(Arrays.asList("CSE", "ECE", "AI"));
        
        OnboardingService service = new OnboardingService(parser, validator, db);

        System.out.println("=== Student Onboarding ===");

        String[] inputs = {
            "name=Riya;email=riya@sst.edu;phone=9876543210;program=CSE",
            "name=John;email=john@sst.edu;phone=invalid;program=ARTS" // Fails phone and program
        };
       

       for (String rawInput : inputs) {
            System.out.println("INPUT: " + rawInput);
            try {
                StudentRecord record = service.registerFromRawInput(rawInput);
                
                System.out.println("OK: created student " + record.id);
                System.out.println("Saved. Total students: " + db.count());
                System.out.println("CONFIRMATION:");
                System.out.println(record.toString());
                
            } catch (IllegalArgumentException e) {
                System.out.println("Validation Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("System Error: " + e.getMessage());
            }
            System.out.println(); // Blank line for readability
        }
        
        System.out.println("-- DB DUMP --");
        System.out.print(TextTable.render3(db));
    }
}
