package com.projetreactjs.demo.student;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class StudentDataAccessService {
    private final JdbcTemplate jdbcTemplate;

    public StudentDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> selectStudent() {
        String sql = "SELECT * FROM students";

        return jdbcTemplate.query(sql, getStudentRowMapper());
    }


    private RowMapper<Student> getStudentRowMapper() {
        return (ResultSet resultSet, int i) -> {
            String studentIdStr = resultSet.getString("id");
            UUID studentId = UUID.fromString(studentIdStr);
            String nom = resultSet.getString("nom");
            String prenom = resultSet.getString("prenom");
            String dateNaiss = resultSet.getString("dateNaiss");
            String filiere = resultSet.getString("filiere");
            String niveau = resultSet.getString("niveau");
            String email = resultSet.getString("email");

            String sexeStr = resultSet.getString("sexe").toUpperCase();
            Student.Gender sexe = Student.Gender.valueOf(sexeStr);

            return new Student(studentId, nom, prenom, dateNaiss, filiere, niveau, email, sexe);
        };
    }

    public int insertStudent(UUID newId, Student student) {
        String sql="INSERT INTO students(id, nom , prenom ,dateNaiss, email , niveau , filiere , sexe) VALUES( ? , ? ,? ,? , ?, ? , ? , ?::sexe)";
        return jdbcTemplate.update(sql,
                newId,
                student.getNom(),
                student.getPrenom(),
                student.getDateNaiss(),
                student.getEmail(),
                student.getNiveau(),
                student.getFiliere(),
                student.getSexe().name().toUpperCase());
    }

    public boolean isEmail(String email) {
       String sql="" +
               "SELECT EXISTS ( " +
                "SELECT 1 " +
                "FROM students " +
               "WHERE email =?" +
               ")";
       return jdbcTemplate.queryForObject(
               sql,
               new Object[] {email},
               (ResultSet resulSet, int i) -> resulSet.getBoolean(1)
       );
    }
    List<StudentCourse> selectAllStudentCourses(UUID studentId){
       String sql=""+
               "SELECT " +
               "student.id " +
               "course.id_course "+
               "course.name "+
               "course.description "+
               "course.teacher_name "+
               "course.departement "+
               "student_course.start_date "+
               "student_course.end_date "+
               "student_course.grade "+
               "FROM student "+
               "JOIN student_course ON id=id_student "+
               "JOIN course ON course_id=id_course "+
               "WHERE id= ? ";

         return  jdbcTemplate.query(sql, new Object[]{studentId}, mapStudentCourse());
    }
    private RowMapper<StudentCourse> mapStudentCourse()
    {
        return  (ResultSet resulSet, int i)->{
           return new StudentCourse(
                    UUID.fromString(resulSet.getString("id_student")),
                    UUID.fromString(resulSet.getString("course_id")),
                   resulSet.getDate("start_date").toLocalDate(),
                   resulSet.getDate("end_date").toLocalDate(),
                    resulSet.getString("name"),
                    resulSet.getString("departement"),
                    resulSet.getString("teacher_name"),
                    resulSet.getString("grade"),
                    Optional.ofNullable(resulSet.getString("grade"))
                            .map(Integer::parseInt)
                            .orElse(null)
            );
     };
    };

    public void addCourse(UUID idNewId, Course courseStudent) {
        String sql="INSERT INTO course(id_course, name, description, teacher_name , departement) VALUES(?, ?, ?, ? , ?)";
        jdbcTemplate.update(sql,
                idNewId,
                courseStudent.getName(),
                courseStudent.getDescription(),
                courseStudent.getTeacherName(),
                courseStudent.getDepartement()
                );
    }

    public  void addStudentCourse(UUID idNew, CourseStudent courseStudent){
        String sql="INSERT INTO student_course(id,id_student, course_id, start_date, end_date, grade) VALUES(? , ? , ? , ? , ? , ?)";
        jdbcTemplate.update(
                sql,
                idNew ,
                courseStudent.getId_student(),
                courseStudent.getCourse_id(),
                courseStudent.getStart_date(),
                courseStudent.getEnd_date(),
                courseStudent.getGrade()
        );

    }

}