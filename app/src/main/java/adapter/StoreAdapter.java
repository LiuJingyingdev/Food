package adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.food.R;
import com.example.food.StoreMap;

import java.util.List;

/**
 * Created by 木头人 on 2018/10/4.
 */

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder>{
    private List<Store> mStoreList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View storeView;//处理点击事件
        ImageView storeImage;
        TextView storeName;

        public ViewHolder(View view){
            super(view);
            storeView = view;//处理点击事件
            storeImage = (ImageView) view.findViewById(R.id.store_image);
            storeName = (TextView) view.findViewById(R.id.store_name);
        }
    }

    public StoreAdapter(List<Store> storeList){
        mStoreList = storeList;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.storeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Store store = mStoreList.get(position);
                Intent intent = new Intent(parent.getContext(), StoreMap.class);
                intent.putExtra("StoreName",store.getStore_name());
                intent.putExtra("StoreImage",store.getStore_imageId());
                parent.getContext().startActivity(intent);
            }
        });
        holder.storeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Store store = mStoreList.get(position);
                Intent intent = new Intent(parent.getContext(), StoreMap.class);
                intent.putExtra("StoreName",store.getStore_name());
//                intent.putExtra("StoreImage",store.getStore_imageId());
                parent.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Store store = mStoreList.get(position);
        holder.storeImage.setImageResource(store.getStore_imageId());
        holder.storeName.setText(store.getStore_name());
    }

    @Override
    public int getItemCount(){
        return mStoreList.size();
    }

}
