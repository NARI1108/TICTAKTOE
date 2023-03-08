package com.example.tictactoe;

import android.app.Dialog;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;


public class double_Player extends AppCompatActivity {
    int score_1=0,score_2=0;
    RelativeLayout result_layout;
    Button btn_play_again;
    String Player_Name_1,Player_Name_2;
    TextView txt_player1,txt_player2,txt_Score_1,txt_Score_2,txt_result;
    ImageView img_0,img_1,img_2,img_3,img_4,img_5,img_6,img_7,img_8;
    int turn =PLAYER_1;
    int winner=-1;
    int [] final_win_pos;
    Boolean game_over=false;
    int[] status = {NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL};
    int[][] winner_Position={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    ArrayList<ImageView> imageViews_List =new ArrayList<>();
    MediaPlayer click_snd,win_snd;
    final static int NULL=0;
    final static int PLAYER_1=1;
    final static int PLAYER_2=2;
    final static int  NO_WINNER=3;
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
    public void imagesClick(View view) {
        int tag = Integer.parseInt((String) view.getTag());

            if (status[tag] != NULL || game_over) return;
            ImageView imagesView = (ImageView) view;
            if (turn == PLAYER_1) {
                imagesView.setImageResource(R.drawable.multiply);
                turn = PLAYER_2;
                status[tag] = PLAYER_1;
            } else {
                imagesView.setImageResource(R.drawable.circle);
                turn = PLAYER_1;
                status[tag] = PLAYER_2;

        }
        getResult();

    }
        private int checkWinner(){
            for(int [] win_pos:winner_Position){
                if (status[win_pos[0]] == status[win_pos[1]] && status[win_pos[1]] == status[win_pos[2]] && status[win_pos[0]] != NULL){
                    final_win_pos = win_pos;
                    return status[win_pos[0]];
                }
            }
            return NO_WINNER;
        }
        private void getResult(){
                winner = checkWinner();
         if(winner != NO_WINNER || isFullCells()){
             game_over=true;
             for(int i=0;i<imageViews_List.size();i++)imageViews_List.get(i).setEnabled(false);
             String res_str="";
             switch(winner){
                 case 1:res_str=Player_Name_1+" won";score_1++;break;
                 case 2:res_str=Player_Name_2+" won";score_2++;break;
                 case 3:res_str="You are equal";break;
             }
             txt_Score_1.setText(String.valueOf(score_1));
             txt_Score_2.setText(String.valueOf(score_2));
             txt_result.setText(res_str);
             result_layout.setVisibility(View.VISIBLE);
             setColorCells();
             click_snd.start();
             win_snd.start();
         }
    }

    @Override
    protected void onResume(){
        if(click_snd == null)click_snd = MediaPlayer.create(this,R.raw.click);
        if(win_snd   == null)win_snd   = MediaPlayer.create(this,R.raw.win_sound);
        super.onResume();
    }

    @Override
    protected void onPause(){
        if(click_snd != null)click_snd.release();
        if(win_snd   != null)win_snd.release();
        super.onPause();
    }
    private boolean isFullCells(){
            for (int j: status) {
                if (j == NULL) return false;
            }
         return true;
        }
        public void restGame(View view){
          if(winner == NO_WINNER) turn = PLAYER_1; else turn = winner;
            game_over=false;
            winner=-1;
          Arrays.fill(status,NULL);
          for(int i=0;i<imageViews_List.size();i++)
          { imageViews_List.get(i).setImageResource(0);
            imageViews_List.get(i).setEnabled(true);}
          result_layout.setVisibility(View.GONE);
        }
        private void setColorCells(){
        for(int i=0;i<imageViews_List.size();i++){
            if(status[i] == 1){
                imageViews_List.get(i).setImageResource(R.drawable.multiply_grey);
            }else if (status[i] == 2){
                imageViews_List.get(i).setImageResource(R.drawable.circle_grey);
            }
            if(winner == PLAYER_1){
                imageViews_List.get(final_win_pos[0]).setImageResource(R.drawable.multiply);
                imageViews_List.get(final_win_pos[1]).setImageResource(R.drawable.multiply);
                imageViews_List.get(final_win_pos[2]).setImageResource(R.drawable.multiply);
            }else if(winner == PLAYER_2){
                imageViews_List.get(final_win_pos[0]).setImageResource(R.drawable.circle);
                imageViews_List.get(final_win_pos[1]).setImageResource(R.drawable.circle);
                imageViews_List.get(final_win_pos[2]).setImageResource(R.drawable.circle);
            }
        }
        }
}