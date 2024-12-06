package org.afs.pakinglot.domain.controller;

import org.afs.pakinglot.domain.Car;
import org.afs.pakinglot.domain.ParkingLot;
import org.afs.pakinglot.domain.ParkingManager;
import org.afs.pakinglot.domain.Ticket;
import org.afs.pakinglot.domain.dto.FetchRequestDto;
import org.afs.pakinglot.domain.dto.ParkRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking-lot")
@CrossOrigin(origins = "http://localhost:3000")
public class ParkingLotController {

    private final ParkingManager parkingManager;

    public ParkingLotController(ParkingManager parkingManager) {
        this.parkingManager = parkingManager;
        init();
    }

    private void init() {
        parkingManager.park(new Car("CX-3123"), 0);
        parkingManager.park(new Car("AB-8564"), 0);
        parkingManager.park(new Car("LS-3211"), 1);
        parkingManager.park(new Car("RT-3123"), 2);
        parkingManager.park(new Car("RJ-1999"), 2);
        parkingManager.park(new Car("ON-7999"), 1);
    }

    @GetMapping
    public ResponseEntity<List<ParkingLot>> getAllParkingLots() {
        return ResponseEntity.ok(parkingManager.getParkingLots());
    }

    @PostMapping("/park")
    public ResponseEntity<Ticket> parkCar(@RequestBody ParkRequestDto parkRequest) {
        Car car = new Car(parkRequest.getPlateNumber());
        Ticket ticket = parkingManager.park(car, parkRequest.getStrategyIndex());
        return ResponseEntity.ok(ticket);
    }

    @PostMapping("/fetch")
    public ResponseEntity<Car> fetchCar(@RequestBody FetchRequestDto fetchRequest) {
        Car car = parkingManager.fetch(new Ticket(fetchRequest.getPlateNumber(), fetchRequest.getPosition(), fetchRequest.getParkingLot()));
        return ResponseEntity.ok(car);
    }
}