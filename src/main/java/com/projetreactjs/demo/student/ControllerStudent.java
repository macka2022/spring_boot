package com.projetreactjs.demo.student;

import com.projetreactjs.demo.Exception.ApiRequestException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("students")
public class ControllerStudent {
    
   private ServiceStudent service;

    public ControllerStudent(ServiceStudent service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getStudents(){

                 return service.getStudents();

    }
    @PostMapping
    public  void addNewStuent(UUID id,@RequestBody @Valid  Student student){

        service.addNewStudent(id, student);
    }
    @GetMapping(path = "{studentId}/courses")
    public  List<StudentCourse> getAllCourseForStudent(@PathVariable("studentId") UUID studentId){

        return  service.selectAllStudentCourses(studentId);
    }
    @PostMapping(path="courses")
    public  void addNewCourse(UUID id, @RequestBody @Valid Course courseStudent){
         service.addNewCourse(id, courseStudent);
    }

    @PostMapping(path = "course_student")
    public  void addNewCourseStudent(UUID id , @RequestBody @Valid CourseStudent courseStudent){
        service.addNewCourseStudent(id, courseStudent);
    }
}
