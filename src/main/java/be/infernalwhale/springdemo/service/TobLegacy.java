package be.infernalwhale.springdemo.service;

import java.time.LocalDateTime;

public interface TobLegacy {

    boolean requestTobStatus(int sourceStationID, LocalDateTime dateTime);
}
