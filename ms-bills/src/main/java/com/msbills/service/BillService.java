package com.msbills.service;

import com.msbills.models.Bill;
import com.msbills.repositories.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillService {

    private final BillRepository repository;

    public List<Bill> getAllBill() {
        return repository.findAll();
    }

    public List<Bill> findBillsByUserId(String customerBill){
        return repository.findBillsByCustomerBill(customerBill);
    }

    public Bill saveBill(Bill bill){
        return repository.save(bill);
    }

}
