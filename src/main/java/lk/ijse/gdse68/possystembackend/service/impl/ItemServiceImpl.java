package lk.ijse.gdse68.possystembackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse68.possystembackend.customObj.ItemErrorResponse;
import lk.ijse.gdse68.possystembackend.customObj.ItemResponse;
import lk.ijse.gdse68.possystembackend.dto.ItemDTO;
import lk.ijse.gdse68.possystembackend.entity.ItemEntity;
import lk.ijse.gdse68.possystembackend.exception.DataPersistFailedException;
import lk.ijse.gdse68.possystembackend.exception.ItemNotFountException;
import lk.ijse.gdse68.possystembackend.repository.ItemRepository;
import lk.ijse.gdse68.possystembackend.service.ItemService;
import lk.ijse.gdse68.possystembackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveItem(ItemDTO itemDTO) {
        if (!itemRepository.existsByItemCode(itemDTO.getItemCode())){
            ItemEntity save = mapping.convertToEntity(itemDTO);
            if (save != null && save.getItemCode() != null){
                itemRepository.save(save);
            }else {
                throw new DataPersistFailedException("Item save failed..!");
            }
        }else {
            throw new DataPersistFailedException("Item already exist..!");
        }
    }

    @Override
    public void updateItem(ItemDTO itemDTO) {
        Optional<ItemEntity> itemEntity = itemRepository.findById(itemDTO.getItemCode());
        if (itemEntity.isPresent()) {
            itemEntity.get().setItemName(itemDTO.getItemName());
            itemEntity.get().setItemPrice(itemDTO.getItemPrice());
            itemEntity.get().setItemQty(String.valueOf(itemDTO.getItemQty()));
        } else {
            throw new ItemNotFountException("item update failed..!");
        }
    }

    @Override
    public ItemResponse getItem(String itemCode) {
        Optional<ItemEntity> itemEntity = itemRepository.findById(itemCode);
        return (itemEntity.isPresent())
                ? (ItemResponse) mapping.convertToDTO(itemEntity.get())
                : new ItemErrorResponse(0, "Item not found");
    }

    @Override
    public void deleteItem(String itemCode) {
        if (itemRepository.existsById(itemCode)) {
            itemRepository.deleteById(itemCode);
        } else {
            throw new ItemNotFountException("Item not found..!");
        }
    }

    @Override
    public List<ItemDTO> getAllItem() {
        return mapping.convertItemToDTOList(itemRepository.findAll());
    }

}
