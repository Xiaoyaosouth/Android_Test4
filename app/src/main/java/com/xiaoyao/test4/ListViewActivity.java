package com.xiaoyao.test4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import java.util.*;

public class ListViewActivity extends AppCompatActivity {
    private List<City> cityList = new ArrayList<>();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.exit:
                this.finish(); // 销毁该活动
                break;
            default:
        }
        return true;
    }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.listview_activity);
            initCities(); // 初始化城市数据
            CityAdapter adapter = new CityAdapter(this,
                    R.layout.city_item, cityList);
            ListView listView = (ListView)findViewById(R.id.mylistview);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    City city = cityList.get(position);
                    //Toast.makeText(this, city.getName(), Toast.LENGTH_SHORT).show();
                    MyToast myToast = new MyToast(ListViewActivity.this);
                    myToast.setToast(city.getName(),city.getImageId());
                    myToast.show();
                }
            });
        }

        /**
         * 给城市数组初始化
         */
    private void initCities(){
        for (int i=0; i<1; i++) {
            // 可循环多次以占满屏幕
            City beijing = new City("北京市", R.drawable.city_beijing);
            cityList.add(beijing);
            City tianjin = new City("天津市", R.drawable.city_tianjin);
            cityList.add(tianjin);
            City shanghai = new City("上海市", R.drawable.city_shanghai);
            cityList.add(shanghai);
            City chongqing = new City("重庆市", R.drawable.city_chongqing);
            cityList.add(chongqing);
            City haerbin = new City("哈尔滨市", R.drawable.city_haerbin);
            cityList.add(haerbin);
            City shijiazhuang = new City("石家庄市", R.drawable.city_shijiazhuang);
            cityList.add(shijiazhuang);
            City qinhuangdao = new City("秦皇岛市", R.drawable.city_qinhuangdao);
            cityList.add(qinhuangdao);
            City jinan = new City("济南市", R.drawable.city_jinan);
            cityList.add(jinan);
            City qingdao = new City("青岛市", R.drawable.city_qingdao);
            cityList.add(qingdao);
            City guangzhou = new City("广州市", R.drawable.city_guangzhou);
            cityList.add(guangzhou);
            City shenzhen = new City("深圳市", R.drawable.city_shenzhen);
            cityList.add(shenzhen);
        }
    }
}
