package elakaddo.projects.Shipment.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateShipmentRequestDTO {
    @NotBlank(message = "Origin is required")
    public String origin;

    @NotBlank(message = "destination is required")
    public String destination;
    public String estimatedDelivery;
}
