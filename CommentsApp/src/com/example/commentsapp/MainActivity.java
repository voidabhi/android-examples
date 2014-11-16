package com.example.commentsapp;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import eu.erikw.PullToRefreshListView;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	TextView t;
	ProgressDialog p;
	PullToRefreshListView lv1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		
		
			getListData();
	        // List view object
	       
	       lv1 = (PullToRefreshListView) findViewById(R.id.listView1);
	      
	       
	        // Setting custom adapter passing list of model items
	       
	       lv1.setOnRefreshListener(new PullToRefreshListView.OnRefreshListener(){
	            @Override
	            public void onRefresh() {
	                // Your code to refresh the list contents
	                // Make sure you call listView.onRefreshComplete()
	                // once the loading is done. This can be done from here or any
	                // place such as when the network request has completed successfully.
	               getListData();
	            }
	    	   
	       });
	        
	        
	        
	
	}

	private ArrayList<Comment> getListData() {
		
		final ArrayList<Comment> comments = new ArrayList<Comment>();
		
		
        CommentClient.get("v1/comments", null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(JSONArray timeline) {
                // Pull out the first event on the public timeline
            	
                JSONObject firstEvent;
				try {
					
					for(int i=0;i<timeline.length();i++)
					{
						firstEvent = (JSONObject) timeline.get(i);
						Comment c = new Comment();
						c.setAuthor(firstEvent.getString("author"));
						c.setText(firstEvent.getString("text"));
						c.setDate(firstEvent.getString("created_at"));
						comments.add(c);
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				lv1.setAdapter(new CustomListAdapter(getApplicationContext(), comments));
				lv1.onRefreshComplete();
			
            }
            @Override
            public void onFailure(Throwable t1)
            {
            	// Updating the progressbar title on failure
            	p.setTitle(t1.getMessage());
            }            
            
        
        });		
		// TODO Auto-generated method stub
		return comments;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
