package io.platformbuilders.customers.service;

import io.platformbuilders.customers.model.AddressEntity;
import io.platformbuilders.customers.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static io.platformbuilders.customers.util.PropertyRejector.rejectEmptyValues;

@RequiredArgsConstructor
@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressEntity create(AddressEntity address) {
        return addressRepository.save(address);
    }

    public Optional<AddressEntity> retrieve(UUID id) {
        return addressRepository.findById(id);
    }

    public void modify(AddressEntity update) {
        var address = retrieve(Objects.requireNonNullElse(update.getId(), new UUID(0, 0)));
        if (address.isPresent()) {
            BeanUtils.copyProperties(update, address.get(), rejectEmptyValues(update));
            addressRepository.save(address.get());
        }
    }
}
