package it.dogs.learn2.service;

import it.dogs.learn2.exception.SubscriptionNotFoundException;
import it.dogs.learn2.model.Subscription;
import it.dogs.learn2.model.SubscriptionId;
import it.dogs.learn2.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    public Subscription getSubscriptionById(SubscriptionId id) {
        return subscriptionRepository.findById(id).orElseThrow(() -> new SubscriptionNotFoundException(id));
    }

    public Subscription createSubscription(Subscription subscription){
        return subscriptionRepository.save(subscription);
    }

    public void deleteSubscriptionById(SubscriptionId id){
        subscriptionRepository.deleteById(id);
    }

    public Subscription save(Subscription subscription){
        return subscriptionRepository.save(subscription);
    }
}
