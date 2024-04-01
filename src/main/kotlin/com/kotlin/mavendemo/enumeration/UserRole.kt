package com.kotlin.mavendemo.enumeration

enum class UserRole {
    STUDENT,
    TEACHER,
    ADMIN,
    DEFAULT_USER;

    companion object {
        fun fromString(role: String): UserRole? {
            return when (role.uppercase()) {
                "DEFAULT_USER" -> DEFAULT_USER
                "STUDENT" -> STUDENT
                "TEACHER" -> TEACHER
                else -> null
            }
        }
    }
}