package be.infernalwhale.springdemo.db;

public class Price {
    private int priceInCent;
    private TravelClass travelClass;
    private int productCode;

    public int getPriceInCent() {
        return priceInCent;
    }

    public Price setPriceInCent(int priceInCent) {
        this.priceInCent = priceInCent;
        return this;
    }

    public TravelClass getTravelClass() {
        return travelClass;
    }

    public Price setTravelClass(TravelClass travelClass) {
        this.travelClass = travelClass;
        return this;
    }

    public int getProductCode() {
        return productCode;
    }

    public Price setProductCode(int productCode) {
        this.productCode = productCode;
        return this;
    }
}
