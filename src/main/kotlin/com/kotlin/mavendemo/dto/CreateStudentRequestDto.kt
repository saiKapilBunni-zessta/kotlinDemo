package com.kotlin.mavendemo.dto

data class CreateStudentRequestDto(
    val userId: Long,
    val motherName: String,
    val fatherName: String,
    val classes: List<Long> = listOf()
)