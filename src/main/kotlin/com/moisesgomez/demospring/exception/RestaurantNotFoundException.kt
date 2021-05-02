package com.moisesgomez.demospring.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Restaurant not found")
class RestaurantNotFoundException : RuntimeException()