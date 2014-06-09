package com.example.commentsapp;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

//Custom Adapter 
public class CustomListAdapter extends BaseAdapter {
	 
 private ArrayList<Comment> listData;

 private LayoutInflater layoutInflater;

 public CustomListAdapter(Context context, ArrayList<Comment> listData) {
     this.listData = listData;
     layoutInflater = LayoutInflater.from(context);
 }

 @Override
 public int getCount() {
     return listData.size();
 }

 @Override
 public Object getItem(int position) {
     return listData.get(position);
 }

 @Override
 public long getItemId(int position) {
     return position;
 }

 public View getView(int position, View convertView, ViewGroup parent) {
     ViewHolder holder;
     if (convertView == null) {
         convertView = layoutInflater.inflate(R.layout.list_item_row, null);
         holder = new ViewHolder();
         holder.headlineView = (TextView) convertView.findViewById(R.id.title);
         holder.reporterNameView = (TextView) convertView.findViewById(R.id.reporter);
         holder.reportedDateView = (TextView) convertView.findViewById(R.id.date);
         convertView.setTag(holder);
     } else {
         holder = (ViewHolder) convertView.getTag();
     }

     holder.headlineView.setText(((Comment)listData.get(position)).getText());
     holder.reporterNameView.setText("By, " + ((Comment)listData.get(position)).getAuthor());
     holder.reportedDateView.setText(((Comment)listData.get(position)).getDate());

     return convertView;
 }

 static class ViewHolder {
     TextView headlineView;
     TextView reporterNameView;
     TextView reportedDateView;
 }

}
