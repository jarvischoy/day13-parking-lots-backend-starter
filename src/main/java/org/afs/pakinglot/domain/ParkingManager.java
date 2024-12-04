package org.afs.pakinglot.domain;

import java.util.Arrays;
import java.util.List;

import org.afs.pakinglot.domain.exception.UnrecognizedTicketException;
import org.afs.pakinglot.domain.strategies.ParkingStrategy;
import org.afs.pakinglot.domain.strategies.SequentiallyStrategy;
import org.afs.pakinglot.domain.strategies.AvailableRateStrategy;
import org.afs.pakinglot.domain.strategies.MaxAvailableStrategy;
import org.springframework.stereotype.Component;

@Component
public class ParkingManager {
    private final List<ParkingLot> parkingLots;
    private final List<ParkingBoy> parkingBoys;
    public ParkingManager() {
        ParkingLot plazaPark = new ParkingLot(1, "The Plaza Park", 9);
        ParkingLot cityMallGarage = new ParkingLot(2, "City Mall Garage", 12);
        ParkingLot officeTowerParking = new ParkingLot(3, "Office Tower Parking", 9);

        this.parkingLots = Arrays.asList(plazaPark, cityMallGarage, officeTowerParking);

        ParkingBoy standardParkingBoy = new ParkingBoy(parkingLots, new SequentiallyStrategy());
        ParkingBoy smartParkingBoy = new ParkingBoy(parkingLots, new AvailableRateStrategy());
        ParkingBoy superSmartParkingBoy = new ParkingBoy(parkingLots, new MaxAvailableStrategy());

        this.parkingBoys = Arrays.asList(standardParkingBoy, smartParkingBoy, superSmartParkingBoy);
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public Ticket park(Car car, int strategyIndex) {
        if (strategyIndex < 0 || strategyIndex >= parkingBoys.size()) {
            throw new IllegalArgumentException("Invalid strategy index");
        }
        return parkingBoys.get(strategyIndex).park(car);
    }

    public Car fetch(Ticket ticket) {
        for (ParkingBoy parkingBoy : parkingBoys) {
            try {
                return parkingBoy.fetch(ticket);
            } catch (UnrecognizedTicketException e) {
                // Continue to the next parking boy
            }
        }
        throw new UnrecognizedTicketException();
    }
}