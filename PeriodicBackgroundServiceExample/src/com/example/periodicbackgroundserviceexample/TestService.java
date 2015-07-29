package com.example.periodicbackgroundserviceexample;



import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class TestService extends IntentService {

	public TestService() {
		// TODO Auto-generated constructor stub
		super("Test Service");
	}

	@Override
	protected void onHandleIntent(Intent arg0) {
		// TODO Auto-generated method stub
		Log.i("Test Service","Service Running");
		int nId=12;
		
		createNotification(nId,R.drawable.ic_launcher,"Just a notification test","This is a notification");		
	}
	
	// Creating new notification 
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
