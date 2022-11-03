package be.infernalwhale.springdemo.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class ReallyNeedyService {
    private final AnImportantService importantService;

    public ReallyNeedyService(AnImportantService importantService) {
        System.out.println("Creating the ReallyNeedyService");
        this.importantService = importantService;
    }
}
