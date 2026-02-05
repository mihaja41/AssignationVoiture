package com.gestion.assignationvoiture.service;

import com.gestion.assignationvoiture.model.*;
import com.gestion.assignationvoiture.repository.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repo;

    public List<Customer> getAll() { return repo.findAll(); }
    public Customer getById(Integer id) { return repo.findById(id).orElse(null); }
    public void save(Customer obj) { repo.save(obj); }
    public void delete(Integer id) { repo.deleteById(id); }
}