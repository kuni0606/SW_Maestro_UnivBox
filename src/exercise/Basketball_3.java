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

public class Basketball_3 extends Activity{
	ArrayList<MyItem4> arItem;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.list1);
		
		arItem = new ArrayList<MyItem4>();
		MyItem4 mi;
		mi = new MyItem4(R.drawable.muangym120, "무안 실내 체육관", "주소 : 전남 무안군 현경면 공항로 345");arItem.add(mi);
		mi = new MyItem4(R.drawable.younggwanggym120, "영광 스포티움 체육관", "주소 : 전남 영광군 영광읍 월현로 170");arItem.add(mi);
		mi = new MyItem4(R.drawable.muanchodangunivgym120, "무안 초당대 체육관", "주소 : 전남 무안군 무안읍 무안로 380");arItem.add(mi);
		mi = new MyItem4(R.drawable.donggangunivgym120, "동강대 체육관", "주소 : 광주광역시 북구 동문대로 50");arItem.add(mi);
		mi = new MyItem4(R.drawable.jeonjugym120, "전주실내체육관", "주소 : 전북 전주시 덕진구 권삼득로 308");arItem.add(mi);
		
		MyListAdapter4 MyAdapter = new MyListAdapter4(this, R.layout.stadium ,arItem);
		
		ListView MyList;
		MyList = (ListView)findViewById(R.id.listView1);
		MyList.setAdapter(MyAdapter);
	}
}

class MyItem4
{
	MyItem4(int aImage, String aName, String aNick)
	{
		Image=aImage;
		Name=aName;
		Nick=aNick;
	}
	int Image;
	String Name;
	String Nick;
}

class MyListAdapter4 extends BaseAdapter
{
	Context maincon;
	LayoutInflater Inflater;
	ArrayList<MyItem4> arSrc;
	int layout;
	
	public MyListAdapter4(Context context, int alayout, ArrayList<MyItem4> aarSrc)
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
				if(arSrc.get(position).Name == "무안 실내 체육관")
				{
					Intent intent = new Intent(maincon, muangym.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					maincon.startActivity(intent);
				}
				else if(arSrc.get(position).Name == "영광 스포티움 체육관")
				{
					Intent intent = new Intent(maincon, younggwanggym.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					maincon.startActivity(intent);
				}
				else if(arSrc.get(position).Name == "무안 초당대 체육관")
				{
					Intent intent = new Intent(maincon, muanchodangunivgym.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					maincon.startActivity(intent);
				}
				else if(arSrc.get(position).Name == "동강대 체육관")
				{
					Intent intent = new Intent(maincon, donggangunivgym.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					maincon.startActivity(intent);
				}
				else if(arSrc.get(position).Name == "전주실내체육관")
				{
					Intent intent = new Intent(maincon, jeonjugym.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					maincon.startActivity(intent);
				}
			}
		});
		return convertView;
	}
}