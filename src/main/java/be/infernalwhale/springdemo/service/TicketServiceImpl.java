package be.infernalwhale.springdemo.service;

import be.infernalwhale.springdemo.db.Order;
import be.infernalwhale.springdemo.db.Price;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final PriceService basePriceService;
    private final TOBService tobService;

    public TicketServiceImpl(PriceService basePriceService, TOBService tobService) {
        this.basePriceService = basePriceService;
        this.tobService = tobService;
    }

    @Override
    public List<Price> calcPrice(Order order) throws ValidationException {
        validateOrder(order);

        List<Price> prices = basePriceService.calcPrice(order.getSourceStationID(), order.getDestStationID());

        if (tobService.isTobRequired(order.getSourceStationID(), order.getDateTime(), order.getSaleChannel())) {
            prices = tobService.addTOB(prices);
        }

        return prices;
    }

    private void validateOrder(Order order) throws ValidationException {
        if (order.getDateTime().isAfter(LocalDateTime.now()))
            throw new ValidationException("You are trying to communicate to the backend from the future.");
    }
}
