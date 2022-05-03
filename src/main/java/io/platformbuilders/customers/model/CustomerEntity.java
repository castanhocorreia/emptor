package io.platformbuilders.customers.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@JsonInclude(NON_NULL)
@NoArgsConstructor
@Setter
@Table(name = "customers")
@ToString
public class CustomerEntity implements Serializable {
    private static final long serialVersionUID = 8475209610827739047L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private UUID id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private LocalDate birthDate;

    private String email;

    private String phoneNumber;

    @JoinTable(
            inverseJoinColumns = @JoinColumn(name = "address_id"),
            joinColumns = @JoinColumn(name = "customer_id"),
            name = "customers_addresses")
    @ManyToMany(fetch = LAZY)
    @ToString.Exclude
    private Set<AddressEntity> addresses;

    @Column(nullable = false)
    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime createdDate;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}
