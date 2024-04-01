package com.kotlin.mavendemo.service

import org.springframework.stereotype.Service
import jakarta.transaction.Transactional
import com.kotlin.mavendemo.repository.ClassesRepository
import com.kotlin.mavendemo.entity.Classes
import com.kotlin.mavendemo.dto.ClassesDto

@Service
class ClassesService(
    private val classesRepository: ClassesRepository
) {
    @Transactional
    fun createClass(request: Classes): Classes{
       val savedClass = classesRepository.save(request)
       return savedClass
    }

    fun listOfClasses(): List<ClassesDto>{
        return classesRepository.findAll().mapNotNull { toDto(it) }
    }

    fun toDto(request: Classes): ClassesDto{
        val assignedStudents = HashMap<Long,String>()
        request.students?.forEach { x ->
            assignedStudents[x.studentId] = x.user.name
        }
        return ClassesDto(classId = request.classId, className= request.className, teacherId = request.teacher?.teacherId ?: 0, teacherName = request.teacher?.user?.name ?: "", students = assignedStudents)
    }
} 