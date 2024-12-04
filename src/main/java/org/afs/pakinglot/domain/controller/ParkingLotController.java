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
public class ParkingLotController {

    private final ParkingManager parkingManager;

    public ParkingLotController(ParkingManager parkingManager) {
        this.parkingManager = parkingManager;
    }

    @GetMapping
    public ResponseEntity<List<ParkingLot>> getAllParkingLots() {
        return ResponseEntity.ok(parkingManager.getParkingLots());
    }

    @PostMapping("/park")
    public ResponseEntity<Ticket> parkCar(@RequestBody ParkRequestDto parkRequest) {
        Car car = new Car(parkRequest.getLicenseNumber());
        Ticket ticket = parkingManager.park(car, parkRequest.getStrategyIndex());
        return ResponseEntity.ok(ticket);
    }

    @PostMapping("/fetch")
    public ResponseEntity<Car> fetchCar(@RequestBody FetchRequestDto fetchRequest) {
        Car car = parkingManager.fetch(fetchRequest.getTicket());
        return ResponseEntity.ok(car);
    }
}