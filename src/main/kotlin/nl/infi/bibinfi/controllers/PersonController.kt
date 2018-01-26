package nl.infi.bibinfi.controllers

import nl.infi.bibinfi.services.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by aziz on 12/15/2017.
 */
@RestController
@RequestMapping("users")
class PersonController(val userService: UserService) {
    @GetMapping

    fun findAll() = userService.getAll()

    @GetMapping("{id}")
    fun findById(@PathVariable id:Int) =
            userService.get(id)
}