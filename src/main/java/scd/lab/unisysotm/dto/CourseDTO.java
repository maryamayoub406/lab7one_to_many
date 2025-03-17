package scd.lab.unisysotm.dto;

public class CourseDTO {
    private int courseId;
    private String courseName;
    private String courseDescription;
    private String courseCode;

    // Constructor
    public CourseDTO(int courseId, String courseName, String courseDescription, String courseCode) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseCode = courseCode;
    }

    // Default Constructor (needed for serialization)
    public CourseDTO() {}

    // Getters and Setters
    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getCourseDescription() { return courseDescription; }
    public void setCourseDescription(String courseDescription) { this.courseDescription = courseDescription; }

    public String getCourseCode() { return courseCode; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }
}