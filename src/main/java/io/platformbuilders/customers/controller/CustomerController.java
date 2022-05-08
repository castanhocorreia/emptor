package io.platformbuilders.customers.controller;

import io.platformbuilders.customers.data.CustomerRecordData;
import io.platformbuilders.customers.data.CustomerUpdateData;
import io.platformbuilders.customers.data.CustomerViewData;
import io.platformbuilders.customers.repository.CustomerSpecification;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

import static org.springframework.data.domain.Sort.Direction.ASC;

public interface CustomerController {
    @Operation(
            summary = "Create Customer",
            description = "Create a new customer entry",
            tags = {"Customer"})
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Customer successfully created, no errors"),
                @ApiResponse(
                        responseCode = "400",
                        description = "There is an error in the request"),
                @ApiResponse(responseCode = "500", description = "There was some unexpected error")
            })
    ResponseEntity<CustomerViewData> create(@RequestBody @Validated CustomerRecordData customer);

    @Operation(
            summary = "Index Customers",
            description =
                    "Brings a paginated list of all customers, filter parameters can be passed in the path",
            tags = {"Customer"})
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Page processed successfully, no errors"),
                @ApiResponse(
                        responseCode = "400",
                        description = "There is an error in the request"),
                @ApiResponse(responseCode = "500", description = "There was some unexpected error")
            })
    ResponseEntity<Page<CustomerViewData>> index(
            CustomerSpecification spec,
            @PageableDefault(sort = "createdDate", direction = ASC) Pageable pageable);

    @Operation(
            summary = "Retrieve Customer",
            description = "Finds a customer by id, which must be passed in the path",
            tags = {"Customer"})
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Customer found successfully, no errors"),
                @ApiResponse(
                        responseCode = "400",
                        description = "There is an error in the request"),
                @ApiResponse(responseCode = "404", description = "Customer not found"),
                @ApiResponse(responseCode = "500", description = "There was some unexpected error")
            })
    ResponseEntity<CustomerViewData> retrieve(@PathVariable UUID id);

    @Operation(
            summary = "Modify Customer",
            description = "Update the current state of a customer by id",
            tags = {"Customer"})
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Customer updated successfully, no errors"),
                @ApiResponse(
                        responseCode = "400",
                        description = "There is an error in the request"),
                @ApiResponse(responseCode = "404", description = "Customer not found"),
                @ApiResponse(responseCode = "500", description = "There was some unexpected error")
            })
    ResponseEntity<CustomerViewData> modify(@RequestBody @Validated CustomerUpdateData customer);

    @Operation(
            summary = "Destroy Customer",
            description = "Delete a customer by id, which must be passed in the path",
            tags = {"Customer"})
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Customer deleted successfully, no errors"),
                @ApiResponse(
                        responseCode = "400",
                        description = "There is an error in the request"),
                @ApiResponse(responseCode = "404", description = "Customer not found"),
                @ApiResponse(responseCode = "500", description = "There was some unexpected error")
            })
    ResponseEntity<Void> destroy(@PathVariable UUID id);
}
