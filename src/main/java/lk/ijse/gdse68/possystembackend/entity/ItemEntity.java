package lk.ijse.gdse68.possystembackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "item")
@Entity
public class ItemEntity implements SuperEntity {
    @Id
    private String itemCode;
    private String itemName;
    private String itemQty;
    private double itemPrice;

//    @ManyToMany(mappedBy = "items", cascade = CascadeType.ALL)
//    @ToString.Exclude
//    private List<OrderEntity> orders;
}
