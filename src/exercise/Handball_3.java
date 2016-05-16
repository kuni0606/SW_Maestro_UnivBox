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

public class Handball_3 extends Activity{
	ArrayList<MyItem9> arItem;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.list1);
		
		arItem = new ArrayList<MyItem9>();
		MyItem9 mi;
		mi = new MyItem9(R.drawable.najugym120,"나주 다목적 체육관", "주소 : 전라남도 나주시 영산강변로 99");arItem.add(mi);
		mi = new MyItem9(R.drawable.guraegym120,"구례 실내 체육관", "주소 : 전라남도 구례군 구례읍 서시천로 76-11");arItem.add(mi);
		mi = new MyItem9(R.drawable.najugym2120,"나주 실내 체육관", "주소 : 전라남도 나주시 구진포로 519");arItem.add(mi);
		mi = new MyItem9(R.drawable.jeonnamunivgym120,"전남대학교 체육관", "주소 : 광주광역시 북구 용봉로 77");arItem.add(mi);
		
		MyListAdapter9 MyAdapter = new MyListAdapter9(this, R.layout.stadium ,arItem);
		
		ListView MyList;
		MyList = (ListView)findViewById(R.id.listView1);
		MyList.setAdapter(MyAdapter);
	}
}

class MyItem9
{
	MyItem9(int aImage, String aName, String aNick)
	{
		Image=aImage;
		Name=aName;
		Nick=aNick;
	}
	int Image;
	String Name;
	String Nick;
}

class MyListAdapter9 extends BaseAdapter
{
	Context maincon;
	LayoutInflater Inflater;
	ArrayList<MyItem9> arSrc;
	int layout;
	
	public MyListAdapter9(Context context, int alayout, ArrayList<MyItem9> aarSrc)
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
				if(arSrc.get(position).Name == "나주 다목적 체육관")
				{
					Intent intent = new Intent(maincon, najugym.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					maincon.startActivity(intent);
				}
				else if(arSrc.get(position).Name == "구례 실내 체육관")
				{
					Intent intent = new Intent(maincon, guraegym.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					maincon.startActivity(intent);
				}
				else if(arSrc.get(position).Name == "나주 실내 체육관")
				{
					Intent intent = new Intent(maincon, najugym2.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					maincon.startActivity(intent);
				}
				else if(arSrc.get(position).Name == "전남대학교 체육관")
				{
					Intent intent = new Intent(maincon, jeonnamunivgym.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					maincon.startActivity(intent);
				}
			}
		});
		return convertView;
	}
}