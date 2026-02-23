public class PushNotificationSender implements NotificationSender {
    private final AuditLog audit;
    public PushNotificationSender(AuditLog audit) { this.audit = audit; }

    @Override
    public void send(Notification n) {
        System.out.println("PUSH -> subject=" + n.subject + " body=" + n.body);
        audit.add("push sent");
    }
}