package com.example.carolsusieo.jobsearch;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public class EnterDataActivity extends AppCompatActivity {
  //  private Button _storeBtn;
  ApplicationData applicationData;
  TinyDB tinydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_data);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button _storeBtn = (Button) findViewById(R.id.buttonStoreData);
        applicationData = new ApplicationData();
         tinydb = new com.example.carolsusieo.jobsearch.TinyDB(getApplicationContext());
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        _storeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeData();
            }
        });
    }
    private String getItem(int in) {
        EditText item = (EditText) findViewById(in);
        return  item.getText().toString();
    }
    // get any already entered and in the tinyDB
    private void getData() {

        ArrayList<Object> objArray = tinydb.getListObject("ApplicationData", AppDataStruct.class);

        for(Object obj: objArray)
        {
            AppDataStruct in = (AppDataStruct) obj;
            applicationData.storeData(in);
        }
    }

    private AppData storeData() {
        AppData input = new AppData();
        String fld_company_name = getItem(R.id.editTextCompanyName);
        if (fld_company_name.trim().length() == 0 || fld_company_name.contentEquals(getString(R.string.empty)))
            return null;
        else {
             CheckBox intermediate = (CheckBox) findViewById(R.id.checkBoxIntermediate);
            boolean fld_intermediate = intermediate.isChecked();
            input.setCompanyName(fld_company_name);
            input.setFollowupDate(getItem(R.id.editTextDateFollowup));
            input.setInitialDate(getItem(R.id.editTextDateInitial));
            input.setIntermediate(fld_intermediate);
            applicationData.storeData(input.getData());

            ArrayList<AppDataStruct> arrayListData =  applicationData.getAppArray();
            ArrayList<Object> array = new ArrayList<Object>();
            for(AppDataStruct item: arrayListData)
                array.add(item);
            tinydb.putListObject("ApplicationData", array);
        }
        return input;
    }

 }
