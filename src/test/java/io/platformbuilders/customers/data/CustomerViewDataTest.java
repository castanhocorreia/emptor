package io.platformbuilders.customers.data;

import io.platformbuilders.customers.mapper.CustomerMapper;
import io.platformbuilders.customers.model.CustomerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.assertEquals;

@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@SpringBootTest
class CustomerViewDataTest {
    @Autowired
    private CustomerMapper customerMapper;

    @Test
    void itShouldMapAgeFieldBasedOnBirthDate() {
        var customerModel = new CustomerEntity();
        var birthDate = LocalDate.of(1998, 7, 2);
        customerModel.setBirthDate(birthDate);
        var customerData = customerMapper.fromEntity(customerModel);
        assertEquals(customerData.getAge(), Period.between(birthDate, LocalDate.now()).getYears());
    }
}
