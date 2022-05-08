package io.platformbuilders.customers.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;
import static org.hibernate.annotations.FetchMode.SUBSELECT;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@JsonInclude(NON_NULL)
@NoArgsConstructor
@Setter
@Table(name = "customers")
@ToString
public class CustomerEntity implements Serializable {
    private static final long serialVersionUID = 8475209610827739047L;

    @Id
    @GeneratedValue(strategy = AUTO)
    private UUID id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @Column(nullable = false)
    private String email;

    private String phoneNumber;

    @Fetch(SUBSELECT)
    @OneToMany(fetch = EAGER, mappedBy = "resident", cascade = ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<AddressEntity> addresses = new HashSet<>();

    @Column(nullable = false, updatable = false)
    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime createdDate;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CustomerEntity that = (CustomerEntity) object;
        return id.equals(that.id)
                && fullName.equals(that.fullName)
                && birthDate.equals(that.birthDate)
                && email.equals(that.email)
                && Objects.equals(phoneNumber, that.phoneNumber)
                && addresses.equals(that.addresses)
                && createdDate.equals(that.createdDate)
                && lastModifiedDate.equals(that.lastModifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                fullName,
                birthDate,
                email,
                phoneNumber,
                addresses,
                createdDate,
                lastModifiedDate);
    }
}
