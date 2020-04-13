package com.platzi.reservation.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "customers")
@NamedQuery(name = "Customer.findByIdentification", query = "select c from Customer c where c.identification = ?1")
public final class Customer {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    private String name;
    private String lastName;
    private String identification;
    private String address;
    private String phoneNumber;
    private String email;
    @OneToMany(mappedBy = "customer")
    private Set<Reservation> reservationList;

    public Customer() {
    }
}
