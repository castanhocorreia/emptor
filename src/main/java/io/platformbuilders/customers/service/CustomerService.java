package io.platformbuilders.customers.service;

import io.platformbuilders.customers.model.CustomerEntity;
import io.platformbuilders.customers.repository.CustomerRepository;
import io.platformbuilders.customers.repository.CustomerSpecification;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;

import static io.platformbuilders.customers.util.PropertyRejector.rejectEmptyValues;

@RequiredArgsConstructor
@Service
public class CustomerService {
    private final AddressService addressService;
    private final CustomerRepository customerRepository;

    public CustomerEntity create(CustomerEntity customer) {
        var addresses = new HashSet<>(customer.getAddresses());
        customer.getAddresses().clear();
        addresses.forEach(
                address ->
                        customer.getAddresses()
                                .add(
                                        addressService
                                                .retrieve(address.getId())
                                                .orElse(addressService.create(address))));
        return customerRepository.save(customer);
    }

    public Page<CustomerEntity> index(CustomerSpecification spec, Pageable pageable) {
        return customerRepository.findAll(spec, pageable);
    }

    public CustomerEntity retrieve(UUID id) {
        return customerRepository
                .findById(Objects.requireNonNullElse(id, new UUID(0, 0)))
                .orElseThrow(NoSuchElementException::new);
    }

    public CustomerEntity update(CustomerEntity update) {
        var customer = retrieve(update.getId());
        BeanUtils.copyProperties(
                update, customer, ArrayUtils.addAll(rejectEmptyValues(update), "addresses"));
        update.getAddresses().forEach(addressService::modify);
        return customerRepository.save(customer);
    }

    public void destroy(UUID id) {
        var customer = retrieve(id);
        customerRepository.delete(customer);
    }
}
