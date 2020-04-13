package com.platzi.reservation.resources;

import com.platzi.reservation.model.Customer;
import com.platzi.reservation.resources.DTO.CustomerDTO;
import com.platzi.reservation.services.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@Api(tags = "customer")
public class CustomerResource {
    private final CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    @ApiOperation(value = "create customer", notes = "create a new customer service")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "customer created successful"),
            @ApiResponse(code = 400, message = "Invalid request")})
    public ResponseEntity<Customer> create(@RequestBody CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setIdentification(customerDTO.getIdentification());
        customer.setName(customerDTO.getName());
        customer.setLastName(customerDTO.getLastName());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setAddress(customerDTO.getAddress());
        customer.setEmail(customerDTO.getEmail());

        return new ResponseEntity<>(this.customerService.create(customer), HttpStatus.CREATED);
    }

    @PutMapping("/{identification}")
    @ApiOperation(value = "update customer", notes = "update a new customer service")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "customer updated successful"),
            @ApiResponse(code = 404, message = "customer not found")})
    public ResponseEntity<Customer> update(@PathVariable("identification") String identification,
                                           @RequestBody CustomerDTO customerDTO) {

        Customer customer = this.customerService.findByIdentification(identification);

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        customer.setIdentification(customerDTO.getIdentification());
        customer.setName(customerDTO.getName());
        customer.setLastName(customerDTO.getLastName());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setAddress(customerDTO.getAddress());
        customer.setEmail(customerDTO.getEmail());

        return new ResponseEntity<>(this.customerService.update(customer), HttpStatus.OK);
    }

    @DeleteMapping("/{identification}")
    @ApiOperation(value = "delete customer", notes = "delete customer service")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "customer deleted successful"),
            @ApiResponse(code = 404, message = "customer not found")})
    public void delete(@PathVariable("identification") String identification) {

        Customer customer = this.customerService.findByIdentification(identification);

        if (customer != null) {
            this.customerService.delete(customer);
        }

    }

    @GetMapping
    @ApiOperation(value = "list customer", notes = "list all customers service")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "customers found successful"),
            @ApiResponse(code = 404, message = "customers not found")})
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.ok(this.customerService.findAll());
    }
}
