package lk.ijse.gdse68.possystembackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse68.possystembackend.dto.OrderDTO;
import lk.ijse.gdse68.possystembackend.entity.ItemEntity;
import lk.ijse.gdse68.possystembackend.entity.OrderEntity;
import lk.ijse.gdse68.possystembackend.exception.DataPersistFailedException;
import lk.ijse.gdse68.possystembackend.repository.ItemRepository;
import lk.ijse.gdse68.possystembackend.repository.OrderRepository;
import lk.ijse.gdse68.possystembackend.service.OrderService;
import lk.ijse.gdse68.possystembackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveOrder(OrderDTO orderDTO) {
        if (!orderRepository.existsById(orderDTO.getOrderId())){
            orderRepository.save(mapping.convertToEntity(orderDTO));
            orderDTO.getItems().forEach(itemDTO -> {
                ItemEntity item = itemRepository.getReferenceById(itemDTO.getItemCode());
                item.setItemQty(item.getItemQty() - itemDTO.getItemQty());
                itemRepository.save(item);
            });
        }else {
            throw new DataPersistFailedException("Order already exist..!");
        }
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<OrderEntity> all = orderRepository.findAll();
        return mapping.convertOrderToDTOList(all);
    }

}