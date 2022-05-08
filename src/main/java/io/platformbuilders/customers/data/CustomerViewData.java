package io.platformbuilders.customers.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@AllArgsConstructor
@Data
@JsonInclude(NON_NULL)
@NoArgsConstructor
public class CustomerViewData {
    private UUID id;

    private String fullName;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = STRING)
    private LocalDate birthDate;

    private int age;

    private String email;

    private String phoneNumber;

    private Set<AddressViewData> addresses;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", shape = STRING)
    private LocalDateTime createdDate;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", shape = STRING)
    private LocalDateTime lastModifiedDate;
}
