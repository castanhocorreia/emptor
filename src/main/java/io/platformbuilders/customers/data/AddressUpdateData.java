package io.platformbuilders.customers.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AddressUpdateData {
    private UUID id;

    private String postCode;

    private String streetName;

    private String streetNumber;

    private String city;

    private String state;

    private String country;
}
