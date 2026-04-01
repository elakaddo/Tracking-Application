package elakaddo.projects.Shipment.services;

import elakaddo.projects.Shipment.DTO.CreateShipmentRequestDTO;
import elakaddo.projects.Shipment.DTO.ShipmentResponseDTO;
import elakaddo.projects.Shipment.models.Shipment;
import elakaddo.projects.Shipment.repositories.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public ShipmentResponseDTO createShipment(CreateShipmentRequestDTO request) {
        Shipment shipment = Shipment.builder()
                .trackingNumber(generatedTrackingNumber())
                .origin(request.origin)
                .destination(request.destination)
                .estimatedDelivery(request.estimatedDelivery)
                .build();
        shipmentRepository.save(shipment);
        return mapToShipmentResponseDTO(shipment);
    }

    public List<ShipmentResponseDTO> getAllShipments() {
        List<Shipment> shipments = shipmentRepository.findAll();
        return shipments.stream().map(this::mapToShipmentResponseDTO).collect(Collectors.toList());
    }

    public ShipmentResponseDTO getShipment(Long id) {
        Shipment shipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipment with id " + id + " not found"));
        return mapToShipmentResponseDTO(shipment);
    }

    public ShipmentResponseDTO getShipmentBytrackingNumber(String trackingNumber) {
        Shipment shipment = shipmentRepository.findByTrackingNumber(trackingNumber).orElseThrow(
                () -> new RuntimeException("Shipment with trackingNumber " + trackingNumber + " not found")
        );
        return mapToShipmentResponseDTO(shipment);
    }

    private String generatedTrackingNumber() {
        return "TRK-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    private ShipmentResponseDTO mapToShipmentResponseDTO(Shipment shipment) {
        return ShipmentResponseDTO.builder()
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
