package com.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final GridView gridView = (GridView) findViewById(R.id.gridView1);
        MyGridAdapter gridAdapter = new MyGridAdapter(this);
        gridView.setAdapter(gridAdapter);


    }
    class MyGridAdapter extends BaseAdapter {
        Context context;
        Integer[] posterID = {
                R.drawable.mov1,R.drawable.mov2,R.drawable.mov3,R.drawable.mov4,R.drawable.mov5,R.drawable.mov6,R.drawable.mov7,R.drawable.mov8,R.drawable.mov9,R.drawable.mov10,
                R.drawable.mov1,R.drawable.mov2,R.drawable.mov3,R.drawable.mov4,R.drawable.mov5,R.drawable.mov6,R.drawable.mov7,R.drawable.mov8,R.drawable.mov9,R.drawable.mov10,
                R.drawable.mov1,R.drawable.mov2,R.drawable.mov3,R.drawable.mov4,R.drawable.mov5,R.drawable.mov6,R.drawable.mov7,R.drawable.mov8,R.drawable.mov9,R.drawable.mov10,
                R.drawable.mov1,R.drawable.mov2,R.drawable.mov3,R.drawable.mov4,R.drawable.mov5,R.drawable.mov6,R.drawable.mov7,R.drawable.mov8,R.drawable.mov9,R.drawable.mov10
        };
        String[] moiveNames = {
                "검은사제들","그놈이다","내부자들","도리화가","마션","명량","베테랑","신세계","인터스텔라","특종:량첸살인기",
                "검은사제들","그놈이다","내부자들","도리화가","마션","명량","베테랑","신세계","인터스텔라","특종:량첸살인기",
                "검은사제들","그놈이다","내부자들","도리화가","마션","명량","베테랑","신세계","인터스텔라","특종:량첸살인기",
                "검은사제들","그놈이다","내부자들","도리화가","마션","명량","베테랑","신세계","인터스텔라","특종:량첸살인기"
        };
        public MyGridAdapter(Context c) {
            context = c;
        }

        @Override
        public int getCount() {
            return posterID.length;
        }

        @Override
        public Object getItem(int position) {
            return posterID[position];
        }

        @Override
        public long getItemId(int position) {
            return posterID[position];
        }

        @Override
        public View getView(final int position, View convertView,final ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if(convertView == null) {
                convertView = inflater.inflate(R.layout.adapter_item, null);
            }
            ImageView poster = (ImageView) convertView.findViewById(R.id.img_poster);
            TextView movieName = (TextView) convertView.findViewById(R.id.tv_name);
            poster.setImageResource(posterID[position]);
            movieName.setText(moiveNames[position]);

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialogView = (View) View.inflate(MainActivity.this,R.layout.dialog,null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(posterID[position]);
                    dlg.setTitle(moiveNames[position]);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기",null);
                    dlg.show();
                }
            });

            return convertView;
        }
    }

}
