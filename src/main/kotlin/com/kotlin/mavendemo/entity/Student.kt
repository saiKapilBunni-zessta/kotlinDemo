package com.kotlin.mavendemo.entity

import jakarta.persistence.*

@Entity
data class Student(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val studentId: Long = 0,
    @OneToOne
    @JoinColumn(name = "user_id")
    val user: User,
    val motherName: String,
    val fatherName: String,
    @ManyToMany
    @JoinTable(name = "student_classes",
        joinColumns = [JoinColumn(name = "student_id")],
        inverseJoinColumns = [JoinColumn(name = "class_id")])
    val classes: List<Classes> ?= null
)