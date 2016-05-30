package com.example.tfm;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;


public class DrawableActivity extends Activity {
	private long splashDelay = 3000; //3 segundos

	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent mainIntent = new Intent().setClass(DrawableActivity.this, PantallaInicio.class);
                startActivity(mainIntent);
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, splashDelay);//Pasado los 3 segundos dispara la tarea
    }

}
