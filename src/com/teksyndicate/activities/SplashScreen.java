package com.teksyndicate.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import com.teksyndicate.R;

public class SplashScreen extends Activity
{
    private final int SPLASH_DURATION = 3000;

    ProgressBar loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //Request to Hide Title Bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Request Full Screen
        //Only going to be used for SplashScreen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Set Content View
        setContentView(R.layout.activity_splash_screen);

        //Get progress bar
        loadingBar = (ProgressBar) findViewById(R.id.loadingBar);
        //Set Indeterminate Mode
        //Means will never stop spinning
        loadingBar.setIndeterminate(true);

        //Set Background Color to black
        loadingBar.getRootView().setBackgroundColor(getResources().getColor(android.R.color.black));

        Thread timer = new Thread()
        {
            public void run()
            {
                try
                {
                    //just sleep the thread so we dont do anything
                    //will show RTW logo
                    sleep(SPLASH_DURATION);
                }
                catch (InterruptedException e)
                {
                    //Well dont interrupt me then
                    Log.e("INTERRUPT_ERROR", e.getMessage());
                    e.printStackTrace();
                }
                finally
                {
                    //move to the MainScreen
                    Intent i = new Intent("com.teksyndicate.MAINSCREEN");
                    startActivity(i);
                }
            }
        };
        timer.start();
    }

    @Override
    public void onPause()
    {
        super.onPause();
        //Kill off the splash activity
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId())
        {
            case R.id.viewVideos:
            {
                return true;
            }
            case R.id.viewLatest:
            {
                return true;
            }
            case R.id.viewForums:
            {
                return true;
            }
            case R.id.viewSettings:
            {
                return true;
            }
            default:
            {
                return super.onOptionsItemSelected(item);
            }
        }
    }
}
