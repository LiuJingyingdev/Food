package adapter;

/**
 * Created by 木头人 on 2019/1/26.
 */

public class Classify {
    public Classify(int imagId, String storeName) {
        this.imagId = imagId;
        this.storeName = storeName;
    }

    public int getImagId() {
        return imagId;
    }

    public String getStoreName() {
        return storeName;
    }

    private int imagId;
    private String storeName;
}
