package com.example.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void  btn_Click(View view){
        int id =view.getId();
        switch(id){
            case R.id.btn_Single_Player:startActivity(new Intent(MainActivity.this,single_Player.class));
            break;
            case R.id.btn_Double_Player:startActivity(new Intent(MainActivity.this,double_Player.class));
            break;
            case R.id.btn_Contact_us:startActivity(new Intent(MainActivity.this,Contact_Us.class));
            break;
            case R.id.btn_Game_Guide:startActivity(new Intent(MainActivity.this,Game_Guide.class));
            break;
        }
    }
}