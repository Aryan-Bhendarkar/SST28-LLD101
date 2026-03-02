import java.util.List;
import java.util.Map;

public class OnboardingService {
    private final StudentRepository repo;
    private final InputParser parser;
    private final StudentValidator validator;
    private final StudentIdGenerator idGenerator;
    private final RegistrationPrinter printer;

    public OnboardingService(StudentRepository repo) {
        this.repo = repo;
        this.parser = new InputParser();
        this.validator = new StudentValidator();
        this.idGenerator = new StudentIdGenerator();
        this.printer = new RegistrationPrinter();
    }

    public void registerFromRawInput(String raw) {
        System.out.println("INPUT: " + raw);
        Map<String, String> fields = parser.parse(raw);
        List<String> errors = validator.validate(fields);

        if (!errors.isEmpty()) {
            printer.printErrors(errors);
            return;
        }

        String id = idGenerator.generate(repo.count());
        StudentRecord rec = new StudentRecord(id,
                fields.get("name"), fields.get("email"),
                fields.get("phone"), fields.get("program"));

        repo.save(rec);
        printer.printSuccess(rec, repo.count());
    }
}
