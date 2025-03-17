package scd.lab.unisysotm.controller;

import scd.lab.unisysotm.dto.CourseDTO;
import scd.lab.unisysotm.dto.ProfessorDTO;
import scd.lab.unisysotm.entities.Professor;
import scd.lab.unisysotm.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professors")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    // Get all professors with their courses
    @GetMapping
    public List<ProfessorDTO> getAllProfessors() {
        return professorService.getAllProfessors();
    }

    // Get professor by ID with courses
    @GetMapping("/{id}")
    public ProfessorDTO getProfessorById(@PathVariable int id) {
        return professorService.getProfessorById(id);
    }

    // Create new professor with courses
    @PostMapping
    public ProfessorDTO saveProfessor(@RequestBody Professor professor) {
        return professorService.saveProfessor(professor);
    }

    // Get all courses taught by a specific professor
    @GetMapping("/{id}/courses")
    public List<CourseDTO> getCoursesByProfessorId(@PathVariable int id) {
        return professorService.getCoursesByProfessorId(id);
    }
}