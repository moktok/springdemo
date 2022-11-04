package be.infernalwhale.springdemo.service;

import be.infernalwhale.springdemo.db.Price;
import be.infernalwhale.springdemo.db.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.TestPropertySources;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySources([
        @TestPropertySource("classpath:application-integrationtest.properties")])
        // TestPropertySource; Load application properties without creating/loading a profile
        // TestPropertySources for multiple sources, order matters
    @Profile({"prof1", "prof2"})
@DataJpaTest
@WebMvcTest
class TicketServiceImpl_IntegrationTest {

    @MockBean
    MockMvc mockMvc;

    @Test
    void mvcTest() {

    }

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
        @Bean
        public PriceService priceService() {
            return new PriceService() {
                @Override
                public List<Price> calcPrice(int sourceStationID, int destStationID) {
                    return null;
                }
            };
        }
    }

    @MockBean
    private ProductRepository productRepository;
    // Will behave like normal mock.. but Spring will be aware of this bean

    @Test
    public void contextLoads() {
        // By default, @SpringBootTest will load the FULL context
    }


}