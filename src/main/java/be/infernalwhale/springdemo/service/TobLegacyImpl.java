package be.infernalwhale.springdemo.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class TobLegacyImpl implements TobLegacy {

    @Override
    public boolean requestTobStatus(int sourceStationID, LocalDateTime dateTime) {
        // We're simulating a call to a legacy system here.. We're representing this by returning a random value.
        // But just pretend it's a call to
        return new Random().nextBoolean();
    }
}
