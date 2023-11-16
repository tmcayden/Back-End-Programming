package com.example.demo.bootstrap;

import com.example.demo.dao.*;
import com.example.demo.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BootStrapData implements CommandLineRunner {

    public BootStrapData(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    private final CustomerRepository customerRepository;


    @Override
    public void run(String... args) throws Exception {
        if (customerRepository.count() < 2) {

            Customer customer2 = new Customer();
            customer2.setAddress("254 Merry Lane");
            customer2.setFirstName("Heather");
            customer2.setLastName("Jorgen");
            customer2.setPhone("123-456-7890");
            customer2.setPostal_code("12345");
            customerRepository.save(customer2);

            Customer customer3 = new Customer();
            customer3.setAddress("6512 Sparkly Lane");
            customer3.setFirstName("Steven");
            customer3.setLastName("Hanks");
            customer3.setPhone("512-572-1252");
            customer3.setPostal_code("35689");
            customerRepository.save(customer3);


            Customer customer4 = new Customer();
            customer4.setAddress("12 Green Road");
            customer4.setFirstName("Mary");
            customer4.setLastName("Poppins");
            customer4.setPhone("643-578-3667");
            customer4.setPostal_code("90678");
            customerRepository.save(customer4);


            Customer customer5 = new Customer();
            customer5.setAddress("173 Large Toe Bend");
            customer5.setFirstName("Anthony");
            customer5.setLastName("Davis");
            customer5.setPhone("173-694-7946");
            customer5.setPostal_code("34589");
            customerRepository.save(customer5);


            Customer customer6 = new Customer();
            customer6.setAddress("1672 Apple Orchard Route");
            customer6.setFirstName("Squidward");
            customer6.setLastName("Tentacles");
            customer6.setPhone("865-355-2347");
            customer6.setPostal_code("64468");
            customerRepository.save(customer6);

        }
    }
}
