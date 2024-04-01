package com.kotlin.mavendemo.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.GetMapping
import com.kotlin.mavendemo.service.ClassesService
import com.kotlin.mavendemo.entity.Classes
import com.kotlin.mavendemo.dto.ClassesDto

@RestController
@RequestMapping("/classes")

class ClassesController(
    private val classesService: ClassesService
){
    @PostMapping("/create")
    fun createClass(@RequestBody classes: Classes): Classes{
        return classesService.createClass(classes)
    }

    @GetMapping("/listOfClasses")
    fun listOfClasses(): List<ClassesDto>{
        return classesService.listOfClasses()
    }
}