package io.platformbuilders.customers.repository;

import io.platformbuilders.customers.model.CustomerEntity;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@And({
    @Spec(path = "fullName", spec = Like.class),
    @Spec(path = "birthDate", spec = Equal.class),
    @Spec(path = "email", spec = Equal.class),
    @Spec(path = "phoneNumber", spec = Equal.class)
})
public interface CustomerSpecification extends Specification<CustomerEntity> {}
