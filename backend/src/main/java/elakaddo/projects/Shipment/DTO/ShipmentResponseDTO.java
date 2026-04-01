package elakaddo.projects.Shipment.DTO;

import elakaddo.projects.Shipment.models.ShipmentStatus;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentResponseDTO {
    private Long id;
    private String trackingNumber;
    private String origin;
    private String estimatedDelivery;
    private String destination;
    private ShipmentStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String currentLocation;
}
