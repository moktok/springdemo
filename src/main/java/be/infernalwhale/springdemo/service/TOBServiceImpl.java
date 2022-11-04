package be.infernalwhale.springdemo.service;

import be.infernalwhale.springdemo.db.Price;
import be.infernalwhale.springdemo.db.SaleChannel;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static be.infernalwhale.springdemo.db.SaleChannel.ONTRAIN;
import static be.infernalwhale.springdemo.db.SaleChannel.TVM_ONTRAIN;

@Service
public class TOBServiceImpl implements TOBService {


    private final TobLegacy tobLegacy;

    public TOBServiceImpl(TobLegacy tobLegacy) {
        this.tobLegacy = tobLegacy;
    }

    @Override
    public boolean isTobRequired(int sourceStationID, LocalDateTime dateTime, SaleChannel saleChannel) {
        if (saleChannel == ONTRAIN || saleChannel ==  TVM_ONTRAIN) return tobLegacy.requestTobStatus(sourceStationID, dateTime);

        return false;
    }

    @Override
    public List<Price> addTOB(List<Price> prices) {
        return prices.stream()
                .map(this::applyTOB)
                .collect(Collectors.toList());
    }

    private Price applyTOB(Price price) {
        if (price.getProductCode() < 1) price.setPriceInCent(price.getPriceInCent() * 10);
        return price;
    }
}
