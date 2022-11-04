package be.infernalwhale.springdemo.service;

import be.infernalwhale.springdemo.db.Price;
import be.infernalwhale.springdemo.db.SaleChannel;

import java.time.LocalDateTime;
import java.util.List;

public interface TOBService {
    boolean isTobRequired(int sourceStationID, LocalDateTime dateTime, SaleChannel saleChannel);

    List<Price> addTOB(List<Price> prices);
}
