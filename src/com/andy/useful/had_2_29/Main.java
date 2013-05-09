package com.andy.useful.had_2_29;    //˵������com.andy.useful.had_2_29������

import android.app.Activity;      //���밲׿��N����
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("unused")   //ѹ�ƾ���
public class Main extends Activity {   //�����Main
    @Override   //��дActivity��onCreate()����
    public void onCreate(Bundle savedInstanceState) {    //onCreate()����
        super.onCreate(savedInstanceState);   //����Activity��onCreate����
        setContentView(R.layout.main);   //��ʾ����
        Button Listener_for_button = (Button) findViewById(R.id.button1);   //��������
        final TextView tv = (TextView) findViewById(R.id.scope);
        final TextView tve = (TextView) findViewById(R.id.sc_eng);
        final TextView tvf = (TextView) findViewById(R.id.sc_fanti);
        final EditText user_input = (EditText) findViewById(R.id.Year);
        Listener_for_button.setOnClickListener(new OnClickListener(){    //�¼�������

			@Override   //ʵ��OnClickListener�ӿ�
			public void onClick(View arg0) {   //�ӿڵķ���
				
				if(user_input.getText().toString().length() == 0){
					tv.setText("��ݲ���Ϊ�գ�");
					tve.setText("Year cannot be empty!");
					tvf.setText("��ݲ��ܞ�գ�");
					return;
				}   //��������ַ�������
				
				if(user_input.getText().toString().length() != 4){
					tv.setText("���ֻ��Ϊ��λ��");
					tve.setText("Only to four-digit years!");
					tvf.setText("���ֻ�ܞ���λ��");
					return;
				}   //������Ƿ��ַ�������
				
				int tmp = Integer.parseInt(user_input.getText().toString());	    //��ȡ����		
				int temp2 = Integer.parseInt(user_input.getText().toString().substring(2));
				int temp3 = Integer.parseInt(user_input.getText().toString().substring(3));
				
				if(temp2 == 0 && temp3 == 0){   //�������
					int ys = tmp % 400;   //����
					if(ys == 0){   //������
						tv.setText("�����꣬����400����");   //����  �ǵ�
						tve.setText("Is a leap year, and 400 in addition to");
						tvf.setText("���c�꣬���c400���M");
					}
					else{
						tv.setText("�������꣬������400����");   //����  ����
						tve.setText("Is not a leap year, not 400 in addition to");
						tvf.setText("�����c�꣬�����c400���M");
					}
				}
				else{   //��������
					int ys = tmp % 4;  //����
					if(ys == 0){   //������
						tv.setText("�����꣬����4����");     //����  �ǵ�
						tve.setText("Is a leap year, and 4 in addition to");
						tvf.setText("���c�꣬���c4���M");
					}
					else{
						tv.setText("�������꣬������4����");     //����  ����
						tve.setText("Is not a leap year, not 4 in addition to");
						tvf.setText("�����c�꣬�����c4���M");
					}
				}
			}
        	
        });
        
    }
    @Override
    protected void onDestroy(){   //��дonDestroy
    	super.onDestroy();
    }
}