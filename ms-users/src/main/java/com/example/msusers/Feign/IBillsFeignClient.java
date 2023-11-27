package com.example.msusers.Feign;

import com.example.msusers.Feign.FeignConfiguration.OAuthFeignConfig;
import com.example.msusers.domain.Bill;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "ms-bills" , url = "http://localhost:8083" , configuration = OAuthFeignConfig.class)
public interface IBillsFeignClient {
    @GetMapping("/bills/find")
    List<Bill> findBillsByCustomerBill(@RequestParam String customerBill);

}
