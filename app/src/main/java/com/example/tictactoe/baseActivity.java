package com.example.tictactoe;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class baseActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_base);
    }
}