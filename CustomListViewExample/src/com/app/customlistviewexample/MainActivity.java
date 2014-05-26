package com.app.customlistviewexample;

import java.util.ArrayList;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	ProgressDialog ringProgressDialog;

	  @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        
    		// Fetching list of model items
	       ArrayList<NewsItem> image_details = getListData();
	        // List view object
	        final ListView lv1 = (ListView) findViewById(R.id.custom_list);
	        // Setting custom adapter passing list of model items
	        lv1.setAdapter(new CustomListAdapter(getApplicationContext(), image_details));
	        
	   
	       
	 
	    }
	 
	    private ArrayList<NewsItem> getListData() {
	        ArrayList<NewsItem> results = new ArrayList<NewsItem>();
	        NewsItem newsData = new NewsItem();
	        newsData.setHeadline("Dance of Democracy");
	        newsData.setReporterName("Pankaj Gupta");
	        newsData.setDate("May 26, 2013, 13:35");
	        results.add(newsData);
	 
	        newsData = new NewsItem();
	        newsData.setHeadline("Major Naxal attacks in the past");
	        newsData.setReporterName("Pankaj Gupta");
	        newsData.setDate("May 26, 2013, 13:35");
	        results.add(newsData);
	 
	        newsData = new NewsItem();
	        newsData.setHeadline("BCCI suspends Gurunath pending inquiry ");
	        newsData.setReporterName("Rajiv Chandan");
	        newsData.setDate("May 26, 2013, 13:35");
	        results.add(newsData);
	 
	        newsData = new NewsItem();
	        newsData.setHeadline("Life convict can`t claim freedom after 14 yrs: SC");
	        newsData.setReporterName("Pankaj Gupta");
	        newsData.setDate("May 26, 2013, 13:35");
	        results.add(newsData);
	 
	        newsData = new NewsItem();
	        newsData.setHeadline("Indian Army refuses to share info on soldiers mutilated at LoC");
	        newsData.setReporterName("Pankaj Gupta");
	        newsData.setDate("May 26, 2013, 13:35");
	        results.add(newsData);
	 
	        newsData = new NewsItem();
	        newsData.setHeadline("French soldier stabbed; link to Woolwich attack being probed");
	        newsData.setReporterName("Sudeep Nanda");
	        newsData.setDate("May 26, 2013, 13:35");
	        results.add(newsData);
	        
	        return results;
	 
	    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

