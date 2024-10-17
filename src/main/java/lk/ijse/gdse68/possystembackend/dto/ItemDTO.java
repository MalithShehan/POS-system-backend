package lk.ijse.gdse68.possystembackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO implements SuperDTO {
    private String itemCode;
    private String itemName;
    private int itemQty;
    private double itemPrice;

//    @JsonIgnore
//    private List<OrderEntity> orders;
}
