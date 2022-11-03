package be.infernalwhale.springdemo.service;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class EventHandlerService {
    @EventListener
    public void onCustomEvent(CustomEvent event) {
        System.out.println("Event received with message: " + event.getMessage());
    }
}
