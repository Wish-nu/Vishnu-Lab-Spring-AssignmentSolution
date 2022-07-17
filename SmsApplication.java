
SmsApplication.java

package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.boot.CommandLineRunner; 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository; /*
* Code owned by: Vishnu Prasad Preetham Kumar @creator */
@SpringBootApplication
    public class SmsApplication implements CommandLineRunner {
      public static void main(String[] args) {
      SpringApplication.run(SmsApplication.class, args); 
        
      @Autowired
      private StudentRepository studentRepository;

      @Override
      public void run(String... args) throws Exception {
       // TODO Auto-generated method stub
        
        /*
Student Student1=new Student("s","r","a");
* studentRepository.save(Student1);
*
* Student Student2=new Student("s","p","a");
studentRepository.save(Student2); *
* Student Student3=new Student("s","d","a"); studentRepository.save(Student3);
*/
} 
}
      
StudentController.java
package com.example.demo.controller; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping;
      
      import com.example.demo.entity.Student; 
      import com.example.demo.service.StudentService; 
      
      @Controller 
      public class StudentController {
      private StudentService studentService; 
      public StudentController(StudentService studentService) {
      super();
      this.studentService = studentService;
      }
        
        //handler method to handle list students and return mode and view 
        @GetMapping("/students")
        public String listStudents(Model model) {
        model.addAttribute("students",studentService.getAllStudents()); 
          return "students";
          }
        @GetMapping("/students/new") 
        public String createStudentForm(Model model) {
          //create customer object to hold customer form data 
          Student student=new Student();
          model.addAttribute("student",student); 
          return "create_student";
          }
        
        @PostMapping("/students") 
        public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student); 
        return "redirect:/students";
         }
//------------------------------------
        @GetMapping("/students/edit/{id}") 
       public String editStudentForm(@PathVariable Long id,Model model ) { 
       model.addAttribute("student",studentService.getStudentById(id)); 
       return "edit_student";
        }

        @PostMapping("/students/{id}") 
        public String updateStudent(@PathVariable Long id,
        @ModelAttribute("student") Student student, Model model) {
        //get customer from database by id
         Student existingStudent=studentService.getStudentById(id);
         existingStudent.setName(student.getName()); 
          existingStudent.setDept(student.getDept()); 
          existingStudent.setCountry(student.getCountry());
          studentService.updateStudent(existingStudent); 
          return "redirect:/students";
          }
          //handler method to handle delete student request 
        
        @GetMapping("/students/{id}")
        public String deleteStudent(@PathVariable Long id) { 
        studentService.deleteStudentById(id);
        return "redirect:/students"; 
        }
        }
      
      Student.java
      package com.example.demo.entity; 
      import javax.persistence.Column; 
      import javax.persistence.Entity; 
      import javax.persistence.GeneratedValue; 
      import javax.persistence.GenerationType; 
      import javax.persistence.Id; 
      import javax.persistence.Table; 
      @Entity 
      @Table(name="student")
      public class Student {
      @Id
      @GeneratedValue(strategy =GenerationType.IDENTITY) private Long id;
      @Column(name="name", nullable=false)
        
      private String name;
      @Column(name="dept") 
      private String dept; 
      @Column(name="country") 
      private String country;
      public Student() { 
      }
        
        public Student(String name, String dept, String country) { 
        super();
        this.name = name; 
        this.dept = dept;
        this.country = country; 
        }
        public Long getId() { 
        return id;
        }
        public void setId(Long id) {
        this.id = id; }
        public String getName() { 
        return name;
        }
        public void setName(String name) {
        this.name = name;
        }
        public String getDept() {
        return dept; }
        public void setDept(String dept) { 
        this.dept = dept;
        }
        public String getCountry() {
        return country;
        }
        public void setCountry(String country) {
        } 
      }
      
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
      
      StudentServiceImpl.java
        
      package com.example.demo.service.impl;
      import java.util.List;
      import org.springframework.stereotype.Service; 
      import com.example.demo.entity.Student; 
      import com.example.demo.repository.StudentRepository; 
      import com.example.demo.service.StudentService;
      @Service public class StudentServiceImpl implements StudentService{ 
      private StudentRepository studentRepository; 
      public StudentServiceImpl(StudentRepository studentRepository) {
      super();
      this.studentRepository = studentRepository;
      }

        @Override
        public List<Student> getAllStudents() {
        // TODO Auto-generated method stub 
         return studentRepository.findAll();
        }
        @Override
        public Student saveStudent(Student student) {
        // TODO Auto-generated method stub 
        return studentRepository.save(student);
        }
        @Override
        public Student getStudentById(Long id) {
        // TODO Auto-generated method stub 
       return studentRepository.findById(id).get();
        }
        @Override
        public Student updateStudent(Student student) {
        // TODO Auto-generated method stub 
        return studentRepository.save(student);
        }
        @Override
        public void deleteStudentById(Long id) {
        // TODO Auto-generated method stub 
        studentRepository.deleteById(id);
        } 
      }
      
      application.properties
        
        spring.datasource.url=jdbc:mysql://localhost:3306/sms?useSSL=false&serverTimezone= UTC&useLegacyDatetimeCode=false spring.datasource.username=root spring.datasource.password=root
      
      #Hibernate
      spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect 
      #Hibernate auto ddl
      spring.jpa.hibernate.ddl-auto=update
        
      logging.level.org.org.hibernate.SQL=DEBUG
        
