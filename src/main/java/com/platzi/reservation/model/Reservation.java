package com.platzi.reservation.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "reservations")
public final class Reservation {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    @Temporal(TemporalType.DATE)
    private Date starDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;
    private int numberOfPersons;
    private String description;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
