package com.example.order_event_sender.Order;

public record Order (String userId, String product, int quantity, Double total) {
    @Override
    public String toString() {
        return ("User: " + this.userId + "; Product: " + this.product + "; Quantity: " + this.quantity + "; Total: " + this.total);
    }
}
