package it.dogs.learn2.facade.definition;

import it.dogs.learn2.dto.CourseRequestDTO;
import it.dogs.learn2.dto.CourseResponseDTO;

import java.util.List;

public interface CourseFacadeDefinition {
    List<CourseResponseDTO> getAllCourses();
    CourseResponseDTO createCourse(CourseRequestDTO requestDTO);
    CourseResponseDTO updateCourse(Long id, CourseRequestDTO requestDTO);
    CourseResponseDTO getCourseDetails(Long id);
    void deleteCourse(Long id);
}
