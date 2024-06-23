package org.sk.designpatterns.template;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public abstract class TicketBookingTemplate {

    public void bookAvailableTicket(TicketBooking tb) {
        boolean isSeatLocked = false;
        List<Vehicle> availableVehicles = findAvailableVehicles(tb);
        for (Vehicle vehicle : availableVehicles) {
            isSeatLocked = lockSeat(tb, vehicle);
            if (isSeatLocked) {
                tb.setVehicle(vehicle);
                try {
                    payTicket(tb, vehicle);
                } catch (Exception e) {
                    tb.setStatus(BookingStatus.PAYMENT_FAILED);
                    break;
                }
                tb.setStatus(BookingStatus.PAYMENT_SUCCESS);
                break;
            }
        }
        bookingStatus(tb);
    }

    public void bookingStatus(TicketBooking tb) {
        log.info("Ticket {} ", tb);
    }

    public abstract List<Vehicle> findAvailableVehicles(TicketBooking tb);

    public abstract boolean lockSeat(TicketBooking tb, Vehicle vehicle);

    public abstract void payTicket(TicketBooking tb, Vehicle vehicle);


}
