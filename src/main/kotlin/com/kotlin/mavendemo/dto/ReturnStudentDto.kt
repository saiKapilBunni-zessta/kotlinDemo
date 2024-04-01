package com.kotlin.mavendemo.dto

import com.kotlin.mavendemo.enumeration.UserRole
import com.kotlin.mavendemo.entity.Role

data class ReturnStudentDto(
    val userID: Long,
    val studentId: Long,
    val name: String,
    val email: String,
    val fatherName: String,
    val motherName: String,
    val roles: List<Role> = listOf(),
    val classes: HashMap<Long,String>
)