package elakaddo.projects.Shipment.repositories;

import elakaddo.projects.Shipment.models.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

}
