package com.main;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.pm.PackageManager;

public class ListTask extends ListActivity {
    /** Called when the activity is first created. */
	
	
    public void onCreate(Bundle savedInstanceState) {
    	
    	final Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
    	mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
    	         
    	final List pkgAppsList = getApplicationContext().getPackageManager().queryIntentActivities( mainIntent, 0);
    	//final List<String> names = null;
    	////
    	 final PackageManager pm = getPackageManager();
    	//get a list of installed apps.
    	       /* List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);
    	       

    	        for (ApplicationInfo packageInfo : packages) {
    	        	names.add(packageInfo.packageName.toString());
    	        	Log.i ("package name:",packageInfo.packageName.toString());
    	        	Log.i("list para" , names.get(0));
    	 //           log.d("tag", "Installed package :" + packageInfo.packageName);
    	   //         log.d("tag", "Launch Activity :" + pm.getLaunchIntentForPackage(packageInfo.packageName)); 
    	        }
    */
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        setListAdapter(new ArrayAdapter(this, 
                android.R.layout.simple_list_item_1, pkgAppsList));
       // ListActivity.setListAdapter(new ArrayAdapter<String>(this, R.id.listView1, COUNTRIES));

       /* System.out.println("Listview id " + R.id.listView1);
        ListView lv = (ListView)findViewById(R.id.listView1);
        lv.setTextFilterEnabled(true);
        lv.setAdapter(new ArrayAdapter<String>(this, R.layout.list, COUNTRIES));
        lv.setOnItemClickListener(new OnItemClickListener() {
          public void onItemClick(AdapterView<?> parent, View view,
              int position, long id) {
            // When clicked, show a toast with the TextView text
            Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
                Toast.LENGTH_SHORT).show();
          }
        });
       */
             
        final Button button = (Button) findViewById(R.id.buttonback);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
               setContentView(R.layout.main);
            	/*Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();*/
                
            }
        });
    }
}