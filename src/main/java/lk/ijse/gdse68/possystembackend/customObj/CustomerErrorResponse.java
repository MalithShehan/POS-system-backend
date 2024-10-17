package lk.ijse.gdse68.possystembackend.customObj;

import lk.ijse.gdse68.possystembackend.customObj.response.CustomerResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerErrorResponse implements CustomerResponse {
    private int errorCode;
    private String errorMessage;
}
