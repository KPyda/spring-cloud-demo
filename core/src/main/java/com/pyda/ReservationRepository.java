package com.pyda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by jakubpyda on 03/09/16.
 */
@RepositoryRestResource
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
