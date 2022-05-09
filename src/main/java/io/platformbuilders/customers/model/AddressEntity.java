package io.platformbuilders.customers.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static javax.persistence.GenerationType.AUTO;

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
    @GeneratedValue(strategy = AUTO)
    private UUID id;

    @JoinColumn(name = "resident_id")
    @ManyToOne(optional = false)
    @ToString.Exclude
    private CustomerEntity resident;

    @Column(nullable = false)
    private String postCode;

    @Column(nullable = false)
    private String streetName;

    private String streetNumber;

    @Column(nullable = false)
    private String city;

    private String state;

    @Column(nullable = false)
    private String country;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        AddressEntity that = (AddressEntity) object;
        return id.equals(that.id)
                && postCode.equals(that.postCode)
                && Objects.equals(streetName, that.streetName)
                && Objects.equals(streetNumber, that.streetNumber)
                && city.equals(that.city)
                && state.equals(that.state)
                && country.equals(that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, postCode, streetName, streetNumber, city, state, country);
    }
}
