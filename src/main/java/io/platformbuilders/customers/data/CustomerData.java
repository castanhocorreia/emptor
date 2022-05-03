package io.platformbuilders.customers.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@JsonInclude(NON_NULL)
public class CustomerData {
    private UUID id;

    @NotBlank(groups = {CustomerView.Record.class})
    private String fullName;

    @NotBlank(groups = {CustomerView.Record.class})
    private LocalDate birthDate;

    @Email(groups = {CustomerView.Record.class})
    private String email;

    private int age;

    private String phoneNumber;

    private Set<AddressData> addresses;

    private LocalDateTime createdDate;

    private LocalDateTime lastModifiedDate;

    public interface CustomerView {
        interface Record {}

        interface Update {}
    }
}
