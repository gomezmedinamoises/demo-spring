package com.moisesgomez.demospring.services.users

import com.moisesgomez.demospring.controller.dto.UserDto
import com.moisesgomez.demospring.model.User

interface UsersService {

    fun save(userDto: UserDto): User

    fun update(userId: String, userDto: UserDto): User

    fun findUserById(userId: String): User?

    fun all(): List<User>

    fun delete(userId: String): Boolean

}