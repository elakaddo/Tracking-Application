package elakaddo.projects.Shipment.controllers;

import elakaddo.projects.Shipment.DTO.ShipmentDTO;
import elakaddo.projects.Shipment.models.Shipment;
import elakaddo.projects.Shipment.services.ShipmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shipments")
@RequiredArgsConstructor
public class ShipmentController {
    private final ShipmentService shipmentService;

    @PostMapping
    public ResponseEntity<?> createShipment(@Valid @RequestBody ShipmentDTO.CreateShipmentRequest request) {
        var createdShipment = shipmentService.createShipment(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdShipment);
    }

    @GetMapping
    public ResponseEntity<?> getAllShipments() {
        var shipments = shipmentService.getAllShipments();
        return ResponseEntity.status(HttpStatus.OK).body(shipments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getShipmentById(@PathVariable Long id) {
        ShipmentDTO.ShipmentResponse shipment = shipmentService.getShipment(id);
        return ResponseEntity.status(HttpStatus.OK).body(shipment);
    }

    @GetMapping("/track/{trackingNumber}")
    public ResponseEntity<?> getShipmentBytrackingNumber(@PathVariable String trackingNumber) {
        ShipmentDTO.ShipmentResponse shipment = shipmentService.getShipmentBytrackingNumber(trackingNumber);
        return ResponseEntity.status(HttpStatus.OK).body(shipment);
    }
}
