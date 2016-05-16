package com.project.smums;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import anim.CloseAnimation;
import anim.ExpandAnimation;

public class StartActivity extends Activity {

	DBAdapter mdb;
	SQLiteDatabase db;
	private DisplayMetrics metrics;
	private LinearLayout slidingPanel;
	private LinearLayout leftMenuPanel;
	private FrameLayout.LayoutParams slidingPanelParameters;
	private FrameLayout.LayoutParams leftMenuPanelParameters;
	private int panelWidth;
	private static boolean isLeftExpanded;
	private Button bt_left, b1, b2, b3, b4;

	private Backpress backPressCloseHandler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.startlayout);

		metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		panelWidth = (int) ((metrics.widthPixels) * 0.75);
		
		bt_left = (Button) findViewById(R.id.bt_left);

		b1 = (Button) findViewById(R.id.start1);
		b2 = (Button) findViewById(R.id.start2);
		b3 = (Button) findViewById(R.id.start3);
		b4 = (Button) findViewById(R.id.start4);
		
		slidingPanel = (LinearLayout) findViewById(R.id.slidingPanel);
		slidingPanelParameters = (FrameLayout.LayoutParams) slidingPanel
				.getLayoutParams();
		slidingPanelParameters.width = metrics.widthPixels;
		slidingPanel.setLayoutParams(slidingPanelParameters);

		// left slide menu initialize
		leftMenuPanel = (LinearLayout) findViewById(R.id.leftMenuPanel);
		leftMenuPanelParameters = (FrameLayout.LayoutParams) leftMenuPanel
				.getLayoutParams();
		leftMenuPanelParameters.width = panelWidth;
		leftMenuPanel.setLayoutParams(leftMenuPanelParameters);

		initialize(getApplicationContext());

		ArrayList<String> arr = new ArrayList<String>();
		long aa = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(aa);
		String gg = sdf.format(cal.getTime());
		System.out.println("date:" + gg);

		mdb = new DBAdapter(this);
		db = mdb.getWritableDatabase();

		
		 try { SQLiteDatabase db = openOrCreateDatabase("schedule.db",
		 Context.MODE_PRIVATE, null);
		 
		 Cursor c = db.rawQuery("SELECT game FROM schedule WHERE date ='" + gg
		 + "';", null); c.moveToFirst(); c.getCount();
		 
		 for (int i = 0; i < c.getCount(); i++) { arr.add(c.getString(0));
		 c.moveToNext();
		 
		 ListView list = (ListView) findViewById(R.id.listview2); final
		 ArrayAdapter<String> aaa = new ArrayAdapter<String>(this,
		 android.R.layout.simple_list_item_1, arr); list.setAdapter(aaa); } }
		 catch (Exception e) { Log.i("_)", "" + e.toString()); }

		backPressCloseHandler = new Backpress(this);

		/*
		 * Cursor c = db.rawQuery("SELECT game FROM schedule WHERE date ='" + gg
		 * + "';", null); c.moveToFirst(); c.getCount();
		 */

	}

	public static final String PACKAGE_DIR = "/data/data/com.project.smums/";
	public static final String DATABASE_NAME = "schedule.db";
	public static final String COPY2DATABASE_NAME = "schedule2.db";

	public static void initialize(Context ctx) {
		File folder = new File(PACKAGE_DIR + "databases");
		folder.mkdirs();
		File outfile = new File(PACKAGE_DIR + "databases/" + COPY2DATABASE_NAME);

		if (outfile.length() <= 0) {
			AssetManager assetManager = ctx.getResources().getAssets();
			try {
				InputStream is = assetManager.open(DATABASE_NAME,
						AssetManager.ACCESS_BUFFER);
				long filesize = is.available();
				byte[] tempdata = new byte[(int) filesize];
				is.read(tempdata);
				is.close();
				outfile.createNewFile();
				FileOutputStream fo = new FileOutputStream(outfile);
				fo.write(tempdata);
				fo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	void menuLeftSlideAnimationToggle() {

		if (!isLeftExpanded) {

			// networkRequestTimeLineGetNewCnt();

			isLeftExpanded = true;
			leftMenuPanel.setVisibility(View.VISIBLE);

			// Expand
			new ExpandAnimation(slidingPanel, panelWidth, "left",
					Animation.RELATIVE_TO_SELF, 0.0f,
					Animation.RELATIVE_TO_SELF, 0.75f, 0, 0.0f, 0, 0.0f);

			// disable all of main view
			// LinearLayout viewGroup = (LinearLayout) findViewById(
			FrameLayout viewGroup = (FrameLayout) findViewById(R.id.ll_fragment)
					.getParent();
			enableDisableViewGroup(viewGroup, false);

			// enable empty view
			((LinearLayout) findViewById(R.id.ll_empty))
					.setVisibility(View.VISIBLE);

			findViewById(R.id.ll_empty).setEnabled(true);
			findViewById(R.id.ll_empty).setOnTouchListener(
					new OnTouchListener() {

						@Override
						public boolean onTouch(View arg0, MotionEvent arg1) {
							menuLeftSlideAnimationToggle();
							return true;
						}
					});

		} else {
			isLeftExpanded = false;

			// Collapse
			new CloseAnimation(slidingPanel, panelWidth,
					TranslateAnimation.RELATIVE_TO_SELF, 0.75f,
					TranslateAnimation.RELATIVE_TO_SELF, 0.0f, 0, 0.0f, 0, 0.0f);

			// enable all of main view
			// LinearLayout viewGroup = (LinearLayout) findViewById(
			FrameLayout viewGroup = (FrameLayout) findViewById(R.id.ll_fragment)
					.getParent();
			enableDisableViewGroup(viewGroup, true);

			// disable empty view
			((LinearLayout) findViewById(R.id.ll_empty))
					.setVisibility(View.GONE);
			findViewById(R.id.ll_empty).setEnabled(false);

		}
	}

	public static void enableDisableViewGroup(ViewGroup viewGroup,
			boolean enabled) {
		int childCount = viewGroup.getChildCount();
		for (int i = 0; i < childCount; i++) {
			View view = viewGroup.getChildAt(i);

			if (view.getId() != R.id.bt_left) {
				view.setEnabled(enabled);
				if (view instanceof ViewGroup) {
					enableDisableViewGroup((ViewGroup) view, enabled);
				}
			}
		}
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_left:
			menuLeftSlideAnimationToggle();
			break;
		case R.id.start1:
			Intent intent1 = new Intent(StartActivity.this,
					championship.ChampionshipIntro.class);
			startActivity(intent1);

			break;
		case R.id.start2:
			Intent intent2 = new Intent(StartActivity.this,
					exercise.ExerciseIntro.class);
			startActivity(intent2);

			break;
		case R.id.start3:
			Intent intent3 = new Intent(StartActivity.this,
					schedule.GameSchedule.class);
			startActivity(intent3);

			break;
		case R.id.start4:
			Intent intent4 = new Intent(StartActivity.this,
					player.PlayerIntro.class);
			startActivity(intent4);

			break;
		default:
			break;
		}
	}

	@Override
	public void onBackPressed() {
		// super.onBackPressed();
		backPressCloseHandler.onBackPressed();
	}
}