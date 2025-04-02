package it.dogs.learn2.repository;

import it.dogs.learn2.model.Subscription;
import it.dogs.learn2.model.SubscriptionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, SubscriptionId> {}
