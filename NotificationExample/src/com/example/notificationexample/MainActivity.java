package com.example.notificationexample;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;

public class MainActivity extends Activity {
	
	int nId ;
	String notificationMessage = "Just a notification test";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
			
		// providing unique id to the notification
		nId=12;
		
		// creating new notification
		createNotification(nId,R.drawable.ic_launcher,notificationMessage,"This is a notification");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	// utility for creating new notification
	private void createNotification(int nId, int iconRes, String title, String body) {
		
		
		// Building an intent
		Intent intent = new Intent(this, MainActivity.class);
		int requestID = (int) System.currentTimeMillis(); //unique requestID to differentiate between various notification with same NotifId
		int flags = PendingIntent.FLAG_CANCEL_CURRENT; // cancel old intent and create new one
		
		// Changing it to pending intent
		PendingIntent pIntent = PendingIntent.getActivity(this, requestID, intent, flags);
		
		// Building notification with notification builder
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
				this).setSmallIcon(iconRes)
				.setContentTitle(title)
				.setContentText(body)
				.setContentIntent(pIntent)
				.addAction(android.R.drawable.ic_delete, "Share",pIntent)
				.setAutoCancel(true);
		
		// Passing notification to notification manager
		NotificationManager mNotificationManager = 
	            (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		// mId allows you to update the notification later on.
		mNotificationManager.notify(nId, mBuilder.build());
		
		// Cancelling notification when needed
		//mNotificationManager.cancel(nId);
	}	

}
