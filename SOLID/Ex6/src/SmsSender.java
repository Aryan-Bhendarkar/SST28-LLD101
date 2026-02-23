public class SmsSender implements NotificationSender {
    private final AuditLog audit;
    public SmsSender(AuditLog audit) { this.audit = audit; }

    @Override
    public void send(Notification n) {
        // Ignores subject; base type doesn't clarify expectations (smell)
        System.out.println("SMS -> to=" + n.phone + " body=" + n.body);
        audit.add("sms sent");
    }
}
