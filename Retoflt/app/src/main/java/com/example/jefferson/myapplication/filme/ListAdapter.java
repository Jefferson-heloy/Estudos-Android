package com.example.jefferson.myapplication.filme;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jefferson.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListAdapter extends ArrayAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<Filme> list;
    ListAdapter(Context context, int resource, List<Filme> objects) {
        super(context, resource, objects);
        this.context = context;
        this.list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(inflater == null)
        {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView == null)
        {
            view = inflater.inflate(R.layout.liste_filme,null);
        }
        TextView name = (TextView)view.findViewById(R.id.textview);
        TextView descricao = (TextView)view.findViewById(R.id.textview1);

        Filme filmeList = list.get(position);
        if(name != null)
        {

            // show The Image in a ImageView
            Picasso.get().load(filmeList.getImagem())
                    .into((ImageView) view.findViewById(R.id.imageView));
            name.setText(filmeList.getNome());
            descricao.setText(filmeList.getDescricao());

        }

        return view;
    }





}