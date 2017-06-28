package revanth.dice2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Revanth on 25-09-2016.
 */
public class jail extends Activity {
    private static int userOverallscore,user2Overallscore;
    private static final int winscore=100;
    private static Button btnr,btnr2,btnreset1;
    private static TextView tvscore,tvwinner,tv1winner,tv1score;
    private static ImageView ivDiceFace;
    private static int diceFaces[]={
            R.drawable.dice1,
            R.drawable.dice2,
            R.drawable.dice3,
            R.drawable.dice4,
            R.drawable.dice5,
            R.drawable.dice6
    };
    private static Random random =new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jail);
        tvscore = (TextView)findViewById(R.id.textView4);
        tv1score=(TextView)findViewById(R.id.textView6);
        tvwinner=(TextView)findViewById(R.id.textView3);
        tv1winner=(TextView)findViewById(R.id.textView5);
        btnr=(Button)findViewById(R.id.button8);
        btnreset1=(Button)findViewById(R.id.button12);
        btnr2=(Button)findViewById(R.id.button10);
        ivDiceFace=(ImageView)findViewById(R.id.imageView4);
        btnr2.setEnabled(false);
        updateScoreLabel();
    }
    public void r(View z)
    {
        btnr.setEnabled(true);
        btnr2.setEnabled(false);
        int dicevalue=random.nextInt(6)+1;
        if(dicevalue==1 || dicevalue==6)
        {
            ivDiceFace.setImageResource(diceFaces[dicevalue-1]);
            userOverallscore+=dicevalue;
            btnr.setEnabled(true);
            updateScoreLabel();
        }
        else{
            ivDiceFace.setImageResource(diceFaces[dicevalue-1]);
            userOverallscore+=dicevalue;
            btnr.setEnabled(false);
            btnr2.setEnabled(true);
            updateScoreLabel();
        }
        if (userOverallscore > winscore){
            String s="1st player won";
            String b="2nd player lost";
            tvwinner.setText(s);
            tv1winner.setText(b);
            btnr.setEnabled(false);
            btnr2.setEnabled(false);
            return;
        }
    }
    public void t(View z)
    {
        int dicevalue=random.nextInt(6)+1;
        if(dicevalue==1 || dicevalue==6)
        {
            ivDiceFace.setImageResource(diceFaces[dicevalue-1]);
            user2Overallscore+=dicevalue;
            btnr2.setEnabled(true);
            updateScoreLabel();
        }
        else
        {
            ivDiceFace.setImageResource(diceFaces[dicevalue-1]);
            user2Overallscore+=dicevalue;
            btnr2.setEnabled(false);
            btnr.setEnabled(true);
            updateScoreLabel();
        }
        if (user2Overallscore > winscore){
            String s="2nd player wons";
            String b="1st player lost";
            tv1winner.setText(s);
            tvwinner.setText(b);
            btnr2.setEnabled(false);
            btnr.setEnabled(false);
            return;
        }
    }
    public void res(View z)
    {
        ivDiceFace.setImageResource(diceFaces[0]);
        userOverallscore=user2Overallscore=0;
        updateScoreLabel();
        tvwinner.setText("");
        btnr.setEnabled(true);
        btnr2.setEnabled(false);
    }
    public static void updateScoreLabel(){
        String lbl_userOverscore="1st player score: ";
        String lbl_user2Overallscore="2nd player score: ";
        String score_lbl=lbl_userOverscore+userOverallscore+"\n" +lbl_user2Overallscore+user2Overallscore;
        tvscore.setText(score_lbl);
        tv1score.setText(score_lbl);
    }

}
