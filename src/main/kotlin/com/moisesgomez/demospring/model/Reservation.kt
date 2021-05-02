package com.moisesgomez.demospring.model

import com.moisesgomez.demospring.controller.dto.ReservationDto
import com.moisesgomez.demospring.controller.dto.RestaurantDto
import java.util.*

data class Reservation(
    val oid: Long,
    val id: String,
    val user: String,
    val restaurant: String,
    val date: String
) {
    constructor(oid: Long, reservationDto: ReservationDto) :
            this(oid,
            reservationDto.id,
            reservationDto.user,
            reservationDto.restaurant,
            reservationDto.date)

}