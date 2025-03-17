package scd.lab.unisysotm.dto;

import java.util.List;

public class ProfessorDTO {
    private int professorId;
    private String name;
    private String department;
    private String email;
    private List<CourseDTO> courses;

    // Constructor
    public ProfessorDTO(int professorId, String name, String department, String email, List<CourseDTO> courses) {
        this.professorId = professorId;
        this.name = name;
        this.department = department;
        this.email = email;
        this.courses = courses;
    }

    // Default Constructor (needed for serialization)
    public ProfessorDTO() {}

    // Getters and Setters
    public int getProfessorId() { return professorId; }
    public void setProfessorId(int professorId) { this.professorId = professorId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<CourseDTO> getCourses() { return courses; }
    public void setCourses(List<CourseDTO> courses) { this.courses = courses; }
}