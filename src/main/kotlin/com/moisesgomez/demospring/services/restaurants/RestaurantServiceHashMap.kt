package com.moisesgomez.demospring.services.restaurants

import com.moisesgomez.demospring.controller.dto.RestaurantDto
import com.moisesgomez.demospring.controller.dto.UserDto
import com.moisesgomez.demospring.model.Restaurant
import com.moisesgomez.demospring.model.User
import com.moisesgomez.demospring.services.users.UsersService
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong

@Service
class RestaurantServiceHashMap : RestaurantsService {

    private val restaurants = HashMap<String, Restaurant>()
    private val nextOid  = AtomicLong()


    override fun save(restaurantDto: RestaurantDto): Restaurant {
        val restaurant = Restaurant(nextOid.incrementAndGet(), restaurantDto)
        restaurants[restaurantDto.id] = restaurant
        return restaurant
    }

    override fun update(restaurantId: String, restaurantDto: RestaurantDto): Restaurant {
        if (restaurants.containsKey(restaurantId)) {
            val restaurant = restaurants[restaurantId]
            restaurants[restaurantId] = Restaurant(restaurant!!.oid, restaurantDto)
        }
        return restaurants[restaurantId]!!
    }

    override fun findRestaurantById(restaurantId: String): Restaurant? {
        return if (restaurants.containsKey(restaurantId))
            restaurants[restaurantId]
        else
            null
    }

    override fun all(): List<Restaurant> {
        return restaurants.values.toList()
    }

    override fun delete(restaurantId: String): Boolean {
        return restaurants.remove(restaurantId) != null
    }
}