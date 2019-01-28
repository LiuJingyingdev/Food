package com.example.food;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

import adapter.Coupon;
import adapter.CouponAdapter;

//商家代金券
public class CashCoupon extends AppCompatActivity {

    private List<Coupon> couponList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
//设置修改状态栏
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//设置状态栏的颜色，和你的app主题或者标题栏颜色设置一致就ok了
            window.setStatusBarColor(getResources().getColor(R.color.gray));
        }
        setContentView(R.layout.activity_cash_coupon);

        initCoupons();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.cash_coupon_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        CouponAdapter adapter = new CouponAdapter(couponList);
        recyclerView.setAdapter(adapter);
    }

    public void initCoupons(){
        Coupon a = new Coupon(R.drawable.p1,"原味坊","8");
        couponList.add(a);
        Coupon b = new Coupon(R.drawable.p2,"大雄美食","5");
        couponList.add(b);
        Coupon c = new Coupon(R.drawable.p3,"陈生师太","10");
        couponList.add(c);
        Coupon d = new Coupon(R.drawable.p4,"非尝不可","3");
        couponList.add(d);
        Coupon e = new Coupon(R.drawable.p5,"特工厨房","2");
        couponList.add(e);
        Coupon f = new Coupon(R.drawable.p6,"先入为煮","15");
        couponList.add(f);
    }
}
