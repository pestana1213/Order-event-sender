package com.example.order_event_sender.Order;

public enum OrderStatus {
    PROCESSING("processing"),
    PROCESSED("processed"),
    SENT("sent"),
    RECEIVED("received");

    private String description;
    OrderStatus(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
