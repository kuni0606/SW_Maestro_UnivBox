package exercise;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListAdapter;

import com.project.smums.R;

public class ExerciseIntro extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.exerciseintro);
	    GridView grid = (GridView)findViewById(R.id.grid);
		ImageAdapter Adapter = new ImageAdapter(this);
		grid.setAdapter((ListAdapter) Adapter);
	}
}