package com.evaglass;

import com.evaglass.entity.Customer;
import com.evaglass.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrdersManagementApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(OrdersManagementApplication.class, args);
    }

    @Autowired
    CustomerRepository customerRepository;
    @Override
    public void run(String... args) throws Exception {
//       Customer customer1=new Customer("Bogdan","0770491","a@gmail.com");
//       customerRepository.save(customer1);
//        Customer customer2=new Customer("Alexandra","0770491","a@gmail.com");
//        customerRepository.save(customer2);
    }
}
