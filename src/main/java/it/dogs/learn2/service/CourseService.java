package it.dogs.learn2.service;

import it.dogs.learn2.exception.CourseNotFoundException;
import it.dogs.learn2.model.Course;
import it.dogs.learn2.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
    }

    public Course createCourse(Course course){
        return courseRepository.save(course);
    }

    public void deleteCourseById(Long id){
        courseRepository.deleteById(id);
    }

    public Course save(Course course){
        return courseRepository.save(course);
    }
}
