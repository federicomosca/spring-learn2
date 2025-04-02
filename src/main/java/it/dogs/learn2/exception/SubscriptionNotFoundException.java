package it.dogs.learn2.exception;

import it.dogs.learn2.model.SubscriptionId;

public class SubscriptionNotFoundException extends RuntimeException{

    public SubscriptionNotFoundException(SubscriptionId id){
        super("Subscription with ID" + id + " not found.");
    }
}
