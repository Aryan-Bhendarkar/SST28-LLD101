public class EmailSender implements NotificationSender {
    private final AuditLog audit;
    public EmailSender(AuditLog audit) { this.audit = audit; }

    @Override
    public void send(Notification n) {
        // LSP smell: truncates silently, changing meaning
        System.out.println("EMAIL -> to=" + n.email + " subject=" + n.subject + " body=" + n.body);
        audit.add("email sent");
    }
}
