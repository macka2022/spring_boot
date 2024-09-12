CREATE TABLE IF NOT EXISTS course(
id_course UUID NOT NULL primary key,
name VARCHAR(50) NOT NULL UNIQUE,
description TEXT NOT NULL,
departement VARCHAR(49) ,
teacher_name VARCHAR(40)
);

CREATE TABLE IF NOT EXISTS student_course(

id_student UUID NOT NULL REFERENCES students(id),
course_id UUID NOT NULL REFERENCES course(id_course),
start_date DATE NOT NULL,
end_date DATE NOT NULL,
grade INTEGER CHECK(grade >=0 AND grade <= 100),
UNIQUE(id_student, course_id)
);