package io.platformbuilders.customers.repository;

import io.platformbuilders.customers.model.CustomerEntity;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Join;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@Join(path = "addresses", alias = "add")
@And({
    @Spec(path = "fullName", spec = Like.class),
    @Spec(path = "birthDate", spec = Equal.class),
    @Spec(path = "email", spec = Equal.class),
    @Spec(path = "phoneNumber", spec = Equal.class),
    @Spec(path = "add.postCode", params = "postCode", spec = Equal.class),
    @Spec(path = "add.city", params = "city", spec = Like.class),
    @Spec(path = "add.state", params = "state", spec = Equal.class),
    @Spec(path = "add.country", params = "country", spec = Like.class)
})
public interface CustomerSpecification extends Specification<CustomerEntity> {}
