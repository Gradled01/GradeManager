package com.good;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class StudentActivity extends AppCompatActivity {
    TextView username ;
    TextView normal;
    TextView test;
    TextView total;
    private List<User> userList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        username = findViewById(R.id.username);
        normal = findViewById(R.id.normal);
        test = findViewById(R.id.test);
        total = findViewById(R.id.total);

        Intent intent = getIntent();
        String user = intent.getStringExtra("USERNAME");
        String nor = intent.getStringExtra("NORMAL");
        String te = intent.getStringExtra("TEST");
        String to = intent.getStringExtra("TEST");
        username.setText(user);
        normal.setText(nor);
        test.setText(te);
        total.setText(to);


    }
}
