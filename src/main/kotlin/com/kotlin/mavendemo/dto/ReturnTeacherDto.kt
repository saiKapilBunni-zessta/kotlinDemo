package com.kotlin.mavendemo.dto

import com.kotlin.mavendemo.enumeration.UserRole
import com.kotlin.mavendemo.entity.Classes
import com.kotlin.mavendemo.entity.Role
import java.util.HashMap

data class ReturnTeacherDto(
    val userID: Long,
    val teacherId: Long,
    val name: String,
    val email: String,
    val roles: List<Role> = listOf(),
    // val classes: List<Classes> = listOf()
    val classesMap: HashMap<Long, String>
)