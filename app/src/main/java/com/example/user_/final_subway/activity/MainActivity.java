package com.example.user_.final_subway.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import com.example.user_.final_subway.R;
import com.example.user_.final_subway.fragments.OneFragment;
import com.example.user_.final_subway.fragments.TwoFragment;
import com.example.user_.final_subway.fragments.ThreeFragment;
import com.example.user_.final_subway.fragments.FourFragment;
import com.example.user_.final_subway.fragments.FiveFragment;
import com.example.user_.final_subway.fragments.SixFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.ic_tab_favourite,
            R.drawable.ic_tab_call,
            R.drawable.ic_tab_contacts
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 액션바의 역할로 '툴바' 를 사용하겠다
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);      //액션바 작동 속성 지정

        // 뷰페이져를 사용하겠다
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);                                  //setupViewPager() 메소드는 존재하지 않으므로 아래에서 별도로 정의하게됨

        // 뷰페이져에 따른 탭레이아웃을 사용하겠다
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        // 액션버튼이 선언되어있다(디스플레이 테마 설정시 기본값 :: 변경 가능)
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    // 위에서 만들기로 했던 setupViewPager() 메소드를 정의한다.
    // 단, 어댑터(그 중에서도 뷰페이져어댑터)를 사용하게 되므로 이 역시 아래에서 별도로 정의하기로 한다.
    // 참고로, 어댑터는 class 다.
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(), "");
        adapter.addFragment(new TwoFragment(), "TWO");
        adapter.addFragment(new ThreeFragment(), "THREE");
        //adapter.addFragment(new FourFragment(), "FOUR");
        //adapter.addFragment(new FiveFragment(), "FIVE");
        //adapter.addFragment(new SixFragment(), "SIX");
        viewPager.setAdapter(adapter);
    }

    // 바로 위에서 만들기로 했던 어댑터를 바로 아래에 붙여 만들었다.
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    // onCreateOptionsMenu 는 프로젝트 테마 설정시 (여기서는 blank_activity) 기본값
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // onOptionsItemSelected 는 프로젝트 테마 설정시 (여기서는 blank_activity) 기본값
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
