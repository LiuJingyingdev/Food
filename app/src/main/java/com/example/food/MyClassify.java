package com.example.food;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

import adapter.Classify;
import adapter.ClassifyAdapter;

public class MyClassify extends AppCompatActivity {

    private List<Classify> classifyList = new ArrayList<>();
    private Toolbar toolbar;

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
        setContentView(R.layout.activity_my_classify);

        Intent intent = getIntent();
        String classType = intent.getStringExtra("class_type");
        toolbar = (Toolbar) findViewById(R.id.classify_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(classType);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.jiantou1);
        }

        initClassify();



        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.classify_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ClassifyAdapter adapter = new ClassifyAdapter(classifyList);
        recyclerView.setAdapter(adapter);
    }

    private void initClassify(){
        Classify a = new Classify(R.drawable.p25,"港堡汉堡");
        classifyList.add(a);
        Classify b = new Classify(R.drawable.p24,"头号粥铺");
        classifyList.add(b);
        Classify c = new Classify(R.drawable.p23,"芝根芝底");
        classifyList.add(c);
        Classify d = new Classify(R.drawable.p22,"华莱士汉堡");
        classifyList.add(d);
        Classify e = new Classify(R.drawable.p21,"粥多点");
        classifyList.add(e);
        Classify f = new Classify(R.drawable.p20,"九毛九");
        classifyList.add(f);
        Classify g = new Classify(R.drawable.p19,"西贝面村");
        classifyList.add(g);
        Classify h = new Classify(R.drawable.p18,"香鸡王");
        classifyList.add(h);
        Classify i = new Classify(R.drawable.p17,"盒鲜骨头饭");
        classifyList.add(i);
        Classify j = new Classify(R.drawable.p16,"堕落小龙虾");
        classifyList.add(j);
        Classify k = new Classify(R.drawable.p15,"淘汰郎小火锅");
        classifyList.add(k);
        Classify l = new Classify(R.drawable.p14,"非尝不可");
        classifyList.add(l);
        Classify m = new Classify(R.drawable.p13,"合利美食");
        classifyList.add(m);
        Classify n = new Classify(R.drawable.p12,"隆江猪脚饭");
        classifyList.add(n);
        Classify o = new Classify(R.drawable.p11,"西安小吃");
        classifyList.add(o);
        Classify p = new Classify(R.drawable.p10,"好尚瘾");
        classifyList.add(p);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                finish();
                break;
            }
        }
        return true;
    }
}
