package be.infernalwhale.springdemo.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class NeedyService {
    private final AnImportantService importantService;

    public NeedyService(AnImportantService importantService) {
        System.out.println("Create NeedyService...");
        this.importantService = importantService;
    }

    public String fizzBuzz(Integer x) {
        if (x % 3 == 0 && x % 5 == 0) return importantService.hello();
        if (x % 3 == 0) return importantService.getFizz();
        if (x % 5 == 0) return importantService.getBuzz();
        return "" + x;
    }
}
