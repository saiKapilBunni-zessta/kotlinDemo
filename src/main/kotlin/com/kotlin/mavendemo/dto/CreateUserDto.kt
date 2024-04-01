package com.kotlin.mavendemo.dto

data class CreateUserDto(
    val name: String,
    val email: String,
    val password: String,
    val roles: List<Long> = listOf()
)