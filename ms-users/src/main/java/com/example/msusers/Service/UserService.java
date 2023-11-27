package com.example.msusers.Service;

import com.example.msusers.Feign.IBillsFeignClient;
import com.example.msusers.Repository.UserRepository;
import com.example.msusers.domain.Bill;
import com.example.msusers.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final IBillsFeignClient billsFeignClient;

    public Optional<User>  findUserById (String id){
        Optional<User> user = userRepository.findUserByCustomerId(id);
        List<Bill> bills = billsFeignClient.findBillsByCustomerBill(id);

        user.ifPresent(value -> value.setBills(bills));
        return user;
    }
}
