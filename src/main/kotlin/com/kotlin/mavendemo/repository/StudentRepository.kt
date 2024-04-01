package com.kotlin.mavendemo.repository

import org.springframework.data.jpa.repository.JpaRepository
import com.kotlin.mavendemo.entity.Student


interface StudentRepository : JpaRepository<Student, Long> {
    // Add custom query methods here if needed
}