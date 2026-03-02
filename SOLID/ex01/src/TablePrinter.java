public class TablePrinter {
    public String render(StudentRepository repo) {
        StringBuilder sb = new StringBuilder();
        sb.append("| ID             | NAME | PROGRAM |\n");
        for (StudentRecord r : repo.findAll()) {
            sb.append(String.format("| %-14s | %-4s | %-7s |\n", r.id, r.name, r.program));
        }
        return sb.toString();
    }
}
