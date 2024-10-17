package lk.ijse.gdse68.possystembackend.repository;

import lk.ijse.gdse68.possystembackend.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, String> {
    boolean existsByItemCode(String itemCode);
}
