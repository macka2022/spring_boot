package com.projetreactjs.demo.student;

import com.projetreactjs.demo.EmailValidator.EmailValidator;
import com.projetreactjs.demo.Exception.ApiRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServiceStudent {
    public  StudentDataAccessService studentDataAccessService;
    public final EmailValidator emailValidator;
    public ServiceStudent(StudentDataAccessService studentDataAccessService, EmailValidator emailValidator) {
        this.studentDataAccessService = studentDataAccessService;
        this.emailValidator = emailValidator;
    }

    public List<Student> getStudents(){
        return studentDataAccessService.selectStudent();
    }
    public void addNewStudent(UUID id , Student student){
      UUID newId= Optional.ofNullable(id).orElse(UUID.randomUUID());
      //TODO VERIFY THAT MAIL IS NOT TOKEN
        if(studentDataAccessService.isEmail(student.getEmail())){
            throw new ApiRequestException(student.getEmail()+"  is token");
        }
        //EMAIL VALIDATE
        if(!emailValidator.test(student.getEmail())){
            throw  new ApiRequestException(student.getEmail()+ " "+ "is not valid");
        }
        studentDataAccessService.insertStudent(newId, student);

    }
    List<StudentCourse> selectAllStudentCourses(UUID studentId){
       return  studentDataAccessService.selectAllStudentCourses(studentId);
    }

    public void addNewCourse(UUID id, Course courseStudent) {
        UUID idNewId = Optional.ofNullable(id).orElse(UUID.randomUUID());
        studentDataAccessService.addCourse(idNewId, courseStudent);
    }
    public  void addNewCourseStudent(UUID id, CourseStudent courseStudent){
         UUID idNew = Optional.ofNullable(id).orElse(UUID.randomUUID());
         studentDataAccessService.addStudentCourse(idNew, courseStudent);
    }
}
