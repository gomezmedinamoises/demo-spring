package com.moisesgomez.demospring.controller

import com.moisesgomez.demospring.controller.dto.ReservationDto
import com.moisesgomez.demospring.controller.dto.RestaurantDto
import com.moisesgomez.demospring.exception.ReservationNotFoundException
import com.moisesgomez.demospring.exception.RestaurantNotFoundException
import com.moisesgomez.demospring.model.Reservation
import com.moisesgomez.demospring.model.Restaurant
import com.moisesgomez.demospring.services.reservations.ReservationsService
import com.moisesgomez.demospring.services.restaurants.RestaurantsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/reservations")
class ReservationsController(@Autowired val reservationsService: ReservationsService) {

    @PostMapping
    fun create(@RequestBody reservationDto: ReservationDto): Reservation {
        return reservationsService.save(reservationDto)
    }

    @GetMapping
    fun getReservations(): List<Reservation>? {
        return reservationsService.all()
    }

    @GetMapping("/{id}")
    fun findRestaurantById(@PathVariable id: String): Reservation? {
        return reservationsService.findReservationById(id) ?: throw ReservationNotFoundException()
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody reservationDto: ReservationDto): Reservation? {
        return reservationsService.update(id, reservationDto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String): Boolean {
        return reservationsService.delete(id)
    }
}