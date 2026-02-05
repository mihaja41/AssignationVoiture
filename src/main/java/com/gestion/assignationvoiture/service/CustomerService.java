package com.gestion.assignationvoiture.service;

import com.gestion.assignationvoiture.model.*;
import java.util.List;

public interface CustomerService {
    List<Customer> getAll();
    Customer getById(Integer id);
    void save(Customer obj);
    void delete(Integer id);
}