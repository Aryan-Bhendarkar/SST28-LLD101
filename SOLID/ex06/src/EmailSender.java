public class EmailSender implements NotificationSender {
    private final AuditLog audit;

    public EmailSender(AuditLog audit) {
        this.audit = audit;
    }

    public void send(Notification notification) {
        System.out.println("EMAIL -> to=" + notification.email
                + " subject=" + notification.subject
                + " body=" + notification.body);
        audit.add("email sent");
    }
}
