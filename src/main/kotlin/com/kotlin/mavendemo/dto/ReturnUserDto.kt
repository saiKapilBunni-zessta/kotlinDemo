package com.kotlin.mavendemo.dto

import com.kotlin.mavendemo.enumeration.UserRole
import com.kotlin.mavendemo.entity.Role

data class ReturnUserDto(
    val userID: Long,
    val name: String,
    val email: String,
    val roles: List<Role> = listOf()
)