package com.example.pitalicatvzandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.security.keystore.UserNotAuthenticatedException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pitalicatvzandroid.R;
import com.example.pitalicatvzandroid.models.User;
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

public class TakenActivity extends AppCompatActivity {

    private APIService mAPIService;
    //private ArrayList<UserExamTaken> uExams = new ArrayList<>();
    //private ArrayList<String> uExamNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taken);

        final ListView uExamList;
        final ArrayList<String> uExamNames;
        final Bundle bundle = getIntent().getExtras();
        String fullName = bundle.getString("fullName");
        int id = bundle.getInt("id");
/*
        mAPIService = ApiUtils.getAPIService();

        getUserExamsTakenByUserId(id);
*/
        uExamNames = getIntent().getStringArrayListExtra("exam.list");


        final ArrayAdapter<String> mArrayAdapter;
        mArrayAdapter = new ArrayAdapter<>(this, R.layout.simple_list_item, uExamNames);
        uExamList = (ListView) findViewById(R.id.bExams);
        uExamList.setAdapter(mArrayAdapter);
        int i = 0;
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


                            //uExamNames.add(word);

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
        Toast.makeText(TakenActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}

