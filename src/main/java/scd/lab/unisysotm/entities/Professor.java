package scd.lab.unisysotm.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "professors")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int professorId;

    private String name;
    private String department;
    private String email;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Course> courses;

    // Constructors
    public Professor() {}

    public Professor(String name, String department, String email, List<Course> courses) {
        this.name = name;
        this.department = department;
        this.email = email;
        this.courses = courses;
    }

    // Getters and Setters
    public int getProfessorId() { return professorId; }
    public void setProfessorId(int professorId) { this.professorId = professorId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Course> getCourses() { return courses; }
    public void setCourses(List<Course> courses) {
        this.courses = courses;
        // Maintain bidirectional relationship
        if (courses != null) {
            for (Course course : courses) {
                course.setProfessor(this);
            }
        }
    }
}