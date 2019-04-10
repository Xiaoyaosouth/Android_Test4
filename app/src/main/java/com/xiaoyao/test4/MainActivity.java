package com.xiaoyao.test4;

import android.content.*;
import android.support.v7.app.*;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button1,button2,button3,button4,button5,button6;
    private String[] cityArr = new String[]{
            "北京市","天津市","河北省",
            "山西省","内蒙古自治区","辽宁省",
            "吉林省","黑龙江省","上海市",
            "江苏省","浙江省","安徽省",
            "福建省","江西省","山东省",
            "河南省","湖北省","湖南省",
            "广东省","广西壮族自治区","海南省",
            "四川省","贵州省","云南省",
            "重庆市","西藏自治区","陕西省",
            "甘肃省","青海省","宁夏回族自治区",
            "新疆维吾尔自治区","香港特别行政区","澳门特别行政区",
            "台湾省"
    };
    private boolean[] bArr = new boolean[cityArr.length]; // 复选项初始值
    private View loginDialogView;
    private EditText editText_userName, editText_password;

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
        setContentView(R.layout.activity_main);
        initButton(); // 按钮初始化
    }

    /**
     * 按钮控件初始化
     */
    private void initButton(){
        button1 = (Button)findViewById(R.id.btn1);
        button1.setOnClickListener(this);
        button2 = (Button)findViewById(R.id.btn2);
        button2.setOnClickListener(this);
        button3 = (Button)findViewById(R.id.btn3);
        button3.setOnClickListener(this);
        button4 = (Button)findViewById(R.id.btn4);
        button4.setOnClickListener(this);
        button5 = (Button)findViewById(R.id.btn5);
        button5.setOnClickListener(this);
        button6 = (Button)findViewById(R.id.btn6);
        button6.setOnClickListener(this);
    }

    /**
     * 按钮事件处理统一管理
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:openListviewActivity();
                break;
            case R.id.btn2:textDialog();
                break;
            case R.id.btn3:simpleListDialog();
                break;
            case R.id.btn4:singleChoiceListDialog();
                break;
            case R.id.btn5:multiChoiceListDialog();
                break;
            case R.id.btn6:loginDialog();
                break;
            default:
        }
    }

    /**
     * 打开ListView和复合Toast的活动
     */
    private void openListviewActivity(){
        // 显式Intent
        Intent intent = new Intent(MainActivity.this,ListViewActivity.class);
        startActivity(intent);
    }

    /**
     * 文本对话框
     */
    private void textDialog(){
        AlertDialog.Builder dialog1 = new AlertDialog.Builder
                (MainActivity.this);
        dialog1.setTitle("文本对话框");
        dialog1.setMessage("文本");
        dialog1.setCancelable(false); // 对话框弹出后点击或按返回键不消失,默认true
        dialog1.setPositiveButton("确定",
                new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog1, int which) {
                        Toast.makeText(MainActivity.this,"你点击了确定",Toast.LENGTH_SHORT).show();
                    }
                });
        dialog1.setNegativeButton("取消",
                new  DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog1, int which) {
                        Toast.makeText(MainActivity.this,"你点击了取消",Toast.LENGTH_SHORT).show();
                    }
                });
        dialog1.show();
    }

    /**
     * 简单列表对话框
     */
    private void simpleListDialog(){
        AlertDialog.Builder dialog2 = new AlertDialog.Builder(MainActivity.this);
        dialog2.setTitle("简单列表对话框");
        dialog2.setItems(cityArr,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "你选择了："+cityArr[which], Toast.LENGTH_SHORT).show();
                    }
                });
        dialog2.create().show();
    }

    /**
     * 单选列表对话框
     */
    private void singleChoiceListDialog(){
        AlertDialog.Builder dialog3 = new AlertDialog.Builder(MainActivity.this);
        dialog3.setTitle("简单列表对话框");
        dialog3.setSingleChoiceItems(cityArr, 0,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "你选择了："+cityArr[which], Toast.LENGTH_SHORT).show();
                    }
                });
        dialog3.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "你点击了确定，关闭对话框", Toast.LENGTH_SHORT).show();
                        dialog.dismiss(); // 要调用dialog.dismiss()关闭对话框
                    }
                });
        dialog3.create().show();
    }

    /**
     * 多选列表对话框
     */
    private void multiChoiceListDialog(){
        AlertDialog.Builder dialog4 = new AlertDialog.Builder(MainActivity.this);
        dialog4.setTitle("复选列表对话框");
        Arrays.fill(bArr,false); // 给布尔数组全赋false值
        dialog4.setMultiChoiceItems(cityArr, bArr,
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        //Toast.makeText(MainActivity.this,"你选择了："+cityArr[which],Toast.LENGTH_SHORT).show();
                    }
                });
        dialog4.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                StringBuilder sb = new StringBuilder(); // 临时保存选项数据
                // 程序会根据你选择的项来改变布尔数组的值
                for (int i = 0; i < bArr.length; i++){
                    if(bArr[i]==true){
                        // 将布尔数组中值为true的下标项从城市数组取出
                        sb.append(cityArr[i]+",");
                    }
                }
                Toast.makeText(MainActivity.this, "你选择了："+sb.toString(), Toast.LENGTH_LONG).show();
                dialog.dismiss(); // 要调用dialog.dismiss()关闭对话框
            }
        });
        dialog4.create().show();
    }

    /**
     * 用户登录对话框
     */
    private void loginDialog(){
        AlertDialog.Builder dialog5 = new AlertDialog.Builder(MainActivity.this);
        // 给对话框载入自定义布局
        loginDialogView = getLayoutInflater().inflate(R.layout.dialog_login, null,false);
        dialog5.setView(loginDialogView);
        dialog5.setTitle("用户登录对话框");
        dialog5.setPositiveButton("登录", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 获取编辑框的值，注意要把当前对话框的View传进去再找id
                editText_userName = (EditText)loginDialogView.findViewById(R.id.edittext_username);
                editText_password = (EditText)loginDialogView.findViewById(R.id.edittext_password);
                String userName = editText_userName.getText().toString();
                String password = editText_password.getText().toString();
                String text = "用户名："+userName+"\r\n密码："+password;
                Toast.makeText(MainActivity.this,text,Toast.LENGTH_LONG).show();
            }
        });
        dialog5.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"您取消了登录",Toast.LENGTH_SHORT).show();
            }
        });
        dialog5.create().show();
    }
}
