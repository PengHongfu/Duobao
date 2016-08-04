package com.peng.duobao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private FrameLayout mainFragment;
    private FrameLayout bottomFragment;
    private RadioGroup mainRg;
    private RadioButton mainDb;
    private RadioButton mainFx;
    private RadioButton mainQd;
    private RadioButton mainMe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragment = (FrameLayout) findViewById(R.id.main_fragment);
        bottomFragment = (FrameLayout) findViewById(R.id.bottom_fragment);

        mainRg = (RadioGroup) findViewById(R.id.main_rg);
        //底部四个按钮 夺宝 发现 清单 我的
        mainDb = (RadioButton) findViewById(R.id.main_db);
        mainFx = (RadioButton) findViewById(R.id.main_fx);
        mainQd = (RadioButton) findViewById(R.id.main_qd);
        mainMe = (RadioButton) findViewById(R.id.main_me);

        mainRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                //获取fragment的管理者
                android.app.FragmentManager fragmentManager  = getFragmentManager();
                //开启事物
                android.app.FragmentTransaction beginTrasaction = fragmentManager.beginTransaction();

                switch (checkedId){
                    case R.id.main_db:
                        beginTrasaction.replace(R.id.main_fragment,new Doubao_Fragment());
                    break;
                    case R.id.main_fx:
                        beginTrasaction.replace(R.id.main_fragment,new Discover_Fragment());
                        break;
                    case R.id.main_qd:
                        beginTrasaction.replace(R.id.main_fragment,new List_Fragment());
                        break;
                    case R.id.main_me:
                        beginTrasaction.replace(R.id.main_fragment,new Me_Fragment());
                        break;
                }
                beginTrasaction.commit();

            }
        });
    }

}
