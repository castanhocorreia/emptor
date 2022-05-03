package io.platformbuilders.customers.controller.impl;

import io.platformbuilders.customers.controller.CustomerController;
import io.platformbuilders.customers.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(maxAge = 3600, origins = "*")
@RequestMapping("/customers")
@RequiredArgsConstructor
@RestController
@Slf4j
public class CustomerControllerImpl implements CustomerController {
    private final CustomerService customerService;
}
