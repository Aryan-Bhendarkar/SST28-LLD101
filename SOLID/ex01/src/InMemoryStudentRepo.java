import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryStudentRepo implements StudentRepository {
    private final List<StudentRecord> records = new ArrayList<>();

    public void save(StudentRecord record) {
        records.add(record);
    }

    public int count() {
        return records.size();
    }

    public List<StudentRecord> findAll() {
        return Collections.unmodifiableList(records);
    }
}
