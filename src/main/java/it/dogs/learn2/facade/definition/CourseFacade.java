package it.dogs.learn2.facade.definition;

import it.dogs.learn2.dto.CourseRequestDTO;
import it.dogs.learn2.dto.CourseResponseDTO;
import it.dogs.learn2.dto.UserRequestDTO;
import it.dogs.learn2.dto.UserResponseDTO;

import java.util.List;

public interface CourseFacade {
    List<CourseResponseDTO> getAllCourses();
    CourseResponseDTO createCourse(CourseRequestDTO requestDTO);
    CourseResponseDTO updateCourse(Long id, CourseRequestDTO requestDTO);
    CourseResponseDTO getCourseDetails(Long id);
    void deleteCourse(Long id);
}
