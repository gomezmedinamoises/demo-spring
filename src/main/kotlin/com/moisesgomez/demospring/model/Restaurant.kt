package com.moisesgomez.demospring.model

import com.moisesgomez.demospring.controller.dto.RestaurantDto
import com.moisesgomez.demospring.controller.dto.UserDto

data class Restaurant(
    val oid: Long,
    val id: String,
    var name: String,
    var email: String) {

    constructor(oid: Long, restaurantDto: RestaurantDto) :
            this(oid, restaurantDto.id, restaurantDto.name, restaurantDto.email)
}