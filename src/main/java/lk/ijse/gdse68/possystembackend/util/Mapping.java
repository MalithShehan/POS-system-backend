package lk.ijse.gdse68.possystembackend.util;

import lk.ijse.gdse68.possystembackend.dto.CustomerDTO;
import lk.ijse.gdse68.possystembackend.entity.CustomerEntity;
import org.hibernate.annotations.Comments;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    public CustomerEntity convertToEntity(CustomerDTO dto) {
        return modelMapper.map(dto, CustomerEntity.class);
    }

    public CustomerDTO convertToDTO(CustomerEntity entity) {
        return modelMapper.map(entity, CustomerDTO.class);
    }

    public List<CustomerDTO> convertToDTOList(List<CustomerEntity> entities) {
        return entities.stream().map(entity -> modelMapper.map(entity, CustomerDTO.class)).collect(Collectors.toList());
    }
}
