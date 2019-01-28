package adapter;

/**
 * Created by 木头人 on 2018/10/4.
 */

public class Good {
    public Good(String goodName, int goodImageId) {
        this.goodName = goodName;
        this.goodImageId = goodImageId;
    }

    public String getGoodName() {
        return goodName;
    }

    public int getGoodImageId() {
        return goodImageId;
    }

    private String goodName;
    private int goodImageId;
}
