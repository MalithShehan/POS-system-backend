package lk.ijse.gdse68.possystembackend.repository;

import lk.ijse.gdse68.possystembackend.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {
}
