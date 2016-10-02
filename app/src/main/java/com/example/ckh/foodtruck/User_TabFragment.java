package com.example.ckh.foodtruck;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import com.example.ckh.cstview.UserTruckListviewAdapter;

/**
 * Created by Ckh on 2016-09-25.
 */
public class User_TabFragment extends AppCompatActivity {
    FragmentInflater fi1;
    FragmentInflater fi2;
    private ListView trucklist = null;
    private UserTruckListviewAdapter Adapter =null;
    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_fragment);

        ViewPager viewPager = (ViewPager) findViewById(R.id.user_viewpager);
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());

        fi1 = new FragmentInflater();
        fi1.setresId(R.layout.user_tab1_list);
        adapter.addFragment(fi1,"리스트");
        fi2 = new FragmentInflater();
        fi2.setresId(R.layout.user_tab2_map);
        adapter.addFragment(fi2,"지도");

        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.user_tabs);
        tabLayout.setupWithViewPager(viewPager);

        /*ListView trucklist = (ListView) findViewById(R.id.User_Truck_List);
        Adapter = new UserTruckListviewAdapter(getApplicationContext());
        trucklist.setAdapter(Adapter);

        Adapter.addItem(getResources().getDrawable(R.drawable.cvt_truckimg,null),
                "고기식당",
                "호주산 스테이크",
                "위치");
        Adapter.addItem(getResources().getDrawable(R.drawable.cvt_truck2img,null),
                "통통브리또",
                "맛있는 브리또",
                "위치");*/
    }

    public void onClick_truckdetail(View view) {
        Intent intent = new Intent(User_TabFragment.this,User_TruckDetail.class);
        startActivity(intent);
    }
}
