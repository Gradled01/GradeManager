package com.good;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private List<User> userList = new ArrayList<>();
    TextView user ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        user = findViewById(R.id.user);
        Intent intent = getIntent();



        DataBase db = new DataBase();



        userList=(List<User>) intent.getSerializableExtra("USER_LIST");

        RecyclerView recyclerView = findViewById(R.id.ry_grades);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);  //设置方向
        recyclerView.setLayoutManager(layoutManager);
        GradeAdapter adapter = new GradeAdapter(userList);
        recyclerView.setAdapter(adapter);



    }


    class GradeAdapter extends BaseQuickAdapter<User, BaseViewHolder> {


        public GradeAdapter(@Nullable List<User> data) {
            super(R.layout.item_grade, data);
        }


        @Override
        protected void convert(BaseViewHolder baseViewHolder, final User user) {
//            TextView username = baseViewHolder.getView(R.id.username);
//            TextView normal = baseViewHolder.getView(R.id.normal);
//            TextView test = baseViewHolder.getView(R.id.test);

            Button set_grade = baseViewHolder.getView(R.id.set_grade);


            baseViewHolder.setText(R.id.total,user.getTotal());
            baseViewHolder.setText(R.id.username, user.getUsername());
            baseViewHolder.setText(R.id.normal, user.getGrade_normal());
            baseViewHolder.setText(R.id.test, user.getGrade_test());

            set_grade.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), UpdateGrade.class);

                    intent.putExtra("NAME",user.getUsername());

                    startActivity(intent);
                }
            });
        }
    }


}
