package com.kotlin.mavendemo.repository

import com.kotlin.mavendemo.entity.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface RoleRepository : JpaRepository<Role, Long> {
    // Add custom query methods here if needed
}