package com.kotlin.mavendemo.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.GetMapping
import com.kotlin.mavendemo.service.TeacherService
import com.kotlin.mavendemo.dto.CreateTeacherDto
import com.kotlin.mavendemo.dto.ReturnTeacherDto

@RestController
@RequestMapping("/teacher")
class TeacherController(
    private val teacherService: TeacherService
) {
    @PostMapping("/create")
    fun createTeacher(@RequestBody request: CreateTeacherDto): ReturnTeacherDto{
        // println(request.toString())
        val createdTeacher = teacherService.createTeacher(request);
        return createdTeacher
    }
    @GetMapping("/getAllTeachers")
    fun listAllTeachers(): List<ReturnTeacherDto>{
        return teacherService.listAllTeachers()
    }
}