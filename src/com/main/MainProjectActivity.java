package com.main;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainProjectActivity extends Activity {
    /** Called when the activity is first created. */

    
     TextView contentTxt;
    private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver(){
      @Override
      public void onReceive(Context arg0, Intent intent) {
        // TODO Auto-generated method stub
        int level = intent.getIntExtra("level", 0);
        contentTxt.setText("Your Battery is : "+String.valueOf(level) + "%");
      }
    };
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main);
       
        contentTxt = (TextView) this.findViewById(R.id.textView1);
        this.registerReceiver(this.mBatInfoReceiver, 
        new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        
        final Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
               //setContentView(R.layout.list);
            	Intent myIntent = new Intent(getApplicationContext(), ListTask.class);
                startActivityForResult(myIntent,0);
            }
        });
    }
}