package org.sk.designpatterns.template;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j(topic = "TrainTicketBookTemplate")
public class TrainTicketBookTemplate extends TicketBookingTemplate {

    @Override
    public List<Vehicle> findAvailableVehicles(TicketBooking tb) {
        log.info("Finding available vehicles...");
        List<Vehicle> availableVehicles = new ArrayList<>();
        availableVehicles.add(Vehicle.builder().vehicleId(1)
                .vehicleType("Bus")
                .vehicleName("Coimbatore Deluxe")
                .noOfAvailableSeats(4)
                .build());

        availableVehicles.add(Vehicle.builder().vehicleId(2)
                .vehicleName("Coimbatore Express")
                .vehicleType("Train")
                .noOfAvailableSeats(50)
                .build());
        log.info("No of available vehicles found {} ", availableVehicles.size());
        return availableVehicles;
    }

    @Override
    public boolean lockSeat(TicketBooking tb, Vehicle vehicle) {
        log.info("Locking seat of vehicle {} ", vehicle);
        vehicle.setNoOfAvailableSeats(vehicle.getNoOfAvailableSeats() - tb.getNoOfTickets());
        return true;
    }

    @Override
    public void payTicket(TicketBooking tb, Vehicle vehicle) {
        log.info("Paying ticket via {} ", tb.getPaymentType());
    }

}
