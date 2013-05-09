package com.andy.useful.had_2_29;    //说明我是com.andy.useful.had_2_29包的类

import android.app.Activity;      //引入安卓的N个类
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("unused")   //压制警告
public class Main extends Activity {   //活动程序Main
    @Override   //重写Activity的onCreate()方法
    public void onCreate(Bundle savedInstanceState) {    //onCreate()方法
        super.onCreate(savedInstanceState);   //调用Activity的onCreate方法
        setContentView(R.layout.main);   //显示窗体
        Button Listener_for_button = (Button) findViewById(R.id.button1);   //对象引用
        final TextView tv = (TextView) findViewById(R.id.scope);
        final TextView tve = (TextView) findViewById(R.id.sc_eng);
        final TextView tvf = (TextView) findViewById(R.id.sc_fanti);
        final EditText user_input = (EditText) findViewById(R.id.Year);
        Listener_for_button.setOnClickListener(new OnClickListener(){    //事件监听器

			@Override   //实现OnClickListener接口
			public void onClick(View arg0) {   //接口的方法
				
				if(user_input.getText().toString().length() == 0){
					tv.setText("年份不能为空！");
					tve.setText("Year cannot be empty!");
					tvf.setText("年份不能為空！");
					return;
				}   //避免因空字符而出错
				
				if(user_input.getText().toString().length() != 4){
					tv.setText("年份只能为四位！");
					tve.setText("Only to four-digit years!");
					tvf.setText("年份只能為四位！");
					return;
				}   //避免因非法字符而出错
				
				int tmp = Integer.parseInt(user_input.getText().toString());	    //获取内容		
				int temp2 = Integer.parseInt(user_input.getText().toString().substring(2));
				int temp3 = Integer.parseInt(user_input.getText().toString().substring(3));
				
				if(temp2 == 0 && temp3 == 0){   //检查整百
					int ys = tmp % 400;   //求余
					if(ys == 0){   //除尽了
						tv.setText("是闰年，能与400除尽");   //反馈  是的
						tve.setText("Is a leap year, and 400 in addition to");
						tvf.setText("是閏年，能與400除盡");
					}
					else{
						tv.setText("不是闰年，不能与400除尽");   //反馈  不是
						tve.setText("Is not a leap year, not 400 in addition to");
						tvf.setText("不是閏年，不能與400除盡");
					}
				}
				else{   //不是整百
					int ys = tmp % 4;  //求余
					if(ys == 0){   //除尽了
						tv.setText("是闰年，能与4除尽");     //反馈  是的
						tve.setText("Is a leap year, and 4 in addition to");
						tvf.setText("是閏年，能與4除盡");
					}
					else{
						tv.setText("不是闰年，不能与4除尽");     //反馈  不是
						tve.setText("Is not a leap year, not 4 in addition to");
						tvf.setText("不是閏年，不能與4除盡");
					}
				}
			}
        	
        });
        
    }
    @Override
    protected void onDestroy(){   //重写onDestroy
    	super.onDestroy();
    }
}