package revanth.dice2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Revanth on 25-09-2016.
 */
public class players extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.players);
    }
    public void sp(View v)
    {
        Intent intent=new Intent(players.this,jio.class);
        startActivity(intent);
    }
    public void p(View v)
    {
        Intent intent=new Intent(players.this,jail.class);
        startActivity(intent);
    }
}
