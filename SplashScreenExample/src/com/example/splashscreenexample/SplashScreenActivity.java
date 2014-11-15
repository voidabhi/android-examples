package com.example.splashscreenexample;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
 
public class SplashScreenActivity extends Activity {
 
 // activity holding time in milliseonds
  private static final int SPLASH_SHOW_TIME = 1000;
 
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash_screen);
 
    // Callling execute function of AsyncTask
    new BackgroundSplashTask().execute();
 
  }
 
  /**
   * Async Task: can be used to load DB, images during which the splash screen
   * is shown to user
   */
  private class BackgroundSplashTask extends AsyncTask<Void, Void, Void> {
 
    @Override
    protected void onPreExecute() {
      super.onPreExecute();
    }
 
    @Override
    protected Void doInBackground(Void... arg0) {
 
      // I have just given a sleep for this thread
      // if you want to load database, make
      // network calls, load images
      // you can do them here and remove the following
      // sleep
 
      // do not worry about this Thread.sleep
      // this is an async task, it will not disrupt the UI
      try {
        // Holding Activity thread 
        Thread.sleep(SPLASH_SHOW_TIME);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
 
      return null;
    }
 
    @Override
    protected void onPostExecute(Void result) {
      super.onPostExecute(result);
      Intent i = new Intent(SplashScreenActivity.this,
          MainActivity.class);
      // any info loaded can during splash_show
      // can be passed to main activity using
      // below
      i.putExtra("loaded_info", " ");
      startActivity(i);
      finish();
    }
 
  }
}
