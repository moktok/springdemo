package be.infernalwhale.springdemo.service;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EventHandlerServiceTest {
    EventHandlerService eventHandlerService;

    @Mock
    ApplicationEventPublisher publisher;

    @BeforeEach
    void init() {
        eventHandlerService = new EventHandlerService(publisher);
    }

    @Test
    void testEventHandlingService_givenValidEvent_shouldPublishStringBuilder() {
        // given
        // create the input (and in this case it's an event)
        CustomEvent inputEvent = new CustomEvent("It doesn't matter..");
        // Setup the mock - Not needed IN THIS CASE

        // when
        eventHandlerService.onCustomEvent(inputEvent);

        // then
        // check output (this thing is void, so no output)
        // BUT, we also have to verify that it does what we expect, in this case.. publish another event.
        verify(publisher, times(1))
                .publishEvent(anyString());
    }

}