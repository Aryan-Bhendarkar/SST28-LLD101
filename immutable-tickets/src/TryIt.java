import com.example.tickets.IncidentTicket;
import com.example.tickets.TicketService;

import java.util.List;

public class TryIt {

    public static void main(String[] args) {
        TicketService service = new TicketService();

        IncidentTicket t = service.createTicket("TCK-1001", "reporter@example.com", "Payment failing on checkout");
        System.out.println("Created: " + t);

        IncidentTicket assigned = service.assign(t, "agent@example.com");
        IncidentTicket escalated = service.escalateToCritical(assigned);

        System.out.println("\nOriginal ticket (unchanged): " + t);
        System.out.println("\nAfter assign + escalate (brand new object): " + escalated);

        List<String> tags = escalated.getTags();
        try {
            tags.add("HACKED_FROM_OUTSIDE");
            System.out.println("List was mutable - something went wrong");
        } catch (UnsupportedOperationException e) {
            System.out.println("\nTags list is immutable - mutation blocked correctly.");
        }

        IncidentTicket manual = IncidentTicket.builder()
                .id("TCK-2002")
                .reporterEmail("dev@example.com")
                .title("Login page broken after deploy")
                .priority("HIGH")
                .description("Users cannot log in after latest deploy")
                .addTag("AUTH")
                .addTag("P1")
                .slaMinutes(60)
                .source("WEBHOOK")
                .build();

        System.out.println("\nManually built ticket: " + manual);
    }
}
