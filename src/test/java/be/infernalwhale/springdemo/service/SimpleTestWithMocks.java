package be.infernalwhale.springdemo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SimpleTestWithMocks {
    NeedyService needyService;

    @Mock
    AnImportantService importantService;

    @BeforeEach
    void init() {
        needyService = new NeedyService(importantService);
    }

    @Test
    void testNeedyService_givenValidInput_willReturnSomething() {
        // define the input of the method under test
        Integer input = 0;
        // if we use a method of a dependency we need to create a mock for that method
        when(importantService.hello()).thenReturn("hello");

        String output = needyService.fizzBuzz(input);

//        assertThrows(NullPointerException.class, () -> needyService.fizzBuzz(null));
        verify(importantService, times(1)).hello();
        assertThat(output).isEqualTo("hello");
    }

}
