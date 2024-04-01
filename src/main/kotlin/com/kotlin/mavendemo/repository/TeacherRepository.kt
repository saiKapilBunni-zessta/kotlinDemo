package com.kotlin.mavendemo.repository

import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository
import com.kotlin.mavendemo.entity.Teacher

@Repository
interface TeacherRepository : JpaRepository<Teacher, Long> {
    // Add custom query methods here if needed
}