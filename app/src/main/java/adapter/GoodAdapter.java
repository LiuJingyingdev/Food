package adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.food.MainMenu;
import com.example.food.MyApplication;
import com.example.food.R;
import com.example.food.StoreMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 木头人 on 2018/10/4.
 */

public class GoodAdapter  extends RecyclerView.Adapter<GoodAdapter.ViewHolder> {

    private List<Good> mGoodList;
    private TextView mgoodPrice;
    private List<SGoodPrice> sgprive = new ArrayList<>();
    private int kgood;

    private void Initspgrive()
    {
        for(int i = 0;i < mGoodList.size();i++) {
            SGoodPrice stemp = new SGoodPrice();
            stemp.Setigood(6);
            sgprive.add(stemp);
        }
    }

    static class SGoodPrice
    {
        private int igood;
        String goodString()
        {
            return Integer.toString(igood);
        }
        void Setigood(int sgood)
        {
            igood = sgood;
        }
        int Getigood()
        {
            return igood;
        }
    }



    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView goodImage;
        TextView goodName;
        ImageView addGood;

        public ViewHolder(View view){
            super(view);
            goodImage = (ImageView) view.findViewById(R.id.good_image);
            goodName = (TextView) view.findViewById(R.id.good_name);
            addGood = (ImageView) view.findViewById(R.id.add_good);
        }
    }

    public GoodAdapter(List<Good> goodList,TextView goodPrice){
        mGoodList = goodList;
        mgoodPrice = goodPrice;

        kgood = 0;
        Initspgrive();
        Log.d("Init","构造函数结束");
    }

    @Override
    public GoodAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.good_item, parent, false);
        GoodAdapter.ViewHolder holder = new GoodAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(GoodAdapter.ViewHolder holder, final int position){
        final Good good = mGoodList.get(position);
        holder.goodImage.setImageResource(good.getGoodImageId());
        holder.goodName.setText(good.getGoodName());
        holder.addGood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SGoodPrice stemp = sgprive.get(position);
                kgood = kgood + stemp.Getigood();
                mgoodPrice.setText(Integer.toString(kgood)+"块钱");
              //  Toast.makeText(MyApplication.getContext(),"你点击了加入购物车！",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount(){
        return mGoodList.size();
    }
}
