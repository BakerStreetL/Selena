package com.example.mywork;
import android.app.Fragment;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.Window ;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    private LinearLayout mTabWeixin;
    private LinearLayout mTabFrd;
    private LinearLayout mTabContacts;
    private LinearLayout mTabSettings;

    private ImageButton mImgWeixin;
    private ImageButton mImgFrd;
    private ImageButton mImgContacts;
    private ImageButton mImgSettings;

    private Fragment mTab01 = new weixinFragment() ;
    private Fragment mTab02 = new frdFragment() ;
    private Fragment mTab03 = new contactFragment() ;
    private Fragment mTab04 = new settingFragment() ;



    private FragmentManager fm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE );
        setContentView(R.layout.activity_main);

        initView() ;
        initEvent() ;
        initFragment();
        selectfragment(0);
    }


    private void initFragment(){
        fm=getFragmentManager();
        FragmentTransaction transaction=fm.beginTransaction();
        transaction.add(R.id.id_content,mTab01);
        transaction.add(R.id.id_content,mTab02);
        transaction.add(R.id.id_content,mTab03);
        transaction.add(R.id.id_content,mTab04);
        transaction.commit();

    }

    private void initEvent(){
        mTabWeixin.setOnClickListener(this);
        mTabFrd.setOnClickListener(this);
        mTabContacts.setOnClickListener(this);
        mTabSettings.setOnClickListener(this);

    }

    private void initView(){
        mTabWeixin=(LinearLayout)findViewById(R.id.id_tab_weixin);
        mTabFrd=(LinearLayout)findViewById(R.id.id_tab_frd);
        mTabContacts=(LinearLayout)findViewById(R.id.id_tab_contact);
        mTabSettings=(LinearLayout)findViewById(R.id.id_tab_settings);

        mImgWeixin=(ImageButton)findViewById(R.id.id_tab_weixin_img );
        mImgFrd=(ImageButton)findViewById(R.id.id_tab_frd_img);
        mImgContacts=(ImageButton)findViewById(R.id.id_tab_contact_img);
        mImgSettings=(ImageButton)findViewById(R.id.id_tab_settings_img);

//        mtextWeixin=(TextView)findViewById(R.id.textView1);
    }



    private void hidefragment(FragmentTransaction transaction){
        transaction.hide(mTab01);
        transaction.hide(mTab02);
        transaction.hide(mTab03);
        transaction.hide(mTab04);

    }

    private void selectfragment(int i){
        FragmentTransaction transaction=fm.beginTransaction();
        hidefragment(transaction);
        //把图片设置为亮的
        //设置内容区域
        switch (i){

            case 0:
                Log.d("selectfragment","1");
                transaction.show(mTab01);
                mImgWeixin.setImageResource(R.drawable.image4);
                break;

            case 1:
                transaction.show(mTab02);
                mImgFrd.setImageResource(R.drawable.image7);
                break;

            case 2:
                transaction.show(mTab03);
                mImgContacts.setImageResource(R.drawable.image6);
                break;

            case 3:
                transaction.show(mTab04);
                mImgSettings.setImageResource(R.drawable.image1);
                break;

            default:
                break;
        }
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        Log.d("onClick","1");
//        resetImg() ;
        mImgWeixin.setImageResource(R.drawable.image4);
        mImgFrd.setImageResource(R.drawable.image7);
        mImgContacts.setImageResource(R.drawable.image6);
        mImgSettings.setImageResource(R.drawable.image1);
        switch(v.getId()){
            case R.id.id_tab_weixin :
                selectfragment(0);
                break;

            case R.id.id_tab_frd:
                selectfragment(1);
                break;

            case R.id.id_tab_contact:
                selectfragment(2);
                break;

            case R.id.id_tab_settings:
                selectfragment(3);
                break;

            default:
                break;
        }
    }

//    public void resetImg(){
//        mImgWeixin.setImageResource(R.drawable.image4);
//        mImgFrd.setImageResource(R.drawable.image7);
//        mImgContacts.setImageResource(R.drawable.image6);
//        mImgSettings.setImageResource(R.drawable.image1);
//
//    }
}