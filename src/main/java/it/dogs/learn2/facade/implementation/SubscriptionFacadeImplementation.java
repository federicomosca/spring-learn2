package it.dogs.learn2.facade.implementation;

import it.dogs.learn2.facade.definition.SubscriptionFacadeDefinition;
import it.dogs.learn2.model.Course;
import it.dogs.learn2.model.Subscription;
import it.dogs.learn2.model.SubscriptionId;
import it.dogs.learn2.model.User;
import it.dogs.learn2.repository.CourseRepository;
import it.dogs.learn2.repository.SubscriptionRepository;
import it.dogs.learn2.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SubscriptionFacadeImplementation implements SubscriptionFacadeDefinition {
    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    public SubscriptionFacadeImplementation(
            SubscriptionRepository subscriptionRepository,
            UserRepository userRepository,
            CourseRepository courseRepository
    ) {
        this.subscriptionRepository = subscriptionRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void subscribeUserToCourse(Long userId, Long courseId) {
        User user = userRepository.findById(userId).orElseThrow();
        Course course = courseRepository.findById(courseId).orElseThrow();

        Subscription subscription = new Subscription();
        subscription.setId(new SubscriptionId(userId, courseId));
        subscription.setUser(user);
        subscription.setCourse(course);
        subscription.setSubscriptionDate(LocalDate.now());

        subscriptionRepository.save(subscription);
    }
}