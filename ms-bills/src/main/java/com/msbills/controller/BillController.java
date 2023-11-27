package com.msbills.controller;

import com.msbills.models.Bill;
import com.msbills.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bills")
@RequiredArgsConstructor
public class BillController {

    private final BillService service;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_user')")
    public ResponseEntity<List<Bill>> getAll() {
        return ResponseEntity.ok().body(service.getAllBill());
    }

    @GetMapping("/find")
    public ResponseEntity<List<Bill>> findBillsByUserId(@RequestParam String customerBill){
        return ResponseEntity.ok().body(service.findBillsByUserId(customerBill));
    }
    @PostMapping
    public ResponseEntity<Bill> saveBill(@RequestBody Bill bill){
        return ResponseEntity.ok(service.saveBill(bill));
    }
}
