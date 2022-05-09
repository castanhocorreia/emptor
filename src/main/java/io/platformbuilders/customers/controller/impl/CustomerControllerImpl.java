package io.platformbuilders.customers.controller.impl;

import io.platformbuilders.customers.controller.CustomerController;
import io.platformbuilders.customers.data.CustomerRecordData;
import io.platformbuilders.customers.data.CustomerUpdateData;
import io.platformbuilders.customers.data.CustomerViewData;
import io.platformbuilders.customers.mapper.CustomerMapper;
import io.platformbuilders.customers.repository.CustomerSpecification;
import io.platformbuilders.customers.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@CrossOrigin(maxAge = 3600, origins = "*")
@RequestMapping("/customers")
@RequiredArgsConstructor
@RestController
@Slf4j
public class CustomerControllerImpl implements CustomerController {
    private final CustomerMapper customerMapper;
    private final CustomerService customerService;

    @Override
    @PostMapping
    public ResponseEntity<CustomerViewData> create(
            @RequestBody @Validated CustomerRecordData customerData) {
        var customerEntity = customerService.create(customerMapper.fromData(customerData));
        log.info("POST request for customer {}", customerData);
        return ResponseEntity.status(CREATED).body(customerMapper.fromEntity(customerEntity));
    }

    @GetMapping
    public ResponseEntity<Page<CustomerViewData>> index(
            CustomerSpecification spec,
            @PageableDefault(sort = "createdDate", direction = ASC) Pageable pageable) {
        var customerPage = customerService.index(spec, pageable);
        log.info("GET request for index customers with {}", spec);
        return ResponseEntity.status(OK).body(customerPage.map(customerMapper::fromEntity));
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<CustomerViewData> retrieve(@PathVariable UUID id) {
        var customerEntity = customerService.retrieve(id);
        log.info("GET request for customer with id {}", id);
        return ResponseEntity.status(OK).body(customerMapper.fromEntity(customerEntity));
    }

    @Override
    @PutMapping
    public ResponseEntity<CustomerViewData> modify(
            @RequestBody @Validated CustomerUpdateData customerData) {
        var customerEntity = customerService.update(customerMapper.fromData(customerData));
        log.info("PUT request for customer {}", customerData);
        return ResponseEntity.status(OK).body(customerMapper.fromEntity(customerEntity));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> destroy(@PathVariable UUID id) {
        customerService.destroy(id);
        log.info("DELETE request for customer with id {}", id);
        return ResponseEntity.status(OK).build();
    }
}
