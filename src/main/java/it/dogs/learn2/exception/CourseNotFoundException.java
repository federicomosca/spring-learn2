package it.dogs.learn2.exception;

public class CourseNotFoundException extends RuntimeException{

    public CourseNotFoundException(Long id){
        super("Course with ID" + id + " not found.");
    }
}
