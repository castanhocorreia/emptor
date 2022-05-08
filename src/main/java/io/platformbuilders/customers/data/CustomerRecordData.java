package io.platformbuilders.customers.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CustomerRecordData {
    private UUID id;

    @NotBlank private String fullName;

    @NotNull private LocalDate birthDate;

    @Email @NotNull private String email;

    @Size(min = 4)
    private String phoneNumber;

    @NotNull
    @Size(max = 10, min = 1)
    private Set<@Valid AddressRecordData> addresses;
}
