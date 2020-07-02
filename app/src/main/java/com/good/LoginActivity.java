package com.good;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private EditText edt_account ;
    private EditText edt_password;
    List<User> user_list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final String teacher_account = "008";
        final String teacher_password= "008";

        DataBase db = new DataBase();
        db.getUserMap();
        user_list =  db.getUser_list();

        edt_account = findViewById(R.id.et_tel);
        edt_password = findViewById(R.id.et_pass);


        TextView tv_login = findViewById(R.id.tv_login);





       // System.out.println(account);
        tv_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //System.out.println(account);
                if(edt_account.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "请输入账号密码",
                            Toast.LENGTH_SHORT).show();
                }else{
                    for(User user : user_list){


                        if(edt_account.getText().toString().equals(teacher_account) && edt_password.getText().toString().equals(teacher_password)){
                            Intent intent =new Intent(LoginActivity.this,MainActivity.class);

                            startActivity(intent);
                        }else if(user.getAccount().equals( edt_account.getText().toString()) && user.getPassword().equals(edt_password.getText().toString())  ){
                            System.out.println(user.getUsername()+"  "+user.getPassword());

                            if(user.getType().equals("captain")){
                                Intent intent =new Intent(LoginActivity.this,CaptainActivity.class);
                                startActivity(intent);
                            }else{
                                Intent intent =new Intent(LoginActivity.this,StudentActivity.class);
                                intent.putExtra("USERNAME",user.getUsername());
                                intent.putExtra("NORMAL",user.getGrade_normal());
                                intent.putExtra("TEST",user.getGrade_test());
                                intent.putExtra("TOTAL",user.getTotal());
                                startActivity(intent);
                            }

                            return;
                        }else{
                            Toast.makeText(getApplicationContext(), "账号或者密码错误",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                }
            }
        });

    }

}
