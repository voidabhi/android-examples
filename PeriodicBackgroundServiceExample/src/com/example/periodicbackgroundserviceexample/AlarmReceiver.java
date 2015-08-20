package com.example.periodicbackgroundserviceexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver {
	
	// unique request code
	public static final int REQUEST_CODE = 12345;
	public static final String ACTION = "com.codepath.example.servicesdemo.alarm";

	public AlarmReceiver() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		Intent i = new Intent(arg0,TestService.class);
		i.putExtra("foo","bar");
		arg0.startService(i);
	}
	

}
