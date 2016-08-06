package com.peng.duobao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.peng.duobao.fragment.Discover_Fragment;
import com.peng.duobao.fragment.Doubao_Fragment;
import com.peng.duobao.fragment.List_Fragment;
import com.peng.duobao.fragment.Me_Fragment;

public class MainActivity extends AppCompatActivity {
    private FrameLayout mainFragment;
    private FrameLayout bottomFragment;
    private RadioGroup mainRg;
    private RadioButton mainDb;
    private RadioButton mainFx;
    private RadioButton mainQd;
    private RadioButton mainMe;
    //四个fragment页面
    private Doubao_Fragment duobaofragment;
    private Discover_Fragment discoverFragment;
    private List_Fragment listFragment;
    private Me_Fragment meFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragment = (FrameLayout) findViewById(R.id.main_fragment);
        bottomFragment = (FrameLayout) findViewById(R.id.bottom_fragment);

        inintView();


    }
     //页面底部四个按钮的点击 显示不同的fragment
    private void inintView() {
        //底部四个按钮 夺宝 发现 清单 我的
        mainDb = (RadioButton) findViewById(R.id.main_db);
        mainFx = (RadioButton) findViewById(R.id.main_fx);
        mainQd = (RadioButton) findViewById(R.id.main_qd);
        mainMe = (RadioButton) findViewById(R.id.main_me);

        duobaofragment = new Doubao_Fragment();
        getFragmentManager().beginTransaction().replace(R.id.main_fragment, duobaofragment).commit();

        //RadioGroup的点击事件 分别打开不同的fragment
        mainRg = (RadioGroup) findViewById(R.id.main_rg);
        mainRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                //获取fragment的管理者
                android.app.FragmentManager fragmentManager = getFragmentManager();
                //开启事物
                android.app.FragmentTransaction beginTrasaction = fragmentManager.beginTransaction();

                switch (checkedId) {
                    case R.id.main_db:
                        if (duobaofragment == null) {
                            duobaofragment = new Doubao_Fragment();
                            beginTrasaction.add(R.id.main_fragment, duobaofragment);
                        }
                        if (discoverFragment != null)
                            beginTrasaction.hide(discoverFragment);
                        if (listFragment != null)
                            beginTrasaction.hide(listFragment);
                        if (meFragment != null)
                            beginTrasaction.hide(meFragment);
                        beginTrasaction.show(duobaofragment);
                        beginTrasaction.commit();

                        //beginTrasaction.replace(R.id.main_fragment, new Doubao_Fragment());

                        break;
                    case R.id.main_fx:
                        if (discoverFragment == null) {
                            discoverFragment = new Discover_Fragment();
                            beginTrasaction.add(R.id.main_fragment, discoverFragment);
                        }
                        if (duobaofragment != null)
                            beginTrasaction.hide(duobaofragment);
                        if (listFragment != null)
                            beginTrasaction.hide(listFragment);
                        if (meFragment != null)
                            beginTrasaction.hide(meFragment);
                        beginTrasaction.show(discoverFragment);
                        beginTrasaction.commit();

                        //beginTrasaction.replace(R.id.main_fragment, new Discover_Fragment());

                        break;
                    case R.id.main_qd:
                        if (listFragment == null) {
                            listFragment = new List_Fragment();
                            beginTrasaction.add(R.id.main_fragment, listFragment);
                        }
                        if (duobaofragment != null)
                            beginTrasaction.hide(duobaofragment);
                        if (discoverFragment != null)
                            beginTrasaction.hide(discoverFragment);
                        if (meFragment != null)
                            beginTrasaction.hide(meFragment);
                        beginTrasaction.show(listFragment);
                        beginTrasaction.commit();

                        //beginTrasaction.replace(R.id.main_fragment, new List_Fragment());
                        break;
                    case R.id.main_me:

                        if (meFragment == null) {
                            meFragment = new Me_Fragment();
                            beginTrasaction.add(R.id.main_fragment, meFragment);
                        }
                        if (duobaofragment != null)
                            beginTrasaction.hide(duobaofragment);
                        if (listFragment != null)
                            beginTrasaction.hide(listFragment);
                        if (discoverFragment != null)
                            beginTrasaction.hide(discoverFragment);
                        beginTrasaction.show(meFragment);
                        beginTrasaction.commit();
                        //beginTrasaction.replace(R.id.main_fragment, new Me_Fragment());
                        break;
                    default:
                        break;
                }
                //beginTrasaction.commit();
            }
        });
    }

}
