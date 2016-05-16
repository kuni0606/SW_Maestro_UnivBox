package championship;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.project.smums.R;

public class ChampionshipIntro extends TabActivity {
	TabHost tabs;
	@Override
	 protected void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.champintrolayout);
	 
	  tabs = getTabHost();
	  tabs.getTabWidget().setStripEnabled(false);
	  TabSpec tabSpec1 = tabs.newTabSpec("소개");
	        tabSpec1.setIndicator("소개");
	        tabSpec1.setContent(new Intent(this, Champ_1.class)); // Tab Content
	        tabs.addTab(tabSpec1);
	       
	        TabSpec tabSpec2 = tabs.newTabSpec("이념");
	        tabSpec2.setIndicator("이념");
	        tabSpec2.setContent(new Intent(this, Champ_2.class)); // Tab Content
	        tabs.addTab(tabSpec2);
	        
	        TabSpec tabSpec3 = tabs.newTabSpec("상징");
	        tabSpec3.setIndicator("상징");
	        tabSpec3.setContent(new Intent(this, Champ_3.class)); // Tab Content
	        tabs.addTab(tabSpec3);
	        
	        TabSpec tabSpec4 = tabs.newTabSpec("홍보");
	        tabSpec4.setIndicator("홍보");
	        tabSpec4.setContent(new Intent(this, Champ_4.class)); // Tab Content
	        tabs.addTab(tabSpec4);
	       
	        TabSpec tabSpec5 = tabs.newTabSpec("행사");
	        tabSpec5.setIndicator("행사");
	        tabSpec5.setContent(new Intent(this, Champ_5.class)); // Tab Content
	        tabs.addTab(tabSpec5);

	        TabSpec tabSpec6 = tabs.newTabSpec("후원");
	        tabSpec6.setIndicator("후원");
	        tabSpec6.setContent(new Intent(this, Champ_6.class)); // Tab Content
	        tabs.addTab(tabSpec6);
	        tabs.setCurrentTab(0);  // ���� ���� ��ġ
	 
	        for (int i = 0; i < tabs.getTabWidget().getChildCount(); i++)
	        {
	           tabs.getTabWidget().getChildAt(i).getLayoutParams().width = (int) (60*(getResources( ).getDisplayMetrics( ).density));; 
	           tabs.getTabWidget().getChildAt(i).getLayoutParams().height=100;
	        }   
	   }
	}