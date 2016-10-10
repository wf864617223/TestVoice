package com.rf.hp.bottomlayout;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationBar bottomNavigationBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_layout);
        //Values:MODE_DEFAULT, MODE_FIXED, MODE_SHIFTING
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        //BACKGROUND_STYLE_DEFAULT,BACKGROUND_STYLE_STATIC, BACKGROUND_STYLE_RIPPLE
        bottomNavigationBar
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_DEFAULT
                );
        BadgeItem numberBadgeItem = new BadgeItem()
                .setBorderWidth(4)
                .setBackgroundColor(Color.RED)
                .setText("");
        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.tab_find_focus,"first").setActiveColorResource(R.color.colorPrimaryDark).setBadgeItem(numberBadgeItem))
                .addItem(new BottomNavigationItem(R.mipmap.tab_home_focus,"second").setActiveColorResource(R.color.colorPrimary).setBadgeItem(numberBadgeItem))
                .addItem(new BottomNavigationItem(R.mipmap.tab_mine_focus,"third").setActiveColorResource(R.color.colorAccent).setBadgeItem(numberBadgeItem))
                .addItem(new BottomNavigationItem(R.mipmap.tab_shop_focus,"last").setActiveColorResource(R.color.black).setBadgeItem(numberBadgeItem))
                .initialise();

        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            //开启事务
            @Override
            public void onTabSelected(int position) {
                switch (position){
                    case 0:
                        Toast.makeText(MainActivity.this, "first", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "second", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "third", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this, "last", Toast.LENGTH_SHORT).show();
                        break;
                }

            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });

    }
}
