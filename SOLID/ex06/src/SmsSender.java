public class SmsSender implements NotificationSender {
    private final AuditLog audit;

    public SmsSender(AuditLog audit) {
        this.audit = audit;
    }

    public void send(Notification notification) {
        System.out.println("SMS -> to=" + notification.phone + " body=" + notification.body);
        audit.add("sms sent");
    }
}
