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
