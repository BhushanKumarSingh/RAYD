package com.example.repair.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.repair.model.CustomerInvoice;

public interface CustomerInvoiceRepo extends CrudRepository<CustomerInvoice, Integer>{

	CustomerInvoice findByOrderId(int orderId);

}
