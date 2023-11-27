package com.example.msusers.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bill {
    private String idBill;
    private String customerBill;
    private String productBill;
    private Double totalPrice;

}
