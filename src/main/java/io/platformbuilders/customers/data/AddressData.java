package io.platformbuilders.customers.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@JsonInclude(NON_NULL)
public class AddressData {
    private UUID id;

    @NotEmpty(groups = {AddressView.Record.class})
    private String postCode;

    @NotEmpty(groups = {AddressView.Record.class})
    private String streetName;

    private String streetNumber;

    @NotEmpty(groups = {AddressView.Record.class})
    private String city;

    @NotEmpty(groups = {AddressView.Record.class})
    private String state;

    @NotEmpty(groups = {AddressView.Record.class})
    private String country;

    public interface AddressView {
        interface Record {}

        interface Update {}
    }
}
