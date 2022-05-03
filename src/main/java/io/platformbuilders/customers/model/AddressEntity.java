package io.platformbuilders.customers.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@JsonInclude(NON_NULL)
@NoArgsConstructor
@Setter
@Table(name = "addresses")
@ToString
public class AddressEntity implements Serializable {
    private static final long serialVersionUID = -1104620051808430717L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private UUID id;

    @Column(nullable = false)
    private String postCode;

    @Column(nullable = false)
    private String streetName;

    private String streetNumber;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String country;
}
