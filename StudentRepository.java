StudentRepository.java
        
      package com.example.demo.repository;
      import org.springframework.data.jpa.repository.JpaRepository; 
      import com.example.demo.entity.Student;
      public interface StudentRepository extends JpaRepository<Student, Long> {
      }
      
      StudentService.java package
        
      com.example.demo.service; 
      import java.util.List;
      import com.example.demo.entity.Student; 
      public interface StudentService {
      List<Student> getAllStudents();
      Student saveStudent(Student student);
      Student getStudentById(Long id); 
      Student updateStudent(Student student); 
        void deleteStudentById(Long id);
      }
