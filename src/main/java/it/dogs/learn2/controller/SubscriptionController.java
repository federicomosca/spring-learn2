package it.dogs.learn2.controller;

import it.dogs.learn2.facade.definition.SubscriptionFacadeDefinition;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {
    private final SubscriptionFacadeDefinition subscriptionFacade;

    @PostMapping
    public ResponseEntity<Void> subscribe(@RequestParam Long userId, @RequestParam Long courseId) {
        subscriptionFacade.subscribeUserToCourse(userId, courseId);
        return ResponseEntity.ok().build();
    }
}