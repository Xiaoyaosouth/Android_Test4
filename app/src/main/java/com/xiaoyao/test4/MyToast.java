package com.xiaoyao.test4;

import android.content.Context;
import android.view.*;
import android.widget.*;

public class MyToast {
    private Toast myToast;
    private View myView;
    private ImageView imageView;
    private TextView textView;

    public MyToast(Context context) {
        myToast = new Toast(context);
        // 载入布局
        myView = LayoutInflater.from(context).inflate(R.layout.toast_view, null);
        // 为toast两个控件指定id
        imageView = (ImageView)myView.findViewById(R.id.toast_image);
        textView = (TextView)myView.findViewById(R.id.toast_text);
    }

    /**
     * 设置toast
     * @param text 要显示的文本
     * @param imageId 要显示的图片
     * @return
     */
    public MyToast setToast(String text, int imageId){
        myToast.setView(myView);
        this.textView.setText(text);
        this.imageView.setImageResource(imageId);
        //this.myToast.setGravity(gravity, 0, 0);
        this.myToast.setDuration(Toast.LENGTH_SHORT);
        return this;
    }

    /**
     * 显示toast
     * @return
     */
    public void show(){
        this.myToast.show();
    }
}
