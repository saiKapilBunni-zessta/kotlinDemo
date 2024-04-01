package com.kotlin.mavendemo.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import com.kotlin.mavendemo.repository.RoleRepository
import com.kotlin.mavendemo.entity.Role

@Service
class RoleService(
    private val roleRepository: RoleRepository
) {
    @Transactional
    fun createRole(request: Role): Role{
       val savedRole = roleRepository.save(request)
       return savedRole
    } 

    fun listAllRoles(): List<Role>{
        return roleRepository.findAll()
    }
}