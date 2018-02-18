package com.example.pitalicatvzandroid.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.pitalicatvzandroid.R;
import com.example.pitalicatvzandroid.models.UserExamTaken;
import com.example.pitalicatvzandroid.remote.APIService;
import com.example.pitalicatvzandroid.remote.ApiUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Lucian on 2/12/2018.
 */

public class MenuActivity extends AppCompatActivity {

    private Button taken;
    private Button notTaken;
    private Button created;

    private ArrayList<String> uExamNames = new ArrayList<>();

    private APIService mAPIService;

    @Override
    protected void onCreate (@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        taken = (Button) findViewById(R.id.btn_taken);
        notTaken = (Button) findViewById(R.id.btn_notTaken);
        created = (Button) findViewById(R.id.btn_created);

        final Bundle bundle = getIntent().getExtras();
        String fullName = bundle.getString("fullName");
        final int id = bundle.getInt("id");

        mAPIService = ApiUtils.getAPIService();
        getUserExamsTakenByUserId(id);

        taken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent= new Intent(getBaseContext(), TakenActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);*/
                //uExamNames.clear();



                Intent intent = new Intent(getBaseContext(), TakenActivity.class);
                intent.putExtra("exam.list", uExamNames);
                startActivity(intent);
            }
        });

        notTaken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        created.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void getUserExamsTakenByUserId(int id) {

        Call<List<UserExamTaken>> call = mAPIService.getUserExamsTakenByUserId(id);

        call.enqueue(new Callback<List<UserExamTaken>>() {
            @Override
            public void onResponse(Call<List<UserExamTaken>> call, Response<List<UserExamTaken>> response) {
                try {

                    //uExamNames.clear();
                    List<UserExamTaken> exams = response.body();

                    if(exams!=null){
                        for (int i = 0; i < exams.size(); i++) {
                            String userName = exams.get(i).getUser().getFullName().toString();
                            String testName = exams.get(i).getExam().getExamTitle().toString();
                            String word = userName + ' '  + testName;
                            //showToast(word);

                            uExamNames.add(word);
                            int j =0;
                        }
                    }


                } catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<UserExamTaken>> call, Throwable t) {

            }
        });
    }

    public void showToast(String message){
        Toast.makeText(MenuActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}


