package org.sk.designpatterns.template;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
public class Vehicle {

    private Integer vehicleId;
    private String vehicleName;
    private String vehicleType;
    @ToString.Exclude
    private int noOfAvailableSeats;
}
