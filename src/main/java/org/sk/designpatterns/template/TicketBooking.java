package org.sk.designpatterns.template;

import lombok.Builder;
import lombok.Data;
import org.sk.designpatterns.strategy.PaymentType;

import java.util.Date;

@Data
@Builder
public class TicketBooking {

    private Long userId;
    private Vehicle vehicle;
    private String onboardingPoint;
    private String arrivalPoint;
    private Date date;
    private PaymentType paymentType;
    private int noOfTickets;
    @Builder.Default
    private BookingStatus status = BookingStatus.TICKET_NOT_AVAILABLE;

}
