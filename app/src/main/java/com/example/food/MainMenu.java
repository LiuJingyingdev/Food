package com.example.food;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;

import adapter.OderAdapter;
import adapter.Order;
import adapter.Person;
import adapter.PersonAdapter;
import adapter.Store;
import adapter.StoreAdapter;
import fragment.CarFragment;
import fragment.MenuFragment;
import fragment.PersonFragment;

//主菜单
public class MainMenu extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {


    private MenuFragment menuFragment;
    private CarFragment carFragment;
    private PersonFragment personFragment;
    private FragmentManager fragmentManager;


    private List<Store> storeList = new ArrayList<>();//首页商店的列表
    private List<Order> OrderList = new ArrayList<>();//订单列表
    private List<Person> personList = new ArrayList<>();//个人中心的列表

    RadioButton menu_Button;
    RadioButton car_Button;
    RadioButton person_Button;

    private Boolean a, b, c;
    private Boolean first;

    private RadioGroup chooseGroup;//单选按钮组，用来获取单选按钮响应事件
    private RadioButton defaultButton;//默认单选按钮


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

        setContentView(R.layout.activity_main_menu);
        a = false;//首页碎片状态
        b = false;//订单碎片状态
        c = false;//个人中心碎片状态
        //初始化列表
        initSore();
        initOrder();
        iniPerson();


        menu_Button = (RadioButton) findViewById(R.id.radio_button1);
        car_Button = (RadioButton) findViewById(R.id.radio_button2);
        person_Button = (RadioButton) findViewById(R.id.radio_button3);
        changeImageSize(menu_Button, car_Button, person_Button);//改变底部单选按钮的大小


        chooseGroup = (RadioGroup) findViewById(R.id.choose_group);
        chooseGroup.setOnCheckedChangeListener(this);



        first = false;//判断事务是否第一次进行
        fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction myfragmentTransaction = fragmentManager.beginTransaction();
        if (menuFragment == null) {
            menuFragment = new MenuFragment();
            myfragmentTransaction.add(R.id.frame_layout, menuFragment);
        }
        if (carFragment == null) {
            carFragment = new CarFragment();
            myfragmentTransaction.add(R.id.frame_layout, carFragment);
        }
        if (personFragment == null) {
            personFragment = new PersonFragment();
            myfragmentTransaction.add(R.id.frame_layout, personFragment);
        }
        if (!first) {
            myfragmentTransaction.hide(carFragment);
            myfragmentTransaction.hide(personFragment);
            myfragmentTransaction.show(menuFragment);
            myfragmentTransaction.commit();
        }

       // menu_Button.setChecked(true);
        //让首页默认选中
        //defaultButton = (RadioButton) findViewById(R.id.radio_button1);


        //用来判断碎片的状态，是实例化了，还是空值


    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.radio_button1: {
                Select(1);
                break;
            }
            case R.id.radio_button2: {
                Select(2);
                break;
            }
            case R.id.radio_button3: {
                Select(3);
                break;
            }
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton1: {
                Intent intent = new Intent(MainMenu.this, MyClassify.class);
                intent.putExtra("class_type", "美食");
                startActivity(intent);
                break;
            }
            case R.id.imageButton2: {
                Intent intent = new Intent(MainMenu.this, MyClassify.class);
                intent.putExtra("class_type", "超市");
                startActivity(intent);
                break;
            }
            case R.id.imageButton3: {
                Intent intent = new Intent(MainMenu.this, MyClassify.class);
                intent.putExtra("class_type", "生鲜");
                startActivity(intent);
                break;
            }
            case R.id.imageButton4: {
                Intent intent = new Intent(MainMenu.this, MyClassify.class);
                intent.putExtra("class_type", "专送");
                startActivity(intent);
                break;
            }
            case R.id.imageButton5: {
                Intent intent = new Intent(MainMenu.this, MyClassify.class);
                intent.putExtra("class_type", "代购");
                startActivity(intent);
                break;
            }
            case R.id.imageButton6: {
                Intent intent = new Intent(MainMenu.this, MyClassify.class);
                intent.putExtra("class_type", "午餐");
                startActivity(intent);
                break;
            }
            case R.id.imageButton7: {
                Intent intent = new Intent(MainMenu.this, MyClassify.class);
                intent.putExtra("class_type", "甜品");
                startActivity(intent);
                break;
            }
            case R.id.imageButton8: {
                Intent intent = new Intent(MainMenu.this, MyClassify.class);
                intent.putExtra("class_type", "家常");
                startActivity(intent);
                break;
            }
            case R.id.imageButton9: {
                Intent intent = new Intent(MainMenu.this, MyClassify.class);
                intent.putExtra("class_type", "小吃");
                startActivity(intent);
                break;
            }
            case R.id.imageButton10: {
                Intent intent = new Intent(MainMenu.this, MyClassify.class);
                intent.putExtra("class_type", "快餐");
                startActivity(intent);
                break;
            }
            default:
                break;
        }
    }

    private void Select(int i) {
//        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
//        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        initFragment(fragmentTransaction);
        if (i == 1) {
            //用recyclerView陈列商店列表
            if (menuFragment == null) {
                menuFragment = new MenuFragment();
                fragmentTransaction.add(R.id.frame_layout, menuFragment);
                Log.d("TAG1", "加法减法就爱看放假啊垃圾分类卡机了开发");
            } else {
                if (!a) {

                    Log.d("TAG2", "奥卡福捡垃圾反垃圾发了简历发借记卡");
                    RecyclerView recyclerView1 = (RecyclerView) findViewById(R.id.recycler_view);
                    LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);
                    layoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
                    recyclerView1.setLayoutManager(layoutManager1);
                    //recyclerView1.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
                    StoreAdapter adapter1 = new StoreAdapter(storeList);
                    recyclerView1.setAdapter(adapter1);
                    //处理recyclerview和scrollview滑动冲突
                    recyclerView1.setHasFixedSize(true);
                    recyclerView1.setNestedScrollingEnabled(false);

                    a = true;
                }

                Log.d("TAG3", "；类分类法放假啊洛夫克拉夫垃圾卡进了房间all结案率会计分录");


                //图片按钮
                ImageButton imageButton1;
                ImageButton imageButton2;
                ImageButton imageButton3;
                ImageButton imageButton4;
                ImageButton imageButton5;
                ImageButton imageButton6;
                ImageButton imageButton7;
                ImageButton imageButton8;
                ImageButton imageButton9;
                ImageButton imageButton10;

//                //首页显示的情况下，再获取首页中的控件
//                android.support.v4.app.FragmentManager manager;
//                MenuFragment fragment;
//
//                //下面是处理首页的ImagaButton的点击事件
//                /*获取manager*/
//                manager = this.getSupportFragmentManager();
//        /*通过findFragmentById获取Fragment*/
//                fragment = (MenuFragment) manager.findFragmentById(R.id.frame_layout);
//        /*通过fragment.getView()获取视图，然后在获取fragment中的button*/
                imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
                imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
                imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
                imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
                imageButton5 = (ImageButton) findViewById(R.id.imageButton5);
                imageButton6 = (ImageButton) findViewById(R.id.imageButton6);
                imageButton7 = (ImageButton) findViewById(R.id.imageButton7);
                imageButton8 = (ImageButton) findViewById(R.id.imageButton8);
                imageButton9 = (ImageButton) findViewById(R.id.imageButton9);
                imageButton10 = (ImageButton) findViewById(R.id.imageButton10);
                imageButton1.setOnClickListener(this);
                imageButton2.setOnClickListener(this);
                imageButton3.setOnClickListener(this);
                imageButton4.setOnClickListener(this);
                imageButton5.setOnClickListener(this);
                imageButton6.setOnClickListener(this);
                imageButton7.setOnClickListener(this);
                imageButton8.setOnClickListener(this);
                imageButton9.setOnClickListener(this);
                imageButton10.setOnClickListener(this);


                fragmentTransaction.show(menuFragment);//显示首页碎片


            }

        }
        if (i == 2) {
            if (carFragment == null) {
                carFragment = new CarFragment();
                fragmentTransaction.add(R.id.frame_layout, carFragment);
            } else {
                if (!b) {

                    RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.order_recylerview);
                    LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
                    recyclerView2.setLayoutManager(layoutManager2);
                    OderAdapter adapter2 = new OderAdapter(OrderList);
                    recyclerView2.setAdapter(adapter2);
                    b = true;
                }
                fragmentTransaction.show(carFragment);//显示订单碎片
            }


        }
        if (i == 3) {
            if (personFragment == null) {
                personFragment = new PersonFragment();
                fragmentTransaction.add(R.id.frame_layout, personFragment);
            } else {
                if (!c) {
                    RecyclerView recyclerView3 = (RecyclerView) findViewById(R.id.person_recyclerview);
                    LinearLayoutManager layoutManager3 = new LinearLayoutManager(this);
                    recyclerView3.setLayoutManager(layoutManager3);
                    PersonAdapter adapter3 = new PersonAdapter(personList);
                    recyclerView3.setAdapter(adapter3);
                    c = true;
                }
                fragmentTransaction.show(personFragment);//显示个人中心碎片
            }
        }
        fragmentTransaction.commit();//碎片提交事物
    }

    public void initFragment(android.support.v4.app.FragmentTransaction fragmentTransaction) {//初始化碎片
        if (menuFragment != null) {
            fragmentTransaction.hide(menuFragment);
        }
        if (carFragment != null) {
            fragmentTransaction.hide(carFragment);
        }
        if (personFragment != null) {
            fragmentTransaction.hide(personFragment);
        }
    }

    private void initSore() {
        Store a = new Store("原味坊", R.drawable.p1);
        storeList.add(a);
        Store b = new Store("大雄美食（玫瑰园店）", R.drawable.p2);
        storeList.add(b);
        Store c = new Store("陈生陈太", R.drawable.p3);
        storeList.add(c);
        Store d = new Store("非尝不可", R.drawable.p4);
        storeList.add(d);
        Store e = new Store("特工厨房", R.drawable.p5);
        storeList.add(e);
        Store f = new Store("先入为煮", R.drawable.p6);
        storeList.add(f);
        Store g = new Store("蜀园川菜馆", R.drawable.p7);
        storeList.add(g);
        Store h = new Store("私家屋", R.drawable.p8);
        storeList.add(h);
        Store i = new Store("Q堡堡", R.drawable.p9);
        storeList.add(i);
        Store j = new Store("沙县小吃", R.drawable.p10);
        storeList.add(j);
        Store k = new Store("德乐士（玫瑰园店）", R.drawable.p11);
        storeList.add(k);
        Store l = new Store("陈记关东煮", R.drawable.p12);
        storeList.add(l);
        Store m = new Store("正兴鸡扒", R.drawable.p13);
        storeList.add(m);
        Store n = new Store("叫了只炸鸡", R.drawable.p14);
        storeList.add(n);
        Store o = new Store("味食先", R.drawable.p15);
        storeList.add(o);
    }

    private void initOrder() {
        Order a = new Order("原味坊", R.drawable.p1);
        OrderList.add(a);
        Order b = new Order("大雄美食（玫瑰园店）", R.drawable.p2);
        OrderList.add(b);
        Order c = new Order("陈生陈太", R.drawable.p3);
        OrderList.add(c);
        Order d = new Order("非尝不可", R.drawable.p4);
        OrderList.add(d);
        Order e = new Order("特工厨房", R.drawable.p5);
        OrderList.add(e);
        Order f = new Order("先入为煮", R.drawable.p6);
        OrderList.add(f);
        Order g = new Order("蜀园川菜馆", R.drawable.p7);
        OrderList.add(g);
        Order h = new Order("私家屋", R.drawable.p8);
        OrderList.add(h);
        Order i = new Order("Q堡堡", R.drawable.p9);
        OrderList.add(i);
        Order j = new Order("沙县小吃", R.drawable.p10);
        OrderList.add(j);
        Order k = new Order("德乐士（玫瑰园店）", R.drawable.p11);
        OrderList.add(k);
        Order l = new Order("陈记关东煮", R.drawable.p12);
        OrderList.add(l);
        Order m = new Order("正兴鸡扒", R.drawable.p13);
        OrderList.add(m);
        Order n = new Order("叫了只炸鸡", R.drawable.p14);
        OrderList.add(n);
        Order o = new Order("味食先", R.drawable.p15);
        OrderList.add(o);
    }

    private void iniPerson() {
        Person a = new Person("巴哥红包");
        personList.add(a);
        Person b = new Person("商家代金券");
        personList.add(b);
        Person c = new Person("我的地址");
        personList.add(c);
        Person d = new Person("邀请有奖");
        personList.add(d);
        Person e = new Person("客服中心");
        personList.add(e);
        Person f = new Person("帮助和反馈");
        personList.add(f);
        Person g = new Person("协议和说明");
        personList.add(g);
    }


    private void changeImageSize(RadioButton menu_Button, RadioButton car_Button, RadioButton person_Button) {


        //定义底部标签图片大小
        Drawable drawableFirst = getResources().getDrawable(R.drawable.menu);
        drawableFirst.setBounds(0, 0, 69, 69);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        menu_Button.setCompoundDrawables(null, drawableFirst, null, null);//只放上面

        Drawable drawableSearch = getResources().getDrawable(R.drawable.car);
        drawableSearch.setBounds(0, 0, 69, 69);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        car_Button.setCompoundDrawables(null, drawableSearch, null, null);//只放上面

        Drawable drawableMe = getResources().getDrawable(R.drawable.person);
        drawableMe.setBounds(0, 0, 69, 69);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        person_Button.setCompoundDrawables(null, drawableMe, null, null);//只放上面
    }


}
