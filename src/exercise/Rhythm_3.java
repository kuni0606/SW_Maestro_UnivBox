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

public class Rhythm_3 extends Activity{
	ArrayList<MyItem11> arItem;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.list1);
		
		arItem = new ArrayList<MyItem11>();
		MyItem11 mi;
		mi = new MyItem11(R.drawable.gwangjuwomenunivgym120,"광주여대 신축 다목적 체육관", "주소 : 광주광역시 광산구 여대길 201");arItem.add(mi);
		
		MyListAdapter11 MyAdapter = new MyListAdapter11(this, R.layout.stadium ,arItem);
		
		ListView MyList;
		MyList = (ListView)findViewById(R.id.listView1);
		MyList.setAdapter(MyAdapter);
	}
}

class MyItem11
{
	MyItem11(int aImage, String aName, String aNick)
	{
		Image=aImage;
		Name=aName;
		Nick=aNick;
	}
	int Image;
	String Name;
	String Nick;
}

class MyListAdapter11 extends BaseAdapter
{
	Context maincon;
	LayoutInflater Inflater;
	ArrayList<MyItem11> arSrc;
	int layout;
	
	public MyListAdapter11(Context context, int alayout, ArrayList<MyItem11> aarSrc)
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
				if(arSrc.get(position).Name == "광주여대 신축 다목적 체육관")
				{
					Intent intent = new Intent(maincon, gwangjuwomenunivgym.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					maincon.startActivity(intent);
				}
			}
		});
		return convertView;
	}
}