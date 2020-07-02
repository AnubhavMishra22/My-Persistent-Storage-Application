package com.example.mypersistentstorageapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private EditText editName;
    private EditText editAddress;
    private EditText editPhone;
    private EditText editEmail;

    private RadioGroup rdgFavouritePartOfDay;
    private RadioButton rdgMorning;
    private RadioButton rdgAfternoon;
    private RadioButton rdgEvening;
    private RadioButton rdgNight;

    public static final String MYPREFS = "mySharedPrefences";
    private String favouritePartOfDay;
    //private  RadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = (EditText)findViewById(R.id.editName);
        editAddress = (EditText)findViewById(R.id.editAddress);
        editPhone = (EditText)findViewById(R.id.editPhone);
        editEmail = (EditText)findViewById(R.id.editEmail);

        rdgMorning = (RadioButton)findViewById(R.id.rdbMorning);
        rdgAfternoon = (RadioButton)findViewById(R.id.rdbAfternoon);
        rdgEvening = (RadioButton)findViewById(R.id.rdbEvening);
        rdgNight = (RadioButton)findViewById(R.id.rdbNight);

        this.loadPreferences();

    }

    public  void loadPreferences(){
        int mode = Activity.MODE_PRIVATE;
        android.content.SharedPreferences mySharedPreferences = getSharedPreferences(MYPREFS,mode);
        editName.setText(mySharedPreferences.getString(key: "name",defValue""));
        editAddress.setText(mySharedPreferences.getString(key: "address",defValue""));
        editPhone.setText(mySharedPreferences.getString(key: "phone",defValue""));
        editEmail.setText(mySharedPreferences.getString(key: "email",defValue""));

        favouritePartOfDay = mySharedPreferences.getString(key: "favouritePartOfDay", defValue "m");

        loadradioButtonpreference();


    }

    public void loadradioButtonpreference(){
        if(favouritePartOfDay.equals("m")){
            rdgFavouritePartOfDay.check(R.id.rdbMorning);
        }
        else if(favouritePartOfDay.equals("a")){
            rdgFavouritePartOfDay.check(R.id.rdbAfternoon);
        }
        else if(favouritePartOfDay.equals("e")){
            rdgFavouritePartOfDay.check(R.id.rdbEvening);
        }
        else if(favouritePartOfDay.equals("n")){
            rdgFavouritePartOfDay.check(R.id.rdbNight);
        }
        else{
            rdgFavouritePartOfDay.check(R.id.rdbMorning);
        }

    }

    public void onClick(){
        if(rdbMorning.isChecked()) {
            favouritePartOfDay = "m";
        }
        else if(rdbAfternoon.isChecked()){
            favouritePartOfDay="a";
        }
        else if(rdgEvening.isChecked()){
            favouritePartOfDay="e";
        }
        else if(rdgNight.isChecked()){
            favouritePartOfDay="n";
        }
        else {
            favouritePartOfDay="";
        }

    }

    protected void savedPreferences(){
        int mode = Activity.MODE_PRIVATE;
        android.content.SharedPreferences mySharedPreferences = getSharedPreferences(MYPREFS,mode);
        android.content.SharedPreferences.Editor editor = mySharedPrefernces.edit();
        editor.putString("name",editname.getText().toString());
        editor.putString("address",editAddress.getText().toString());
        editor.putString("phone",editPhone.getText().toString());
        editor.putString("email",editEmail.getText().toString());
        editor.putString("favouritePartOfDay",favouritePartOfDay);
        editor.commit();
    }

    protected void onStop(){
        super.onStop();
        this.savedPreferences();
    }

    public boolean onCreateOptionsMenu(Menu menu){
        //inflate the menu. this adds item to the action bar if present
        getMenuInflater().inflate(R.menu.menu_shared_preferences_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}