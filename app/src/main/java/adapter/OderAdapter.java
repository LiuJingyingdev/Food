package adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.food.Oder_Details;
import com.example.food.R;

import java.util.List;

/**
 * Created by 木头人 on 2018/10/4.
 */

public class OderAdapter extends RecyclerView.Adapter<OderAdapter.ViewHolder>{
    private List<Order> mOderList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView orderImage;
        TextView orderName;
        View orderView;

        public ViewHolder(View view){
            super(view);
            orderView = view;
            orderImage = (ImageView) view.findViewById(R.id.order_image);
            orderName = (TextView) view.findViewById(R.id.order_name);

        }
    }

    public OderAdapter(List<Order> orderList){
        mOderList = orderList;
    }

    @Override
    public OderAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);
        final OderAdapter.ViewHolder holder = new OderAdapter.ViewHolder(view);
        holder.orderView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(parent.getContext(),Oder_Details.class);
                parent.getContext().startActivity(intent);

            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(OderAdapter.ViewHolder holder, int position){
        Order order = mOderList.get(position);
        holder.orderImage.setImageResource(order.getOrderImageId());
        holder.orderName.setText(order.getOrderName());
    }

    @Override
    public int getItemCount(){
        return mOderList.size();
    }
}
