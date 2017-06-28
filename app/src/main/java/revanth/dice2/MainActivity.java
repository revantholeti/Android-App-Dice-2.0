package revanth.dice2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void play(View p) {
        Intent intent = new Intent(MainActivity.this,players.class);
        startActivity(intent);
    }
    public void exit(View v) {
        finish();
        System.exit(0);
    }
}


