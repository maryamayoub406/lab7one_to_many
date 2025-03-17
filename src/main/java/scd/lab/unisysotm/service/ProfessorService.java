package scd.lab.unisysotm.service;

import scd.lab.unisysotm.dto.CourseDTO;
import scd.lab.unisysotm.dto.ProfessorDTO;
import scd.lab.unisysotm.entities.Professor;
import scd.lab.unisysotm.entities.Course;
import scd.lab.unisysotm.repository.ProfessorRepository;
import scd.lab.unisysotm.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private CourseRepository courseRepository;

    // Convert Entity to DTO
    private ProfessorDTO convertToDTO(Professor professor) {
        List<CourseDTO> courseDTOs = professor.getCourses().stream()
                .map(course -> new CourseDTO(
                        course.getCourseId(),
                        course.getCourseName(),
                        course.getCourseDescription(),
                        course.getCourseCode()))
                .collect(Collectors.toList());

        return new ProfessorDTO(
                professor.getProfessorId(),
                professor.getName(),
                professor.getDepartment(),
                professor.getEmail(),
                courseDTOs);
    }

    // Convert Course Entity to DTO
    private CourseDTO convertCourseToDTO(Course course) {
        return new CourseDTO(
                course.getCourseId(),
                course.getCourseName(),
                course.getCourseDescription(),
                course.getCourseCode());
    }

    // Get All Professors with their courses
    public List<ProfessorDTO> getAllProfessors() {
        return professorRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get Professor by ID with courses
    public ProfessorDTO getProfessorById(int id) {
        return professorRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    // Save Professor with courses
    public ProfessorDTO saveProfessor(Professor professor) {
        // Ensure the bidirectional relationship is maintained
        if (professor.getCourses() != null) {
            professor.getCourses().forEach(course -> course.setProfessor(professor));
        }
        Professor savedProfessor = professorRepository.save(professor);
        return convertToDTO(savedProfessor);
    }

    // Get all courses taught by a professor
    public List<CourseDTO> getCoursesByProfessorId(int professorId) {
        return courseRepository.findByProfessorProfessorId(professorId).stream()
                .map(this::convertCourseToDTO)
                .collect(Collectors.toList());
    }
}