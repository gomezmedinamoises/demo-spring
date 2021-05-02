package com.moisesgomez.demospring.model

import com.moisesgomez.demospring.controller.dto.UserDto

data class User(val oid: Long, val id: String, var name: String, var email: String) {

    constructor(oid: Long, userDto: UserDto) :
            this(oid, userDto.id, userDto.name, userDto.email)
}