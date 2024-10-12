package lk.ijse.gdse68.possystembackend.service;

import lk.ijse.gdse68.possystembackend.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);

    void updateCustomer(CustomerDTO customerDTO);

    CustomerDTO getCustomer(String customerId);

    void deleteCustomer(String customerId);

    List<CustomerDTO> getAllCustomers();
}
