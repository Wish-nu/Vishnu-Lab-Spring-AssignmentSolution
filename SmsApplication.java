
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
      

      

        
