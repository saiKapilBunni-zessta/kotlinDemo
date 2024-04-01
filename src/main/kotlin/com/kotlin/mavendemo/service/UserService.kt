package com.kotlin.mavendemo.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import com.kotlin.mavendemo.repository.UserRepository
import com.kotlin.mavendemo.entity.User
import com.kotlin.mavendemo.dto.ReturnUserDto
import com.kotlin.mavendemo.enumeration.UserRole

@Service
class UserService(
    private val userRepository: UserRepository
) {
    @Transactional
    fun createUser(request: User): ReturnUserDto{
        println("inside service class createuser method")
        println(request.toString())
       val savedUser = userRepository.save(request)
       println(savedUser.toString())
    //    val assignedRoles : MutableSet<UserRole> = mutableSetOf()
    //     assignedRoles.add(UserRole.DEFAULT_USER)
       return ReturnUserDto(userID = savedUser.userId, name = savedUser.name, email = savedUser.email, roles = savedUser.roles)
    }
}