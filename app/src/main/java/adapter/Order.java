package adapter;

/**
 * Created by 木头人 on 2018/10/4.
 */

public class Order {
    public Order(String orderName, int orderImageId) {
        this.orderName = orderName;
        this.orderImageId = orderImageId;
    }

    public String getOrderName() {
        return orderName;
    }

    public int getOrderImageId() {
        return orderImageId;
    }

    private String orderName;
    private int orderImageId;
}
