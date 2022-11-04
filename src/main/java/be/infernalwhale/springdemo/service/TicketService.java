package be.infernalwhale.springdemo.service;

import be.infernalwhale.springdemo.db.Order;
import be.infernalwhale.springdemo.db.Price;

import javax.xml.bind.ValidationException;
import java.util.List;

public interface TicketService {

    List<Price> calcPrice(Order order) throws ValidationException;

}
