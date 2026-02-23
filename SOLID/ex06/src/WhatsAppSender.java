public class WhatsAppSender implements NotificationSender {
    private final AuditLog audit;

    public WhatsAppSender(AuditLog audit) {
        this.audit = audit;
    }

    public void send(Notification notification) {
        if (notification.phone == null || !notification.phone.startsWith("+")) {
            System.out.println("WA ERROR: phone must start with + and country code");
            audit.add("WA failed");
            return;
        }
        System.out.println("WA -> to=" + notification.phone + " body=" + notification.body);
        audit.add("wa sent");
    }
}
