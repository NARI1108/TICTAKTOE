package com.example.tictactoe;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class double_Player extends AppCompatActivity {
    String Player_Name_1,Player_Name_2;
    TextView txt_player1,txt_player2,txt_Score_1,txt_Score_2;
    ImageView img_0,img_1,img_2,img_3,img_4,img_5,img_6,img_7,img_8;
    int turn =1;
    int[] status = {0,0,0,0,0,0,0,0,0};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_double_player);
        txt_player1=findViewById(R.id.txt_player1);   txt_player2=findViewById(R.id.txt_player2);
        txt_Score_1=findViewById(R.id.txt_Score_1);   txt_Score_2=findViewById(R.id.txt_Score_2);
        img_0=findViewById(R.id.img_0);  img_1=findViewById(R.id.img_1);  img_2=findViewById(R.id.img_2);
        img_3=findViewById(R.id.img_3);  img_4=findViewById(R.id.img_4);  img_5=findViewById(R.id.img_5);
        img_6=findViewById(R.id.img_6);  img_7=findViewById(R.id.img_7);  img_8=findViewById(R.id.img_8);
      playerNameDialog();
    }
    private void playerNameDialog(){
        Dialog playerNamesDialog = new Dialog(this);
        playerNamesDialog.setCancelable(false);
        playerNamesDialog.setContentView(R.layout.player_names_dialog);
        EditText edt_Player_1 = playerNamesDialog.findViewById(R.id.edt_Player_1); EditText edt_Player_2 = playerNamesDialog.findViewById(R.id.edt_Player_2);
        Button btn_Start_Again = playerNamesDialog.findViewById(R.id.btn_Start_Again);
        btn_Start_Again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Player_Name_1 = edt_Player_1.getText().toString().trim();
                Player_Name_2 = edt_Player_2.getText().toString().trim();
                if(Player_Name_1.equals(""))Player_Name_1="Player 1";
                if(Player_Name_2.equals(""))Player_Name_2="Player 2";
                txt_player1.setText(Player_Name_1);
                txt_player2.setText(Player_Name_2);
                playerNamesDialog.dismiss();
            }
        });
        playerNamesDialog.show();
    }
    public void imagesClick(View view){
        int tag = Integer.parseInt((String)view.getTag());
        if(status[tag] != 0)return;
        ImageView imagesView =(ImageView) view;
        if(turn == 1) {
            imagesView.setImageResource(R.drawable.multiply);
            turn=2;
            status[tag]=1;
        }else {
            imagesView.setImageResource(R.drawable.circle);
            turn=1;
            status[tag]=2;
        }
        }
}