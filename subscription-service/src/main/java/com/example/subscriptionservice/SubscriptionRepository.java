package com.example.subscriptionservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription,Long>{
 
    List<Subscription> findAll();
    
    Subscription findBySubscriberName(String subscriberName);
    
}
 