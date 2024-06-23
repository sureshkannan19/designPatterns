package org.sk.designpatterns.template;

import org.sk.designpatterns.strategy.PaymentType;

import java.util.Date;

public class TicketBookingApplication {

    public static void main(String[] args) {
        TrainTicketBookTemplate t = new TrainTicketBookTemplate();
        t.bookAvailableTicket(TicketBooking.builder()
                .userId(1L)
                .noOfTickets(2)
                .onboardingPoint("Chennai")
                .arrivalPoint("Coimbatore")
                .date(new Date())
                .paymentType(PaymentType.CREDIT_CARD)
                .build());

        t.bookAvailableTicket(TicketBooking.builder()
                .userId(1L)
                .noOfTickets(51)
                .onboardingPoint("Chennai")
                .arrivalPoint("Coimbatore")
                .date(new Date())
                .paymentType(PaymentType.CREDIT_CARD)
                .build());
    }
}
