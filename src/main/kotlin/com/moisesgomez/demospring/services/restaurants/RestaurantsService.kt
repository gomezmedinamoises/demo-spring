package com.moisesgomez.demospring.services.restaurants

import com.moisesgomez.demospring.controller.dto.RestaurantDto
import com.moisesgomez.demospring.controller.dto.UserDto
import com.moisesgomez.demospring.model.Restaurant
import com.moisesgomez.demospring.model.User

interface RestaurantsService {

    fun save(restaurantDto: RestaurantDto): Restaurant

    fun update(restaurantId: String, restaurantDto: RestaurantDto): Restaurant

    fun findRestaurantById(restaurantId: String): Restaurant?

    fun all(): List<Restaurant>

    fun delete(restaurantId: String): Boolean
}