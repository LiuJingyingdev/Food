package adapter;

/**
 * Created by 木头人 on 2019/1/22.
 */

public class Coupon {
    public Coupon(int imagId, String storeName, String price) {
        this.imagId = imagId;
        this.storeName = storeName;
        this.price = price;
    }

    public int getImagId() {
        return imagId;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getPrice() {
        return price;
    }

    private int imagId;
    private String storeName;
    private String price;
}
