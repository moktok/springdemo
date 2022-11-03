package be.infernalwhale.springdemo;

import be.infernalwhale.springdemo.service.CustomEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringdemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =
        SpringApplication.run(SpringdemoApplication.class, args);

        CustomEvent event = new CustomEvent("Message from hell!!!");
        ctx.publishEvent(event);

        // https://www.youtube.com:443/watch?v=CBfGIR0NqCE
        // http(s) >> communications protocol (request-response-model)
        // ://
        // www.youtube.com >> domain-name >> translated to server address
        // /watch >> resource-application-path
        // v=CBfGIR0NqCE >> request-params

        // GET          >> READ
        // POST         >> CREATE
        // PUT / PATCH  >> UPDATE
        // DELETE       >> DELETE

    }

}
