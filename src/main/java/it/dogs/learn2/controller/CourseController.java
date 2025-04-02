package it.dogs.learn2.controller;

import it.dogs.learn2.dto.CourseRequestDTO;
import it.dogs.learn2.dto.CourseResponseDTO;
import it.dogs.learn2.facade.definition.CourseFacadeDefinition;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseFacadeDefinition courseFacadeDefinition;

    @GetMapping("/details/{id}")
    public ResponseEntity<CourseResponseDTO> getCourseDetails(@PathVariable Long id) {
        return ResponseEntity.ok(courseFacadeDefinition.getCourseDetails(id));
    }

    @GetMapping
    public List<CourseResponseDTO> getAllCourses() {
        return courseFacadeDefinition.getAllCourses();
    }

    @PostMapping("/create")
    public ResponseEntity<CourseResponseDTO> createCourse(@RequestBody CourseRequestDTO requestDTO) {
        return ResponseEntity.ok(courseFacadeDefinition.createCourse(requestDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CourseResponseDTO> updateCourse(@PathVariable Long id,
                                                          @RequestBody CourseRequestDTO requestDTO) {
        return ResponseEntity.ok(courseFacadeDefinition.updateCourse(id, requestDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseFacadeDefinition.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}

