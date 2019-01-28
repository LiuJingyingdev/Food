package adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

import com.example.food.CashCoupon;
import com.example.food.HelpAndFeedBack;
import com.example.food.MyAddress;
import com.example.food.MyReward;
import com.example.food.ProtocolAndSay;
import com.example.food.R;
import com.example.food.RedEnvelopes;
import com.example.food.ServiceCenter;

/**
 * Created by 木头人 on 2019/1/6.
 */

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder>{

    private List<Person> mPersonList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView personItem;
        View viewPerson;


    public ViewHolder(View view){
        super(view);
        viewPerson = view;
        personItem = (TextView) view.findViewById(R.id.personItem);
    }
    }

    public PersonAdapter(List<Person> personList){
        mPersonList = personList;
    }



    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.viewPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                int myPosition = holder.getAdapterPosition();
//                Person person = mPersonList.get(myPosition);
//                String temp1 = person.getPersonItem();
//                String temp = String.valueOf(myPosition);
//                Log.d("TAG",temp);
//                Log.d("TAG1",temp1);
                int position = holder.getAdapterPosition();
                switch (position){
                    case 0:{
                        Intent intent = new Intent(parent.getContext(), RedEnvelopes.class);//红包
                        parent.getContext().startActivity(intent);
                        break;
                    }
                    case 1:{
                        Intent intent = new Intent(parent.getContext(), CashCoupon.class);//商家代金券
                        parent.getContext().startActivity(intent);
                        break;
                    }
                    case 2:{
                        Intent intent = new Intent(parent.getContext(), MyAddress.class);//我的地址
                        parent.getContext().startActivity(intent);
                        break;
                    }
                    case 3:{
                        Intent intent = new Intent(parent.getContext(), MyReward.class);//邀请有奖
                        parent.getContext().startActivity(intent);
                        break;
                    }
                    case 4:{
                        Intent intent = new Intent(parent.getContext(), ServiceCenter.class);//客服中心
                        parent.getContext().startActivity(intent);
                        break;
                    }
                    case 5:{
                        Intent intent = new Intent(parent.getContext(), HelpAndFeedBack.class);//帮助和反馈
                        parent.getContext().startActivity(intent);
                        break;
                    }
                    case 6:{
                        Intent intent = new Intent(parent.getContext(), ProtocolAndSay.class);//协议和说明
                        parent.getContext().startActivity(intent);
                        break;
                    }
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position, List<Object> payloads) {
        Person person = mPersonList.get(position);
        holder.personItem.setText(person.getPersonItem());
    }

    @Override
    public int getItemCount() {
        return mPersonList.size();
    }
}
