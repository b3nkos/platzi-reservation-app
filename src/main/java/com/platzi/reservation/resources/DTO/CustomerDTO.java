package com.platzi.reservation.resources.DTO;

import lombok.Data;

@Data
public final class CustomerDTO {
    private String id;
    private String name;
    private String lastName;
    private String identification;
    private String address;
    private String phoneNumber;
    private String email;
}
