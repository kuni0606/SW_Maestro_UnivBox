package exercise;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.project.smums.R;

public class Volleyball_3 extends Activity{
	ArrayList<MyItem19> arItem;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.list1);
		
		arItem = new ArrayList<MyItem19>();
		MyItem19 mi;
		mi = new MyItem19(R.drawable.yeomjugym120,"염주 종합체육관", "주소 : 광주광역시 서구 금화로 278 구민생활관");arItem.add(mi);
		mi = new MyItem19(R.drawable.honamunivgym120,"호남대학교 체육관", "주소 : 광주광역시 광산구 어등대로 417");arItem.add(mi);
		mi = new MyItem19(R.drawable.najudongsinunivgym120,"나주 동신대 체육관", "주소 : 전라남도 나주시 건재로 185");arItem.add(mi);
		mi = new MyItem19(R.drawable.soonchungym120,"순천 팔마체육관", "주소 : 전남 순천시 팔마로 333");arItem.add(mi);
		mi = new MyItem19(R.drawable.gochanggym120,"고창군립체육관", "주소 : 고창군 고창읍 운동장길 36");arItem.add(mi);
		
		MyListAdapter19 MyAdapter = new MyListAdapter19(this, R.layout.stadium ,arItem);
		
		ListView MyList;
		MyList = (ListView)findViewById(R.id.listView1);
		MyList.setAdapter(MyAdapter);
	}
}

class MyItem19
{
	MyItem19(int aImage, String aName, String aNick)
	{
		Image=aImage;
		Name=aName;
		Nick=aNick;
	}
	int Image;
	String Name;
	String Nick;
}

class MyListAdapter19 extends BaseAdapter
{
	Context maincon;
	LayoutInflater Inflater;
	ArrayList<MyItem19> arSrc;
	int layout;
	
	public MyListAdapter19(Context context, int alayout, ArrayList<MyItem19> aarSrc)
	{
		maincon = context;
		Inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		arSrc = aarSrc;
		layout = alayout;
	}
	public int getCount()
	{
		return arSrc.size();
	}
	public String getItem(int position)
	{
		return arSrc.get(position).Name;
	}
	public long getItemId(int position)
	{
		return position;
	}
	
	public View getView(final int position, View convertView, ViewGroup parent)
	{
		//final int pos = position;
		if(convertView == null)
		{
			convertView = Inflater.inflate(layout, parent, false);
		}
		ImageView iv1 = (ImageView)convertView.findViewById(R.id.imageView1);
		iv1.setImageResource(arSrc.get(position).Image);
		
		TextView txt1 = (TextView)convertView.findViewById(R.id.textView1);
		txt1.setText(arSrc.get(position).Name);
		
		TextView txt2 = (TextView)convertView.findViewById(R.id.textView2);
		txt2.setText(arSrc.get(position).Nick);		

		ImageButton btn = (ImageButton)convertView.findViewById(R.id.ImageButton1);
		btn.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v){
				if(arSrc.get(position).Name == "염주 종합체육관")
				{
					Intent intent = new Intent(maincon, chosununivgym.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					maincon.startActivity(intent);
				}
				if(arSrc.get(position).Name == "호남대학교 체육관")
				{
					Intent intent = new Intent(maincon, honamunivgym.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					maincon.startActivity(intent);
				}
				if(arSrc.get(position).Name == "나주 동신대 체육관")
				{
					Intent intent = new Intent(maincon, najudongsinunivgym.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					maincon.startActivity(intent);
				}
				if(arSrc.get(position).Name == "순천 팔마체육관")
				{
					Intent intent = new Intent(maincon, soonchungym.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					maincon.startActivity(intent);
				}
				if(arSrc.get(position).Name == "고창군립체육관")
				{
					Intent intent = new Intent(maincon, gochanggym.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					maincon.startActivity(intent);
				}
			}
		});
		return convertView;
	}
}