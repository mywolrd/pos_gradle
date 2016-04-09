package pos.model;

import java.time.ZonedDateTime;
import java.util.List;

public class Order {

    private long id;
    private List<OrderDetails> items;
    private int quantity;
    private Price total;
    private ZonedDateTime dropDate;
    private ZonedDateTime readyDate;

    public static class OrderBuilder {

        private long id;
    }
}