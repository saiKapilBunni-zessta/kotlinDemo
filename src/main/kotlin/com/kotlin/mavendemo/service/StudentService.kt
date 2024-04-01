package com.kotlin.mavendemo.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import jakarta.persistence.EntityNotFoundException

import com.kotlin.mavendemo.repository.StudentRepository
import com.kotlin.mavendemo.repository.UserRepository
import com.kotlin.mavendemo.repository.RoleRepository
import com.kotlin.mavendemo.repository.ClassesRepository
import com.kotlin.mavendemo.dto.CreateStudentRequestDto
import com.kotlin.mavendemo.dto.ReturnStudentDto
import com.kotlin.mavendemo.dto.CreateUserandMapToStudentRequestDto
import com.kotlin.mavendemo.entity.Student
import com.kotlin.mavendemo.entity.User
import com.kotlin.mavendemo.entity.Role
// import com.kotlin.mavendemo.enumeration.UserRole

@Service
class StudentService(
    private val studentRepository: StudentRepository,
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository,
    private val classesRepository: ClassesRepository
) {
    @Transactional
    fun createStudentForExistingUser(request: CreateStudentRequestDto): ReturnStudentDto{
       val existingUser = userRepository.findById(request.userId).orElseThrow { EntityNotFoundException("User not found with ID: ${request.userId}")}
       val assignedClasses = request.classes.mapNotNull { classesRepository.findById(it).get() }
       val student = Student(user = existingUser, motherName = request.motherName, fatherName = request.fatherName, classes = assignedClasses)
       val savedStudent = studentRepository.save(student)
    //    return ReturnStudentDto(userID = savedStudent.user.userId, name = savedStudent.user.name, email = savedStudent.user.email, fatherName = savedStudent.fatherName, motherName = savedStudent.motherName, roles = savedStudent.user.roles, studentId = savedStudent.studentId)
        return toDto(savedStudent)
    }

    @Transactional
    fun createUserAndMapToStudent(request: CreateUserandMapToStudentRequestDto): ReturnStudentDto{
        val assignedRoles = request.roles.mapNotNull { roleRepository.findById(it).orElseThrow{ EntityNotFoundException("Role not found with ID: $it")} }
        val assignedClasses = request.classes.mapNotNull { classesRepository.findById(it).get() }
        val createdUser = userRepository.save(User(name = request.name, email = request.email, password = request.password, roles = assignedRoles))
        userRepository.save(createdUser)
        val student = Student(user = createdUser, motherName = request.motherName, fatherName = request.fatherName, classes = assignedClasses)
        val savedStudent = studentRepository.save(student)
        // return ReturnStudentDto(userID = savedStudent.user.userId, name = savedStudent.user.name, email = savedStudent.user.email, fatherName = savedStudent.fatherName, motherName = savedStudent.motherName, roles = savedStudent.user.roles, studentId = savedStudent.studentId)
        return toDto(savedStudent)
    }

    fun toDto(request: Student): ReturnStudentDto{
        val assignedClasses = HashMap<Long,String>()
        request.classes?.forEach { x ->
            assignedClasses[x.classId] = x.className
        }
        return ReturnStudentDto(userID = request.user.userId, name = request.user.name, email = request.user.email, fatherName = request.fatherName, motherName = request.motherName, roles = request.user.roles, studentId = request.studentId, classes = assignedClasses)
    }
}
