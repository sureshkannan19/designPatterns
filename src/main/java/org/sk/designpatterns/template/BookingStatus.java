package org.sk.designpatterns.template;

import lombok.Getter;

@Getter
public enum BookingStatus {
    PAYMENT_FAILED("Ticket not booked due to payment failure."),
    TICKET_NOT_AVAILABLE("Ticket not booked due to unavailable seats."),
    PAYMENT_SUCCESS("Ticket booked successfully.");
    private final String status;

    BookingStatus(String status) {
        this.status = status;
    }
}