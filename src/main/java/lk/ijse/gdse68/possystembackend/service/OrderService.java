package lk.ijse.gdse68.possystembackend.service;

import lk.ijse.gdse68.possystembackend.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    void saveOrder(OrderDTO orderDTO);
    List<OrderDTO> getAllOrders();
}
