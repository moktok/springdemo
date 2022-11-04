package be.infernalwhale.springdemo.service;

import be.infernalwhale.springdemo.db.Price;

import java.util.List;

public interface PriceService {
    List<Price> calcPrice(int sourceStationID, int destStationID);
}
