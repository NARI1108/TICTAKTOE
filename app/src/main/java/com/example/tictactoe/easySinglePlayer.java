package com.example.tictactoe;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class easySinglePlayer extends baseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_double_player);
        btn_play_again = findViewById(R.id.btn_play_again);
        result_layout = findViewById(R.id.result_layout);
        txt_player1=findViewById(R.id.txt_player1);   txt_player2=findViewById(R.id.txt_player2);
        txt_Score_1=findViewById(R.id.txt_Score_1);   txt_Score_2=findViewById(R.id.txt_Score_2);
        img_0=findViewById(R.id.img_0);  img_1=findViewById(R.id.img_1);  img_2=findViewById(R.id.img_2);
        img_3=findViewById(R.id.img_3);  img_4=findViewById(R.id.img_4);  img_5=findViewById(R.id.img_5);
        img_6=findViewById(R.id.img_6);  img_7=findViewById(R.id.img_7);  img_8=findViewById(R.id.img_8);
        txt_result = findViewById(R.id.txt_result);
        imageViews_List.add(img_0); imageViews_List.add(img_1); imageViews_List.add(img_2);
        imageViews_List.add(img_3); imageViews_List.add(img_4); imageViews_List.add(img_5);
        imageViews_List.add(img_6); imageViews_List.add(img_7); imageViews_List.add(img_8);
        playerNameDialog();
    }
    private void playerNameDialog(){
        Dialog playerNamesDialog = new Dialog(this);
        playerNamesDialog.setContentView(R.layout.player_names_dialog);
        playerNamesDialog.setCancelable(false);

        EditText edt_Player_1 = playerNamesDialog.findViewById(R.id.edt_Player_1);
        EditText edt_Player_2 = playerNamesDialog.findViewById(R.id.edt_Player_2);
        Button btn_Start_Again = playerNamesDialog.findViewById(R.id.btn_Start_Again);

        edt_Player_1.setVisibility(View.GONE);
        edt_Player_2.setHint("Your Name");

        btn_Start_Again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Player_Name_1= "Robot";
                Player_Name_2 = edt_Player_2.getText().toString().trim();

                if (Player_Name_2.equals(""))Player_Name_2="You";

                txt_player1.setText(Player_Name_1);
                txt_player2.setText(Player_Name_2);

                playerNamesDialog.dismiss();
            }
        });

        playerNamesDialog.show();
    }
}