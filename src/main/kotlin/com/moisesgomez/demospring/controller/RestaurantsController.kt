package com.moisesgomez.demospring.controller

import com.moisesgomez.demospring.controller.dto.RestaurantDto
import com.moisesgomez.demospring.controller.dto.UserDto
import com.moisesgomez.demospring.exception.RestaurantNotFoundException
import com.moisesgomez.demospring.exception.UserNotFoundException
import com.moisesgomez.demospring.model.Restaurant
import com.moisesgomez.demospring.model.User
import com.moisesgomez.demospring.services.restaurants.RestaurantsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/restaurants")
class RestaurantsController(@Autowired val restaurantsService: RestaurantsService) {

    @PostMapping
    fun create(@RequestBody restaurantDto: RestaurantDto): Restaurant {
        return restaurantsService.save(restaurantDto)
    }

    @GetMapping
    fun getRestaurants(): List<Restaurant>? {
        return restaurantsService.all()
    }

    @GetMapping("/{id}")
    fun findRestaurantById(@PathVariable id: String): Restaurant? {
        return restaurantsService.findRestaurantById(id) ?: throw RestaurantNotFoundException()
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody restaurantDto: RestaurantDto): Restaurant? {
        return restaurantsService.update(id, restaurantDto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String): Boolean {
        return restaurantsService.delete(id)
    }
}