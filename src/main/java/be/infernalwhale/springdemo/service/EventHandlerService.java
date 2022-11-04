package be.infernalwhale.springdemo.service;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventHandlerService {
    private ApplicationEventPublisher publisher;

    public EventHandlerService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @EventListener
    public void onCustomEvent(CustomEvent event) {
        System.out.println("Event received with message: " + event.getMessage());
        publisher.publishEvent("Just a message");
    }

    private List<String> someList = new ArrayList<>();
    public String blah() {
        clear();
        return "Not important String";
    }

    private void clear() {
        someList = new ArrayList<>();
    }
}
