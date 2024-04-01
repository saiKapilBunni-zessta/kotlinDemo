package com.kotlin.mavendemo.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import com.kotlin.mavendemo.entity.Role
import com.kotlin.mavendemo.service.RoleService

@RestController
@RequestMapping("/role")

class RoleController(
    private val roleService: RoleService
){
    @PostMapping("/create")
    fun createRole(@RequestBody role: Role): Role{
        return roleService.createRole(role)
    }

    @GetMapping("/listAllRoles")
    fun listAllRoles(): List<Role>{
        return roleService.listAllRoles()
    }
}