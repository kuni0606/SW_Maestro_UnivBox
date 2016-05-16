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

public class Soccer_3 extends Activity{
	ArrayList<MyItem14> arItem;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.list1);
		
		arItem = new ArrayList<MyItem14>();
		MyItem14 mi;
		mi = new MyItem14(R.drawable.honamunivfootball120,"호남대학교 축구장", "주소 : 광주광역시 광산구 어등대로 417");arItem.add(mi);
		mi = new MyItem14(R.drawable.najuground120,"나주 공설 운동장", "주소 : 전라남도 나주시 영산강변로 99");arItem.add(mi);
		mi = new MyItem14(R.drawable.younggwangfootball120,"영광 스포티움 축구장", "주소 : 전라남도 영광군 영광읍 월현로 170");arItem.add(mi);
		mi = new MyItem14(R.drawable.mokpofootball120,"목포 국제 축구센터", "주소 : 전라남도 목포시 내화마을길 89");arItem.add(mi);
		mi = new MyItem14(R.drawable.bosungground120,"보성공설운동장", "주소 : 전라남도 보성군 보성읍 용문길 18");arItem.add(mi);
		mi = new MyItem14(R.drawable.jungeupground120,"정읍공설운동장", "주소 : 전라북도 정읍시 서부산업도로 138-5");arItem.add(mi);
		mi = new MyItem14(R.drawable.gochangground120,"고창공설운동장", "주소 : 전라북도 고창군 고창읍 운동장길 36");arItem.add(mi);
		
		MyListAdapter14 MyAdapter = new MyListAdapter14(this, R.layout.stadium ,arItem);
		
		ListView MyList;
		MyList = (ListView)findViewById(R.id.listView1);
		MyList.setAdapter(MyAdapter);
	}
}

class MyItem14
{
	MyItem14(int aImage, String aName, String aNick)
	{
		Image=aImage;
		Name=aName;
		Nick=aNick;
	}
	int Image;
	String Name;
	String Nick;
}

class MyListAdapter14 extends BaseAdapter
{
	Context maincon;
	LayoutInflater Inflater;
	ArrayList<MyItem14> arSrc;
	int layout;
	
	public MyListAdapter14(Context context, int alayout, ArrayList<MyItem14> aarSrc)
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
				if(arSrc.get(position).Name == "호남대학교 축구장")
				{
					Intent intent = new Intent(maincon, honamunivfootball.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					maincon.startActivity(intent);
				}
				else if(arSrc.get(position).Name == "나주 공설 운동장")
				{
					Intent intent = new Intent(maincon, najuground.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					maincon.startActivity(intent);
				}
				else if(arSrc.get(position).Name == "영광 스포티움 축구장")
				{
					Intent intent = new Intent(maincon, younggwangfootball.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					maincon.startActivity(intent);
				}
				else if(arSrc.get(position).Name == "목포 국제 축구센터")
				{
					Intent intent = new Intent(maincon, mokpofootball.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					maincon.startActivity(intent);
				}
				else if(arSrc.get(position).Name == "보성공설운동장")
				{
					Intent intent = new Intent(maincon, bosungground.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					maincon.startActivity(intent);
				}
				else if(arSrc.get(position).Name == "정읍공설운동장")
				{
					Intent intent = new Intent(maincon, jungeupground.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					maincon.startActivity(intent);
				}
				else if(arSrc.get(position).Name == "고창공설운동장")
				{
					Intent intent = new Intent(maincon, gochangground.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					maincon.startActivity(intent);
				}
			}
		});
		return convertView;
	}
}