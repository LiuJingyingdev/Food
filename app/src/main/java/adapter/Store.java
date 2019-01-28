package adapter;

/**
 * Created by 木头人 on 2018/10/4.
 */

public class Store {


    public Store(String store_name, int store_imageId) {
        this.store_name = store_name;
        this.store_imageId = store_imageId;
    }

    public String getStore_name() {
        return store_name;
    }

    public int getStore_imageId() {
        return store_imageId;
    }

    private String store_name;
    private int store_imageId;
}
