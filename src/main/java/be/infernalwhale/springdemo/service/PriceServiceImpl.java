package be.infernalwhale.springdemo.service;

import be.infernalwhale.springdemo.db.Price;
import be.infernalwhale.springdemo.db.Product;
import be.infernalwhale.springdemo.db.ProductRepository;
import be.infernalwhale.springdemo.db.TravelClass;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PriceServiceImpl implements PriceService {
    private final ProductRepository productRepository;

    public PriceServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<Price> calcPrice(int sourceStationID, int destStationID) {
        Product product = new Product().setDistance(destStationID - sourceStationID);
        List<Product> products = productRepository.findAll(Example.of(product, ExampleMatcher.matching()));

        return products.stream()
                .map(this::mapToPrice)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private List<Price> mapToPrice(Product product) {
        Price normalPrice = new Price()
                .setPriceInCent(product.getPriceInCent())
                .setTravelClass(TravelClass.SECOND)
                .setProductCode(product.getProductCode());


        Price premiumPrice = new Price()
                .setPriceInCent(product.getPriceInCent() * 3)
                .setTravelClass(TravelClass.FIRST)
                .setProductCode(product.getProductCode());

        return List.of(normalPrice, premiumPrice);
    }
}
