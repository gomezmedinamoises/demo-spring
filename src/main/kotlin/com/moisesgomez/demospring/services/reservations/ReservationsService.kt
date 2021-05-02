package com.moisesgomez.demospring.services.reservations

import com.moisesgomez.demospring.controller.dto.ReservationDto
import com.moisesgomez.demospring.controller.dto.RestaurantDto
import com.moisesgomez.demospring.model.Reservation
import com.moisesgomez.demospring.model.Restaurant

interface ReservationsService {

    fun save(reservationDto: ReservationDto): Reservation

    fun update(reservationId: String, reservationDto: ReservationDto): Reservation

    fun findReservationById(reservationId: String): Reservation?

    fun all(): List<Reservation>

    fun delete(reservationId: String): Boolean
}