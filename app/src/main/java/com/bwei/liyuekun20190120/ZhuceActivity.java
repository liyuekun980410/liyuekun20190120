package com.bwei.liyuekun20190120;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ZhuceActivity extends AppCompatActivity {

    private ImageView zhuce_image;
    private Button zhuce_btn;
    private EditText zhuce_pwd;
    private EditText qrmm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);
        zhuce_image = findViewById(R.id.zhuce_image);
        zhuce_btn = findViewById(R.id.zhuce_btn1);
        zhuce_pwd = findViewById(R.id.zhuce_pwd);
        qrmm = findViewById(R.id.qrmm);
        zhuce_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = zhuce_pwd.getText().toString();
                String s1 = qrmm.getText().toString();
                if (s==s1){
                    Toast.makeText(ZhuceActivity.this,"两次密码输入不一致",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ZhuceActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ZhuceActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
