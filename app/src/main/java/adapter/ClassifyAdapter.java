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
 * Created by 木头人 on 2019/1/26.
 */

public class ClassifyAdapter extends RecyclerView.Adapter<ClassifyAdapter.ViewHolder>{

    private List<Classify> mclassifyList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView classifyImage;
        TextView classifyName;

        public ViewHolder(View view){
            super(view);
            classifyImage = (ImageView) view.findViewById(R.id.classsify_store_image);
            classifyName = (TextView) view.findViewById(R.id.classify_store_name);
        }
    }

    public ClassifyAdapter(List<Classify> classifyList){
        mclassifyList = classifyList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.classify_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ClassifyAdapter.ViewHolder holder, int position) {
        Classify classify = mclassifyList.get(position);
        holder.classifyImage.setImageResource(classify.getImagId());
        holder.classifyName.setText(classify.getStoreName());
    }


    @Override
    public int getItemCount() {
        return mclassifyList.size();
    }
}
