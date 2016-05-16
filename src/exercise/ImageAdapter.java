package exercise;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

import com.project.smums.R;

public class ImageAdapter extends BaseAdapter {

	private Context mContext;
	private Activity act;
	private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21;
	int[] btn = { R.layout.btn_archery, R.layout.btn_athlete, R.layout.btn_baseball ,
				  R.layout.btn_basketball, R.layout.btn_fencing, R.layout.btn_golf ,
				  R.layout.btn_gymnastics, R.layout.btn_handball, R.layout.btn_judo ,
				  R.layout.btn_rhythm, R.layout.btn_rowing, R.layout.btn_shoot,
				  R.layout.btn_soccer, R.layout.btn_swimming, R.layout.btn_tabletennis,
				  R.layout.btn_taekwondo, R.layout.btn_tennis, R.layout.btn_volleyball,
				  R.layout.btn_waterpolo, R.layout.btn_badminton, R.layout.btn_diving};
	
	public ImageAdapter(Context c) {
		mContext = c;
		act = (ExerciseIntro)mContext;
	}

	public int getCount() {
		return 21;
	}

	public Object getItem(int position) {
		return btn[position];
	}

	public long getItemId(int position) {
		return position;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		View view;
		if (convertView == null) {
			view = LayoutInflater.from(mContext).inflate(btn[position], null);
			//view.setLayoutParams(new GridView.LayoutParams(60, 60));
			view.setPadding(0, 15, 0, 0);
		} else {
			view = (View) convertView;
		}

		if(view !=null){
			b1 = (Button)view.findViewById(R.id.button1);
			b2 = (Button)view.findViewById(R.id.button2);
			b3 = (Button)view.findViewById(R.id.button3);
			b4 = (Button)view.findViewById(R.id.button4);
			b5 = (Button)view.findViewById(R.id.button5);
			b6 = (Button)view.findViewById(R.id.button6);
			b7 = (Button)view.findViewById(R.id.button7);
			b8 = (Button)view.findViewById(R.id.button8);
			b9 = (Button)view.findViewById(R.id.button9);
			b10 = (Button)view.findViewById(R.id.button10);
			b11 = (Button)view.findViewById(R.id.button11);
			b12 = (Button)view.findViewById(R.id.button12);
			b13 = (Button)view.findViewById(R.id.button13);
			b14 = (Button)view.findViewById(R.id.button14);
			b15 = (Button)view.findViewById(R.id.button15);
			b16 = (Button)view.findViewById(R.id.button16);
			b17 = (Button)view.findViewById(R.id.button17);
			b18 = (Button)view.findViewById(R.id.button18);
			b19 = (Button)view.findViewById(R.id.button19);
			b20 = (Button)view.findViewById(R.id.button20);
			b21 = (Button)view.findViewById(R.id.button21);
			
			if(b1 !=null){
				b1.setOnClickListener(new Button.OnClickListener() {
					
					public void onClick(View v) {
		
						Intent intent1 = new Intent(mContext, Archery.class);
						intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						mContext.startActivity(intent1);
					}
				});
			}
			else if(b3 !=null){
				b3.setOnClickListener(new Button.OnClickListener(){
					
					public void onClick(View v) {
						Intent intent2 = new Intent(mContext, Athlete.class);
						intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						mContext.startActivity(intent2);
					}
				});
			}
			else if(b2 !=null){
				b2.setOnClickListener(new Button.OnClickListener(){
					
					public void onClick(View v) {
						Intent intent3 = new Intent(mContext, Badminton.class);
						intent3.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						mContext.startActivity(intent3);
					}
				});
			}
			else if(b4 !=null){
				b4.setOnClickListener(new Button.OnClickListener(){
					
					public void onClick(View v) {
						Intent intent4 = new Intent(mContext, Baseball.class);
						intent4.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						mContext.startActivity(intent4);
					}
				});
			}
			else if(b5 !=null){
				b5.setOnClickListener(new Button.OnClickListener(){
					
					public void onClick(View v) {
						Intent intent5 = new Intent(mContext, Basketball.class);
						intent5.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						mContext.startActivity(intent5);
					}
				});
			}
			else if(b6 !=null){
				b6.setOnClickListener(new Button.OnClickListener(){
					
					public void onClick(View v) {
						Intent intent6 = new Intent(mContext, Diving.class);
						intent6.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						mContext.startActivity(intent6);
					}
				});
			}
			else if(b7 !=null){
				b7.setOnClickListener(new Button.OnClickListener(){
					
					public void onClick(View v) {
						Intent intent7 = new Intent(mContext, Fencing.class);
						intent7.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						mContext.startActivity(intent7);
					}
				});
			}
			else if(b8 !=null){
				b8.setOnClickListener(new Button.OnClickListener(){
					
					public void onClick(View v) {
						Intent intent8 = new Intent(mContext, Golf.class);
						intent8.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						mContext.startActivity(intent8);
					}
				});
			}
			else if(b9 !=null){
				b9.setOnClickListener(new Button.OnClickListener(){
					
					public void onClick(View v) {
						Intent intent9 = new Intent(mContext, Gymnastics.class);
						intent9.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						mContext.startActivity(intent9);
					}
				});
			}
			else if(b10 !=null){
				b10.setOnClickListener(new Button.OnClickListener(){
					
					public void onClick(View v) {
						Intent intent10 = new Intent(mContext, Handball.class);
						intent10.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						mContext.startActivity(intent10);
					}
				});
			}
			else if(b11 !=null){
				b11.setOnClickListener(new Button.OnClickListener(){
					
					public void onClick(View v) {
						Intent intent11 = new Intent(mContext, Judo.class);
						intent11.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						mContext.startActivity(intent11);
					}
				});
			}
			else if(b12 !=null){
				b12.setOnClickListener(new Button.OnClickListener(){
					
					public void onClick(View v) {
						Intent intent12 = new Intent(mContext, Rhythm.class);
						intent12.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						mContext.startActivity(intent12);
					}
				});
			}
			else if(b13 !=null){
				b13.setOnClickListener(new Button.OnClickListener(){
					
					public void onClick(View v) {
						Intent intent13 = new Intent(mContext, Rowing.class);
						intent13.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						mContext.startActivity(intent13);
					}
				});
			}
			else if(b14 !=null){
				b14.setOnClickListener(new Button.OnClickListener(){
					
					public void onClick(View v) {
						Intent intent14 = new Intent(mContext, Shoot.class);
						intent14.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						mContext.startActivity(intent14);
					}
				});
			}
			else if(b15 !=null){
				b15.setOnClickListener(new Button.OnClickListener(){
					
					public void onClick(View v) {
						Intent intent15 = new Intent(mContext, Soccer.class);
						intent15.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						mContext.startActivity(intent15);
					}
				});
			}
			else if(b16 !=null){
				b16.setOnClickListener(new Button.OnClickListener(){
					
					public void onClick(View v) {
						Intent intent16 = new Intent(mContext, Swimming.class);
						intent16.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						mContext.startActivity(intent16);
					}
				});
			}
			else if(b17 !=null){
				b17.setOnClickListener(new Button.OnClickListener(){
					
					public void onClick(View v) {
						Intent intent17 = new Intent(mContext, Tabletennis.class);
						intent17.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						mContext.startActivity(intent17);
					}
				});
			}
			else if(b18 !=null){
				b18.setOnClickListener(new Button.OnClickListener(){
					
					public void onClick(View v) {
						Intent intent18 = new Intent(mContext, Taekwondo.class);
						intent18.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						mContext.startActivity(intent18);
					}
				});
			}
			else if(b19 !=null){
				b19.setOnClickListener(new Button.OnClickListener(){
					
					public void onClick(View v) {
						Intent intent19 = new Intent(mContext, Tennis.class);
						intent19.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						mContext.startActivity(intent19);
					}
				});
			}
			else if(b20 !=null){
				b20.setOnClickListener(new Button.OnClickListener(){
					
					public void onClick(View v) {
						Intent intent20 = new Intent(mContext, Volleyball.class);
						intent20.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						mContext.startActivity(intent20);
					}
				});
			}
			else if(b21 !=null){
				b21.setOnClickListener(new Button.OnClickListener(){
					
					public void onClick(View v) {
						Intent intent21 = new Intent(mContext, Waterpolo.class);
						intent21.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						mContext.startActivity(intent21);
					}
				});
			}
		}
		return view;
	}
}