package io.platformbuilders.customers.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@AllArgsConstructor
@Data
@JsonInclude(NON_NULL)
@NoArgsConstructor
public class AddressViewData {
    private UUID id;

    private String postCode;

    private String streetName;

    private String streetNumber;

    private String city;

    private String state;

    private String country;
}
