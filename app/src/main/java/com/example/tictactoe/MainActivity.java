package com.example.tictactoe;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String Player_Name_1,Player_Name_2;
    TextView txt_player_1,txt_player_2;

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
    private void levelDialog(){
        Dialog   levelNamesDialog  = new Dialog(this);
        levelNamesDialog.setCancelable(false);
        levelNamesDialog.setContentView(R.layout.player_names_dialog);
        EditText edt_Player_1 = levelNamesDialog.findViewById(R.id.edt_Player_1);  EditText edt_Player_2 = levelNamesDialog.findViewById(R.id.edt_Player_2);
        Button btn_Start_Again = levelNamesDialog.findViewById(R.id.btn_Start_Again);
        btn_Start_Again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Player_Name_1 = edt_Player_1.getText().toString().trim();
                Player_Name_2 = edt_Player_2.getText().toString().trim();
                if(Player_Name_1.equals("")) Player_Name_1="Player 1";
                if(Player_Name_2.equals("")) Player_Name_2="Player 2";
                txt_player_1.setText(Player_Name_1);
                txt_player_2.setText(Player_Name_2);
                levelNamesDialog.dismiss();
            }
        });
        levelNamesDialog.show();
    }

}