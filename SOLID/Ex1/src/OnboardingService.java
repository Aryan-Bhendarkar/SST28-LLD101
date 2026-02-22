
import java.util.Map;


public class OnboardingService {
    private final StudentParser parser;
    private final StudentValidator validator;
    private final StudentRepository repository;

    public OnboardingService(StudentParser parser, StudentValidator validator, StudentRepository repository) {
        this.parser = parser;
        this.validator = validator;
        this.repository = repository;
    }

    public StudentRecord registerFromRawInput(String rawInput) {
      
        Map<String, String> data = parser.parse(rawInput);
        validator.validate(data);
        String id = IdUtil.nextStudentId(repository.count());
        StudentRecord record = new StudentRecord(
            id,
            data.get("name"),
            data.get("email"),
            data.get("phone"),
            data.get("program")
        );

        
        repository.save(record);
        
        return record;
    }
    
}
