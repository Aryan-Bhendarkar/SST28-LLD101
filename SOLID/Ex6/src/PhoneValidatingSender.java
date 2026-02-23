public class PhoneValidatingSender implements NotificationSender {
    private final NotificationSender delegate;

    public PhoneValidatingSender(NotificationSender delegate) {
        this.delegate = delegate;
    }

    @Override
    public void send(Notification n) {
        if (n.phone == null || !n.phone.startsWith("+")) {
            throw new IllegalArgumentException("phone must start with + and country code");
        }
        delegate.send(n);
    }
}