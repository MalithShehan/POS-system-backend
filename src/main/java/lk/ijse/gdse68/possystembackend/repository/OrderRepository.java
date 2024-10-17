package lk.ijse.gdse68.possystembackend.repository;

import lk.ijse.gdse68.possystembackend.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, String> {
}
