package it.dogs.learn2.facade.implementation;

import it.dogs.learn2.dto.CourseRequestDTO;
import it.dogs.learn2.dto.CourseResponseDTO;
import it.dogs.learn2.facade.definition.CourseFacadeDefinition;
import it.dogs.learn2.model.Course;
import it.dogs.learn2.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CourseFacadeImplementation implements CourseFacadeDefinition {

    private final CourseService courseService;

    @Override
    public List<CourseResponseDTO> getAllCourses() {
        return courseService.getAllCourses().stream()
                .map(course -> new CourseResponseDTO(
                        course.getId(),
                        course.getTitle(),
                        course.getDescription(),
                        course.getStartDate(),
                        course.getEndDate(),
                        course.getDeliveryMode()))
                .toList();
    }

    @Override
    public CourseResponseDTO createCourse(CourseRequestDTO requestDTO) {
        Course course = new Course();
        course.setTitle(requestDTO.title());
        course.setDescription(requestDTO.description());
        course.setStartDate(requestDTO.startDate());
        course.setEndDate(requestDTO.endDate());
        course.setDeliveryMode(requestDTO.deliveryMode());

        Course saved = courseService.save(course);

        return new CourseResponseDTO(
                saved.getId(),
                saved.getTitle(),
                saved.getDescription(),
                saved.getStartDate(),
                saved.getEndDate(),
                saved.getDeliveryMode());
    }

    @Override
    public CourseResponseDTO updateCourse(Long id, CourseRequestDTO requestDTO) {
        Course existing = courseService.getCourseById(id);

        existing.setTitle(requestDTO.title());
        existing.setDescription(requestDTO.description());
        existing.setStartDate(requestDTO.startDate());
        existing.setEndDate(requestDTO.endDate());
        existing.setDeliveryMode(requestDTO.deliveryMode());

        Course updated = courseService.save(existing);

        return new CourseResponseDTO(
                updated.getId(),
                updated.getTitle(),
                updated.getDescription(),
                updated.getStartDate(),
                updated.getEndDate(),
                updated.getDeliveryMode());
    }

    @Override
    public CourseResponseDTO getCourseDetails(Long id) {
        Course course = courseService.getCourseById(id);
        return new CourseResponseDTO(
                course.getId(),
                course.getTitle(),
                course.getDescription(),
                course.getStartDate(),
                course.getEndDate(),
                course.getDeliveryMode());
    }

    @Override
    public void deleteCourse(Long id) {
        courseService.deleteCourseById(id);
    }
}

