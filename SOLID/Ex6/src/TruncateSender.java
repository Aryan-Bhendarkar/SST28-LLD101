public class TruncateSender implements NotificationSender {
    private final NotificationSender delegate;
    private final int maxLength;

    public TruncateSender(NotificationSender delegate, int maxLength) {
        this.delegate = delegate;
        this.maxLength = maxLength;
    }

    @Override
    public void send(Notification n) {
        String body = n.body;
        if (body != null && body.length() > maxLength) {
            body = body.substring(0, maxLength);
        }
        Notification safeNotif = new Notification(n.subject, body, n.email, n.phone);
        delegate.send(safeNotif);
    }
}