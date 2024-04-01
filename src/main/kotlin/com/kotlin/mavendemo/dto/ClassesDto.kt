package com.kotlin.mavendemo.dto

import com.kotlin.mavendemo.entity.Classes

data class ClassesDto(
    val classId: Long,
    val className: String,
    val teacherId: Long,
    val teacherName: String,
    // val students: List<ReturnStudentDto> = listOf()
    val students: HashMap<Long,String>
)
