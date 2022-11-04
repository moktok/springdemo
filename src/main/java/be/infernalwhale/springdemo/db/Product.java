package be.infernalwhale.springdemo.db;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private Long id;
    private int priceInCent;
    private int distance;
    private int productCode;

    public Long getId() {
        return id;
    }

    public Product setId(Long id) {
        this.id = id;
        return this;
    }

    public int getPriceInCent() {
        return priceInCent;
    }

    public Product setPriceInCent(int priceInCent) {
        this.priceInCent = priceInCent;
        return this;
    }

    public int getDistance() {
        return distance;
    }

    public Product setDistance(int distance) {
        this.distance = distance;
        return this;
    }

    public int getProductCode() {
        return productCode;
    }

    public Product setProductCode(int productCode) {
        this.productCode = productCode;
        return this;
    }
}
