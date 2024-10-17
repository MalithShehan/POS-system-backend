package lk.ijse.gdse68.possystembackend.service;

import lk.ijse.gdse68.possystembackend.customObj.ItemResponse;
import lk.ijse.gdse68.possystembackend.dto.ItemDTO;
import lk.ijse.gdse68.possystembackend.repository.ItemRepository;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDTO itemDTO);

    void updateItem(ItemDTO itemDTO);

    ItemResponse getItem(String itemCode);

    void deleteItem(String itemCode);

    List<ItemDTO> getAllItem();
}
