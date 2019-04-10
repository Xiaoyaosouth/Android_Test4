package com.xiaoyao.test4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CityAdapter extends ArrayAdapter<City>{
    private int resourceId;
    public CityAdapter(Context context, int textViewResourceId,
                       List<City> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        City city = getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.cityImage = (ImageView)view.findViewById(R.id.city_image);
            viewHolder.cityName = (TextView)view.findViewById(R.id.city_name);
            view.setTag(viewHolder); // 将ViewHolder储存在View中
        }else{
            // 在快速滚动时提升运行效率
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.cityImage.setImageResource(city.getImageId());
        viewHolder.cityName.setText(city.getName());
        return view;
    }

    class ViewHolder{
        ImageView cityImage;
        TextView cityName;
    }
}
