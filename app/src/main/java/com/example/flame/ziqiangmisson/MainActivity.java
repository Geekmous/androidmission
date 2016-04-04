package com.example.flame.ziqiangmisson;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.internal.view.menu.ListMenuItemView;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setHomeButtonEnabled(false);

        ListView list1 = (ListView) findViewById(R.id.listcontain);

        String arr1 = "樱花节有何不同";
        String arr2 = "自强新闻/2015.04.01";
        String[] content ={
                "暖黄的灯光,复古的摆设,清新的绿植,香浓的咖啡.....让人不禁联想成富有小资情调的咖啡馆.事实上,这个刚刚在图书馆工学分馆一楼开张迎客的是我校首个创客空间.",
                "创客属于外来词汇,指不以盈利为目的,努力将创意转变成现实的人,他们坚持分享和传播知识的崇高信仰,追求为全人类创造美好生活的人生价值.创客空间,顾名思义,就是供学子创新,创意,创业项目研讨和路演的场所"
        };

        ListViewAdapter listViewAdapter = new ListViewAdapter();
        listViewAdapter.setTitle(arr1);
        listViewAdapter.setTime(arr2);
        listViewAdapter.setContent(content);
        list1.setAdapter(listViewAdapter);




    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);

        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }


    class ListViewAdapter extends BaseAdapter {

        String title;
        String time;
        String[] content;
        public int getCount() {
           int count = 0;
            count = 3 + content.length;
            return count;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View view, ViewGroup parent) {
            LinearLayout line = new LinearLayout(MainActivity.this);
            if(position == 0) {
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                lp.setMargins(32, 24, 32, 14);
                line.setOrientation(LinearLayout.HORIZONTAL);
                TextView text = new TextView(MainActivity.this);
                text.setTextSize(TypedValue.COMPLEX_UNIT_SP,24);
                text.setTextColor(Color.rgb(33, 33, 33));
                text.setText(this.title);
                text.setLayoutParams(lp);
                text.setLineSpacing(1.0f,3.0f);
                line.addView(text);
            }
            else if(position == 1) {
                line.setOrientation(LinearLayout.HORIZONTAL);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                lp.setMargins(32, 0, 32, 40);
                TextView text = new TextView(MainActivity.this);
                text.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                text.setTextColor(Color.rgb(99,99,99));
                text.setText(this.time);
                text.setLayoutParams(lp);
                line.addView(text);
            }
            else if( position == 2 ) {
                line.setOrientation(LinearLayout.HORIZONTAL);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                lp.setMargins(32, 0, 32, 36);
                ImageView image = new ImageView(MainActivity.this);
                image.setImageResource(R.drawable.b);
                image.setLayoutParams(lp);

                image.setScaleType(ImageView.ScaleType.FIT_XY);
                line.addView(image);
            }

            else {
                line.setOrientation(LinearLayout.HORIZONTAL);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                lp.setMargins((int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16.0f,getResources().getDisplayMetrics()), 0, (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16.0f,getResources().getDisplayMetrics()), (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 18.0f,getResources().getDisplayMetrics()));

                TextView text = new TextView(MainActivity.this);

                text.setText(this.content[position - 3]);
                text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
                text.setTextColor(Color.rgb(33, 33, 33));
                text.setLayoutParams(lp);
                text.setLineSpacing(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 18.0f,getResources().getDisplayMetrics()), 1.0f);
                line.addView(text);
            }



            return line;


        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setTime(String time) {
            this.time = time;
        }
        public void setContent(String[] content) {
            this.content = content;
        }
    }
}
