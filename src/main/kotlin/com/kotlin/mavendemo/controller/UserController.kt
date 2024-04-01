package com.kotlin.mavendemo.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
// import com.kotlin.mavendemo.repository.UserRepository
import com.kotlin.mavendemo.repository.RoleRepository
import com.kotlin.mavendemo.entity.User
import com.kotlin.mavendemo.dto.ReturnUserDto
import com.kotlin.mavendemo.service.UserService
import com.kotlin.mavendemo.dto.CreateUserDto

@RestController
@RequestMapping("/user")
class UserController(
    private val userService: UserService,
    private val roleRepository: RoleRepository
) {
    @PostMapping("/create")
    fun createUser(@RequestBody request: CreateUserDto): ReturnUserDto{
        // println(request.toString())
        val assignedRoles = request.roles.mapNotNull { roleRepository.findById(it).get() }
        val user = User(name = request.name, email = request.email, password = request.password, roles = assignedRoles)
        val savedUser = userService.createUser(user)
       return savedUser
    }
}