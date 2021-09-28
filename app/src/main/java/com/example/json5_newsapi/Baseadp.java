package com.example.json5_newsapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Baseadp extends BaseAdapter {
    Context context;
    ArrayList<Secondclass> data;
    public Baseadp(Context applicationContext, ArrayList<Secondclass> Article){
        context=applicationContext;
        data=Article;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= LayoutInflater.from(context);//first step
        view=inflater.inflate(R.layout.sample,null);//second step
        TextView Title=view.findViewById(R.id.Title);
        Title.setText(data.get(i).title);
        TextView DES= view.findViewById(R.id.Textdes);
        DES.setText(data.get(i).content);
        ImageView image=view.findViewById(R.id.image);
        Picasso.get().load(data.get(i).urlToImage).into(image);
        return view;
    }
}
