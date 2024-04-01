package com.kotlin.mavendemo.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

import com.kotlin.mavendemo.service.StudentService 
import com.kotlin.mavendemo.dto.CreateStudentRequestDto
import com.kotlin.mavendemo.dto.ReturnStudentDto
import com.kotlin.mavendemo.dto.CreateUserandMapToStudentRequestDto

@RestController
@RequestMapping("/student")
class StudentController(
    private val studentService: StudentService
) {
    @PostMapping("/assign")
    fun createStudentForExistingUser(@RequestBody request: CreateStudentRequestDto): ReturnStudentDto{
        println("entered assign")
        val savedUser = studentService.createStudentForExistingUser(request)
       return savedUser
    }

    @PostMapping("/create")
    fun createUserAndMapToStudent(@RequestBody request: CreateUserandMapToStudentRequestDto): ReturnStudentDto{
        val savedUser = studentService.createUserAndMapToStudent(request)
        return savedUser
    }
}