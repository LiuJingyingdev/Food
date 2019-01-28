package adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.food.R;

import java.util.List;

/**
 * Created by 木头人 on 2019/1/22.
 */

public class CouponAdapter extends RecyclerView.Adapter<CouponAdapter.ViewHolder> {

    private List<Coupon> mCouponList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView couponImage;
        TextView couponStoreName;
        TextView couponPrice;
        public ViewHolder(View view){
            super(view);
            couponImage = (ImageView) view.findViewById(R.id.coupon_image);
            couponStoreName = (TextView) view.findViewById(R.id.coupon_store_name);
            couponPrice = (TextView) view.findViewById(R.id.coupon_price);
        }
    }

    public CouponAdapter(List<Coupon> couponList){
        mCouponList = couponList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cash_coupon_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Coupon coupon = mCouponList.get(position);
        holder.couponImage.setImageResource(coupon.getImagId());
        holder.couponStoreName.setText(coupon.getStoreName());
        holder.couponPrice.setText(coupon.getPrice());
    }


    @Override
    public int getItemCount() {
        return mCouponList.size();
    }
}

