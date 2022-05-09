package io.platformbuilders.customers.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AddressRecordData {
    @NotEmpty() private String postCode;

    @NotEmpty() private String streetName;

    private String streetNumber;

    @NotEmpty() private String city;

    private String state;

    @NotEmpty() private String country;
}
