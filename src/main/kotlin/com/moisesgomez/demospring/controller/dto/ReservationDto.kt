package com.moisesgomez.demospring.controller.dto

import com.moisesgomez.demospring.model.Restaurant
import com.moisesgomez.demospring.model.User
import java.util.*

data class ReservationDto(
    val id: String,
    val user: String,
    val restaurant: String,
    val date: String
)