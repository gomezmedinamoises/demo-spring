package com.moisesgomez.demospring.services.reservations

import com.moisesgomez.demospring.controller.dto.ReservationDto
import com.moisesgomez.demospring.controller.dto.RestaurantDto
import com.moisesgomez.demospring.model.Reservation
import com.moisesgomez.demospring.model.Restaurant
import com.moisesgomez.demospring.services.restaurants.RestaurantsService
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong

@Service
class ReservationServiceHashMap : ReservationsService {

    private val reservations = HashMap<String, Reservation>()
    private val nextOid  = AtomicLong()

    override fun save(reservationDto: ReservationDto): Reservation {
        val reservation = Reservation(nextOid.incrementAndGet(), reservationDto)
        reservations[reservationDto.id] = reservation
        return reservation
    }

    override fun update(reservationId: String, reservationDto: ReservationDto): Reservation {
        if (reservations.containsKey(reservationId)) {
            val restaurant = reservations[reservationId]
            reservations[reservationId] = Reservation(restaurant!!.oid, reservationDto)
        }
        return reservations[reservationId]!!
    }

    override fun findReservationById(reservationId: String): Reservation? {
        return if (reservations.containsKey(reservationId))
            reservations[reservationId]
        else
            null
    }

    override fun all(): List<Reservation> {
        return reservations.values.toList()
    }

    override fun delete(reservationId: String): Boolean {
        return reservations.remove(reservationId) != null
    }
}