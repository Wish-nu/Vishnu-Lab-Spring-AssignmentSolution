create_student.html

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"> 
<head>
<meta charset="ISO-8859-1">
<title>Student Management System</title> <link rel="stylesheet"
href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css
"
integrity="sha384- Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
crossorigin="anonymous"> 
</head>
<body>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <!-- Brand -->
<a class="navbar-brand" href="#">Student Management System</a>

<!-- Toggler/collapsibe Button -->
<button class="navbar-toggler" type="button" data-toggle="collapse" datatarget="#collapsibleNavbar">
<span class="navbar-toggler-icon"></span> 
</button>

<!-- Navbar links -->
<div class="collapse navbar-collapse" id="collapsibleNavbar"> 
<ul class="navbar-nav">
<li class="nav-item">
<a class="nav-link" th:href="@{/students}">Student Management</a>
</li> 
</ul>
</div>
</nav>
<br> 
<br>
<div class = "container"> 
<div class = "row">
<div class ="col-lg-6 col-md-6 col-sm-6 container justifycontent-center card"> <h1 class = "text-center"> Create New Student </h1>
<div class = "card-body">
<form th:action="@{/students}" th:object = "${student}" method="POST">
<div class ="form-group">
<label> Student Name </label>
<input
  type = "text"
  name = "name"
  th:field = "*{name}"
  class = "form-control"
  placeholder="Enter Student Name"
  />
  </div>

<div class ="form-group">
<label> Department</label>
<input
  type = "text"
  name = "dept"
  th:field = "*{dept}"
  class = "form-control"
  placeholder="Enter Student Department"
  />
  </div>
  
    <div class ="form-group">
    <label> Country </label>
    <input
    type = "text"
    name = "country"
    th:field = "*{country}"
    class = "form-control"
    placeholder="Enter Student Country"
    />
    </div>
    
      <div class = "box-footer">
      <button type="submit" class = "btn btn-primary">
      Submit
      </button>
      </div>
      </form>
      </div>
      </div>
      </div>
      </div>
      </body>
      </html>
      
 
 student.html
 
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"> 
<head>
<meta charset="ISO-8859-1">
<title>Student Management System</title> <link rel="stylesheet"
href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css
"
integrity="sha384- Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
crossorigin="anonymous"> 
</head>
<body>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
    
<!-- Brand -->
<a class="navbar-brand" href="#">Student Management System</a> 

<!-- Toggler/collapsibe Button -->
<button class="navbar-toggler" type="button" data-toggle="collapse"
datatarget="#collapsibleNavbar">
<span class="navbar-toggler-icon">
</span>
</button>

</nav>

<div class ="container"> 
<div class = "row">
<h1> List Students </h1>
</div>

<div class = "row">
<div class = "col-lg-3">
<a th:href = "@{/students/new}" class = "btn btnprimary btn-sm mb-3"> Add Student</a>
</div>
</div>
<table class = "table table-striped table-bordered"> 
<thead class = "table-dark">
                           <tr>
                                 <th> Student Id</th>
                                 <th> Student Name</th>
                                 <th>  Department</th>
                                 <th>  Country </th>
                                 <th> Actions </th>
                           </tr>
             
  </thead>
  
  <tbody>
  <tr th:each = "student: ${students}">
  <td th:text = "${student.id}"></td>
  <td th:text = "${student.name}"></td> 
  <td th:text = "${student.dept}"></td> 
  <td th:text = "${student.country}"></td> 
  <td>
  <a th:href = "@{/students/edit/{id}(id=${student.id})}"
    class = "btn btn-primary">Update</a>
    <a th:href = "@{/students/{id}(id=${student.id})}"
      class = "btn btn-danger">Delete</a>
      </td>
      </tr>
      </tbody>
      </table>
      </div>
      </body>
      </html>
      
 edit_student.html
 
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"> 
<head>
<meta charset="ISO-8859-1">
<title>Student Management System</title> <link rel="stylesheet"
href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css
"
integrity="sha384- Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="#">Student Management System</a>

<!-- Toggler/collapsibe Button -->
<button class="navbar-toggler" type="button" data-toggle="collapse" datatarget="#collapsibleNavbar">
<span class="navbar-toggler-icon"></span>
</button>

<!-- Navbar links -->
<div class="collapse navbar-collapse" id="collapsibleNavbar">
<ul class="navbar-nav">
<li class="nav-item">
<a class="nav-link" th:href="@{/students}">Student Management</a>
</li>
</ul>
</div>
</nav>
<br>
<br>

<div class = "container">
<div class = "row">
<div class ="col-lg-6 col-md-6 col-sm-6 container justifycontent-center card">
<h1 class = "text-center"> Update Student </h1>
<div class = "card-body">
<form th:action="@{/students/{id}
  (id=${student.id})}" th:object = "${student}" method="POST">
  <div class ="form-group">
  <label> Student Name </label>
  <input
    type = "text"
    name = "name"
    th:field = "*{name}"
    class = "form-control"
    placeholder="Enter Student Name"
    />
    </div>
    
    <div class ="form-group">
    <label> Department </label> 
    <input
      type = "text"
      name = "dept"
      th:field = "*{dept}" 
      class = "form-control" 
      placeholder="Enter Student Department"
      />
      </div>
      
      <div class ="form-group">
      <label> Country </label>
      <input
        type = "text"
        name = "country"
        th:field = "*{country}"
        class = "form-control"
        placeholder="Enter Student Country"
        />
        </div>
        
        <div class = "box-footer">
        <button type="submit" class = "btn btn-primary">
        Submit
        </button>
        </div>
        </form>
        </div>
        </div>
        </div>
        </div>
        </body>
        </html>
        
   view.html
   
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"> <head>
<meta charset="ISO-8859-1">
<title>Student Management System</title> 
<link rel="stylesheet"
href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css
"
integrity="sha384- Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
crossorigin="anonymous"> 
</head>
<body>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">

<!-- Brand -->
<a class="navbar-brand" href="#">Student Management System</a> 
<!-- Toggler/collapsibe Button -->
<button class="navbar-toggler" type="button" data-toggle="collapse"
datatarget="#collapsibleNavbar">
<span class="navbar-toggler-icon"></span>
</button>

</nav>
<div class ="container">
<div class = "row">
<h1> List Students </h1>
</div>

<table class = "table table-striped table-bordered"> 
<thead class = "table-dark">
<tr>
        <th> Student Id</th>
        <th> Student Name</th>
        <th>  Department</th>
        <th>  Country </th>
</tr>
</thead>

<tbody>
<tr th:each = "student: ${students}">
<td th:text = "${student.id}"></td>
<td th:text = "${student.name}"></td> 
<td th:text = "${student.dept}"></td> 
<td th:text = "${student.country}"></td>
</tr>
</tbody>
</table>
</div>
</body>
</html>

login.html

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"> <title>Login</title> 
<style type="text/css"> @import "bourbon";
body {
background: #eee !important;
  }
.wrapper {
margin-top: 80px;
margin-bottom: 80px;
  }
.form-signin {
  max-width: 380px;
  padding: 15px 35px 45px;
  margin: 0 auto;
  background-color: #fff;
  border: 1px solid rgba(0,0,0,0.1);
  
  .form-signin-heading,
       .checkbox {
        margin-bottom: 30px; }
  
  .checkbox { 
    font-weight: normal;
    }
  
  .form-control { 
    position: relative; 
    font-size: 16px; 
    height: auto; 
    padding: 10px;

    @include box-sizing(border-box);
    &:focus { z-index: 2;
     } 
      }
  
  input[type="text"] { 
    margin-bottom: -1px; 
    border-bottom-left-radius: 0; 
    border-bottom-right-radius: 0;
    }
  
  input[type="password"] { 
    margin-bottom: 20px; 
    border-top-left-radius: 0; 
    border-top-right-radius: 0;
  }
  }

</style>
</head>
<body>
<div class="wrapper">
<form class="form-signin" onsubmit="myFunction()">
<h2 class="form-signin-heading">Please login</h2>
<input type="text" class="form-control" name="username" placeholder="Email Address" required="" autofocus="" /><br><br>
<input type="password" class="form-control" name="password" placeholder="Password" required=""/> <br> <br>
<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
  </form>
  </div>
  
  <script>
function myFunction() {
if(username=="AdminLogin" && password =="Admin@123"){ location.replace("http://localhost:8080/students")
}
else if(username=="UserLogin" && password =="User@123"){
location.replace("http://localhost:8080/view") }
}
</script>
</body>
</html>

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
      
