package io.platformbuilders.customers.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CustomerUpdateData {
    @NotNull private UUID id;

    private String fullName;

    private LocalDate birthDate;

    @Email private String email;

    @Size(min = 4)
    private String phoneNumber;

    private Set<AddressUpdateData> addresses;
}
