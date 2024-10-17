package lk.ijse.gdse68.possystembackend.cotroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class HealthTestController {
    @GetMapping
    public String healthTest(){
        return "Customer collector app run successfully..!";
    }
}
