package com.example.jefferson.myapplication.filme;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jefferson.myapplication.R;

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
            view = inflater.inflate(R.layout.liste_item,null);
        }
        TextView name = (TextView)view.findViewById(R.id.textview);
        TextView descricao = (TextView)view.findViewById(R.id.textview1);

        Filme filmeList = list.get(position);
        if(name != null)
        {
            // show The Image in a ImageView
            new ConvertImage.DownloadImageTask((ImageView) view.findViewById(R.id.imageView))
                    .execute(filmeList.getImagem());
            name.setText(filmeList.getNome());
            descricao.setText(filmeList.getDescricao());

        }

        return view;
    }





}