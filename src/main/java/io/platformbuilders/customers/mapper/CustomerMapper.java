package io.platformbuilders.customers.mapper;

import io.platformbuilders.customers.data.CustomerRecordData;
import io.platformbuilders.customers.data.CustomerUpdateData;
import io.platformbuilders.customers.data.CustomerViewData;
import io.platformbuilders.customers.model.CustomerEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.time.LocalDate;
import java.time.Period;

@Mapper(componentModel = "spring")
public abstract class CustomerMapper {
    @AfterMapping
    protected void setAge(@MappingTarget CustomerViewData customer) {
        customer.setAge(Period.between(customer.getBirthDate(), LocalDate.now()).getYears());
    }

    public abstract CustomerEntity fromData(CustomerRecordData customer);

    public abstract CustomerEntity fromData(CustomerUpdateData customer);

    public abstract CustomerViewData fromEntity(CustomerEntity customer);
}
