package player;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import com.project.smums.R;

public class PlayerIntro extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.playerintro);
	
	    WebView view1 = (WebView)findViewById(R.id.webView1);
	    view1.getSettings().setJavaScriptEnabled(true);
	    view1.loadUrl("http://www.gwangju2015.kr/?cat=80&u_news_list=1");
	    
	    // TODO Auto-generated method stub
	}

}
