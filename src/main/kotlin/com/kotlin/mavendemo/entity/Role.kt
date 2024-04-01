package com.kotlin.mavendemo.entity

import jakarta.persistence.*
// import jakarta.validation.constraints.NotBlank

@Entity
data class Role(
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val roleId: Long=0,
    // @field:NotBlank(message = "Role name must not be blank")
    val name: String,
)