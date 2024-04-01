package com.kotlin.mavendemo.entity

import jakarta.persistence.*

@Entity
data class Teacher(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val teacherId: Long = 0,
    @OneToOne
    @JoinColumn(name = "user_id")
    val user: User,
    @OneToMany(mappedBy = "teacher", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val classes: List<Classes>? = null
)