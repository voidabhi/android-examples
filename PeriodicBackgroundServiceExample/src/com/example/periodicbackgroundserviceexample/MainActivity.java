package com.example.periodicbackgroundserviceexample;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		scheduleAlarm();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;   
	}
	
	public void scheduleAlarm() {
		// Construct an intent that will execute the AlarmReceiver
		Intent intent = new Intent(getApplicationContext(), AlarmReceiver.class);
		// Create a PendingIntent to be triggered when the alarm goes off
		final PendingIntent pIntent = PendingIntent.getBroadcast(this, AlarmReceiver.REQUEST_CODE,
				intent, PendingIntent.FLAG_UPDATE_CURRENT);
		// Setup periodic alarm every 5 seconds
		long firstMillis = System.currentTimeMillis(); // first run of alarm is immediate
		int intervalMillis = 5000; // 5 seconds
		AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
		alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, firstMillis, intervalMillis, pIntent);
	}
	
	// creates new notification from passed information
	private void createNotification(int nId, int iconRes, String title, String body) {
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
				this).setSmallIcon(iconRes)
				.setContentTitle(title)
				.setContentText(body);
		// getting notification manager from system
		NotificationManager mNotificationManager = 
	            (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		// mId allows you to update the notification later on.
		mNotificationManager.notify(nId, mBuilder.build());
	}	

}
