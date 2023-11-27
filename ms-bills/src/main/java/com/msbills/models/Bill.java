package com.msbills.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Bill {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String idBill;

    private String customerBill;

    private String productBill;

    private Double totalPrice;

    public Bill(String customerBill, String productBill, Double totalPrice) {
        this.customerBill = customerBill;
        this.productBill = productBill;
        this.totalPrice = totalPrice;
    }
}
