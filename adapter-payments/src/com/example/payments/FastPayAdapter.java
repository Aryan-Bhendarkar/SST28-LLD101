package com.example.payments;
import java.util.*;

public class FastPayAdapter implements PaymentGateway{
    private final FastPayClient client;

    public FastPayAdapter(FastPayClient client) {
        this.client = Objects.requireNonNull(client);
    }

    @Override
    public String charge(String customerId, int amountCents) {
        // Adapt: FastPayClient likely has a different method signature
        return client.payNow(customerId, amountCents); // adjust to actual method
    }
}