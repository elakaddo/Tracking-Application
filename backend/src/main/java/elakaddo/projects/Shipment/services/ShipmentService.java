package elakaddo.projects.Shipment.services;

import elakaddo.projects.Shipment.DTO.ShipmentDTO;
import elakaddo.projects.Shipment.models.Shipment;
import elakaddo.projects.Shipment.repositories.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public ShipmentDTO.ShipmentResponse createShipment(ShipmentDTO.CreateShipmentRequest request) {
        Shipment shipment = Shipment.builder()
                .trackingNumber(generatedTrackingNumber())
                .origin(request.origin)
                .destination(request.destination)
                .estimatedDelivery(request.estimatedDelivery)
                .build();
        shipmentRepository.save(shipment);
        return mapToShipmentResponse(shipment);
    }

    public List<ShipmentDTO.ShipmentResponse> getAllShipments() {
        List<Shipment> shipments = shipmentRepository.findAll();
        return shipments.stream().map(this::mapToShipmentResponse).collect(Collectors.toList());
    }

    public ShipmentDTO.ShipmentResponse getShipment(Long id) {
        Shipment shipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipment with id " + id + " not found"));
        return mapToShipmentResponse(shipment);
    }

    public ShipmentDTO.ShipmentResponse getShipmentBytrackingNumber(String trackingNumber) {
        //Shipment shipment = shipmentRepository.findAll(String.valueOf(trackingNumber));
        return null;
    }

    private String generatedTrackingNumber() {
        return "TRK-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    private ShipmentDTO.ShipmentResponse mapToShipmentResponse(Shipment shipment) {
        return ShipmentDTO.ShipmentResponse.builder()
                .id(shipment.getId())
                .trackingNumber(shipment.getTrackingNumber())
                .origin(shipment.getOrigin())
                .destination(shipment.getDestination())
                .estimatedDelivery(shipment.getEstimatedDelivery())
                .createdAt(shipment.getCreatedAt())
                .updatedAt(shipment.getUpdatedAt())
                .status(shipment.getStatus())
                .currentLocation(shipment.getCurrentLocation())
                .build();
    }


}
