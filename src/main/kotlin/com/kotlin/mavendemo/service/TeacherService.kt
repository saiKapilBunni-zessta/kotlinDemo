package com.kotlin.mavendemo.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import com.kotlin.mavendemo.repository.UserRepository
import com.kotlin.mavendemo.repository.TeacherRepository
import com.kotlin.mavendemo.repository.ClassesRepository
import com.kotlin.mavendemo.repository.RoleRepository
import com.kotlin.mavendemo.entity.Teacher
import com.kotlin.mavendemo.dto.ReturnTeacherDto
import com.kotlin.mavendemo.dto.CreateTeacherDto
import com.kotlin.mavendemo.dto.ClassesDto
import com.kotlin.mavendemo.entity.Classes
import com.kotlin.mavendemo.entity.User
import com.kotlin.mavendemo.entity.Role
import jakarta.persistence.EntityNotFoundException

@Service
class TeacherService(
    private val userRepository: UserRepository,
    private val classesRepository: ClassesRepository,
    private val teacherRepository: TeacherRepository,
    private val roleRepository: RoleRepository
){
    @Transactional
    fun createTeacher(request: CreateTeacherDto): ReturnTeacherDto{
        val existingUser = userRepository.findById(request.userId).orElseThrow { EntityNotFoundException("User not found with ID: ${request.userId}")}
        val updatedRoles: List<Role> = existingUser.roles + roleRepository.findById(1L).get()
        userRepository.save(User(userId = existingUser.userId, name = existingUser.name, email = existingUser.email, password = existingUser.password, roles = updatedRoles))
        val assignedClasses = request.classes?.mapNotNull { x -> classesRepository.findById(x).get();} ?: emptyList()
        val teacher = Teacher(user = existingUser, classes = assignedClasses)
        val savedTeacher = teacherRepository.save(teacher)
        savedTeacher.classes?.mapNotNull { classesRepository.save(Classes(classId = it.classId,className = it.className, teacher = savedTeacher))}
        // return ReturnTeacherDto(userID = savedTeacher.user.userId, teacherId = savedTeacher.teacherId, name = savedTeacher.user.name, email = savedTeacher.user.email, roles = savedTeacher.user.roles, classes = savedTeacher.classes)
        return toDto(savedTeacher)
    }

    fun listAllTeachers(): List<ReturnTeacherDto>{
        return teacherRepository.findAll().mapNotNull { toDto(it) }
    }

    fun toDto(request: Teacher): ReturnTeacherDto {
        val dtoClassesMap = HashMap<Long, String>()
        request.classes?.forEach { x ->
            dtoClassesMap[x.classId] = x.className
        }
        return ReturnTeacherDto(userID = request.user.userId, teacherId = request.teacherId, name = request.user.name, email = request.user.email, roles = request.user.roles, classesMap = dtoClassesMap)
    }
}