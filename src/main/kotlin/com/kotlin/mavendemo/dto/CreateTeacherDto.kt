package com.kotlin.mavendemo.dto

data class CreateTeacherDto(
    val userId: Long,
    val classes: List<Long> = listOf()
)