package com.platzi.reservation.repository;

import com.platzi.reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
    @Query("select r from Reservation r where r.starDate =:starDate and r.endDate =:endDate")
    public List<Reservation> find(@Param("starDate") Date starDate, @Param("endDate") Date endDate);
}
