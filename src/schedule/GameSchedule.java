package schedule;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListAdapter;

import com.project.smums.R;

public class GameSchedule extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.gameschedule);
	    GridView grid = (GridView)findViewById(R.id.grid);
		GsAdapter Adapter = new GsAdapter(this);
		grid.setAdapter((ListAdapter) Adapter);
	}
}