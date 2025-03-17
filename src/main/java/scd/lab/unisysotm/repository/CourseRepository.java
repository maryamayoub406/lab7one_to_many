package scd.lab.unisysotm.repository;

import scd.lab.unisysotm.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    // Find all courses taught by a specific professor
    List<Course> findByProfessorProfessorId(int professorId);

    // Alternative query method using JPQL
    @Query("SELECT c FROM Course c WHERE c.professor.professorId = :professorId")
    List<Course> getCoursesByProfessorId(@Param("professorId") int professorId);
}