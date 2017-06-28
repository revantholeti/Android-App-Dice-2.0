package revanth.dice2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Revanth on 24-09-2016.
 */
public class jio extends Activity {
    private static int userOverallscore,userTurnscore,cpuOverallscore,cpuTurnscore;
    private static final int winscore=200;
    private static TextView tvscore,tvwinner;
    private static Button btnroll,btnreset;
    private static ImageView ivDiceFace,ivDiceFace2;
    private static int diceFaces[]={
            R.drawable.dice1,
            R.drawable.dice2,
            R.drawable.dice3,
            R.drawable.dice4,
            R.drawable.dice5,
            R.drawable.dice6
    };
    private static int diceFaces2[]={
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
        setContentView(R.layout.jio);
        tvscore = (TextView)findViewById(R.id.textView2);
        tvwinner=(TextView)findViewById(R.id.textView);
        btnroll=(Button)findViewById(R.id.button);
        btnreset=(Button)findViewById(R.id.button3);
        ivDiceFace=(ImageView)findViewById(R.id.imageView);
        ivDiceFace2=(ImageView)findViewById(R.id.imageView3);
        updateScoreLabel();
    }
    public void reset(View r)
    {
        ivDiceFace.setImageResource(diceFaces[0]);
        ivDiceFace2.setImageResource(diceFaces2[0]);
        userOverallscore=userTurnscore=cpuTurnscore=cpuOverallscore=0;
        updateScoreLabel();
        tvwinner.setText("");
        btnroll.setEnabled(true);

    }
    public static void rolldice(View o) {
        int dicevalue = random.nextInt(6) + 1;
        int dicevalue2 = random.nextInt(6) + 1;
        if ((dicevalue == 1 && dicevalue2 == 1) || (dicevalue == 6 && dicevalue2 == 6)) {
            ivDiceFace.setImageResource(diceFaces[dicevalue - 1]);
            ivDiceFace2.setImageResource(diceFaces2[dicevalue2 - 1]);
            userTurnscore += (dicevalue + dicevalue2);
            updateScoreLabel();
            btnroll.setEnabled(true);
        } else {
            ivDiceFace.setImageResource(diceFaces[dicevalue - 1]);
            ivDiceFace2.setImageResource(diceFaces2[dicevalue2 - 1]);
            userTurnscore += dicevalue + dicevalue2;
            updateScoreLabel();
            userOverallscore += userTurnscore;
            updateScoreLabel();
            if (userOverallscore > winscore) {
                btnroll.setEnabled(false);
                String s = "you won";
                tvwinner.setText(s);
                return;
            }
            cpuTurn();
        }
    }
    public static void cpuTurn()
    {
        btnroll.setEnabled(false);
        int dicevalue= random.nextInt(6) + 1;
        int dicevalue2=random.nextInt(6) +1;
        if ((dicevalue == 1 && dicevalue2 ==1)||(dicevalue==6&&dicevalue2==6))
        {
            ivDiceFace.setImageResource(diceFaces[dicevalue - 1]);
            ivDiceFace2.setImageResource(diceFaces2[dicevalue2-1]);
            cpuTurnscore+=(dicevalue+dicevalue2);
            updateScoreLabel();
            btnroll.setEnabled(false);
            cpuTurn();
        }
        else {
            ivDiceFace.setImageResource(diceFaces[dicevalue - 1]);
            ivDiceFace2.setImageResource(diceFaces2[dicevalue2 - 1]);
            cpuTurnscore += (dicevalue + dicevalue2);
            updateScoreLabel();
            cpuOverallscore += cpuTurnscore;
            updateScoreLabel();
            cpuTurnscore = 0;
            userTurnscore = 0;
            if (cpuOverallscore > winscore) {
                btnroll.setEnabled(false);
                String s = " you lost";
                tvwinner.setText(s);
                return;
            }
            btnroll.setEnabled(true);
        }
    }
    public static void updateScoreLabel(){
        String lbl_userOverscore="your overallscore: ";
        String lbl_cpuOverallscore="cpu overallscore: ";
        String lbl_cpuTurnscore="cpu trunscore: ";
        String lbl_userTrunscore="user turnscore: ";
        String overallscoreLabel=lbl_userOverscore+userOverallscore+"\n"+lbl_cpuOverallscore+cpuOverallscore+"\n";
        String TurnscoreLabel=lbl_cpuTurnscore+cpuTurnscore+"\n"+lbl_userTrunscore+userTurnscore;
        String y=overallscoreLabel+TurnscoreLabel;
        tvscore.setText(y);

    }
}
