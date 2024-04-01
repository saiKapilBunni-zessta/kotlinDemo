package com.kotlin.mavendemo.entity

import jakarta.persistence.*
import com.kotlin.mavendemo.entity.Teacher

@Entity
data class Classes(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val classId: Long = 0,
    val className: String,
    @OneToOne
    @JoinColumn(name = "teacher_id")
    val teacher: Teacher? = null,
    @ManyToMany(mappedBy = "classes")
    val students: MutableSet<Student> ?= null 
)