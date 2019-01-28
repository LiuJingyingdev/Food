package com.example.food;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import adapter.Good;
import adapter.GoodAdapter;
import adapter.Store;
import adapter.StoreAdapter;

public class StoreMap extends AppCompatActivity {

    private List<Good> goodList = new ArrayList<>();

    Toolbar toolbar;
    ImageView imageView;
    TextView goodPrice;

    int price = 0;

    public Context MyStore = StoreMap.this;

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

        setContentView(R.layout.activity_store_map);

        Intent intent = getIntent();
        String storeName = intent.getStringExtra("StoreName");
        int storeImageId = intent.getIntExtra("StoreImage",0);
        toolbar = (Toolbar) findViewById(R.id.tool_bar_name);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(storeName);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.jiantou1);
        }

        goodPrice = (TextView) findViewById(R.id.good_price);

       imageView = (ImageView) findViewById(R.id.store_map_image);
       Glide.with(this).load(storeImageId).into(imageView);//加载图片
        initGoodMap();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.good_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        GoodAdapter adapter = new GoodAdapter(goodList,goodPrice);
        recyclerView.setAdapter(adapter);

    }
    public void initGoodMap(){
        Good a = new Good("寿司",R.drawable.p1);
        goodList.add(a);
        Good b = new Good("番茄面包",R.drawable.p2);
        goodList.add(b);
        Good c = new Good("牛排",R.drawable.p3);
        goodList.add(c);
        Good d = new Good("鸡翅",R.drawable.p4);
        goodList.add(d);
        Good e = new Good("水果沙拉",R.drawable.p5);
        goodList.add(e);
        Good f = new Good("麻辣烫",R.drawable.p6);
        goodList.add(f);
        Good g = new Good("美味虾肉",R.drawable.p7);
        goodList.add(g);
        Good h = new Good("猪杂炒饭",R.drawable.p8);
        goodList.add(h);
        Good i = new Good("番茄寿司",R.drawable.p9);
        goodList.add(i);
        Good j = new Good("麻辣披萨",R.drawable.p10);
        goodList.add(j);
        Good k = new Good("辣肉圆盘",R.drawable.p11);
        goodList.add(k);
        Good l = new Good("可乐牛丸",R.drawable.p12);
        goodList.add(l);
        Good m = new Good("薯条牛排",R.drawable.p13);
        goodList.add(m);
        Good n = new Good("煎鱼盘菜",R.drawable.p14);
        goodList.add(n);
        Good o = new Good("可口汉堡",R.drawable.p15);
        goodList.add(o);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

}
