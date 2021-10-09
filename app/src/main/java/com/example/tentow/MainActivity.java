
package com.example.tentow;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import static com.example.tentow.R.id.action_bar;
import static com.example.tentow.R.id.id_content;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Fragment mtab01 = new chat_Fragment();
    private Fragment mtab02 = new friend_Fragment();
    private Fragment mtab03 = new news_Fragment();
    private Fragment mtab04 = new setting_Fragment();
    private FragmentManager fm;

    private LinearLayout mTabWeixin;
    private LinearLayout mTabFrd;
    private LinearLayout mTabAddress;
    private LinearLayout mTabSettings;

    private ImageView mImgWeixin;
    private ImageView mImgFrd;
    private ImageView mImgContact;
    private ImageView mImgSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        ActionBar action_bar=getSupportActionBar();
        if(action_bar!=null)
            action_bar.hide();/*隐藏activity头*/
        setContentView(R.layout.activity_main);
        initFragment();
        initview();
        setselect(0);
        initEvent();
    }
    private void initFragment(){
        fm =getFragmentManager();
        FragmentTransaction transaction=fm.beginTransaction();
        transaction.add(R.id.id_content,mtab01);
        transaction.add(R.id.id_content,mtab02);
        transaction.add(R.id.id_content,mtab03);
        transaction.add(R.id.id_content,mtab04);
        transaction.commit();
    }
    private void initview(){
        mTabWeixin=(LinearLayout)findViewById(R.id.lay1);
        mTabFrd=(LinearLayout)findViewById(R.id.lay2);
        mTabAddress=(LinearLayout)findViewById(R.id.lay3);
        mTabSettings=(LinearLayout)findViewById(R.id.lay4);

        mImgWeixin=(ImageView)findViewById(R.id.view1);
        mImgFrd=(ImageView)findViewById(R.id.view2);
        mImgContact=(ImageView)findViewById(R.id.view3);
        mImgSettings=(ImageView)findViewById(R.id.view4);
    }
    private void setselect(int i){
        FragmentTransaction transaction=fm.beginTransaction();
        hideFragment(transaction);
        switch (i){
            case 0:
                transaction.show(mtab01);
                mImgWeixin.setImageResource(R.drawable.chitchat);
                break;
            case 1:
                transaction.show(mtab02);
                mImgFrd.setImageResource(R.drawable.friend);
                break;
            case 2:
                transaction.show(mtab03);
                mImgContact.setImageResource(R.drawable.news);
                break;
            case 3:
                transaction.show(mtab04);
                mImgSettings.setImageResource(R.drawable.setting);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction){
        transaction.hide(mtab01);
        transaction.hide(mtab02);
        transaction.hide(mtab03);
        transaction.hide(mtab04);
    }

    @Override
    public void onClick(View view) {
        resetImgs();
        switch(view.getId())
        {
            case R.id.lay1:
                setselect(0);
                break;
            case R.id.view1:
                setselect(0);
                break;
            case R.id.lay2:
                setselect(1);
                break;
            case R.id.view2:
                setselect(1);
                break;
            case R.id.lay3:
                setselect(2);
                break;
            case R.id.view3:
                setselect(2);
                break;
            case R.id.lay4:
                setselect(3);
                break;
            case R.id.view4:
                setselect(3);
                break;
            default:
                break;
        }
    }
    private void resetImgs(){
        mImgWeixin.setImageResource(R.drawable.chitchatnormal);
        mImgFrd.setImageResource(R.drawable.friendnormal);
        mImgContact.setImageResource(R.drawable.newsnormal);
        mImgSettings.setImageResource(R.drawable.settingnormal);

    }


    private void initEvent(){
        mTabWeixin.setOnClickListener(this);
        mTabFrd.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabSettings.setOnClickListener(this);
        mImgWeixin.setOnClickListener(this);
        mImgFrd.setOnClickListener(this);
        mImgContact.setOnClickListener(this);
        mImgSettings.setOnClickListener(this);
    }
}


