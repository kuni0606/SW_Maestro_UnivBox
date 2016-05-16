package com.project.smums;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);
	    
	    Handler handler = new Handler();
	    handler.postDelayed(new Runnable()
	    {
	    	public void run()
	    	{
	    		Intent intent = new Intent(MainActivity.this, StartActivity.class);
	    		startActivity(intent);
	    		finish();
	    	}
	    }, 2000);
	
	    // TODO Auto-generated method stub
	}

}