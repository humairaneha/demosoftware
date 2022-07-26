package com.app.cardiolog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.app.cardiolog.Adapter.CardiologAdapter;
import com.app.cardiolog.Models.Cardiolog;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
  RecyclerView mRecyclerView;
  ArrayList<Cardiolog>loglist;
  MyDBHelper myDB ;
    CardiologAdapter mAdapter;
  ArrayList<String> log_id,sys,dia,bpm,date,time,comment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        mRecyclerView = findViewById(R.id.recyclerView);
        loglist = new ArrayList<>();

        myDB=new MyDBHelper(HistoryActivity.this);
        log_id=new ArrayList<>();
        sys= new ArrayList<>();
        dia=new ArrayList<>();
        date=new ArrayList<>();
        time=new ArrayList<>();
        bpm=new ArrayList<>();
        comment=new ArrayList<>();
   storeDataInArrays();

 mAdapter= new CardiologAdapter(HistoryActivity.this,log_id,sys,dia,bpm,date,time,comment);
 mRecyclerView.setAdapter(mAdapter);
 mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    public void storeDataInArrays(){

        Cursor cursor=myDB.readAllData();

        if(cursor.getCount()==0){
            Toast.makeText(this,"No data",Toast.LENGTH_SHORT).show();
        }
        else{

            while(cursor.moveToNext()){
                log_id.add(cursor.getString(0));
                sys.add(cursor.getString(1));
                dia.add(cursor.getString(2));
                bpm.add(cursor.getString(3));
                date.add(cursor.getString(4));
                time.add(cursor.getString(5));
                comment.add(cursor.getString(6));
            }


        }



    }
}