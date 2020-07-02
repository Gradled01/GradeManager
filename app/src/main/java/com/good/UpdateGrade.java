package com.good;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UpdateGrade extends AppCompatActivity implements Serializable{

    EditText grade_normal;
    EditText grade_test;
    TextView total;
    EditText rate_normal;
    Button save;
    Button calculate;
    DataBase db = new DataBase();

    List<User> user_list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_grade);
        calculate = findViewById(R.id.calculate);
        total = findViewById(R.id.total);
        grade_normal = findViewById(R.id.grade_normal);
        grade_test = findViewById(R.id.grade_test);
        rate_normal = findViewById(R.id.rate_normal);
        save = findViewById(R.id.save);
        db.getUserMap();
        Intent intent = getIntent();
        final String username = intent.getStringExtra("NAME");

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float ratio = Float.valueOf(rate_normal.getText().toString());

                int normal = Integer.valueOf(grade_normal.getText().toString());

                int test = Integer.valueOf(grade_test.getText().toString());

                total.setText(String.valueOf (normal*ratio + test*(1-ratio)));
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                User user =  db.userMap.get(username);


                user.setGrade_normal(grade_normal.getText().toString());
                user.setGrade_test(grade_test.getText().toString());
                user.setTotal(total.getText().toString());
               // System.out.println(total.getText().toString());
                db.userMap.put(username,user);

                user_list.add(db.userMap.get("小明"));
                user_list.add(db.userMap.get("小芳"));
                user_list.add(db.userMap.get("小王"));
                user_list.add(db.userMap.get("张三"));



                Toast.makeText(getApplicationContext(), "录入成功",
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(UpdateGrade.this,Main2Activity.class);

                Bundle bundle=new Bundle();
                bundle.putSerializable("USER_LIST", (Serializable) user_list);
                //bundle.putSerializable("FLAG", (Serializable) 1);
                intent.putExtras(bundle);

                startActivity(intent);

            }
        });

    }
}
