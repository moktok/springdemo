package be.infernalwhale.springdemo.service;

import org.springframework.stereotype.Service;

@Service
public class AlphaService {
    private final ReallyNeedyService service;

    public AlphaService(ReallyNeedyService service) {
        this.service = service;
    }
}
