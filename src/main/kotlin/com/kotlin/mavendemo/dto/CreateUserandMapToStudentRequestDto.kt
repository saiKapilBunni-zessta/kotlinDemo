package com.kotlin.mavendemo.dto

data class CreateUserandMapToStudentRequestDto(
    val name: String,
    val email: String,
    val password: String,
    val motherName: String,
    val fatherName: String,
    val roles: List<Long>,
    val classes: List<Long> = listOf()
)