package be.infernalwhale.springdemo.db;

import java.time.LocalDateTime;

public class Order {
    private Long id;
    private LocalDateTime dateTime;
    private SaleChannel saleChannel;

    private int sourceStationID;
    private int destStationID;

    public Long getId() {
        return id;
    }

    public Order setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Order setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public SaleChannel getSaleChannel() {
        return saleChannel;
    }

    public Order setSaleChannel(SaleChannel saleChannel) {
        this.saleChannel = saleChannel;
        return this;
    }

    public int getSourceStationID() {
        return sourceStationID;
    }

    public Order setSourceStationID(int sourceStationID) {
        this.sourceStationID = sourceStationID;
        return this;
    }

    public int getDestStationID() {
        return destStationID;
    }

    public Order setDestStationID(int destStationID) {
        this.destStationID = destStationID;
        return this;
    }
}
