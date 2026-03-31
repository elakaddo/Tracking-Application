package elakaddo.projects.Shipment.DTO;

import elakaddo.projects.Shipment.models.ShipmentStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GenerationType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

public class ShipmentDTO {

    @Setter
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor

    public static class CreateShipmentRequest {
        @NotBlank(message = "Origin is required")
        public String origin;

        @NotBlank(message = "destination is required")
        public String destination;
        public String estimatedDelivery;
    }

    @Setter
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ShipmentResponse {
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
}
