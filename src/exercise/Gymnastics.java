package exercise;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.project.smums.R;


public class Gymnastics extends TabActivity {
TabHost tabs;
@Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.gymnasticslayout);
 
  tabs = getTabHost();
  tabs.getTabWidget().setStripEnabled(false);
  TabSpec tabSpec1 = tabs.newTabSpec("종목");
  tabSpec1.setIndicator("종목");
  tabSpec1.setContent(new Intent(this, Gymnastics_1.class)); // Tab Content
  tabs.addTab(tabSpec1);
 
  TabSpec tabSpec2 = tabs.newTabSpec("선수");
  tabSpec2.setIndicator("선수");
  tabSpec2.setContent(new Intent(this, Gymnastics_2.class)); // Tab Content
  tabs.addTab(tabSpec2);
 
  // Tab3 Setting
  TabSpec tabSpec3 = tabs.newTabSpec("경기장");
  tabSpec3.setIndicator("경기장");
  tabSpec3.setContent(new Intent(this, Gymnastics_3.class)); // Tab Content
  tabs.addTab(tabSpec3);
  tabs.setCurrentTab(0);  // ���� ���� ��ġ
 
 
        for (int i = 0; i < tabs.getTabWidget().getChildCount(); i++)
        {
        	tabs.getTabWidget().getChildAt(i).getLayoutParams().width = (int) (60*(getResources( ).getDisplayMetrics( ).density));; 
        	tabs.getTabWidget().getChildAt(i).getLayoutParams().height=70;
        }   
	}
}