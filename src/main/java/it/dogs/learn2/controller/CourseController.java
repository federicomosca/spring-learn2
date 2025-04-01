package it.dogs.learn2.controller;

import it.dogs.learn2.dto.CourseRequestDTO;
import it.dogs.learn2.dto.CourseResponseDTO;
import it.dogs.learn2.facade.definition.CourseFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseFacade courseFacade;

    @GetMapping("/details/{id}")
    public ResponseEntity<CourseResponseDTO> getCourseDetails(@PathVariable Long id) {
        return ResponseEntity.ok(courseFacade.getCourseDetails(id));
    }

    @GetMapping
    public List<CourseResponseDTO> getAllCourses() {
        return courseFacade.getAllCourses();
    }

    @PostMapping("/create")
    public ResponseEntity<CourseResponseDTO> createCourse(@RequestBody CourseRequestDTO requestDTO) {
        return ResponseEntity.ok(courseFacade.createCourse(requestDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CourseResponseDTO> updateCourse(@PathVariable Long id,
                                                          @RequestBody CourseRequestDTO requestDTO) {
        return ResponseEntity.ok(courseFacade.updateCourse(id, requestDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseFacade.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}

