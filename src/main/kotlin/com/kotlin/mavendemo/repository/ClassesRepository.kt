package com.kotlin.mavendemo.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.kotlin.mavendemo.entity.Classes

@Repository
interface ClassesRepository : JpaRepository<Classes, Long> {
    // Add custom query methods here if needed
}