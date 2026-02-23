public class ReceiptPrinter {
    public static void print(BookingRequest request, Money monthly, Money deposit) {
        System.out.println("Room: " + LegacyRoomTypes.nameOf(request.roomType) + " | AddOns: " + request.addOns);
        System.out.println("Monthly: " + monthly);
        System.out.println("Deposit: " + deposit);
        System.out.println("TOTAL DUE NOW: " + monthly.plus(deposit));
    }
}
